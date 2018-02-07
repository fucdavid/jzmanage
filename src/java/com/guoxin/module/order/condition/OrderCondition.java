package com.guoxin.module.order.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.order.entity.Order;

/**
 * 订单信息 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class OrderCondition extends BaseCondition {
    private Order order;
    
    public OrderCondition() {
        this.order = new Order();
    }
    
    public OrderCondition(Order order) {
        this.order = order;
    }
    
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
