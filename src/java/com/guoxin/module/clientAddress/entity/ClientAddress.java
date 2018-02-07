package com.guoxin.module.clientAddress.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户地址 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class ClientAddress implements Serializable{

    private Integer addressId;          //地址ID
    private Integer clientId;          //用户ID
    private String name;          //用户姓名
    private String phone;          //用户电话
    private String address;          //用户地址
    private Boolean deleteFlag;          //删除标记(0未删除 1已删除)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //更新时间
 
    public Integer getAddressId() {  
        return addressId;  
    }  
    public void setAddressId(Integer addressId) {  
        this.addressId = addressId;  
    }
    
    public Integer getClientId() {  
        return clientId;  
    }  
    public void setClientId(Integer clientId) {  
        this.clientId = clientId;  
    }
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
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
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
    
    public Date getUpdateTime() {  
        return updateTime;  
    }  
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }
    
}
