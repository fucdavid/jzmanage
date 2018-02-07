<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="basic.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统提示</title>
    <link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet" />
    <link type="text/css" href="common/css/bootstrap-responsive.min.css" rel="stylesheet" />
</head>

<body>
    <p class="text-center" style="font-size:36px;margin-top: 30px;">系统提示</p>
    <br>
    <p class="text-center" style="font-size:14px; color: blue;">${msg}</p>
    <br>
    <p class="text-center"><a href="${url}" class="btn">关闭</a></p>
</body>
</html>