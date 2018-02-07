package com.guoxin.module.services.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.guoxin.common.base.BaseController;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.services.condition.ServicesCondition;
import com.guoxin.module.services.entity.Services;
import com.guoxin.module.services.service.IServicesService;

/**
 * 服务模块 Controller
 * @author cx
 * @createTime 2017-01-12
 */
@Controller
@RequestMapping("/services")
public class ServicesController extends BaseController{

    private final static Logger logger = Logger.getLogger(ServicesController.class.getName());
	
	@Resource
    private IServicesService servicesService;
    
    /**
     * 跳转到服务模块列表首页
     * @author cx
     * @createTime 2017-01-12
     */
    @RequestMapping(value="/list")
    public String getServicesList(Model model){
        try{
            ServicesCondition condition = new ServicesCondition();
            condition.setOrderBys(" A.servicesId DESC ");
            PageInfo pageInfo = this.servicesService.getServicesPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/services/services-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示服务模块分页列表时:" + e.toString());
            model.addAttribute("msg", "显示服务模块列表出错!");
            model.addAttribute("url", "services/list");
            return "error";
        }
    }
    
    /**
     * 请求服务模块分页列表
     * @author cx
     * @createTime 2017-01-12
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getServicesListByAjax(@ModelAttribute("condition") ServicesCondition condition){
        try{
            condition.setOrderBys(" A.servicesId DESC ");
            PageInfo pageInfo = this.servicesService.getServicesPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求服务模块分页列表时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
            return null;
        }
    }
    
    /**
     * 准备编辑记录(跳转到编辑页面)
     * @author cx
     * @createTime 2017-01-12
     */
    @RequestMapping(value="/{id}/edit")
    public String preAddServices(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            Services services = this.servicesService.getServicesById(id);
            model.addAttribute("services", services);
        }
        return "services/services-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author cx
     * @createTime 2017-01-12
     */
    @ResponseBody
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveServices(@ModelAttribute("services") Services services){
        try{
            if(services.getServiceId() != null && services.getServiceId() > 0){
                int result = this.servicesService.updateServices(services);
                if(result > 0){
                	this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新服务模块成功!\"}");
                }else{
                	this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新服务模块失败!\"}");
                }
            }else{
                int result = this.servicesService.addServices(services);
                if(result > 0){
                	this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加服务模块成功!\"}");
                }else{
                	this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加服务模块失败!\"}");
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
     * @author cx
     * @createTime 2017-01-12
     */
    @ResponseBody
    @RequestMapping(value="/{id}/delete")
    public ModelAndView deleteServices(@PathVariable Integer id){
        try{
            if(this.servicesService.deleteServicesById(id) > 0){
            	this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除服务模块成功!\"}");
            }else{
            	this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除服务模块失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除服务模块时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
		return null;
    }
    
    /**
     * 获取指定ID的服务模块By Ajax
     * @author cx
     * @createTime 2017-01-12
     */
    @ResponseBody
    @RequestMapping(value="/{id}/show")
    public ModelAndView showServices(@PathVariable Integer id){
        try{
            Services services = this.servicesService.getServicesById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(services, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的服务模块时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
		return null;
    }

}
