package com.guoxin.module.wximpl.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 * 公众平台基础接口
 * @author Rocye
 * @createTime 2014-03-31
 * @modifyTime 2015-01-27   针对JS-SDK进行的修改
 */
public class WxBaseUtil {
    private final static Logger logger = Logger.getLogger(WxBaseUtil.class.getName());
    // 统一下单接口
	public static String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    
    /**
     * 通过code换取网页授权access_token
     * @author Rocye
     * @param AppId
     * @param AppSecret
     * @param code 用户通过授权页面同意后
     * @createTime 2014-07-04
     * @return 
     */
    public static Map<String, Object> getOAuth2AccessTokenByCode(String AppId, String AppSecret, String code) {
        try{
            String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ AppId +"&secret="+ AppSecret +"&code="+ code +"&grant_type=authorization_code";
            String result = HttpsRequest.sendGet(getTokenUrl);
            logger.debug(result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map<String, Object> resultMap = (Map<String, Object>)jsonObject.toBean(jsonObject, Map.class);
            
            if(resultMap.containsKey("errcode")){
                logger.debug("通过code请求AccessToken失败!");
                return null;
            }else{
                long expiresIn = Long.parseLong(resultMap.get("expires_in").toString());
                logger.debug("本次请求access_token有效时长是：" + expiresIn + "秒!");
                
                //如果时间小于10分钟就刷新请求
                if(expiresIn <= 600){
                    return getOAuth2RefreshAccessToken(AppId, resultMap.get("refresh_token").toString());
                }else{
//                    "access_token":"ACCESS_TOKEN",
//                    "expires_in":7200,
//                    "refresh_token":"REFRESH_TOKEN",
//                    "openid":"OPENID",
//                    "scope":"SCOPE"
                    return resultMap;
                }
            }
        }catch (Exception e) {
            logger.error("通过code换取网页授权access_token时:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 通过refreshToken重新取网页授权access_token
     * @author Rocye
     * @param AppId
     * @param refreshToken 通过code得到的refreshToken
     * @createTime 2014-07-04
     * @return 
     */
    public static Map<String, Object> getOAuth2RefreshAccessToken(String AppId, String refreshToken) {
        try{
            String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+ AppId +"&grant_type=refresh_token&refresh_token="+ refreshToken;
            String result = HttpsRequest.sendGet(getTokenUrl);
            logger.debug(result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map<String, Object> resultMap = (Map<String, Object>)jsonObject.toBean(jsonObject, Map.class);
            
            if(resultMap == null || resultMap.containsKey("errcode")){
                logger.debug("通过refreshToken重新取网页授权access_token失败!");
                return null;
            }else{
                long expiresIn = Long.parseLong(resultMap.get("expires_in").toString());
                logger.debug("本次refreshToken有效时长是：" + expiresIn + "秒!");
                
                //如果时间小于3分钟就刷新请求
                if(expiresIn <= 180){
                    return null;
                }else{
//                    "access_token":"ACCESS_TOKEN",
//                    "expires_in":7200,
//                    "refresh_token":"REFRESH_TOKEN",
//                    "openid":"OPENID",
//                    "scope":"SCOPE"
                    return resultMap;
                }
            }
        }catch (Exception e) {
            logger.error("通过refreshToken重新取网页授权access_token时:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 通过access_token接取用户信息
     * @author Rocye
     * @param openId
     * @param accessToken
     * @createTime 2014-07-04
     * @return 
     */
    public static Map<String, Object> getOAuth2Userinfo(String openId, String accessToken) {
        try{
            String getUserUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+ accessToken +"&openid="+ openId +"&lang=zh_CN";
            String result = HttpsRequest.sendGet(getUserUrl);
            logger.debug(result);
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map<String, Object> resultMap = (Map<String, Object>)jsonObject.toBean(jsonObject, Map.class);
            
            if(resultMap == null || resultMap.containsKey("errcode")){
                logger.warn("通过access_token接取用户信息失败!");
                return null;
            }else{
//                "openid":" OPENID",
//                " nickname": NICKNAME,
//                "sex":"1",
//                "province":"PROVINCE"
//                "city":"CITY",
//                "country":"COUNTRY",
//                 "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46", 
//                 "privilege":[
//                 "PRIVILEGE1"
//                 "PRIVILEGE2"]

//下载图像
//                URL realUrl = new URL("");
//                //打开和URL之间的连接
//                URLConnection connection = realUrl.openConnection();
//                connection.connect();
//                String fileName = System.currentTimeMillis() + ".jpg";
//                FileIo.writeFile(connection.getInputStream(), Constants.ROOT_PATH + "fileStorage/mediaPerson/", fileName);
                return resultMap;
            }
        }catch (Exception e) {
            logger.error("通过access_token接取用户信息时:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    //测试方法
    public static void main(String[] args) {

    }

}
