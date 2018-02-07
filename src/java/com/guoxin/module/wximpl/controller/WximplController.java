package com.guoxin.module.wximpl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.guoxin.common.base.BaseController;
import com.guoxin.common.page.PageInfo;
import com.guoxin.common.util.Config;
import com.guoxin.common.util.CookieUtil;
import com.guoxin.common.util.DateUtil;
import com.guoxin.common.util.SendMsg;
import com.guoxin.module.clientAddress.entity.ClientAddress;
import com.guoxin.module.clientAddress.service.IClientAddressService;
import com.guoxin.module.clientInfo.entity.ClientInfo;
import com.guoxin.module.clientInfo.service.IClientInfoService;
import com.guoxin.module.order.condition.OrderCondition;
import com.guoxin.module.order.entity.Order;
import com.guoxin.module.order.service.IOrderService;
import com.guoxin.module.serviceDetail.entity.ServiceDetail;
import com.guoxin.module.serviceDetail.service.IServiceDetailService;
import com.guoxin.module.services.entity.Services;
import com.guoxin.module.services.service.IServicesService;
import com.guoxin.module.wximpl.util.WxBaseUtil;
import com.guoxin.module.wximpl.vo.UseDate;
import com.sun.jmx.snmp.Timestamp;

/**
 * 微信相关内容处理
 * @author caoxin
 *
 */
@Controller
@RequestMapping("/wximpl")
public class WximplController extends BaseController{
	private final static Logger logger = Logger.getLogger(WximplController.class.getName());
	@Resource
	private IClientInfoService clientInfoService;
	@Resource
	private IServiceDetailService serviceDetailService;
	@Resource
	private IServicesService servicesService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IClientAddressService clientAddressService;
	private String tplId = "25692";
	
	/**
	 * 绑定和接受消息用的是不同的方式
	 * @author PSY
	 * @createTime 2015-3-5 下午04:58:05
	 */
	@RequestMapping(value="/msgIn")
	public ModelAndView msgIn(){
		if("GET".equals(this.getRequest().getMethod())){
//			bindMsg();
			logger.warn("需要绑定开发者模式");
		}else if("POST".equals(this.getRequest().getMethod())){
			logger.warn("接受到消息");
//			if(WxBaseCheck.checkSignature(request, Constants.BIND_TOKEN)){
//				handleMsgIn();
//			}else{
//				logger.warn("消息验证失败，来源不是微信！");
//			}
		}
		return null;
	}
	
	/**
     * 调用微信二次授权(静默授权)
     * @author caoxin
     */
    @RequestMapping(value="/oauth")
    public String oauth(Model model){
    	String openid = CookieUtil.getCookie(this.getRequest(), "openId_meijia");
    	if(null == openid || "".equals(openid)){
    		logger.warn("no cookie....");
    		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ Config.getAttribute("AppId") +"&redirect_uri="+ Config.getAttribute("ServerURL") + "wximpl/redirecturi&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    		System.out.println(url);
    		return "redirect:" + url;
    	}else{
    		//先判断这个openid在数据库中是否存在
    		logger.warn("cookie:"+openid);
    		return "mobile/eshop-home";
//        	ClientInfo clientInfo = new ClientInfo();
//        	clientInfo.setOpenId(openid);
//        	List<ClientInfo> list = this.clientInfoService.getClientInfoList(clientInfo);
//        	if(list.size() > 0){
//        		Integer clientId = list.get(0).getClientId();
//        		//跳转商城首页面
//        		model.addAttribute("clientId", clientId);
//        		return "mobile/eshop-home";
//        	}else{
//        		//跳转手机号验证页面
//        		model.addAttribute("openid", openid);
//        		return "mobile/phone-valid";
//        	}
    	}
    }
    
    /**
     * 二次授权回调地址
     * @author caoxin
     * @return
     */
    @RequestMapping(value="/redirecturi")
    public String oauth2CrossDomain(Model model){
    	String state=this.getRequest().getParameter("state");
        String code=this.getRequest().getParameter("code");
    	try {
    		if(state == null){
                logger.warn("获取的参数state为空!");
                return null;
            }
    		if(code == null){
                logger.warn("获取的参数code为空!");
                return null;
            }
    		//去取access_token
            Map<String, Object> resultMap = WxBaseUtil.getOAuth2AccessTokenByCode(Config.getAttribute("AppId"), Config.getAttribute("AppSecret"), code);
            if(resultMap == null){
                //跳到提示页，提示重新授权
                logger.warn("get AccessToken failed!");
                return "forward:/wximpl/oauth";
            }else{
            	String openid = resultMap.get("openid").toString();
            	CookieUtil.setCookie(this.getResponse(), "openId_meijia", openid, 24*60*60);
            	return "mobile/eshop-home";
//            	//先判断这个openid在数据库中是否存在
//            	ClientInfo clientInfo = new ClientInfo();
//            	clientInfo.setOpenId(openid);
//            	List<ClientInfo> list = this.clientInfoService.getClientInfoList(clientInfo);
//            	if(list.size() > 0){
//            		Integer clientId = list.get(0).getClientId();
//            		//跳转商城首页面
//            		model.addAttribute("clientId", clientId);
//            		return "mobile/eshop-home";
//            	}else{
//            		//跳转手机号验证页面
//            		model.addAttribute("openid", openid);
//            		return "mobile/phone-valid";
//            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("二次授权回调地址时:" + e.toString());
			return null;
		}
    }
    
    /**
     * 跳转手机商城首页
     * @author caoxin
     * @return
     */
    @RequestMapping(value="/gohome")
    public String gohome(Model model){
    	try {
    		String openId = this.getRequest().getParameter("openId");
        	ClientInfo clientInfo = new ClientInfo();
        	clientInfo.setOpenId(openId);
        	List<ClientInfo> list = this.clientInfoService.getClientInfoList(clientInfo);
        	model.addAttribute("clientId",list.get(0).getClientId());
        	return "mobile/eshop-home";
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("跳转手机商城首页时:" + e.toString());
            return "error";
		}
    }
    
    /**
     * 跳转手机家洁士页面
     * @author cx
     */
    @RequestMapping(value="/services/{serviceId}_{clientId}")
    public String goJiajs(Model model,@PathVariable Integer serviceId,@PathVariable Integer clientId){
    	try {
    		//查询服务
        	Services services = this.servicesService.getServicesById(serviceId);
        	ServiceDetail serviceDetail = new ServiceDetail();
        	serviceDetail.setServiceId(serviceId);
        	List<ServiceDetail> list = this.serviceDetailService.getServiceDetailList(serviceDetail);
        	model.addAttribute("clientId",clientId);
        	model.addAttribute("list",list);
        	model.addAttribute("serviceId",serviceId);
        	model.addAttribute("serviceName",services.getServiceName());
        	if(serviceId == 4){
        		model.addAttribute("serviceDetail",list.get(0));
        		return "mobile/housekeeper-service";
        	}else{
        		return "mobile/jiajs-place";
        	}
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("跳转手机家洁士页面时:" + e.toString());
            return "error";
		}
    }
    
    /**
     * 跳转手机家洁士服务详情页面
     * @author cx
     */
    @RequestMapping(value="/detail/{detailId}_{clientId}")
    public String goDetail(Model model,@PathVariable Integer detailId,@PathVariable Integer clientId){
    	ServiceDetail serviceDetail = this.serviceDetailService.getServiceDetailById(detailId);
    	model.addAttribute("clientId",clientId);
    	model.addAttribute("serviceDetail",serviceDetail);
    	if(detailId == 1){
    		return "mobile/jujia-service";
    	}else if(detailId == 2){
    		return "mobile/shendu-service";
    	}else if(detailId == 3){
    		return "mobile/newlive-service";
    	}else if(detailId == 4){
    		return "mobile/kongtiao-service";
    	}else if(detailId == 5){
    		return "mobile/youyanji-service";
    	}else if(detailId == 6){
    		return "mobile/3Astarhouse-service";
    	}else if(detailId == 7){
    		return "mobile/4Astarhouse-service";
    	}else if(detailId == 8){
    		return "mobile/5Astarhouse-service";
    	}
		return null;
    }
    
    /**
     * 跳转家洁士生成订单页面
     * @author cx
     */
    @RequestMapping(value="/generate/{detailId}_{clientId}")
    public String generateOrder(Model model,@PathVariable Integer detailId,@PathVariable Integer clientId){
    	//获取当前时间 格式2017年4月
    	String date = DateUtil.format2(new Date());
    	String dateTime = date.split("-")[0] + "年" + date.split("-")[1] + "月";
    	ServiceDetail detail = this.serviceDetailService.getServiceDetailById(detailId);
    	String week = DateUtil.getWeekOfDate(new Date());
    	List<UseDate> list = new ArrayList<UseDate>();
    	for (int i = 0; i < 7; i++) {
    		UseDate useDate = new UseDate();
    		Calendar calendar = new GregorianCalendar();
    		calendar.setTime(new Date());
    		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + i);
    		String dat = DateUtil.format2(calendar.getTime());
    		useDate.setDateInfo(dat);
    		useDate.setDay(dat.split("-")[2]);
    		useDate.setWeek(DateUtil.getWeekOfDate(calendar.getTime()));
    		list.add(useDate);
		}
    	model.addAttribute("clientId",clientId);
    	model.addAttribute("detail",detail);
    	model.addAttribute("date",dateTime);
    	model.addAttribute("datelist",list);
    	return "mobile/order-generate";
    }
    
    /**
     * 跳转检查确认订单页面
     * @author cx
     */
    @RequestMapping(value="/checkOrder")
    public String checkOrder(Model model){
    	try {
    		String detailId = this.getRequest().getParameter("did"); 
        	String datetime = this.getRequest().getParameter("datetime");
        	String clientId = this.getRequest().getParameter("clientId");
        	String area = this.getRequest().getParameter("area");
        	ServiceDetail serviceDetail = this.serviceDetailService.getServiceDetailById(Integer.parseInt(detailId));
        	ClientInfo clientInfo = this.clientInfoService.getClientInfoById(Integer.parseInt(clientId));
        	ClientAddress clientAddress = new ClientAddress();
        	clientAddress.setClientId(Integer.parseInt(clientId));
        	List<ClientAddress> addressList = this.clientAddressService.getClientAddressList(clientAddress);
        	model.addAttribute("clientInfo",clientInfo);
        	model.addAttribute("serviceDetail",serviceDetail);
        	model.addAttribute("addressList",addressList);
        	model.addAttribute("datetime",datetime);
        	if(null != area && !"".equals(area)){
        		model.addAttribute("num",Integer.parseInt(area));
        		if("1".equals(area)){
            		model.addAttribute("money",serviceDetail.getMoneya());
            	}
        		if("2".equals(area)){
            		model.addAttribute("money",serviceDetail.getMoneyb());
            	}
        		if("3".equals(area)){
            		model.addAttribute("money",serviceDetail.getMoneyc());
            	}
        		if("4".equals(area)){
            		model.addAttribute("money",serviceDetail.getMoneyd());
            	}
        	}else{
        		model.addAttribute("money",serviceDetail.getMoneya());
        	}
        	
        	return "mobile/order-check";
		} catch (Exception e) {
			logger.warn("跳转检查确认订单页面时出错："+e.toString());
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * 跳转订单展示页面
     * @author cx
     */
    @RequestMapping(value="/listOrder")
    public String listOrder(Model model){
    	Order order = new Order();
    	order.setClientId(1);
    	List<Order> list = this.orderService.getOrderList(order);
    	model.addAttribute("orderList", list);
    	return "mobile/order-list";
    }
    
    /**
     * 用户请求获取验证码
     * @author caoxin
     */
    @RequestMapping(value="/getcode", method = RequestMethod.POST)
    public ModelAndView getCode(@RequestParam("phone") String phone){
    	try {
//    		String phone = this.getRequest().getParameter("phone");
        	//生成随机验证码
        	String code = SendMsg.createRandom(true, 6);
        	String tplValue = "#code#=" + code;
        	String result = SendMsg.sendCode(phone, this.tplId, tplValue);
        	Map<String,Object> map = (Map<String,Object>)JSON.parse(result);
        	if(map.get("error_code").equals(0)){
        		this.printResponseMsg("{\"errcode\":0,\"code\":\""+code+"\"}");
        	}else{
        		logger.warn("用户请求获取验证码:"+result);
        		this.printResponseMsg("{\"errcode\":1,\"code\":\"重新发送验证码\"}");
        	}
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("用户请求获取验证码时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1}");
		}
		return null;
    }
    
    /**
     * 跳转微信支付页面
     * @author caoxin
     */
    @RequestMapping(value="/orderpay")
    public String orderPay(Model model,Order order){
    	try {
    		if(null == order.getOrderCode() || "".equals(order.getOrderCode())){
    			//订单入库
    			order.setUpdateTime(new Date());
    			order.setState(0);
    			//生成订单号
    			int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
    			int r2=(int)(Math.random()*(10));
    			long now = System.currentTimeMillis();//一个13位的时间戳
    			String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
    			order.setOrderCode(paymentID);
    			if(this.orderService.addOrder(order) > 0){
    				ClientInfo clientInfo = this.clientInfoService.getClientInfoById(order.getClientId());
    				ServiceDetail serviceDetail = this.serviceDetailService.getServiceDetailById(order.getDetailId());
    				model.addAttribute("msgid", 0);
    				model.addAttribute("order", order);
    				model.addAttribute("openId", clientInfo.getOpenId());
    				model.addAttribute("detailName", serviceDetail.getDetailName());
    			}else {
    				model.addAttribute("msgid", 1);
    			}
    		}else {
				ClientInfo clientInfo = this.clientInfoService.getClientInfoById(order.getClientId());
				model.addAttribute("msgid", 0);
				model.addAttribute("openId", clientInfo.getOpenId());
				model.addAttribute("order", order);
				model.addAttribute("detailName", order.getDetailName());
			}
    		return "mobile/order-pay";
		} catch (Exception e) {
			model.addAttribute("msgid", 1);
			logger.error("跳转微信支付页面时出错:" + e.toString());
			e.printStackTrace();
			return "error";
		}
    }
    
    /** 
     * form表单提交 Date类型数据绑定 
     * <功能详细描述> 
     * @param binder 
     * @see [类、类#方法、类#成员] 
     */  
	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");    
	        dateFormat.setLenient(false);    
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	}  
    
    /**
     * 支付成功后修改订单状态
     * @author caoxin
     */
    @RequestMapping(value="/updatestate")
    public ModelAndView updateState(){
    	String orderCode = null;
    	try {
    		orderCode = this.getRequest().getParameter("orderCode");
    		logger.warn("更新"+orderCode+"的订单状态");
    		Order order = new Order();
    		order.setOrderCode(orderCode);
    		List<Order> list = this.orderService.getOrderList(order);
    		Order order2 = new Order();
    		if(list.size() > 0){
    			order2.setOrderId(list.get(0).getOrderId());
    			order2.setState(1);
    			if(this.orderService.updateOrder(order2) > 0){
    				this.printResponseMsg("{\"errcode\":0,\"code\":\"更新成功\"}");
    			}else {
    				this.printResponseMsg("{\"errcode\":1,\"code\":\"更新失败\"}");
    				logger.warn("订单："+orderCode+",支付失败");
    			}
    		}else{
    			this.printResponseMsg("{\"errcode\":2,\"code\":\"该订单无效\"}");
    		}
		} catch (Exception e) {
			logger.error("支付成功后修改订单状态时出错:" + e.toString());
			e.printStackTrace();
			logger.warn("订单："+orderCode+",支付失败");
			this.printResponseMsg("{\"errcode\":-1,\"code\":\"系统出错\"}");
		}
		return null;
    }
    
    /**
	 * 跳转到订单展示页面(移动端)
	 * @author caoxin
	 */
	@RequestMapping(value="/ydorder")
	public String ydorder(Model model){
		try {
//			String clientId = this.getRequest().getParameter("clientId");
			Order order = new Order();
//			order.setClientId(Integer.parseInt(clientId));
			order.setClientId(1);
			OrderCondition condition = new OrderCondition();
			condition.setOrder(order);
			PageInfo pageInfo = this.orderService.getOrderPageList(condition);
			model.addAttribute("pageInfo", pageInfo);
			return "/mobile/order-list";
		} catch (Exception e) {
			logger.error("支付成功后修改订单状态时出错:" + e.toString());
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 跳转到下订单页面(移动端)
	 * @author caoxin
	 */
	@RequestMapping(value="/place")
	public String placeOrder(){
		return "/mobile/order-place";
	}
	
	/**
     * 手机查看订单时进入二次授权
     * @return
     */
	@RequestMapping(value="/checkorder")
    public String checkorder(Model model){
    	String openid = CookieUtil.getCookie(this.getRequest(), "openId_meijia");
    	if(null == openid || "".equals(openid)){
    		logger.warn("checkorder:no cookie");
    		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ Config.getAttribute("AppId") +"&redirect_uri="+ Config.getAttribute("ServerURL") + "oauth2CrossDomain1&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    		return "redirect:" + url;
    	}else{
    		logger.warn("checkorder:"+openid);
    		ClientInfo clientInfo = new ClientInfo();
        	clientInfo.setOpenId(openid);
        	List<ClientInfo> list = this.clientInfoService.getClientInfoList(clientInfo);
        	OrderCondition condition = new OrderCondition();
        	PageInfo pageInfo = new PageInfo(condition);
        	if(list.size() > 0){
        		Integer clientId = list.get(0).getClientId();
        		Order order = new Order();
        		order.setClientId(clientId);
    			condition.setOrder(order);
    			pageInfo = this.orderService.getOrderPageList(condition);
        	}
        	model.addAttribute("pageInfo", pageInfo);
        	return "/mobile/order-list";
    	}
    }
    
    /**
     * 回调至手机订单列表页面
     * @param model
     * @return
     */
	@RequestMapping(value="/oauth2CrossDomain1")
    public String oauth2CrossDomain1(Model model){
    	String state=this.getRequest().getParameter("state");
        String code=this.getRequest().getParameter("code");
    	try {
    		if(state == null){
                logger.warn("获取的参数state为空!");
                return null;
            }
    		if(code == null){
                logger.warn("获取的参数code为空!");
                return null;
            }
    		//去取access_token
            Map<String, Object> resultMap = WxBaseUtil.getOAuth2AccessTokenByCode(Config.getAttribute("AppId"), Config.getAttribute("AppSecret"), code);
            if(resultMap == null){
                //跳到提示页，提示重新授权
                logger.warn("获取AccessToken失败!");
                return "forward:/wximpl/checkorder";
            }else{
            	String openid = resultMap.get("openid").toString();
            	CookieUtil.setCookie(this.getResponse(), "openId_meijia", openid, 60*24*24);
            	ClientInfo clientInfo = new ClientInfo();
            	clientInfo.setOpenId(openid);
            	List<ClientInfo> list = this.clientInfoService.getClientInfoList(clientInfo);
            	if(list.size() > 0){
            		Integer clientId = list.get(0).getClientId();
            		Order order = new Order();
            		order.setClientId(clientId);
            		List<Order> orderlist = this.orderService.getOrderList(order);
            		model.addAttribute("orderlist", orderlist);
            	}else{
            		model.addAttribute("openid", openid);
            	}
            	return "/mobile/order-list";
            }
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("回调至手机订单列表页面时:" + e.toString());
			return null;
		}
    }
    
    /**
     * 查看订单详细页面 
     */
    @RequestMapping(value="/godetail/{orderCode}")
	public String godetail(Model model,@PathVariable String orderCode){
    	try {
    		Order order = new Order();
        	order.setOrderCode(orderCode);
        	OrderCondition condition = new OrderCondition();
        	condition.setOrder(order);
        	PageInfo pageInfo = this.orderService.getOrderPageList(condition);
        	order = (Order) pageInfo.getItems().get(0);
        	ClientAddress addressInfo = this.clientAddressService.getClientAddressById(order.getAddressId());
        	ClientAddress clientAddress = new ClientAddress();
        	clientAddress.setClientId(order.getClientId());
        	List<ClientAddress> addressList=this.clientAddressService.getClientAddressList(clientAddress);
    		model.addAttribute("order", order);
    		model.addAttribute("addressInfo", addressInfo);
    		model.addAttribute("addressList", addressList);
    		return "/mobile/order-detail";
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("查看订单详细页面 时:" + e.toString());
            return null;
		}
	}
    
    /**
     * 跳转手机验证页面
     */
    @RequestMapping(value="/valid")
	public String phonevalid(){
    	return "mobile/phone-valid";
	}
    
    /**
     * 手机端短信验证通过之后添加用户信息
     * @author caoxin
     */
    @RequestMapping(value="/save")
	public ModelAndView saveInfo(){
    	try {
			String phone = this.getRequest().getParameter("phone");
			String code = this.getRequest().getParameter("code");
			String codevalid = this.getRequest().getParameter("codevalid");
			String openid = this.getRequest().getParameter("openid");
			if(codevalid.equals(code)){
				ClientInfo clientInfo = new ClientInfo();
				clientInfo.setOpenId(openid);
				clientInfo.setTelephone(phone);
				clientInfo.setUpdateTime(new Date());
				if (this.clientInfoService.addClientInfo(clientInfo) > 0) {
					this.printResponseMsg("{\"errcode\":0,\"code\":\""+openid+"\"}");
				} else {
					this.printResponseMsg("{\"errcode\":1,\"code\":\"验证码正确，信息入库失败\"}");
				}
			}else{
				this.printResponseMsg("{\"errcode\":2,\"code\":\"验证码错误\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("手机端短信验证通过之后添加用户信息时:" + e.toString());
            this.printResponseMsg("{\"errcode\":-1,\"code\":\"系统出错，请稍后再试\"}");
		}
    	return null;
	}
}
