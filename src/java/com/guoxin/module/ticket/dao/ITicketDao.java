package com.guoxin.module.ticket.dao;

import java.util.List;
import com.guoxin.module.ticket.condition.TicketCondition;
import com.guoxin.module.ticket.entity.Ticket;

/**
 * 优惠券信息 DAO层接口
 * @author caoxin
 * @createTime 2016-12-17
 */
public interface ITicketDao {
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param 
     * @createTime 2016-12-17
     * @return Ticket
     */
    public Ticket getTicketById(Integer id);
    
    /**
     * 添加优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int insertTicket(Ticket ticket);
    
    /**
     * 更新优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateTicket(Ticket ticket);
    
    /**
     * 根据条件得到所有优惠券信息的分页列表
     * @author caoxin
     * @param ticketCondition 查询条件
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketPageList(TicketCondition condition);
    
    /**
     * 根据条件得到所有优惠券信息数量
     * @author caoxin
     * @param ticket 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getTicketCount(TicketCondition condition);
    
    /**
     * 根据条件得到所有优惠券信息列表
     * @author caoxin
     * @param ticket 查询条件
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketList(Ticket ticket);
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteTicketById(Integer id);
    
}
