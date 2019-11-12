package com.company.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author  wl
 * @category 数据库连接器，使用Mybatis操作
 */
public class DataConnector {

	/**
	 * @return 获得连接Session对象
	 */
	public static SqlSession getConnector() {
		SqlSession session = null;
		try {
			// 1获取当前Mybatis总的配置文件路径
			String resource = "configuration.xml";
			// 2获取当前配置文件的输入流
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 3通过流对象创建一个SessionFactory对象，数据库会话工厂
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 4根据会话工厂得到SqlSession对象，true表示自动提交
			session = sessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
