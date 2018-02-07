package com.guoxin.module.services.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.services.entity.Services;

/**
 * 服务模块 Condition
 * @author cx
 * @createTime 2017-01-12
 */
public class ServicesCondition extends BaseCondition {
    private Services services;
    
    public ServicesCondition() {
        this.services = new Services();
    }
    
    public ServicesCondition(Services services) {
        this.services = services;
    }
    
    public Services getServices() {
        return services;
    }
    public void setServices(Services services) {
        this.services = services;
    }
}
