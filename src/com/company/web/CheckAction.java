package com.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.company.service.IUserService;

/**
 * @author wl
 * @category 检查用户名称是否存在的控制器
 */
 @Controller
public class CheckAction{
	 
	 private IUserService userService;
	 
		 public String fingByName(Model model){
			 userService.findByName("", "");
			 return "";
		 }
		 
}
