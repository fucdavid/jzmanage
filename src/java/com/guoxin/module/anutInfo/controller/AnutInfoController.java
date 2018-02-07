package com.guoxin.module.anutInfo.controller;

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
import com.guoxin.module.anutInfo.condition.AnutInfoCondition;
import com.guoxin.module.anutInfo.entity.AnutInfo;
import com.guoxin.module.anutInfo.service.IAnutInfoService;

/**
 * 阿姨信息 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/anutInfo")
public class AnutInfoController extends BaseController{

    private final static Logger logger = Logger.getLogger(AnutInfoController.class.getName());
	
	@Resource
    private IAnutInfoService anutInfoService;
    
    /**
     * 跳转到阿姨信息列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getAnutInfoList(Model model){
        try{
            AnutInfoCondition condition = new AnutInfoCondition();
            condition.setOrderBys(" A.anutId DESC ");
            PageInfo pageInfo = this.anutInfoService.getAnutInfoPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/anutInfo/anut-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示阿姨信息分页列表时:" + e.toString());
            model.addAttribute("msg", "显示阿姨信息列表出错!");
            model.addAttribute("url", "anutInfo/list");
            return "error";
        }
    }
    
    /**
     * 请求阿姨信息分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getAnutInfoListByAjax(@ModelAttribute("condition") AnutInfoCondition condition){
        try{
            condition.setOrderBys(" A.anutId DESC ");
            PageInfo pageInfo = this.anutInfoService.getAnutInfoPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求阿姨信息分页列表时:" + e.toString());
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
    public String preAddAnutInfo(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            AnutInfo anutInfo = this.anutInfoService.getAnutInfoById(id);
            model.addAttribute("anutInfo", anutInfo);
        }
        return "anutInfo/anutInfo-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveAnutInfo(@ModelAttribute("anutInfo") AnutInfo anutInfo){
        try{
        	anutInfo.setUpdateTime(new Date());
            if(anutInfo.getAnutId() != null && anutInfo.getAnutId() > 0){
                int result = this.anutInfoService.updateAnutInfo(anutInfo);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新阿姨信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新阿姨信息失败!\"}");
                }
            }else{
            	anutInfo.setState(0);
                int result = this.anutInfoService.addAnutInfo(anutInfo);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加阿姨信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加阿姨信息失败!\"}");
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
    public ModelAndView deleteAnutInfo(@PathVariable Integer id){
        try{
            if(this.anutInfoService.deleteAnutInfoById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除阿姨信息成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除阿姨信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除阿姨信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的阿姨信息By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showAnutInfo(@PathVariable Integer id){
        try{
            AnutInfo anutInfo = this.anutInfoService.getAnutInfoById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(anutInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的阿姨信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
