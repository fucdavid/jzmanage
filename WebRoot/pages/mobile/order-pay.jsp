<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="../basic.jsp"%>
    <title>订单支付</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		body {
		}
		.btn {
			width:auto;
			height:auto;
		    background: #ff752b;
		    display: block;
		    font-size: 76px;
		    margin-top: 25px;
    		border-radius: 10px;
		}
		.result{
			font-size: 76px;
			position: absolute;
			top:30%;left:30%;
		}
	</style>

  </head>
  
  <body>
  	<input type="hidden" id="openIdRcv" value="${openId}">
  	<input type="hidden" id="goodsInfo" value="${detailName}">
  	<input type="hidden" id="goodsFee" value="${order.paymoney}">
  	<input type="hidden" id="orderCode" value="${order.orderCode}">
  	<div class="result">
  		<span id="res">
  			<c:if test="${msgid == 0}">支付中...</c:if>
  			<c:if test="${msgid == 1}">支付失败</c:if>
  		</span>
	    <input id="cont" class="btn" type="button" value="继续支付" style="display: none" onclick="payOrder()">
	    <input id="toho" class="btn" type="button" value="返回首页" style="display: none" onclick="tohome()">
  	</div>
  </body>
  <script type="text/javascript" src="common/js/jquery.min.js"></script>
  <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
  <script type="text/javascript" src="common/js/mobile/zhifu.js?201705161"></script>
</html>
