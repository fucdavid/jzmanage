package com.guoxin.module.order.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.order.condition.OrderCondition;
import com.guoxin.module.order.dao.IOrderDao;
import com.guoxin.module.order.entity.Order;
import com.guoxin.module.order.service.IOrderService;

/**
 * 订单信息 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("orderService")
public class OrderService implements IOrderService {
    
    @Resource
    private IOrderDao orderDao;     //订单信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public Order getOrderById(Integer id){
        return this.orderDao.getOrderById(id);
    }
    
    /**
     * 添加订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addOrder(Order order) {
        return this.orderDao.insertOrder(order);
    }
    
    /**
     * 根据条件得到所有订单信息的分页列表
     * @author caoxin
     * @param orderCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getOrderPageList(OrderCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.orderDao.getOrderCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.orderDao.getOrderPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有订单信息
     * @author caoxin
     * @param orderCondition 查询条件
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderList(OrderCondition condition) {
        return this.orderDao.getOrderPageList(condition);
    }
    
    /**
     * 根据条件得到所有订单信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return List 订单信息列表
     */
    public List<Order> getOrderList(Order order) {
        return this.orderDao.getOrderList(order);
    }
    
    /**
     * 根据条件得到所有订单信息数量
     * @author caoxin
     * @param order 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getOrderCount(OrderCondition condition){
        return this.getOrderCount(condition);
    }
    
    /**
     * 更新订单信息信息
     * @author caoxin
     * @param order 订单信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateOrder(Order order){
        return this.orderDao.updateOrder(order);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteOrderById(Integer id){
        return this.orderDao.deleteOrderById(id);
    }
    
}
