package com.guoxin.module.ticket.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.ticket.entity.Ticket;

/**
 * 优惠券信息 Condition
 * @author caoxin
 * @createTime 2016-12-17
 */
public class TicketCondition extends BaseCondition {
    private Ticket ticket;
    
    public TicketCondition() {
        this.ticket = new Ticket();
    }
    
    public TicketCondition(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
