<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="../basic.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=yes" name="format-detection">
<title>美家到家-家政服务预订平台</title>
<link type="text/css" href="common/css/base.css?1110" rel="stylesheet">
<style>
.services-list {
	margin-bottom: 107px;
}

.services-list ul {
	background: #fff;
}

.services-list ul li a {
	height: 56px;
	padding: 12px;
	border-bottom: 1px solid #C5C6C7;
	position: relative;
}

.services-list .list-li-left {
	width: 56px;
	float: left;
	padding-right: 10px;
}

.services-list .list-li-mid {
	float: left;
}

.services-list .list-tit {
	font-size: 16px;
	color: #333;
}

.services-list .list-word {
	color: #888;
	line-height: 18px;
}

.services-list .list-price {
	font-size: 16px;
	color: #ff3399;
}

.services-list .list-btn {
	position: absolute;
	top: 24px;
	right: 10px;
	z-index: 999;
	color: #484848;
	width: 60px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	display: block;
	border: 1px solid #999;
	border-radius: 5px;
	-webkit-border-radius: 5px;
	padding: 0 6px;
}

.swipe-wrap img {
	height: 145px;
}
.icon.icon1 {
	  display: inline-block;
	  width: 24px;
	  height: 24px;
	  background: url(/images/page/icon.png) -1602px -13px no-repeat;
	  background-size: auto 200%;
	}
</style>
</head>
<body style="position: absolute; top: 0px; left: 0px; right: 0px;" dh="1" rlt="1">
	<div class="hk-container">
		<div class="hk-main">
			<header> <a class="back back-btn" href="wximpl/gohome"></a>${serviceName}
			</header>
				<section class="banner">
				<div class="slider" id="slider" style="visibility: visible;">
					<ul class="swipe-wrap" style="width: 320px;">
							<li data-index="0" style="width: 320px; left: 0px; transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);"><a href="javascritp:void(0);"><img src="common/images/meijia-bg.jpg"/></a></li>
					</ul>
				</div>
				<ul class="slider-btn">
						<li class="active"></li>
				</ul>
				</section>
			<section class="services-list">
			<ul>
				<c:forEach items="${list}" var="item" varStatus="i">
					<li><a href="wximpl/detail/${item.detailId}_${clientId}" style="display: block; overflow: hidden;height:62px;">
							<div class="list-li-left">
								<img src="common/images/images-${item.detailId}.png" width="100%">
							</div>
							<div class="list-li-mid" style="width:54%;">
								<div class="list-tit">${item.detailName}</div>
								<div class="list-word">${item.describes}</div>
								<p class="list-price">
									<c:choose>
										<c:when test="${item.detailId==1}">
											<span>￥${item.moneya}/人</span>
										</c:when>
										<c:when test="${item.detailId==2 || item.detailId==3}">
											<span>￥${item.moneya}起</span>
										</c:when>
										<c:otherwise>
											<span>￥${item.moneya}</span>
										</c:otherwise>
									</c:choose>
								</p>	
							</div> <span class="list-btn">立即预定</span>
					</a></li>
				</c:forEach>
			</ul>
			</section>

		</div>
		<div class="hk-home">
<section>
<%--	<div id="loginInfo">--%>
<%--		<a href="http://m.homeking365.com/login"><img src="http://m.homeking365.com/images/page/user-head.png"></a>--%>
<%--		<p>--%>
<%--			<a href="http://m.homeking365.com/login">登录</a><a href="http://m.homeking365.com/login/register">注册</a>--%>
<%--		</p>--%>
<%--	</div>--%>
<%--	<ul id="cmenu">--%>
<%--		<li><a href="http://m.homeking365.com"><i class="icon home"></i>首页</a></li>--%>
<%--		<li><a href="http://m.homeking365.com/activity/hkbg"><i class="icon clock"></i>限时特惠</a></li>--%>
<%--		<li><a href="http://m.homeking365.com/user/center"><i class="icon"></i>个人中心</a></li>--%>
<%--		<!-- homestore新加代码 2015.12.30  开始 -->--%>
<%--		<li><a href="http://m.homeking365.com/product"><i class="icon icon1"></i>HomeStore</a></li>--%>
<%--		<!-- homestore新加代码 2015.12.30  结束-->--%>
<%--		<!-- <li><a href="http://m.homeking365.com/services/list?city=xiamen"><i class="icon coffee"></i>家庭服务</a></li> -->--%>
<%--		<!-- <li><a href="http://m.homeking365.com/product"><i class="icon tag"></i>家庭用品</a></li> -->--%>
<%--		<!-- <li><a href="http://m.homeking365.com"><i class="icon cal"></i>每日特惠</a></li> -->--%>
<%--	</ul>--%>
</section>
		</div>
	</div>
	<div style="position: absolute; bottom: 0; width: 100%; z-index: 999;">
		<footer>
			<p><img src="common/images/logo-a.png"></p>
			<p>
				服务热线：<a href="tel:4008-954-580">4008-954-580</a> 家务事 我帮您
			</p>
			<p class="copyright">©2016 恩施市美家创新家政有限责任公司 版权所有</p>
		</footer>
	</div>
	<script type="text/javascript" src="common/js/jquery.min.js"></script>
	<script type="text/javascript" src="common/js/swipe.js"></script>
	<script type="text/javascript">
		$(function() {
			//幻灯片
			if ($('#slider').length) {
				$('#slider').Swipe({
					auto : 5000,
					speed : 600,
					callback : function(index) {
						var sliderBtn = $('.slider-btn li');
						var i = sliderBtn.length;
						if (index >= i) {
							index = index % i;
						}
						while (i--) {
							sliderBtn[i].className = ' ';
						}
						sliderBtn[index].className = 'active';
					}
				});
			}
		})
	</script>
	<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script type="text/javascript">
    /****************************自定义微信分享内容*********************************************/
   	var shareData = {
        "title" : '在恩施这么多年了，终于有让人值得信赖的家政服务啦！  美家到家-专业家庭服务预定平台 ',
        "link" : 'http://www.meijiajiazheng.com/jzmanage/wximpl/oauth',
        "imgUrl" : 'http://www.meijiajiazheng.com/jzmanage/common/images/share-bg.png',
    };
    /****************************自定义微信分享内容*********************************************/
	</script>
	<script type="text/javascript" src="common/js/wxJsSdkShare_crossdm.js"></script>