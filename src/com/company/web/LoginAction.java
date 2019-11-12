package com.company.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @author wl
 * @category 登录控制器
 */
@Controller
public class LoginAction {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IUserService userService = new UserServiceImpl();
		//接收用户传入的用户名+密码
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println(name);
		System.out.println(pass);
		//调用业务逻辑对象的方法（查询），得到用户对象
		User user = userService.findByName(name, pass);
		//根据返回结果响应
		if(user!=null){
			System.out.println("登录成功");
			//创建Session，将用户对象放入到session中
			HttpSession session = request.getSession();
			session.setAttribute("current_user", user);
			//转发到首页
			request.getRequestDispatcher("index.html").forward(request, response);
		}else{
			//转发到登录页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
