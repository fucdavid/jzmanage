package com.guoxin.common.base;

import java.sql.Timestamp;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.guoxin.common.constants.WxBaseURLs;
import com.guoxin.module.wximpl.util.HttpsRequest;
import com.guoxin.module.wximpl.vo.JsapiTicket;
import com.guoxin.module.wximpl.vo.ReturnInfoVO;


/**
 * @ClassName: WxBase
 * @Description: 微信的基础接口
 * 包括：获取ACCESSTOKEN、获取微信服务器IP
 * @author PSY
 * @date 2015-3-5 下午03:28:15
 */
public class WxBase extends BaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(WxBase.class);
	
	public String toBaseTest(){
		return "toBaseTest";
	}
	
	/**
	 * 
	 * @createTime 2015-4-20 下午03:21:12
	 * @author PSY
	 * @return
	 */
	public static String getAccessToken(){
		if(Constants.ACCESS_TOKEN == "" || (Constants.EXPIRES_TIME - System.currentTimeMillis()) < 60000){
			getAccessTokenForUse();
		}
		return Constants.ACCESS_TOKEN;
	}
	
	/**
	 * 
	 * @createTime 2015-4-27 下午04:28:47
	 * @author PSY
	 */
	public static void getAccessTokenForUse(){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_ACCESS_TOKEN);
			JSONObject object = JSONObject.fromObject(result);
			ReturnInfoVO returnVO = (ReturnInfoVO) JSONObject.toBean(object,ReturnInfoVO.class);
			if(returnVO.getErrcode() != null){
				logger.error("获取ACCESSTOKEN时出错！错误消息如下："+returnVO.getErrmsg());
			}else{
				Constants.ACCESS_TOKEN = returnVO.getAccess_token();
				Constants.EXPIRES_TIME = System.currentTimeMillis() + Long.parseLong(returnVO.getExpires_in())*1000;
				System.out.println("ACCESSTOKEN："+Constants.ACCESS_TOKEN+"	将于"+new Timestamp(Constants.EXPIRES_TIME) + "过期！");
			}
		} catch (NumberFormatException e) {
			logger.error("获取accesstoken时：" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取新ACCESSTOKEN(GET)
	 * @author PSY
	 * @throws Exception 
	 * @createTime 2015-3-5 下午04:07:49
	 */
	public void getNewAccessToken(){
		try {
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_ACCESS_TOKEN);
			JSONObject object = JSONObject.fromObject(result);
			ReturnInfoVO returnVO = (ReturnInfoVO) JSONObject.toBean(object,ReturnInfoVO.class);
			if(returnVO.getErrcode() != null){
				logger.error("获取ACCESSTOKEN时出错！错误消息如下："+returnVO.getErrmsg());
			}else{
				Constants.ACCESS_TOKEN = returnVO.getAccess_token();
				System.out.println(Constants.ACCESS_TOKEN);
				Constants.EXPIRES_TIME = System.currentTimeMillis() + Long.parseLong(returnVO.getExpires_in())*1000;
				System.out.println(Constants.EXPIRES_TIME);
			}
			this.printResponseMsg(returnVO);
		} catch (NumberFormatException e) {
			logger.error("获取accesstoken时：" + e.getMessage());
			e.printStackTrace();
			this.printResponseMsg("{\"errCode\":1;\"errMsg\":\"\"}");
		}
	}
	
	/**
	 * 获取微信服务器IP(GET)
	 * @author PSY
	 * @createTime 2015-3-5 下午04:20:31
	 */
	public void getWxServerIP(){
		try {
			System.out.println(WxBaseURLs.GET_WXSERVERIP);
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_WXSERVERIP);
			System.out.println(result);
			JSONObject object = JSONObject.fromObject(result);
			ReturnInfoVO infoVO = (ReturnInfoVO) JSONObject.toBean(object, ReturnInfoVO.class);
			if(infoVO.getErrcode() == null){
				this.printResponseMsg(infoVO.getIp_list());
			}else{
				this.printResponseMsg("{\"msgId\":1;\"msg\":\"获取微信服务器IP时出错！错误消息如下："+ infoVO.getErrmsg() +"\"}");
			}
		} catch (Exception e) {
			logger.error("获取微信服务器IP时：" + e.getMessage());
			e.printStackTrace();
			this.printResponseMsg("{\"errCode\":1;\"errMsg\": \"\"}");
		}
	}
	
	/**
	 * 获取二次授权的accesstoken
	 * @author PSY
	 * @createTime 2015-3-17 下午05:33:25
	 * @param code
	 * @return
	 * @throws Exception
	 */
//	public static AuthorizationCode getAuthorizationAccessToken(String code)throws Exception{
//		String jsonResult = HttpsRequest.sendGet(WxBaseURLs.getAuth2AccessToken(code));
//		AuthorizationCode vo = (AuthorizationCode)GsonHandler.toObj(new AuthorizationCode(), jsonResult);
//		return vo;
//	}
	
	/**
	 * 获取JSAPI的ticket
	 * @author PSY
	 * @createTime 2015-3-18 下午12:08:53
	 */
	public static String getJsAPITicket(){
		if(Constants.API_TICKET == null || (Constants.TICKET_EXPIRE - System.currentTimeMillis()) < 60000){
			String result = HttpsRequest.sendGet(WxBaseURLs.GET_APITICKET);
			JSONObject object = JSONObject.fromObject(result);
			JsapiTicket ticket = (JsapiTicket) JSONObject.toBean(object, JsapiTicket.class);
			if("0".equals(ticket.getErrcode())){
				Constants.API_TICKET = ticket.getTicket();
				Constants.TICKET_EXPIRE = System.currentTimeMillis() + Long.parseLong(ticket.getExpires_in())*1000;
				System.out.println("APITICKET：："+Constants.API_TICKET + "	将于" + new Timestamp(Constants.TICKET_EXPIRE) + "过期！");
			}else{
				logger.warn("获取JSAPI的ticket时：" + ticket.getErrmsg());
			}
		}
		return Constants.API_TICKET;
	}
	
	/**
	 * 获取微信添加卡券JSAPI的ticket
	 * @createTime 2015-7-9 上午10:49:52
	 * @author PSY
	 * @return
	 */
	public static String getWxCardAPITicket(){
		return null;
//		if(Constants.WXCARD_API_TICKET == null || (Constants.WXCARD_API_TICKET_EXPIRE - System.currentTimeMillis()) < 60000){
//			String result = HttpsRequest.sendGet(WxBaseURLs.GET_WXCARD_APITICKET);
//			JSONObject object = JSONObject.fromObject(result);
//			JsapiTicket ticket = (JsapiTicket) JSONObject.toBean(object, JsapiTicket.class);
//			if("0".equals(ticket.getErrcode())){
//				Constants.WXCARD_API_TICKET = ticket.getTicket();
//				Constants.WXCARD_API_TICKET_EXPIRE = System.currentTimeMillis() + Long.parseLong(ticket.getExpires_in())*1000;
//				System.out.println("WXCARD_API_TICKET：："+Constants.WXCARD_API_TICKET + "	将于" + new Timestamp(Constants.WXCARD_API_TICKET_EXPIRE) + "过期！");
//			}else{
//				logger.warn("获取微信添加卡券JSAPI的ticket时：" + ticket.getErrmsg());
//			}
//		}
//		return Constants.WXCARD_API_TICKET;
	}
	
	
//	public static void main(String[] args){
//		WxBase base = new WxBase();
//		base.getNewAccessToken();
//		getWxServerIP();
//		getJsAPITicket();
//	}
}
