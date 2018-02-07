/**
 * 
 */
package com.guoxin.module.wximpl.vo;

/**  
 *   
 * 项目名称： 		hcyTest  
 * 类名称：      		SignTrueVo  
 * 类描述：  
 * 创建人：     		hcy  
 * 创建时间：		2015-2-12 下午04:49:14  
 * 修改人：     		hcy  
 * 修改时间：		2015-2-12 下午04:49:14  
 * 修改备注：  
 * @version		3.1
 *   
 */
public class SignTrueVo {
	public Long timestamp;
	public String signature;
	public String nonceStr;
	public String appId;
	/**
	 * 
	 */
	public SignTrueVo() {
		// TODO Auto-generated constructor stub
	}
	
	public SignTrueVo(Long timestamp,String signature,String nonceStr,String appId) {
		this.timestamp = timestamp;
		this.signature = signature;
		this.nonceStr = nonceStr;
		this.appId = appId;
	}
	
	
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
}
