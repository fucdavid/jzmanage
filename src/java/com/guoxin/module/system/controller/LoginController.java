package com.guoxin.module.system.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.guoxin.common.base.Constants;
import com.guoxin.common.util.Config;
import com.guoxin.module.system.entity.Users;
import com.guoxin.module.system.service.IUserService;
import com.guoxin.module.wximpl.util.WxBaseUtil;

/**
 * 用户登录登出控制层
 * @author Rocye
 * @createTime 2014-10-14
 */
@Controller
public class LoginController {
    
    private final static Logger logger = Logger.getLogger(LoginController.class.getName());
    
    @Resource
    private IUserService userService;
    
    /**
     * 用户登陆系统	
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute("user") Users user, HttpSession session, final RedirectAttributes attr){
        try{
            if (user.getLoginName() == null || "".equals(user.getLoginName().trim()) || user.getPassword() == null || "".equals(user.getPassword().trim())) {
                attr.addFlashAttribute("msg", "登录名或密码不能为空!");
                return "redirect:/index";
            } else {
                Map<String, Object> resultMap = this.userService.loginSystemByUser(user);
                if(Integer.parseInt(resultMap.get("msgid").toString()) == 0){
                    attr.addFlashAttribute("msg", resultMap.get("msg").toString());
                    return "redirect:/index";
                }else{
                    session.setAttribute(Constants.LOGIN_KEY, resultMap.get("user"));
                    return "redirect:order/list";
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("登录系统时出错:" + e.toString());
            attr.addFlashAttribute("msg", "发生错误，请联系管理员！");
            return "redirect:/index";
        }
    }
    
    /**
     * 跳转用户登录页面
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/index")
    public String index(){
        return "../index";
    }
    
    /**
     * 登录超时提示页
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/timeout")
    public String loginTimeout(Model model){
        model.addAttribute("msg", "用户登录信息已超期, 请重新登录！");
        model.addAttribute("url", "index");
        return "error-login";
    }
    
    /**
     * 注销用户登录
     * @author Rocye
     * @createTime 2015-10-13
     */
    @RequestMapping(value="/logout")
    public String logout(HttpSession session){
        if(session != null){
            session.removeAttribute(Constants.LOGIN_KEY);
            session.invalidate();
        }
        return "../index";
    }
}
