package com.guoxin.module.wximpl.vo;

import java.util.List;

import net.sf.json.JSONArray;

/**
 * @ClassName: ReturnInfoVO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author PSY
 * @date 2015-3-11 下午05:21:00
 */
public class ReturnInfoVO {
	
	private String access_token;		//获取到的凭证
	private String expires_in;			//凭证有效时间，单位：秒
	private List<String> ip_list;		//微信服务器的ip地址列表
	private String errcode;				//错误码
	private String errmsg;				//错误的详细信息
	private String msgId;				//发送模版消息后返回的msgID
	private String msg_id;				//群发消息时返回的msgId
	private String ticket;				//JSSDK的APITICKET
	private String template_id;			//模版ID转换时候返回的长ID
	private String media_id;			//上传永久图文素材返回的MIDIA_ID
	
	private String groupid;				//查询到的用户所在组的ID
	
	//卡券返回值
	private String url;							//上传LOGO之后返回的LOGO Url
	private List<String> location_id_list;		//门店 ID。插入失败的门店返回数值“-1”，请核查必填字段后单独调用接口导入。
	private JSONArray location_list;			//拉去到的门店信息列表
	private Integer count;						//拉取到的门店数量
	private JSONArray colors;					//颜色列表
	private String card_id;						//创建卡券后返回的该卡券的ID
	
	
	///////GET&SET////////
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expiresIn) {
		expires_in = expiresIn;
	}
	public List<String> getIp_list() {
		return ip_list;
	}
	public void setIp_list(List<String> ipList) {
		ip_list = ipList;
	}
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
	public String getTemplate_id() {
		return template_id;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msgId) {
		msg_id = msgId;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String mediaId) {
		media_id = mediaId;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getLocation_id_list() {
		return location_id_list;
	}
	public void setLocation_id_list(List<String> locationIdList) {
		location_id_list = locationIdList;
	}
	public JSONArray getLocation_list() {
		return location_list;
	}
	public void setLocation_list(JSONArray locationList) {
		location_list = locationList;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public JSONArray getColors() {
		return colors;
	}
	public void setColors(JSONArray colors) {
		this.colors = colors;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String cardId) {
		card_id = cardId;
	}
	@Override
	public String toString() {
		return "ReturnInfoVO [access_token=" + access_token + ", errcode="
		+ errcode + ", errmsg=" + errmsg + ", expires_in=" + expires_in
		+ ", msgId=" + msgId + ", template_id=" + template_id + "]";
	}
}
