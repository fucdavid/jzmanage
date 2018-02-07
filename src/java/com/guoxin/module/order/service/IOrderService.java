package com.guoxin.module.order.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.order.condition.OrderCondition;
import com.guoxin.module.order.entity.Order;

/**
 * 订单信息 Service层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface IOrderService {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public Order getOrderById(Integer id);
    
    /**
     * 添加订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addOrder(Order order);
    
    /**
     * 根据条件得到所有订单信息的分页列表
     * @author caoxin
     * @param orderCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getOrderPageList(OrderCondition condition);
    
    /**
     * 根据条件得到所有订单信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderList(Order order);
    
    /**
     * 根据条件得到所有订单信息
     * @author caoxin
     * @param orderCondition 查询条件
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderList(OrderCondition condition);
    
    /**
     * 根据条件得到所有订单信息数量
     * @author caoxin
     * @param order 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getOrderCount(OrderCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteOrderById(Integer id);
    
    /**
     * 更新订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateOrder(Order order);
    
}
