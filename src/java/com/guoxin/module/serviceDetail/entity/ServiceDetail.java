package com.guoxin.module.serviceDetail.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 服务详细信息 Entity
 * @author cx
 * @createTime 2017-01-12
 */
public class ServiceDetail implements Serializable{

    private Integer detailId;          //
    private String detailName;          //
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //
    private Integer money;          //
    private String describes;          //
    private Integer serviceId;          //
    private Integer moneya;
    private Integer moneyb;
    private Integer moneyc;
    private Integer moneyd;
    
    private String serviceName; 
 
    public Integer getDetailId() {  
        return detailId;  
    }  
    public void setDetailId(Integer detailId) {  
        this.detailId = detailId;  
    }
    
    public String getDetailName() {  
        return detailName;  
    }  
    public void setDetailName(String detailName) {  
        this.detailName = detailName;  
    }
    
    public Date getUpdateTime() {  
        return updateTime;  
    }  
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }
    public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getDescribes() {  
        return describes;  
    }  
    public void setDescribes(String describes) {  
        this.describes = describes;  
    }
    
    public Integer getServiceId() {  
        return serviceId;  
    }  
    public void setServiceId(Integer serviceId) {  
        this.serviceId = serviceId;  
    }
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getMoneya() {
		return moneya;
	}
	public void setMoneya(Integer moneya) {
		this.moneya = moneya;
	}
	public Integer getMoneyb() {
		return moneyb;
	}
	public void setMoneyb(Integer moneyb) {
		this.moneyb = moneyb;
	}
	public Integer getMoneyc() {
		return moneyc;
	}
	public void setMoneyc(Integer moneyc) {
		this.moneyc = moneyc;
	}
	public Integer getMoneyd() {
		return moneyd;
	}
	public void setMoneyd(Integer moneyd) {
		this.moneyd = moneyd;
	}
    
}
