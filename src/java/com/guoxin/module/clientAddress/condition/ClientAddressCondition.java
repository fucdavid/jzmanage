package com.guoxin.module.clientAddress.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.clientAddress.entity.ClientAddress;

/**
 * 用户地址 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class ClientAddressCondition extends BaseCondition {
    private ClientAddress clientAddress;
    
    public ClientAddressCondition() {
        this.clientAddress = new ClientAddress();
    }
    
    public ClientAddressCondition(ClientAddress clientAddress) {
        this.clientAddress = clientAddress;
    }
    
    public ClientAddress getClientAddress() {
        return clientAddress;
    }
    public void setClientAddress(ClientAddress clientAddress) {
        this.clientAddress = clientAddress;
    }
}
