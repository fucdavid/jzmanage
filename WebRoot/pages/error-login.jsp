<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <!-- login 登录 -->
        <div class="container-fluid">
            <div class="container">
                <img class="center-block logo" src="common/images/logox.png" alt=""/>
                <p class="text-center" style="font-size:36px;">系统提示</p>
			    <br>
			    <p class="text-center" style="font-size:14px; color: red;">${msg}</p>
			    <br>
			    <a class="btn btn-hot btn-lg col-lg-3" href="${url}" style="width:140px;margin:0 auto;display:block; float:none;">关闭</a>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="common/js/jquery.min.js"></script>
    <script type="text/javascript" src="common/js/bootstrap.min.js"></script>
</html>