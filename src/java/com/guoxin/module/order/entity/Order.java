package com.guoxin.module.order.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单信息 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer orderId;          //订单Id
    private String orderCode;          //订单号
    private Integer clientId;          //客户id
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;          //更新时间
    private String comment;          //订单评论
    private Integer state;          //订单状态(0未付款，1已付款，2已派单，3已完成，4已取消,5申请退款，6已退款)
    private Double discount;          //优惠抵用
    private Double account;          //账户抵扣
    private Boolean deleteFlag;          //删除标记(0未删除 1已删除)
    private Integer peopleNum;          //需要服务人数
    private Integer area;          //需要服务面积()
    private Integer detailId;      //服务项目Id
    @JSONField(format="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date time;           //服务时间
    private Double paymoney;        //付款金额
    private Integer addressId;       //客户地址ID
    
    private String telephone;       //客户手机号码
    private String detailName;     //订单服务项目名称
    private Double money;           //订单服务金额
    private String address;           //地址
 
    public Integer getOrderId() {  
        return orderId;  
    }  
    public void setOrderId(Integer orderId) {  
        this.orderId = orderId;  
    }
    
    public String getOrderCode() {  
        return orderCode;  
    }  
    public void setOrderCode(String orderCode) {  
        this.orderCode = orderCode;  
    }
    
    public Date getUpdateTime() {  
        return updateTime;  
    }  
    public void setUpdateTime(Date updateTime) {  
        this.updateTime = updateTime;  
    }
    
    public String getComment() {  
        return comment;  
    }  
    public void setComment(String comment) {  
        this.comment = comment;  
    }
    
    public Integer getState() {  
        return state;  
    }  
    public void setState(Integer state) {  
        this.state = state;  
    }
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
    
    public Integer getPeopleNum() {  
        return peopleNum;  
    }  
    public void setPeopleNum(Integer peopleNum) {  
        this.peopleNum = peopleNum;  
    }
    
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
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
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getDetailName() {
		return detailName;
	}
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getAccount() {
		return account;
	}
	public void setAccount(Double account) {
		this.account = account;
	}
	public Double getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
    
}
