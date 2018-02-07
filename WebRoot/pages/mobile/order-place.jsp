<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生成订单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<input type="hidden" id="clientId" value="1">
    	<input type="hidden" id="serviceId" value="1">
    	人数：<input type="text" id="peopleNum">
    	时间：<input type="text" id="time">
    	<input type="button" value="生成订单信息" onclick="submit();">
  </body> 
  <script type="text/javascript" src="common/js/jquery.min.js"></script>
  <script type="text/javascript" src="common/js/mobile/order-place.js"></script>
</html>