package com.guoxin.common.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * @ClassName: GsonHandler
 * @Description: 处理json数据
 * @author PSY
 * @date 2015-3-9 下午01:46:05
 */
public class GsonHandler {
private static Gson gson;
	
	static{
		if(gson == null)gson = new Gson();
	}
	
	/**
	 * 功能： 将json串转成对象
	 * @author hcy
	 * @datetime 2014-11-13 上午11:00:18
	 * @param obj
	 * @param jsonStr
	 * @return
	 */
	public static Object toObj(Object obj,String jsonStr){
		return gson.fromJson(jsonStr, obj.getClass());
	}
	
	/**
	 * 功能： 将对象转成json字符串
	 * @author hcy
	 * @datetime 2014-11-28 下午05:25:08
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj){
		return gson.toJson(obj);
	}
	
	/**
	 * 将对象转成json串
	 * @author PSY
	 * @createTime 2015-3-13 下午04:41:53
	 * @param obj
	 * @return
	 */
	public static JsonElement toJsonTree(Object obj){
		return gson.toJsonTree(obj);
		
	}
}
