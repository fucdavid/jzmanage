package com.guoxin.module.order.dao;

import java.util.List;
import com.guoxin.module.order.condition.OrderCondition;
import com.guoxin.module.order.entity.Order;

/**
 * 订单信息 DAO层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IOrderDao {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param 
     * @createTime 2016-12-17
     * @return Order
     */
    public Order getOrderById(Integer id);
    
    /**
     * 添加订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int insertOrder(Order order);
    
    /**
     * 更新订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateOrder(Order order);
    
    /**
     * 根据条件得到所有订单信息的分页列表
     * @author caoxin
     * @param orderCondition 查询条件
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderPageList(OrderCondition condition);
    
    /**
     * 根据条件得到所有订单信息数量
     * @author caoxin
     * @param order 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getOrderCount(OrderCondition condition);
    
    /**
     * 根据条件得到所有订单信息列表
     * @author caoxin
     * @param order 查询条件
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderList(Order order);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteOrderById(Integer id);
    
}
