package com.guoxin.module.clientAddress.controller;

import java.util.Date;
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
import com.guoxin.module.clientAddress.condition.ClientAddressCondition;
import com.guoxin.module.clientAddress.entity.ClientAddress;
import com.guoxin.module.clientAddress.service.IClientAddressService;

/**
 * 用户地址 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/clientAddress")
public class ClientAddressController extends BaseController{

    private final static Logger logger = Logger.getLogger(ClientAddressController.class.getName());
	
	@Resource
    private IClientAddressService clientAddressService;
    
    /**
     * 跳转到用户地址列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getClientAddressList(Model model){
        try{
            ClientAddressCondition condition = new ClientAddressCondition();
            condition.setOrderBys(" A.clientAddressId DESC ");
            PageInfo pageInfo = this.clientAddressService.getClientAddressPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/clientAddress/clientAddress-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示用户地址分页列表时:" + e.toString());
            model.addAttribute("msg", "显示用户地址列表出错!");
            model.addAttribute("url", "clientAddress/list");
            return "error";
        }
    }
    
    /**
     * 请求用户地址分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getClientAddressListByAjax(@ModelAttribute("condition") ClientAddressCondition condition){
        try{
            condition.setOrderBys(" A.clientAddressId DESC ");
            PageInfo pageInfo = this.clientAddressService.getClientAddressPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求用户地址分页列表时:" + e.toString());
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
    public String preAddClientAddress(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            ClientAddress clientAddress = this.clientAddressService.getClientAddressById(id);
            model.addAttribute("clientAddress", clientAddress);
        }
        return "clientAddress/clientAddress-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveClientAddress(@ModelAttribute("clientAddress") ClientAddress clientAddress){
        try{
        	clientAddress.setUpdateTime(new Date());
            if(clientAddress.getAddressId() != null && clientAddress.getAddressId() > 0){
                int result = this.clientAddressService.updateClientAddress(clientAddress);
                if(result > 0){
                	String jsonResult = JSON.toJSONStringWithDateFormat(clientAddress, "yyyy-MM-dd HH:mm");
                    this.printResponseMsg(jsonResult);
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新用户地址失败!\"}");
                }
            }else{
                int result = this.clientAddressService.addClientAddress(clientAddress);
                if(result > 0){
                	String jsonResult = JSON.toJSONStringWithDateFormat(clientAddress, "yyyy-MM-dd HH:mm");
                    this.printResponseMsg(jsonResult);
//                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加用户地址成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加用户地址失败!\"}");
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
    public ModelAndView deleteClientAddress(@PathVariable Integer id){
        try{
        	ClientAddress clientAddress = this.clientAddressService.getClientAddressById(id);
            if(this.clientAddressService.deleteClientAddressById(id) > 0){
            	ClientAddress clientAddress2 = new ClientAddress();
            	clientAddress2.setClientId(clientAddress.getClientId());
            	List<ClientAddress>  list = this.clientAddressService.getClientAddressList(clientAddress2);
            	String jsonResult = JSON.toJSONStringWithDateFormat(list.get(0), "yyyy-MM-dd HH:mm");
                this.printResponseMsg(jsonResult);
//                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除用户地址成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除用户地址失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户地址时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的用户地址By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showClientAddress(@PathVariable Integer id){
        try{
            ClientAddress clientAddress = this.clientAddressService.getClientAddressById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(clientAddress, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的用户地址时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
