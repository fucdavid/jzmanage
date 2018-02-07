/**
 * 
 */
package com.guoxin.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guoxin.common.base.Constants;


/**  
 *   
 * 项目名称： 		hcyTest  
 * 类名称：      		WxZfUtil  
 * 类描述：  
 * 创建人：     		hcy  
 * 创建时间：		2015-1-12 上午09:27:56  
 * 修改人：     		hcy  
 * 修改时间：		2015-1-12 上午09:27:56  
 * 修改备注：  
 * @version		3.1
 *   
 */
public class WxZfUtil {
	
	/** Token获取网关地址地址 */
	private String tokenUrl;
	/** 预支付网关url地址 */
	private String gateUrl;
	/** 查询支付通知网关URL */
	private String notifyUrl;
	/** 商户参数 */
	private static String appid;
	private String appkey;
	private static String partnerkey;
	private static String appsecret;
	private static String key;
	/** 请求的参数 */
	private SortedMap parameters;
	/** Token */
	private static String Token;
	private static String charset;
	/** debug信息 */
	private static String debugInfo;
	private static String last_errcode;


	
	public WxZfUtil() {
		this.last_errcode = "0";
		this.charset = "UTF-8";
		this.parameters = new TreeMap();
		// 验证notify支付订单网关
		notifyUrl = "https://gw.tenpay.com/gateway/simpleverifynotifyid.xml";
	}

	/**
	 * 初始化函数。
	 */
	public static void init(String app_id, String app_secret,	String partner_key) {
		last_errcode = "0";
		Token = "token_";
		debugInfo = "";
		appid = app_id;
		partnerkey = partner_key;
		appsecret = app_secret;
		key = partner_key;
	}
	
	/**
	 * 生成微信支付sign签名的算法
	 * @Description: 
	 * @author:Saber
	 * @date: 2015-3-13 上午10:17:07
	 */
	public static String createSign(SortedMap<String, String> packageParams){
		StringBuffer sb = new StringBuffer();
		Set<?> es = packageParams.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Constants.KEY);
		System.out.println("md5 sb:" + sb);
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		System.out.println("packge签名:" + sign);
		return sign;
	}
	
	// 获取package的签名包
	public String genPackage(SortedMap<String, String> packageParams)
			throws UnsupportedEncodingException {
		String sign = createSign(packageParams);

		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + URLEncoder.encode(v, this.charset).replace("+", "%20") + "&");
		}

		// 去掉最后一个&
		String packageValue = sb.append("sign=" + sign).toString();
//		System.out.println("UrlEncode后 packageValue=" + packageValue);
		return packageValue;
	}
	public static String getKey() {
		System.out.println("key is :"+key);
		return key;
	}
	
	
	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
}
