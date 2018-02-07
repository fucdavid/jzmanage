package com.guoxin.module.serviceDetail.controller;

import java.util.Date;

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
import com.guoxin.module.serviceDetail.condition.ServiceDetailCondition;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;
import com.guoxin.module.serviceDetail.service.IServiceDetailService;

/**
 * 服务详细信息 Controller
 * @author cx
 * @createTime 2017-01-12
 */
@Controller
@RequestMapping("/serviceDetail")
public class ServiceDetailController extends BaseController{

    private final static Logger logger = Logger.getLogger(ServiceDetailController.class.getName());
	
	@Resource
    private IServiceDetailService serviceDetailService;
    
    /**
     * 跳转到服务详细信息列表首页
     * @author cx
     * @createTime 2017-01-12
     */
    @RequestMapping(value="/list")
    public String getServiceDetailList(Model model){
        try{
            ServiceDetailCondition condition = new ServiceDetailCondition();
            condition.setOrderBys(" A.detailId DESC ");
            PageInfo pageInfo = this.serviceDetailService.getServiceDetailPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/serviceDetail/serviceDetail-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示服务详细信息分页列表时:" + e.toString());
            model.addAttribute("msg", "显示服务详细信息列表出错!");
            model.addAttribute("url", "serviceDetail/list");
            return "error";
        }
    }
    
    /**
     * 请求服务详细信息分页列表
     * @author cx
     * @createTime 2017-01-12
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getServiceDetailListByAjax(@ModelAttribute("condition") ServiceDetailCondition condition){
        try{
            condition.setOrderBys(" A.DetailId DESC ");
            PageInfo pageInfo = this.serviceDetailService.getServiceDetailPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求服务详细信息分页列表时:" + e.toString());
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
    public String preAddServiceDetail(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            ServiceDetail serviceDetail = this.serviceDetailService.getServiceDetailById(id);
            model.addAttribute("serviceDetail", serviceDetail);
        }
        return "serviceDetail/serviceDetail-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author cx
     * @createTime 2017-01-12
     */
    @ResponseBody
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveServiceDetail(@ModelAttribute("serviceDetail") ServiceDetail serviceDetail){
        try{
        	serviceDetail.setUpdateTime(new Date());
            if(serviceDetail.getDetailId() != null && serviceDetail.getDetailId() > 0){
                int result = this.serviceDetailService.updateServiceDetail(serviceDetail);
                if(result > 0){
                	this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新服务详细信息成功!\"}");
                }else{
                	this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新服务详细信息失败!\"}");
                }
            }else{
                int result = this.serviceDetailService.addServiceDetail(serviceDetail);
                if(result > 0){
                	this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加服务详细信息成功!\"}");
                }else{
                	this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加服务详细信息失败!\"}");
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
    public ModelAndView deleteServiceDetail(@PathVariable Integer id){
        try{
            if(this.serviceDetailService.deleteServiceDetailById(id) > 0){
            	this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除服务详细信息成功!\"}");
            }else{
            	this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除服务详细信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除服务详细信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的服务详细信息By Ajax
     * @author cx
     * @createTime 2017-01-12
     */
    @ResponseBody
    @RequestMapping(value="/{id}/show")
    public ModelAndView showServiceDetail(@PathVariable Integer id){
        try{
            ServiceDetail serviceDetail = this.serviceDetailService.getServiceDetailById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(serviceDetail, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的服务详细信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
