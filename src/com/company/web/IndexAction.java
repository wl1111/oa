package com.company.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.bean.Blog;
import com.company.service.IBlogService;
import com.company.vo.BlogVO;

/**
 * @author wl
 * @category 首页控制器
 */
@Controller
public class IndexAction {
	 
	Logger log = Logger.getLogger(IndexAction.class);
	@Resource
	private IBlogService iBlogService;
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("index");
		return "forward:/index.jsp";
	}
	@RequestMapping("/findHotList")
	public String findHotList(Model model){
		log.debug("hotlist");
		List<BlogVO> list=iBlogService.findHotList();
		model.addAttribute("list", list);
		
		return "bloglist";
	}
}
