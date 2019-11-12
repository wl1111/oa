package com.company.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * @author wl
 * @category 用户注册控制器
 */
@Controller
public class RegistAction {
	private static final long serialVersionUID = 1L;
       
    public RegistAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IUserService userService = new UserServiceImpl();
		//接收用户信息
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String ageStr = request.getParameter("age");
		String sex = request.getParameter("sex");
		String provinceId = request.getParameter("provinceId");
		String cityId = request.getParameter("cityId");
		String areaId = request.getParameter("areaId");
		String tel = request.getParameter("tel");
		int age = Integer.valueOf(ageStr);//自动拆箱
		//调用业务逻辑方法返回结果
		User user = new User(name, pass, sex, age, tel, provinceId, cityId, areaId, new Date(System.currentTimeMillis()), request.getRemoteAddr());
		boolean flag = userService.add(user);
		//根据返回值进行判断，响应
		if(flag){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("404.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
