package com.guoxin.module.advice.entity;

import java.io.Serializable;

/**
 * 用户建议 Entity
 * @author caoxin
 * @createTime 2016-12-17
 */
public class Advice implements Serializable{

    private Integer adviceId;          //意见反馈ID
    private String content;          //意见内容
    private Integer userId;          //用户ID
    private Boolean deleteFlag;          //删除标记(0未删除 1已删除)
 
    public Integer getAdviceId() {  
        return adviceId;  
    }  
    public void setAdviceId(Integer adviceId) {  
        this.adviceId = adviceId;  
    }
    
    public String getContent() {  
        return content;  
    }  
    public void setContent(String content) {  
        this.content = content;  
    }
    
    public Integer getUserId() {  
        return userId;  
    }  
    public void setUserId(Integer userId) {  
        this.userId = userId;  
    }
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
    
}
