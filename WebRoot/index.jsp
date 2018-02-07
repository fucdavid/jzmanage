<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>系统登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="common/css/style.css" rel="stylesheet">
	</head>
	<body class="m-login">
	    <div id="browerAlert" class="alert alert-danger hide" role="alert" >系统检测到您的浏览器版本过低，为了正常访问本系统请使用360(或QQ)浏览器的<strong>极速模式</strong>，或者使用IE10及以上版本。给您带来的不便敬请谅解！</div>
        <!-- login 登录 -->
        <div class="container-fluid">
            <div class="container">
                <img class="center-block logo" src="common/images/logox.png" alt=""/>
                <form class="col-lg-4 center-block" action="login" method="post" id="loginForm" onsubmit="return generateCookie();">
                    <div class="controls" style="color: red;margin-bottom: 10px;">${msg}</div>
                    <div class="input-group">
                        <input type="text" class="form-control input-lg name" id="tLoginName" name="loginName" value="" placeholder="用户名">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-user"></span>
                        </div>
                    </div>
                    <br/>
                    <div class="input-group">
                        <input type="password" class="form-control input-lg password" id="tPassword" name="password" value="" placeholder="密码">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-lock"></span>
                        </div>
                    </div>
                    <br/>
                    <button class="btn btn-default btn-lg btn-block btn-submit" type="submit">登录</button>
                    <div class="form-group">
                        <div class="checkbox"><label><input id="chkRemember" type="checkbox"> 记住密码</label></div>
                    </div>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="common/js/jquery.min.js"></script>
    <script type="text/javascript" src="common/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="common/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="common/js/system/login.js"></script>
</html>
