package com.guoxin.module.ticket.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import com.guoxin.common.base.BaseController;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.ticket.condition.TicketCondition;
import com.guoxin.module.ticket.entity.Ticket;
import com.guoxin.module.ticket.service.ITicketService;

/**
 * 优惠券信息 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController{

    private final static Logger logger = Logger.getLogger(TicketController.class.getName());
	
	@Resource
    private ITicketService ticketService;
    
    /**
     * 跳转到优惠券信息列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getTicketList(Model model){
        try{
            TicketCondition condition = new TicketCondition();
            condition.setOrderBys(" A.ticketId DESC ");
            PageInfo pageInfo = this.ticketService.getTicketPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/ticket/ticket-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示优惠券信息分页列表时:" + e.toString());
            model.addAttribute("msg", "显示优惠券信息列表出错!");
            model.addAttribute("url", "ticket/list");
            return "error";
        }
    }
    
    /**
     * 请求优惠券信息分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getTicketListByAjax(@ModelAttribute("condition") TicketCondition condition){
        try{
            condition.setOrderBys(" A.ticketId DESC ");
            PageInfo pageInfo = this.ticketService.getTicketPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求优惠券信息分页列表时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
            return null;
        }
    }
    
    /**
     * 准备编辑记录(跳转到编辑页面)
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/edit")
    public String preAddTicket(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            Ticket ticket = this.ticketService.getTicketById(id);
            model.addAttribute("ticket", ticket);
        }
        return "ticket/ticket-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveTicket(@ModelAttribute("ticket") Ticket ticket){
        try{
            if(ticket.getTicketId() != null && ticket.getTicketId() > 0){
                int result = this.ticketService.updateTicket(ticket);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新优惠券信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新优惠券信息失败!\"}");
                }
            }else{
                int result = this.ticketService.addTicket(ticket);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加优惠券信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加优惠券信息失败!\"}");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("保存编辑的记录时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 删除指定ID的记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/delete")
    public ModelAndView deleteTicket(@PathVariable Integer id){
        try{
            if(this.ticketService.deleteTicketById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除优惠券信息成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除优惠券信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除优惠券信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的优惠券信息By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showTicket(@PathVariable Integer id){
        try{
            Ticket ticket = this.ticketService.getTicketById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(ticket, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的优惠券信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
