package com.company.web;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.company.bean.Blog;
import com.company.service.IBlogService;

/**
 * @author wl
 * @category 博客详情控制器
 */
 @Controller
public class BLogInfoAction{
	 Logger log = Logger.getLogger(IndexAction.class);
	 private IBlogService iBlogService;
	 @RequestMapping("/find")
	 public String find(int id,Model model){
		 log.debug("find");
		 Blog blog=iBlogService.find(2);
		 model.addAttribute("blog", blog);
		 return "bloginfo";
	 }
}
