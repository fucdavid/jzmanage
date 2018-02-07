package com.guoxin.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * 短信API服务调用－ 聚合数据
 * 在线接口文档：http://www.juhe.cn/docs/54
 */
public class SendMsg {
	private final static Logger logger = Logger.getLogger(SendMsg.class.getName());
	//配置您申请的KEY
    public static final String APPKEY ="cf4c91b12568931238775bc65370cd7f";
	
	/**
	* 创建指定数量的随机字符串
	* @param numberFlag 是否是数字
	* @param length
	* @return
	*/
	public static String createRandom(boolean numberFlag, int length){
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
		if (count >= 2) {
			bDone = false;
		}
	   } while (bDone);
			return retStr;
	} 
	
	/**
	 * 获取短信验证码
	 * @param telephone 手机号
	 * @param tplId 短信模板ID
	 * @param tplValue 变量名和变量值对,该处为生成的验证码，#code#=431515
	 * @return
	 */
	public static String sendCode(String telephone,String tplId,String tplValue){
		String result = null;
		try {
			String url = "http://v.juhe.cn/sms/send?mobile="+telephone+"&tpl_id="+tplId+"&tpl_value="+URLEncoder.encode(tplValue,"UTF-8")+"&key="+APPKEY;
			result = HttpRequest.sendGet(url);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.warn("获取短信验证码时出错："+e.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String a = "#code#=" + createRandom(true, 6);
//		System.out.println(a);
//		try {
//			System.out.println(URLEncoder.encode(a,"UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String phone = "18627742367";
		String tplId = "25692";
		String tplValue = "#code#=431515";
		System.out.println(JSONObject.parse(sendCode(phone, tplId, tplValue)));
	}
}
