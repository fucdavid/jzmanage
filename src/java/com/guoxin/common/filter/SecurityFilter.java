package com.guoxin.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.guoxin.common.base.Constants;
import com.guoxin.module.system.entity.Users;

public class SecurityFilter implements Filter {

	private final static String URL_LOGIN = "/timeout";

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httprequest = (HttpServletRequest) request;
			HttpServletResponse httpresponse = (HttpServletResponse) response;
			if (isLoginAction(httprequest)) {
				filterChain.doFilter(request, response);
				return;
			}
			if (!hasLogin(httprequest)) {
			    if(httprequest.getHeader("gxAjax") != null && httprequest.getHeader("gxAjax").equals("true")){
			        httpresponse.getWriter().write("{\"errcode\":-2}");
			    }else{
			        httpresponse.sendRedirect(httprequest.getContextPath()+ URL_LOGIN);
			    }
			    return;
			}
		}
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	private boolean isLoginAction(HttpServletRequest request) {
		String path = request.getServletPath();
		String regEx = ".*delete$";
		String regEx1 = "^/wximpl.*";
		Pattern pattern = Pattern.compile(regEx);
		Pattern pattern1 = Pattern.compile(regEx1);
		Matcher matcher = pattern.matcher(path);
		Matcher matcher1 = pattern1.matcher(path);
		boolean rs = matcher.matches();
		boolean rs1 = matcher1.matches();
		if (path.matches("^[\\w-/.]+(txt|js|css|mp3|mp4|png|jpg|bmp|gif|swf|html|htm|woff|woff2|ttf)$")){
            return true;
        }else if (excludePathList().contains(path)) {
            return true;
        }else if (path.equals(URL_LOGIN)){
			return true;
		}else if(rs || rs1){
			return true;
		}else {
			return false;
		}
	}

	private boolean hasLogin(HttpServletRequest request) {
		boolean hasLogin = true;
		Users user = (Users) request.getSession().getAttribute(Constants.LOGIN_KEY);
		if (user == null) {
			hasLogin = false;
		} 
		return hasLogin;
	}
	
	private List<String> excludePathList(){
        List<String> pathList = new ArrayList<String>();
        pathList.add("/index");
        pathList.add("/login");
        pathList.add("/logout");
        pathList.add("/index.jsp");
        pathList.add("/pages/mobile/phone-valid.jsp");
        pathList.add("/order/place");
        pathList.add("/ydorder");
        pathList.add("/oauth");
        pathList.add("/redirecturi");
        pathList.add("/clientAddress/save");
        pathList.add("/zhifu/prePayOrder");
        pathList.add("/zhifu/signJsSDK");
        return pathList;
    }

}
