/**   
 * @Title: MyApplicationContextUtil.java
 * @Package com.guoxin.common.util
 * @Description: TODO
 * @author xyu
 * @date 2011-6-14 下午05:12:29
 *  
 */

package com.guoxin.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
*   
* 项目名称： 		cms  
* 类名称：      		MyApplicationContextUtil  
* 类描述：                 声明一个静态变量
* 创建人：     		yangling  
* 创建时间：		2011-11-1 下午03:48:55  
* 修改人：     		yangling  
* 修改时间：		2011-11-1 下午03:48:55  
* 修改备注：  
* @version		1.0
*
 */

public class MyApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext context;

	// 声明一个静态变量保存
	public void setApplicationContext(ApplicationContext contex) throws BeansException {
		context = contex;
	}

	public static ApplicationContext getContext() {
		return context;
	}
}
