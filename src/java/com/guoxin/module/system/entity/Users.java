package com.guoxin.module.system.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 系统用户 Entity
 * @author Rocye
 * @createTime 2013-08-25
 */
public class Users implements Serializable{
    
    private static final long serialVersionUID = 6552288028399525389L;
    
    private Integer userId;				    //主键ID
	private String loginName;				//登录名
	private String password;				//密码
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;             //生日
	private Boolean deleteFlag;				//删除标记
	
	public Users() {
    }

    public Users(String loginName, String password, String userName,String userPhone, String userEmail, Boolean deleteFlag) {
        this.loginName = loginName;
        this.password = password;
        this.deleteFlag = deleteFlag;
    }

    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
