package com.guoxin.module.ticket.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.ticket.condition.TicketCondition;
import com.guoxin.module.ticket.dao.ITicketDao;
import com.guoxin.module.ticket.entity.Ticket;
import com.guoxin.module.ticket.service.ITicketService;

/**
 * 优惠券信息 Service层实现类
 * @author caoxin
 * @createTime 2016-12-17
 */
@Service("ticketService")
public class TicketService implements ITicketService {
    
    @Resource
    private ITicketDao ticketDao;     //优惠券信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author caoxin
     * @param Integer 
     * @createTime 2016-12-17
     * @return 
     */
    public Ticket getTicketById(Integer id){
        return this.ticketDao.getTicketById(id);
    }
    
    /**
     * 添加优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int addTicket(Ticket ticket) {
        return this.ticketDao.insertTicket(ticket);
    }
    
    /**
     * 根据条件得到所有优惠券信息的分页列表
     * @author caoxin
     * @param ticketCondition 查询条件
     * @createTime 2016-12-17
     * @return PageInfo 分页对象
     */
    public PageInfo getTicketPageList(TicketCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.ticketDao.getTicketCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.ticketDao.getTicketPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有优惠券信息
     * @author caoxin
     * @param ticketCondition 查询条件
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketList(TicketCondition condition) {
        return this.ticketDao.getTicketPageList(condition);
    }
    
    /**
     * 根据条件得到所有优惠券信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return List 优惠券信息列表
     */
    public List<Ticket> getTicketList(Ticket ticket) {
        return this.ticketDao.getTicketList(ticket);
    }
    
    /**
     * 根据条件得到所有优惠券信息数量
     * @author caoxin
     * @param ticket 查询条件
     * @createTime 2016-12-17
     * @return Integer 记录数
     */
    public Integer getTicketCount(TicketCondition condition){
        return this.getTicketCount(condition);
    }
    
    /**
     * 更新优惠券信息信息
     * @author caoxin
     * @param ticket 优惠券信息实例
     * @createTime 2016-12-17
     * @return 
     */
    public int updateTicket(Ticket ticket){
        return this.ticketDao.updateTicket(ticket);
    }
    
    /**
     * 删除指定ID的实例
     * @author caoxin
     * @param id 要删除实例的ID
     * @createTime 2016-12-17
     */
    public int deleteTicketById(Integer id){
        return this.ticketDao.deleteTicketById(id);
    }
    
}
