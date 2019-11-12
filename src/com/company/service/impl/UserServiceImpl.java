package com.company.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Blog;
import com.company.bean.User;
import com.company.dao.IBlogDao;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.service.IUserService;

/**
 * @author  wl
 * @category 用户的业务逻辑层
 */
@Service
public class UserServiceImpl implements IUserService {
	
	 @Autowired
	private IBlogDao blogDao;
	 @Autowired
	private ICommentDao commentDao;
	 @Autowired
	private IUserDao myUserDao;
	@Test
	public void test(){
		  
		 System.out.println(myUserDao.findByName("弋一", "123").getSex());
	}
	public User find1(String id, String pass) {
		User user = null;
		if (id != null && !id.equals("")) {
			int idInt = Integer.valueOf(id);
			user = myUserDao.find1(idInt, pass);
		}
		return user;
	}
	
	public User findByName(String name, String pass) {
		User user = null;
		if (name != null &&!name.equals("")) {
			user = myUserDao.findByName(name, pass);
		}
		return user;
	}



	public boolean add(User user) {
		int i = myUserDao.add(user);
		return i > 0 ? true : false;
	}

	public List<User> findUserList() {
		return myUserDao.findUserList();
	}

	public boolean delete(String id) {
		boolean flag = false;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			
			//根据Userid得到所有的博客
			List<Blog> blogs = blogDao.findList1(userId);
			for (Blog blog : blogs) {
				//根据博客的id得到所有的评论
				commentDao.deleteByBlogId(blog.getId());
				blogDao.delete(blog.getId());
			}
			//删除该人发表的所有评论 
			commentDao.deleteByUserId(userId);
			
			int i = myUserDao.delete(userId);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	public User find(String id) {
		User user = null;
		if (id != null && !id.equals("")) {
			int userId = Integer.valueOf(id);
			user = myUserDao.find(userId);
		}
		return user;
	}

	public boolean update(User user) {
		boolean flag = false;
		if (user != null && user.getId() != 0) {
			int i = myUserDao.update(user);
			if (i > 0) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean findByUserName(String name) {
		return myUserDao.findByUserName(name)==null?true:false;
	}
	 
	
}
