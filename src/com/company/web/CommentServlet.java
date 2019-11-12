package com.company.web;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.company.bean.Comment;
import com.company.service.ICommentService;
import com.company.vo.CommentVO;

/**
 * @author wl
 * @category 评论的控制器 type: 1:查询该博客下的所有评论,2：保存评论，3：删除评论
 */
 @Controller
public class CommentServlet {

		Logger log = Logger.getLogger(CommentServlet.class);

	private ICommentService commentService ;
	@RequestMapping("/find")
	 public String find(int bid, Model model){
			List<CommentVO> list = commentService.find(bid);
			model.addAttribute("list", list);
			return "bloglist";
	 }
	@RequestMapping("/save")
	 public String save(Comment comment){
		boolean flag=commentService.save(1, 2, "fghh", "fgjhhj");
		 log.debug("flag" + flag);
		return "redirect:bloglist.action";
	 }
	@RequestMapping("/delete")
	public String delete(int id){
		boolean flag=commentService.delete(3);
		 log.debug("flag" + flag);
		return "redirect:bloglist.action";
	}
}
