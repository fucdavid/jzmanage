package com.guoxin.module.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.guoxin.common.base.BaseController;
import com.guoxin.common.base.Constants;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.UserCondition;
import com.guoxin.module.system.entity.Users;
import com.guoxin.module.system.service.IUserService;

/**
 * 用户管理控制层
 * @author Rocye
 * @createTime 2014-10-14
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    
    private final static Logger logger = Logger.getLogger(UserController.class.getName());
    
    @Resource
    private IUserService userService;
    
    /**
     * 跳转到用户列表首页
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/list")
    public String getUserList(Model model){
        try{
            UserCondition condition = new UserCondition();
            condition.setPageSize(10);
            condition.setOrderBys(" A.userId DESC ");
            PageInfo pageInfo = this.userService.getUserPageList(condition);
            
            model.addAttribute("pageInfo", pageInfo);
            return "/user/user-list";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("显示用户分页列表时:" + e.toString());
            model.addAttribute("msg", "显示用户列表出错!");
            model.addAttribute("url", "user/list");
            return "error";
        }
    }
    
    /**
     * 请求用户分页列表
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/listAjax", method=RequestMethod.POST)
    public ModelAndView getUserListByAjax(@ModelAttribute("condition") UserCondition condition){
        try{
            condition.setOrderBys(" A.userId DESC ");
            PageInfo pageInfo = this.userService.getUserPageList(condition);
            String jsonResult = JSON.toJSONStringWithDateFormat(pageInfo, "yyyy-MM-dd HH:mm:ss");
            this.printResponseMsg(jsonResult);
            return null;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax请求用户分页列表时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
            return null;
        }
    }
    
    /**
     * 准备编辑记录(跳转到编辑页面)
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/{id}/edit")
    public String preAddUser(@PathVariable Integer id, Model model){
        if(id != null && id > 0){
            Users user = this.userService.getUserById(id);
            model.addAttribute("user", user);
        }
        return "user/user-edit";
    }
    
    /**
     * 保存编辑记录By Ajax
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") Users user){
        try{
        	user.setUpdateTime(new Date());
            if(user.getUserId() != null && user.getUserId() > 0){
                int result = this.userService.updateUser(user);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"更新用户信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"更新用户信息失败!\"}");
                }
            }else{
                int result = this.userService.insertUser(user);
                if(result > 0){
                    this.printResponseMsg("{\"errcode\":0,\"msg\":\"添加用户信息成功!\"}");
                }else{
                    this.printResponseMsg("{\"errcode\":1,\"msg\":\"添加用户信息失败!\"}");
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
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/{id}/delete")
    public ModelAndView deleteUser(@PathVariable Integer id){
        try{
            if(this.userService.deleteUserById(id) > 0){
                this.printResponseMsg("{\"errcode\":0,\"msg\":\"删除用户信息成功!\"}");
            }else{
                this.printResponseMsg("{\"errcode\":1,\"msg\":\"删除用户信息失败!\"}");
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("保存编辑的记录时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 获取指定ID的用户信息By Ajax
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/{id}/show")
    public ModelAndView showUser(@PathVariable Integer id){
        try{
            Users user = this.userService.getUserById(id);
            String jsonResult = JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss");
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("保存编辑的记录时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
    
    /**
     * 利用Springmvc解板器上传文件By Ajax
     * @author Rocye
     * @createTime 2015-10-14
     */
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public ModelAndView uploadFile(HttpServletRequest request, String upType){
        System.out.println(upType);
        List<String> filePathList = new ArrayList<String>(0);
        try{
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
            //判断 request 是否有文件上传,即多部分请求
            if(multipartResolver.isMultipart(request)){
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while(iter.hasNext()){
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if(file != null){
                        //取得当前上传文件的文件名称  
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                        if(myFileName.trim() !=""){  
                            System.out.println(myFileName);
                            //重命名上传后的文件名  
                            String fileName = "F" + System.currentTimeMillis();
                            if(myFileName.contains(".")){
                                fileName += "." + StringUtils.substringAfterLast(myFileName, ".");
                            }
                            File localFile = new File(Constants.ROOT_PATH + "uploadtemp/" + fileName);
                            file.transferTo(localFile);
                            
                            filePathList.add("uploadtemp/" + fileName);
                        }
                    }
                }
            }
            String jsonResult = JSON.toJSONString(filePathList);
            this.printResponseMsg(jsonResult);
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Ajax上传文件时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
        }
        return null;
    }
}

