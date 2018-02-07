package com.guoxin.module.clientInfo.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.clientInfo.entity.ClientInfo;

/**
 * 客户信息 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class ClientInfoCondition extends BaseCondition {
    private ClientInfo clientInfo;
    
    public ClientInfoCondition() {
        this.clientInfo = new ClientInfo();
    }
    
    public ClientInfoCondition(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
    
    public ClientInfo getClientInfo() {
        return clientInfo;
    }
    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
