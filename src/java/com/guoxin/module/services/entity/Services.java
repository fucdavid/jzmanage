package com.guoxin.module.services.entity;

import java.io.Serializable;

/**
 * 服务模块 Entity
 * @author cx
 * @createTime 2017-01-12
 */
public class Services implements Serializable{

    private Integer serviceId;          //
    private String serviceName;          //
    private String describe;          //
    private Boolean deleteFlag;          //
 
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
    
    public String getDescribe() {  
        return describe;  
    }  
    public void setDescribe(String describe) {  
        this.describe = describe;  
    }
    
    public Boolean getDeleteFlag() {  
        return deleteFlag;  
    }  
    public void setDeleteFlag(Boolean deleteFlag) {  
        this.deleteFlag = deleteFlag;  
    }
    
}
