package com.guoxin.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 主要是JAVA里面的删除和添加Cookie操作
 * @author Rocye
 * @createTime 2015-05-23
 */
public class CookieUtil {
    /**
     * 设置Cookie
     * @author Rocye
     * @param name 名字   value 值   maxAage 有效时间（秒为单位）
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookieOpenId = new Cookie(name, value);
        cookieOpenId.setMaxAge(maxAge);
        response.addCookie(cookieOpenId);
    }
    
    
    /**
     * 获取Cookie
     * @author Rocye
     * @param name 名字 
     */
    public static String getCookie(HttpServletRequest request, String name){
        String value = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                Cookie tmpCookie = cookies[i];
                if(tmpCookie != null && name.equals(tmpCookie.getName())){
                    value = tmpCookie.getValue();
                }
            }
        }
        return value;
    }
}
