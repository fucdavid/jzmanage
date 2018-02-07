package com.guoxin.module.anutInfo.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 阿姨信息 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class AnutInfo implements Serializable{

    private Integer anutId;          //阿姨id
    private String anutName;          //阿姨姓名
    private String phone;          //阿姨手机号
    private String address;          //阿姨住址
    private String headImg;          //阿姨头像
    private Integer state;          //状态(0空闲1繁忙)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //注册时间
 
    public Integer getAnutId() {  
        return anutId;  
    }  
    public void setAnutId(Integer anutId) {  
        this.anutId = anutId;  
    }
    
    public String getAnutName() {  
        return anutName;  
    }  
    public void setAnutName(String anutName) {  
        this.anutName = anutName;  
    }
    
    public String getPhone() {  
        return phone;  
    }  
    public void setPhone(String phone) {  
        this.phone = phone;  
    }
    
    public String getAddress() {  
        return address;  
    }  
    public void setAddress(String address) {  
        this.address = address;  
    }
    
    public String getHeadImg() {  
        return headImg;  
    }  
    public void setHeadImg(String headImg) {  
        this.headImg = headImg;  
    }
    
    public Integer getState() {  
        return state;  
    }  
    public void setState(Integer state) {  
        this.state = state;  
    }
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
