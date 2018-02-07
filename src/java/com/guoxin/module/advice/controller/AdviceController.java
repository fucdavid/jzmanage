package com.guoxin.module.advice.controller;

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
import com.guoxin.module.advice.condition.AdviceCondition;
import com.guoxin.module.advice.entity.Advice;
import com.guoxin.module.advice.service.IAdviceService;

/**
 * 用户建议 Controller
 * @author caoxin
 * @createTime 2016-12-17
 */
@Controller
@RequestMapping("/advice")
public class AdviceController extends BaseController{

    private final static Logger logger = Logger.getLogger(AdviceController.class.getName());
	
	@Resource
    private IAdviceService adviceService;
    
    /**
     * 跳转到用户建议列表首页
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/list")
    public String getAdviceList(Model model){
        try{
            AdviceCondition condition = new AdviceCondition();
            condition.setOrderBys(" A.adviceId DESC ");
            PageInfo pageInfo = this.adviceService.getAdvicePageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/advice/advice-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示用户建议分页列表时:" + e.toString());
            model.addAttribute("msg", "显示用户建议列表出错!");
            model.addAttribute("url", "advice/list");
            return "error";
        }
    }
    
    /**
     * 请求用户建议分页列表
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getAdviceListByAjax(@ModelAttribute("condition") AdviceCondition condition){
        try{
            condition.setOrderBys(" A.adviceId DESC ");
            PageInfo pageInfo = this.adviceService.getAdvicePageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求用户建议分页列表时:" + e.toString());
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
    public String preAddAdvice(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            Advice advice = this.adviceService.getAdviceById(id);
            model.addAttribute("advice", advice);
        }
        return "advice/advice-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveAdvice(@ModelAttribute("advice") Advice advice){
        try{
            if(advice.getAdviceId() != null && advice.getAdviceId() > 0){
                int result = this.adviceService.updateAdvice(advice);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新用户建议成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新用户建议失败!\"}");
                }
            }else{
                int result = this.adviceService.addAdvice(advice);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加用户建议成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加用户建议失败!\"}");
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
    public ModelAndView deleteAdvice(@PathVariable Integer id){
        try{
            if(this.adviceService.deleteAdviceById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除用户建议成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除用户建议失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户建议时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的用户建议By Ajax
     * @author caoxin
     * @createTime 2016-12-17
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showAdvice(@PathVariable Integer id){
        try{
            Advice advice = this.adviceService.getAdviceById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(advice, "yyyy-MM-dd HH:mm");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取指定ID的用户建议时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }

}
