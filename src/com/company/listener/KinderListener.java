package com.company.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.company.bean.BlogKind;
import com.company.service.IBlogKindService;
import com.company.service.impl.BlogKindServiceImpl;

/**
 * @author  wl
 * @category 对APP的监听
 */
@WebListener
public class KinderListener implements ServletContextListener {

    public KinderListener() {
    }

    public void contextDestroyed(ServletContextEvent event)  { 
    }

    public void contextInitialized(ServletContextEvent event)  {
    	System.out.println("监听器工作：监听application，将所有的博客类型放到作用域中");
    	//创建业务逻辑对象
    	IBlogKindService blogKindService = new BlogKindServiceImpl();
    	//得到APP
    	ServletContext application = event.getServletContext();
    	//得到博客类型列表集合
    	List<BlogKind> blogKindList = blogKindService.findList();
    	//将集合放入APP作用域
    	application.setAttribute("blogKindList", blogKindList);
    }
	
}
