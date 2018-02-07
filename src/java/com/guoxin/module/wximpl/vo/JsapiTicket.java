package com.guoxin.module.wximpl.vo;

/**
 * 
 * 使用jssdk的凭证
 *    
 * 项目名称：weixin   
 * 类名称：AuthorizationCode   
 * 类描述：   
 * 创建人：Saber   
 * 创建时间：2015-3-13 下午04:07:19   
 * 修改人：Saber   
 * 修改时间：2015-3-13 下午04:07:19   
 * 修改备注：   
 * @version    
 *   
 */
public class JsapiTicket {

	public String errcode;
	public String errmsg;
	public String expires_in;
	public String ticket;
	
	/*
	 * 生成JS-SDK权限验证的签名所使用的参数
	 */
	public String noncestr;			//生成随机字符串
	public String timestamp;		//时间戳
	public String url;				//当前页面的链接
	public String sign;				//签名证书
	
	
	//************************get/set***********************
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expiresIn) {
		expires_in = expiresIn;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "JsapiTicket [errcode=" + errcode + ", errmsg=" + errmsg
				+ ", expires_in=" + expires_in + ", noncestr=" + noncestr
				+ ", sign=" + sign + ", ticket=" + ticket + ", timestamp="
				+ timestamp + ", url=" + url + "]";
	}
}
