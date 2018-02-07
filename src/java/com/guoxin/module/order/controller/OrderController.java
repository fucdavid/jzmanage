package com.guoxin.module.order.controller;

import java.sql.Timestamp;
import java.util.List;

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
import com.guoxin.module.order.condition.OrderCondition;
import com.guoxin.module.order.entity.Order;
import com.guoxin.module.order.service.IOrderService;

/**
 * 订单信息 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

    private final static Logger logger = Logger.getLogger(OrderController.class.getName());
	
	@Resource
    private IOrderService orderService;
    
    /**
     * 跳转到订单信息列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getOrderList(Model model){
        try{
            OrderCondition condition = new OrderCondition();
            condition.setOrderBys(" A.updateTime DESC ");
            PageInfo pageInfo = this.orderService.getOrderPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/order/order-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示订单信息分页列表时:" + e.toString());
            model.addAttribute("msg", "显示订单信息列表出错!");
            model.addAttribute("url", "order/list");
            return "error";
        }
    }
    
    /**
     * 请求订单信息分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getOrderListByAjax(@ModelAttribute("condition") OrderCondition condition){
        try{
            condition.setOrderBys(" A.updateTime DESC");
            PageInfo pageInfo = this.orderService.getOrderPageList(condition);
            String jsonResult = JSON.toJSONString(pageInfo);
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求订单信息分页列表时:" + e.toString());
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
    public String preAddOrder(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            Order order = this.orderService.getOrderById(id);
            model.addAttribute("order", order);
        }
        return "order/order-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveOrder(@ModelAttribute("order") Order order){
        try{
        	order.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            if(order.getOrderId() != null && order.getOrderId() > 0){
                int result = this.orderService.updateOrder(order);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新订单信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新订单信息失败!\"}");
                }
            }else{
            	 //生成订单号
                int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
                int r2=(int)(Math.random()*(10));
                long now = System.currentTimeMillis();//一个13位的时间戳
                String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
                order.setOrderCode(paymentID);
                int result = this.orderService.addOrder(order);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加订单信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加订单信息失败!\"}");
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
    public ModelAndView deleteOrder(@PathVariable Integer id){
        try{
            if(this.orderService.deleteOrderById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除订单信息成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除订单信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除订单信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的订单信息By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showOrder(@PathVariable Integer id){
        try{
            Order order = this.orderService.getOrderById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(order, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的订单信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
