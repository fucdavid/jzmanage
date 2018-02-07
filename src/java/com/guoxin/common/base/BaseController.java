package com.guoxin.common.base;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.guoxin.common.util.CookieUtil;

/**
 * 系统基础控制层
 * @author Rocye
 * @createTime 2015-10-14
 */
public abstract class BaseController {

    /**
     * 获取HttpSession
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    /**
     * 获取HttpServletRequest
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    
    /**
     * 获取HttpServletResponse
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpServletResponse getResponse() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getResponse();
    }
    
    /**
     * 返回前端ajax接收的信息
     * @author Rocye
     * @param str
     * String contentType = "application/json; charset=utf-8";
     */
    public void printResponseMsg(String str){
        printResponseMsg(str, "UTF-8");
    }
    
    /**
     * 可自定义返回类型
     * @author Saber
     * @param str
     * @param ContentType
     * String contentType = "application/json; charset=utf-8";
     */
	public void printResponseMsg(Object str){
		Gson gson = new Gson();
    	printResponseMsg(gson.toJson(str));
    }
    
    /**
     * 可自定义返回类型
     * @author Rocye
     * @param str
     * @param ContentType
     */
    public void printResponseMsg(String str, String charset){
        HttpServletResponse response = getResponse();
        if(charset != null){
            response.setCharacterEncoding(charset);
        }
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
