package com.guoxin.module.ticket.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.ticket.condition.TicketCondition;
import com.guoxin.module.ticket.entity.Ticket;

/**
 * 优惠券信息 Service层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface ITicketService {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public Ticket getTicketById(Integer id);
    
    /**
     * 添加优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addTicket(Ticket ticket);
    
    /**
     * 根据条件得到所有优惠券信息的分页列表
     * @author caoxin
     * @param ticketCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getTicketPageList(TicketCondition condition);
    
    /**
     * 根据条件得到所有优惠券信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketList(Ticket ticket);
    
    /**
     * 根据条件得到所有优惠券信息
     * @author caoxin
     * @param ticketCondition 查询条件
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketList(TicketCondition condition);
    
    /**
     * 根据条件得到所有优惠券信息数量
     * @author caoxin
     * @param ticket 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getTicketCount(TicketCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteTicketById(Integer id);
    
    /**
     * 更新优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateTicket(Ticket ticket);
    
}
