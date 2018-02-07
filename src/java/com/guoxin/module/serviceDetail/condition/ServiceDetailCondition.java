package com.guoxin.module.serviceDetail.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;

/**
 * 服务详细信息 Condition
 * @author cx
 * @createTime 2017-01-12
 */
public class ServiceDetailCondition extends BaseCondition {
    private ServiceDetail serviceDetail;
    
    public ServiceDetailCondition() {
        this.serviceDetail = new ServiceDetail();
    }
    
    public ServiceDetailCondition(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
    
    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }
    public void setServiceDetail(ServiceDetail serviceDetail) {
        this.serviceDetail = serviceDetail;
    }
}
