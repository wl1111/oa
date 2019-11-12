package com.company.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.bean.BlogKind;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.IBlogKindDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IBlogService;
import com.company.vo.BlogVO;

/**
 * @author  wl
 * @category 博客的业务逻辑实现类
 * 
 */
@Service
public class BlogServiceImpl implements IBlogService {
	 
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IBlogKindDao blogKindDao;
	@Autowired
	private ICommentDao commentDao;//评论的数据访问层对象
	@Autowired
	private IBlogDao myBlogDao;
@Test
public void test1(){
	Blog  b=new Blog(2345,4436,5,"trh","gjhj","gjgnj",78);
	 
	
		System.out.println(myBlogDao.add(b));
	 
}
	/**
	 * 将po对象转换为vo对象
	 * @param voList vo集合
	 * @param blogList po集合
	 */
	public void change(List<BlogVO> voList,List<Blog> blogList){
		for (Blog blog : blogList) {
			User user = userDao.find(blog.getUid());
			String authorName = user.getName();
			BlogKind blogKind = blogKindDao.find(blog.getKid());
			String kindName = blogKind.getName();
			BlogVO vo = new BlogVO(blog.getId(), blog.getKid(), blog.getUid(),
					kindName, authorName, blog.getTitle(), blog.getSchema(),
					blog.getContent(), blog.getClicks(), blog.getdatetime());
			voList.add(vo);
		}
	}
	
	public List<BlogVO> findList() {
		List<BlogVO> voList = new ArrayList<BlogVO>();
		List<Blog> blogList = myBlogDao.findList();
		change(voList, blogList);
		return voList;
	}

	public Blog find(int id) {
		return myBlogDao.find(id);
	}

	public List<BlogVO> findKindList(int kid) {
		List<BlogVO> voList = new ArrayList<BlogVO>();
		List<Blog> blogList = myBlogDao.findKindList(kid);
		change(voList, blogList);
		return voList;
	}

	public List<BlogVO> findList(int uid) {
		List<BlogVO> voList = new ArrayList<BlogVO>();
		List<Blog> blogList = myBlogDao.findList1(uid);
		change(voList, blogList);
		return voList;
	}

	public boolean delete(int id) {
		//首先删除该博客的所有评论：使用的是评论的数据访问层对象
		commentDao.deleteByBlogId(id);
		//删除该博客对象，根据博客id
		boolean flag = myBlogDao.delete(id) > 0 ? true : false;
		return flag;
	}

	public boolean update(int id,String title,String kind,String schema,String content) {
		int kid = Integer.valueOf(kind);
		//根据id获取博客对象
		Blog blog = myBlogDao.find(id);
		blog.setTitle(title);
		blog.setKid(kid);
		blog.setSchema(schema);
		blog.setContent(content);
		return myBlogDao.update(blog) > 0 ? true : false;
	}

	public boolean saveBlog(int uid, String title, String kind, String schema,
			String content) {
		boolean flag = false;
		if (kind != null && !kind.equals("")) {
			int kid = Integer.valueOf(kind);
			int clicks = 0; // 初始化的点击量为0
			// 创建博客对象
			Blog blog = new Blog(kid, uid, title, schema, content, clicks,new Date());
			int i = myBlogDao.add(blog);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public List<BlogVO> findHotList() {
		List<BlogVO> voList = new ArrayList<BlogVO>();
		List<Blog> blogList = myBlogDao.findHotList();
		change(voList, blogList);
		return voList;
	}

	@Override
	public List<BlogVO> findIndexList() {
		List<BlogVO> voList = new ArrayList<BlogVO>();
		List<Blog> blogList = myBlogDao.findIndexList();
		change(voList, blogList);
		return voList;
	}

}
