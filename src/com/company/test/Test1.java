package com.company.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.bean.User;
import com.company.service.IAreaService;
import com.company.service.IBlogKindService;
import com.company.service.IBlogService;
import com.company.service.ICityService;
import com.company.service.ICommentService;
import com.company.service.IProvinceService;
import com.company.service.IUserService;

/**
 * @author wl
 * @category 测试类
 *
 */
public class Test1 {
	 
	@Test
	public void test(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/spring.xml");
		//用户测试
		/*IUserService userService=applicationContext.getBean(IUserService.class);
		System.out.println("用户："+userService.findByUserName("admin"));*/
	   //博客类型测试
		/*IBlogKindService iBlogKindService=applicationContext.getBean(IBlogKindService.class);
		System.out.println("博客类型："+iBlogKindService);*/
		 //博客测试
		IBlogService iBlogService=applicationContext.getBean(IBlogService.class);
		System.out.println("博客："+iBlogService.update(9, "11", "22", "33", "44"));
		//城市测试
		/*ICityService iCityService=applicationContext.getBean(ICityService.class);
		System.out.println("城市："+iCityService);
		//评论测试
		ICommentService iCommentService=applicationContext.getBean(ICommentService.class);
		System.out.println("评论："+iCommentService);
		//省
		IProvinceService iProvinceService=applicationContext.getBean(IProvinceService.class);
		System.out.println("省份："+iProvinceService);
		//区
		IAreaService iAreaService=applicationContext.getBean(IAreaService.class);
		System.out.println("区："+iAreaService);*/
	}
}
