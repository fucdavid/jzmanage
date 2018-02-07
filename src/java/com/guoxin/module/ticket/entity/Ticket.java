package com.guoxin.module.ticket.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 优惠券信息 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class Ticket implements Serializable{

    private Integer ticketId;          //优惠券ID
    private String type;          //优惠类型
    private Integer sum;          //金额
    private Integer clientd;          //用户ID
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;          //有效开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;          //有效结束时间
    private Boolean isUse;          //是否使用(0未使用 1已使用)
    private Boolean deleteFlag;          //删除标记(0未删除 1已删除)
    private String ticketCode;          //兑换码
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //更新时间
 
    public Integer getTicketId() {  
        return ticketId;  
    }  
    public void setTicketId(Integer ticketId) {  
        this.ticketId = ticketId;  
    }
    
    public String getType() {  
        return type;  
    }  
    public void setType(String type) {  
        this.type = type;  
    }
    
    public Integer getSum() {  
        return sum;  
    }  
    public void setSum(Integer sum) {  
        this.sum = sum;  
    }
    
    public Integer getClientd() {  
        return clientd;  
    }  
    public void setClientd(Integer clientd) {  
        this.clientd = clientd;  
    }
    
    public Date getStartTime() {  
        return startTime;  
    }  
    public void setStartTime(Date startTime) {  
        this.startTime = startTime;  
    }
    
    public Date getEndTime() {  
        return endTime;  
    }  
    public void setEndTime(Date endTime) {  
        this.endTime = endTime;  
    }
    
    public Boolean getIsUse() {  
        return isUse;  
    }  
    public void setIsUse(Boolean isUse) {  
        this.isUse = isUse;  
    }
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
    
    public String getTicketCode() {  
        return ticketCode;  
    }  
    public void setTicketCode(String ticketCode) {  
        this.ticketCode = ticketCode;  
    }
    
    public Date getUpdateTime() {  
        return updateTime;  
    }  
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }
    
}
