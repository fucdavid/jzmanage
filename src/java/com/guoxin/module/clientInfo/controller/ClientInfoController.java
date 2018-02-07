package com.guoxin.module.clientInfo.controller;

import java.sql.Timestamp;
import java.util.Date;

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
import com.guoxin.module.clientInfo.condition.ClientInfoCondition;
import com.guoxin.module.clientInfo.entity.ClientInfo;
import com.guoxin.module.clientInfo.service.IClientInfoService;

/**
 * 客户信息 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/clientInfo")
public class ClientInfoController extends BaseController{

    private final static Logger logger = Logger.getLogger(ClientInfoController.class.getName());
	
	@Resource
    private IClientInfoService clientInfoService;
    
    /**
     * 跳转到客户信息列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getClientInfoList(Model model){
        try{
            ClientInfoCondition condition = new ClientInfoCondition();
            condition.setOrderBys(" A.clientId DESC ");
            PageInfo pageInfo = this.clientInfoService.getClientInfoPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/client/client-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示客户信息分页列表时:" + e.toString());
            model.addAttribute("msg", "显示客户信息列表出错!");
            model.addAttribute("url", "client/list");
            return "error";
        }
    }
    
    /**
     * 请求客户信息分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getClientInfoListByAjax(@ModelAttribute("condition") ClientInfoCondition condition){
        try{
            condition.setOrderBys(" A.clientId DESC ");
            PageInfo pageInfo = this.clientInfoService.getClientInfoPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求客户信息分页列表时:" + e.toString());
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
    public String preAddClientInfo(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            ClientInfo clientInfo = this.clientInfoService.getClientInfoById(id);
            model.addAttribute("clientInfo", clientInfo);
        }
        return "clientInfo/clientInfo-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveClientInfo(@ModelAttribute("clientInfo") ClientInfo clientInfo){
        try{
        	clientInfo.setUpdateTime(new Date());
            if(clientInfo.getClientId() != null && clientInfo.getClientId() > 0){
                int result = this.clientInfoService.updateClientInfo(clientInfo);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新客户信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新客户信息失败!\"}");
                }
            }else{
            	clientInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
                int result = this.clientInfoService.addClientInfo(clientInfo);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"clientId\":\""+result+"\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加客户信息失败!\"}");
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
    public ModelAndView deleteClientInfo(@PathVariable Integer id){
        try{
            if(this.clientInfoService.deleteClientInfoById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除客户信息成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除客户信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除客户信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的客户信息By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showClientInfo(@PathVariable Integer id){
        try{
            ClientInfo clientInfo = this.clientInfoService.getClientInfoById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(clientInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的客户信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
