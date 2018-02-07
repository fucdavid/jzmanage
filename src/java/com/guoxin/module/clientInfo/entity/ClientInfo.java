package com.guoxin.module.clientInfo.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 客户信息 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class ClientInfo implements Serializable{

    private Integer clientId;          //用户ID
    private String telephone;          //手机号
    private Integer money;          //余额
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //注册时间
    private Boolean deleteFlag;          //删除标记(0未删除 1已删除)
    private String openId;              //openId
 
    public Integer getClientId() {  
        return clientId;  
    }  
    public void setClientId(Integer clientId) {  
        this.clientId = clientId;  
    }
    
    public String getTelephone() {  
        return telephone;  
    }  
    public void setTelephone(String telephone) {  
        this.telephone = telephone;  
    }
    
    public Integer getMoney() {  
        return money;  
    }  
    public void setMoney(Integer money) {  
        this.money = money;  
    }
    
    public Date getUpdateTime() {  
        return updateTime;  
    }  
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
    
}
