<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html style="height:100%"><head>
	<%@ include file="../basic.jsp"%>
	<title>我的订单-个人后台</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta content="telephone=no" name="format-detection">
	
<link type="text/css" href="common/css/base.css" rel="stylesheet">
<link type="text/css" media="all" href="common/css/center.css?v=20160918" rel="stylesheet">
<script type="text/javascript" src="common/js/jquery.min.js"></script>
<script type="text/javascript" src="common/js/common.js?v=201702080808"></script>
<%--<script src="//hm.baidu.com/hm.js?3c8ecbfa472e76b0340d7a701a04197e"></script><script type="text/javascript" src="http://mstatic.homeking365.com/js/common/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/jquery.mobile.custom.min.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/json2.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/CryptoJS.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/common.js?v=20160918"></script>--%>
<script>
	var _webApp = 'http://m.homeking365.com';
	var city = '恩施';
	//提示相关信息
	var infoTips = '';
	$(function() {
		//提示信息
		if (infoTips) {
			infoPrompt(infoTips);
		}
	})
</script>

	<script type="text/javascript" src="http://m.homeking365.com/js/pages/center/center-order.js?v=20170218"></script>
	<script type="text/javascript">
		$(function() {
			$('.menu a').on("tap", function() {
				$(this).parents("table").find("a").removeClass("active");
				$(this).addClass("active");
			});
		})
	</script>
</head>
<body class="center" rlt="1">
<div class="hk-container">
	<div class="hk-main">
		<header> 
<%--		<a class="back back-btn" href="javascript:void(0);" data-url="http://m.homeking365.com/user/center"></a>--%>
			服务订单
<%--			<div class="btns">--%>
<%--				<a class="hk-home-btn" href="javascript:void(0);"></a>--%>
<%--			</div>--%>
		</header>
		<section class="card-wrap"> 
				<c:forEach items="${pageInfo.items}" var="item" varStatus="i">
					<div class="order-card-wrap">
						<p class="top-text">
							下单时间:
							<fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
						</p>
						<a href="wximpl/godetail/${item.orderCode}" style="color: inherit;">
							<div class="order-card">
								<table>
									<thead>
									<tr>
										<th colspan="2">
													<c:if test="${item.state == 0}"><span class="rabbon gray">未支付</span></c:if>
													<c:if test="${item.state == 1}"><span class="rabbon green">已支付</span></c:if>
													<c:if test="${item.state == 2}"><span class="rabbon blue">已派单</span></c:if>
													<c:if test="${item.state == 3}"><span class="rabbon warning">已完成</span></c:if>
													<c:if test="${item.state == 4}"><span class="rabbon red">已取消</span></c:if>
													<span style="float: right; margin-right: 17px;">订单号：${item.orderCode}</span>
										</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td colspan="2"><img src="common/images/share-bg.png">
											<div class="order-info">
												<input type="hidden" id="orderCode">
												<p>
														${item.detailName}
												</p>
												<c:if test="${item.time != null && item.time != ''}">
												<p>
														服务时间：<fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd" />
												</p>
												</c:if>
													<p>服务地区：${item.address}</p>
												<c:if test="${item.detailId == 1}">
													<p>
																数量：${item.peopleNum}人
													</p>
												</c:if>
											</div></td>
									</tr>
									<tr>
												<td><span class="red">¥<strong>${item.paymoney}</strong></span></td>
										<td><span class="view">查看</span></td>
									</tr>
									</tbody>
								</table>
							</div>
						</a>
					</div>
				</c:forEach> 
		 </section>
		
<%--			<div id="loadOrders" class="loadmore">--%>
<%--				<a id="loadMore" href="javascript:loadMoreOfOrderServices(0);">加载更多</a>--%>
<%--			</div>--%>
		
	</div>
	<div class="hk-home">
<style>
	.icon.icon1 {
	  display: inline-block;
	  width: 24px;
	  height: 24px;
	  background: url(/images/page/icon.png) -1602px -13px no-repeat;
	  background-size: auto 200%;
	}
</style>
<section>
	<div id="loginInfo">
		<a href="http://m.homeking365.com/user/center"><img src="http://m.homeking365.com/images/page/user-pic.png"></a>
		<p><a href="http://m.homeking365.com/user/center">18627742367</a></p>
	</div>
	<ul id="cmenu">
		<li><a href="http://m.homeking365.com"><i class="icon home"></i>首页</a></li>
		<li><a href="http://m.homeking365.com/activity/hkbg"><i class="icon clock"></i>限时特惠</a></li>
		<li><a href="http://m.homeking365.com/user/center"><i class="icon"></i>个人中心</a></li>
		<!-- homestore新加代码 2015.12.30  开始 -->
		<li><a href="https://mall.homeking365.com"><i class="icon icon1"></i>HomeStore</a></li>
		<!-- homestore新加代码 2015.12.30  结束-->
		<!-- <li><a href="http://m.homeking365.com/services/list?city=xiamen"><i class="icon coffee"></i>家庭服务</a></li> -->
		<!-- <li><a href="http://m.homeking365.com/product"><i class="icon tag"></i>家庭用品</a></li> -->
		<!-- <li><a href="http://m.homeking365.com"><i class="icon cal"></i>每日特惠</a></li> -->
	<li><a href="http://m.homeking365.com/login/logout"><i class="icon power"></i>退出登录</a></li></ul>
</section>
	</div>
</div>
<script>
	function fillTrialOrderInfo(id){
		alert("asd");
		event.stopPropagation();
		window.location.href = _webApp + "/user/nurse/service-time?orderServicesId=" + id;
	}
</script>



<div class="cnzz-stats" style="display: none;">
	
	<script src="https://s11.cnzz.com/z_stat.php?id=1254124211&amp;web_id=1254124211" language="JavaScript"></script><script src="https://c.cnzz.com/core.php?web_id=1254124211&amp;t=z" charset="utf-8" type="text/javascript"></script><a href="http://www.cnzz.com/stat/website.php?web_id=1254124211" target="_blank" title="站长统计">站长统计</a>
	
	<script src="https://s11.cnzz.com/z_stat.php?id=1254124217&amp;web_id=1254124217" language="JavaScript"></script><script src="https://c.cnzz.com/core.php?web_id=1254124217&amp;t=z" charset="utf-8" type="text/javascript"></script><a href="http://www.cnzz.com/stat/website.php?web_id=1254124217" target="_blank" title="站长统计">站长统计</a>
	<script type="text/javascript">
		var cnzz_web_id = '1254124217';
		//删除多余cnzz城市Cookice
		if (document.cookie != '') {
			var arrCookie = document.cookie.split('; ');
			var arrLength = arrCookie.length;
			var date = new Date();
			date.setTime(date.getTime() - 10000);
			for (var i = 0; i < arrLength; i++) {
				var cookiceName = arrCookie[i].split("=")[0];
				if (/^CNZZDATA\d{10}$/.test(cookiceName)) {
					if (cookiceName != 'CNZZDATA1254124211'
							&& cookiceName != 'CNZZDATA' + cnzz_web_id) {
						document.cookie = cookiceName + "=del; expires="
								+ date.toGMTString();
					}
				}
			}
		}
	</script>
</div>
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

</body></html>
