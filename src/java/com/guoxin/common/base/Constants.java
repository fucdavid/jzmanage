package com.guoxin.common.base;

import java.io.File;

public class Constants {
	// Dump file store
	public final static String DUMP_FILE_CATALOG = "dump";

	// Query result list
	public final static int QUERY_RESULT_ITEMS_PER_PAGE = 15;

	// Object keys
	public final static String LOGIN_KEY = "guoxin.login";
	public final static String ID_KEY = "id";

	// Format strings
	public final static String FORMAT_STRING_DATE = "yyyy-MM-dd";
	public final static String FORMAT_STRING_TIME = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_STRING_TIMESTAMP = "yyyy-MM-dd HH:mm:ss";

	public static final String SAVE_PATH = File.separator + "uploadFile" + File.separator;

	// excel 导出临时文件夹
	public static final String EXCEL_TEMPLET_PATH = File.separator + "exceltemplate" + File.separator;
	
	//项目根路径
	public static String ROOT_PATH = "";
	
	//用户权限
    public final static String ROLES_KEY = "guoxin.roles";
    
    public static final String APPID = "wx3f42aa4a9d6d9be6";
	public static final String APPSECRET = "f8f32c063dd8146421b3b7c19f11e9de";
	
	//支付相关参数
	public static final String MCHID = "1430993502";
	public static final String KEY = "jWO4mk269AhTa8IBKK7TXjfwBvYcRsaV";
	
	//系统的根目录
	public static final String BASEROOT = "http://www.meijiajiazheng.com/jzmanage/";		//5段
	
	//api_ticket是用于调用微信 JS API 的临时票据,获取 api_ticsket的 接口调用次数非常有限，频繁刷新 api_ticket 会导致 接口调用受限，影响自身业务 ；有效时间7200s
	public static String API_TICKET;
	public static long TICKET_EXPIRE = 0L; 
	
	//调用所有接口的凭据，有效时间7200s； 每天获取次数2000
	public static String ACCESS_TOKEN = "";
	public static long EXPIRES_TIME = 0L;
}
