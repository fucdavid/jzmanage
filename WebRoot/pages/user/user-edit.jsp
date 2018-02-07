<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../basic.jsp"%>
<!doctype html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
		<title>用户编辑</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
        <link type="text/css" href="common/css/loading.css" rel="stylesheet" />
		<link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet" />
		<link type="text/css" href="common/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<style type="text/css">
          select, textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"], .uneditable-input {height: auto;}
        </style>
	</head>

	<body>
	    <h3>用户编辑 <a class="btn btn-sm btn-success" href="javascript:history.go(-1);">返回</a> </h3>
	    <input type="hidden" id="hdnUserId" value="${user.userId}" />
        <table cellpadding="0" cellspacing="0" border="1" id="tbUserEdit" class="table table-condensed" style="width: 500px;">
            <tr>
                <td>登录名：</td>
                <td><input type="text" id="tloginName" value="${user.loginName}"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" id="tpassword" value="${user.password}"/></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" id="tuserName" value="${user.userName}"/></td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="text" id="tbirthday" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" value='<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd HH:mm:ss" />' /></td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" id="tuserPhone" value="${user.userPhone}"/></td>
            </tr>
            <tr>
                <td>邮件：</td>
                <td><input type="text" id="tuserEmail" value="${user.userEmail}"/></td>
            </tr>
            <tr>
                <td>图像：</td>
                <td>
                    <input type="file" id="fileHeadImg" name="fileHeadImg" onchange="uploadHeadImg(this,1)"/>
                    <img id="theadImg" alt="" src="${user.headImg}" style="width: 100px;" />
                </td>
            </tr>
            <tr>
                <td colspan="2"><button class="btn btn-sm btn-default" onclick="saveUser();">保存</button></td>
            </tr>
        </table>
	</body>
    <div id="ibody" class="ibody"></div>
	<script type="text/javascript" src="common/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="common/js/jquery.bgiframe.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="common/js/loading-min.js"></script>
	<script type="text/javascript" src="common/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="common/js/dialog/jquery.artDialog.js?skin=default"></script>
    <script type="text/javascript" src="common/js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="common/js/syscommon.js"></script>
	<script type="text/javascript" src="common/js/user-edit.js"></script>
</html>
