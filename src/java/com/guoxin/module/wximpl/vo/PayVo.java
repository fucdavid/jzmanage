/**
 * 
 */
package com.guoxin.module.wximpl.vo;

/**  
 *   
 * 项目名称： 		hcyTest  
 * 类名称：      		PayVo  
 * 类描述：  
 * 创建人：     		hcy  
 * 创建时间：		2015-2-12 下午05:42:23  
 * 修改人：     		hcy  
 * 修改时间：		2015-2-12 下午05:42:23  
 * 修改备注：  
 * @version		3.1
 *   
 */
public class PayVo {
	
	public String appid;
	public String timeStamp;
	public String nonceStr;
	public String packages;
	public String sign;
	
	/**
	 * 
	 */
	public PayVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PayVo(String appid,String timeStamp,String nonceStr,String packages,String sign) {
		this.appid = appid;
		this.timeStamp = timeStamp;
		this.nonceStr = nonceStr;
		this.packages = packages;
		this.sign = sign;
	}
	
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
