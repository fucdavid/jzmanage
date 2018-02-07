package com.guoxin.module.wximpl.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guoxin.common.base.BaseController;
import com.guoxin.common.base.Constants;
import com.guoxin.common.base.WxBase;
import com.guoxin.common.util.GsonHandler;
import com.guoxin.common.util.SHA1;
import com.guoxin.common.util.WxZfUtil;
import com.guoxin.common.util.XmlHandler;
import com.guoxin.module.wximpl.util.HttpsRequest;
import com.guoxin.module.wximpl.util.WxBaseUtil;
import com.guoxin.module.wximpl.vo.OrderVO;
import com.guoxin.module.wximpl.vo.PayVo;
import com.guoxin.module.wximpl.vo.SignTrueVo;

@Controller
@RequestMapping("/zhifu")
public class ZfController extends BaseController{
	private final static Logger logger = Logger.getLogger(WximplController.class.getName());
	
	/**
	 * 微信支付第三步-----生成JSSDK权限验证的签名
	 * @createTime 2015-4-28 下午02:35:23
	 * @author PSY
	 * @return
	 */
	@RequestMapping(value="/signJsSDK")
	public ModelAndView signJsSDK(){
		try {
//			System.out.println(url);
			String url = this.getRequest().getParameter("url");
			String noncestr= createNonceStr(16);
			String jsapi_ticket = WxBase.getJsAPITicket();
			long timestamp= System.currentTimeMillis()/1000;
			String[] strings = new String[] { "jsapi_ticket="+jsapi_ticket,"noncestr="+noncestr,"timestamp="+timestamp,"url="+url};
			// 字典排序
			int i = 0;
			Arrays.sort(strings);
			StringBuffer sb = new StringBuffer();
			for (String str : strings) {
				if(i == 0){
					sb.append(str);
					i = i+1;
				}else{
					sb.append("&"+str);
				}
			}
//			System.out.println(sb.toString());
			// SHA1加密
			String signature = new SHA1().getDigestOfString(sb.toString().getBytes("UTF-8"));
		    
			SignTrueVo vo = new SignTrueVo(timestamp,signature,noncestr,Constants.APPID);
//			System.out.println(GsonHandler.toJson(vo));
			this.printResponseMsg(GsonHandler.toJson(vo));
		} catch (Exception e) {
			logger.warn("测试签名错误使用ajax调用时：" + e.getMessage());
			e.printStackTrace();
			this.printResponseMsg("{\"errCode\":1,\"errMsg\":\"\"}");
		}
		return null;
	}
	
	/**
	 * 微信支付第四步------生成预支付订单
	 * @createTime 2015-5-9 下午02:22:22
	 * @author PSY
	 */
	@RequestMapping(value="/prePayOrder")
	public ModelAndView prePayOrder(@ModelAttribute OrderVO orderVO){
		try {
			if(orderVO != null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				long preOrderTime = System.currentTimeMillis();
				orderVO.setAppid(Constants.APPID);
				orderVO.setMch_id(Constants.MCHID);
//				orderVO.setDevice_info("panshuyang"); 	//非必须，微信分配的终端设备号
				orderVO.setNonce_str(createNonceStr(32));
//				orderVO.setFee_type("");			//貌似V3支付没有这个参数了
				orderVO.setTrade_type("JSAPI");		//支付类型
				orderVO.setNotify_url(Constants.BASEROOT + "wximpl/msgIn");
				orderVO.setOut_trade_no(System.currentTimeMillis() + createNonceStr(10));			//订单号
//				orderVO.setProduct_id("")	//只有当Trade_type为NATIVE时需要此参数
				orderVO.setGoods_tag("");
				orderVO.setSpbill_create_ip("127.0.0.1");
				orderVO.setAttach("支付测试");
				orderVO.setTime_start(sdf.format(new Timestamp(preOrderTime)));
				orderVO.setTime_expire(sdf.format(new Timestamp(preOrderTime + 3600000L)));
				WxZfUtil.init(Constants.APPID, Constants.APPSECRET, Constants.MCHID);
				SortedMap<String, String> prePayMap = (SortedMap<String, String>) JSONObject.toBean(JSONObject.fromObject(orderVO), TreeMap.class);
				System.out.println(prePayMap);
				String sign = WxZfUtil.createSign(prePayMap);
				prePayMap.put("sign", sign);
				
				String payXml = XmlHandler.objToXml(prePayMap);
				System.out.println(payXml);
				String result = HttpsRequest.sendPost(WxBaseUtil.ORDER_URL, payXml);
				JSONObject object = JSONObject.fromObject(XmlHandler.xml2JSON(result));
				logger.warn("Pay Result:"+object);
				if(object.getString("return_code").equals("SUCCESS") && object.getString("result_code").equals("SUCCESS")){
					if(object.getString("prepay_id") != null){
						prePayMap.put("prepay_id", object.getString("prepay_id"));
						
						/**创建第二次签名，获得调启网页支付插件的最终签名**/
						SortedMap<String, String> finalpackage = new TreeMap<String, String>();
						String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
						String nonceStr = prePayMap.get("nonce_str");
						String prepay_id = "prepay_id="+prePayMap.get("prepay_id");
						String packages = prepay_id;
						finalpackage.put("appId", Constants.APPID);  
						finalpackage.put("timeStamp", timestamp);  
						finalpackage.put("nonceStr", nonceStr);  
						finalpackage.put("package", packages);  
						finalpackage.put("signType", "MD5");
						String finalsign = WxZfUtil.createSign(finalpackage);//生成支付签名
						PayVo payVo = new PayVo(Constants.APPID,timestamp,nonceStr,packages,finalsign);
						this.printResponseMsg(GsonHandler.toJson(payVo));
					}else{
						this.printResponseMsg("{\"msgId\":1,\"msg\":\"获取预支付订单号失败！！错误信息：" + object.getString("return_msg") + "\"}");
					}
				}else{
					this.printResponseMsg("{\"msgId\":1,\"msg\":\"获取预支付订单号失败！！错误信息：" + object.getString("return_msg") + "\"}");
				}
			}else{
				this.printResponseMsg("{\"msgId\":1,\"msg\":\"授权失败！！\"}");
			}
		} catch (Exception e) {
			logger.error("生成预支付订单时：" + e.getMessage());
			e.printStackTrace();
			this.printResponseMsg("{\"errCode\":1,\"errMsg\":\"\"}");
		}
		return null;
	}
	
	/**
	 * 生成随机字串nonceStr
	 * @createTime 2015-4-30 下午01:54:31
	 * @author PSY
	 * @return
	 */
	public String createNonceStr(int length){
		String base = "QWERTYUIOPASDFGHJKLZXCVBNMabcdefghijklmnopqrstuvwxyz0123456789";     
        Random random = new Random();     
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {     
            int number = random.nextInt(base.length());     
            sb.append(base.charAt(number));     
        }
        return sb.toString();
	}
}

