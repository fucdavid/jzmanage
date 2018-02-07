package com.guoxin.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.guoxin.common.base.Constants;

/**
 * 项目启动时加载进行一些初始化操作
 * @author Rocye
 * @createTime 2013-4-3
 */
public class InitServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent contextEvent) {
		
	}

	public void contextInitialized(ServletContextEvent contextEvent) {
	    //初始化项目物理路径，便于普通方法中调用
		Constants.ROOT_PATH = contextEvent.getServletContext().getRealPath("/");
	}

}
