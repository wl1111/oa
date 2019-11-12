package com.company.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.bean.User;
import com.company.service.IUserService;

/**
 * @author wl
 * @category 用户列表控制器
 */
@Controller
public class UserListAction {
	Logger log = Logger.getLogger(UserListAction.class);
	@Resource
	private IUserService userService;
	@RequestMapping("/userlist")
	 public String list(Model model){
		 log.debug("list");
		 List<User> list=userService.findUserList();
		 model.addAttribute("list", list);
		 return "list";
	 }

}
