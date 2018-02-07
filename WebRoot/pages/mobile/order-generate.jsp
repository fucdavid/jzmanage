<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="../basic.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<meta content="black" name="apple-mobile-web-app-status-bar-style">
		<meta content="telephone=yes" name="format-detection">
		<title>美家在家-家政服务预订平台</title>

		<link type="text/css" href="common/css/base.css" rel="stylesheet">
		<link type="text/css" href="common/css/services.css" rel="stylesheet">
		<script type="text/javascript" src="common/js/jquery.min.js"></script>

		<script>
			var _webApp = 'http://m.homeking365.com';
			var city = '恩施';
			//提示相关信息
			var infoTips = '';
			var msg = '';
			$(function() {
				//提示信息
				if (infoTips) {
					infoPrompt(infoTips);
				} else if (msg) {
					infoPrompt(msg);
				}
			})
		</script>
		<script type="text/javascript">
			var servicesDateQuerys = [];
			var serviceDate = '';
			var serviceTime = '';
		</script>
		<style>
		.mypopup {
			width: 100%;
			height: 100%;
			position: fixed;
			top: 0;
			left: 0;
			background: rgba(0, 0, 0, 0.8);
			z-index: 99999;
		}

.mypre-popupbox {
	width: 80%;
	height: 230px;
	position: relative;
	top: 160px;
	left: 10%;
	background: url(/images/common/close-tc.png);
	background-size: 100% 100%;
}

.mypre-popuptext {
	width: 86%;
	height: 80px;
	position: absolute;
	bottom: 6%;
	right: 7%;
	font-size: 12px;
	color: #666666;
	line-height: 16px;
	text-align: left;
}

.mypre-popupbtn {
	width: 50%;
	height: 32px;
	color: white;
	background: #FF5A46;
	font-size: 16px;
	border-radius: 16px;
	-webkit-border-radius: 16px;
	line-height: 32px;
	text-align: center;
	position: relative;
	top: 186px;
	margin: 0 auto;
}

.mypre-popup-close {
	position: absolute;
	width: .6rem;
	top: .5rem;
	right: .5rem;
}
</style>
	</head>
	<body style="position: absolute; top: 0px; bottom: 0px; left: 0px; right: 0px;" dh="1" rlt="1">
		<!--start 即日起至2月4号弹窗提示-->
		<div class="mypopup" style="display: none;">
			<div class="mypre-popupbox">
				<img src="http://mstatic.homeking365.com/images/common/close.png" class="mypre-popup-close">
				<div class="mypre-popuptext">
					该区近期订单暴增，我们已将激活有效期延长至60天，以便您能更好激活体验！
				</div>
				<div class="mypre-popupbtn">
					我知道了
				</div>
			</div>
		</div>
		<input type="hidden" id="serName" value="宅洁士居家保洁-4小时">
		<input type="hidden" id="cityName" value="恩施">
		<!-- end 即日起至2月4号弹窗提示-->
		<div class="hk-container">
			<div class="hk-main">
				<header>
				<a class="back" href="javascript: history.go(-1);"></a>预定服务
				<%--                    <div class="btns ">--%>
				<%--                        <a class="hk-home-btn" href="javascript:void(0);"></a>--%>
				<%--                    </div>--%>
				</header>
				<section class="select">
				<label id="calLabel">
					服务时间
				</label>
				<div class="canlender" id="canlender">
					<div class="header">
						<span class="date">${date}</span>
					</div>
					<table>
						<thead>
							<tr>
								<c:forEach items="${datelist}" var="item" varStatus="i">
									<th <c:if test="${item.week == '周六' || item.week == '周日'}">class="weekend"</c:if>>
									${item.week}
									</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach items="${datelist}" var="item" varStatus="i">
									<td class="usable month-start" data-value="${item.dateInfo}">
									${item.day}
									<p class="order-sellout">
									</p>
									</td>
								</c:forEach>
							</tr>
<%--							<tr>--%>
<%--								<td class="disable month-start" data-value="2017-01-23">--%>
<%--									23--%>
<%--									<p class="order-sellout">--%>
<%--										售完--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="disable month-start" data-value="2017-01-24">--%>
<%--									24--%>
<%--									<p class="order-sellout">--%>
<%--										售完--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="disable month-start" data-value="2017-01-25">--%>
<%--									25--%>
<%--									<p class="order-sellout">--%>
<%--										售完--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="disable month-start" data-value="2017-01-26">--%>
<%--									26--%>
<%--									<p class="order-sellout">--%>
<%--										售完--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="disable month-start" data-value="2017-01-27">--%>
<%--									27--%>
<%--									<p class="order-sellout">--%>
<%--										售完--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="usable month-start" data-value="2017-01-28">--%>
<%--									28--%>
<%--									<p class="order-sellout">--%>
<%--									</p>--%>
<%--								</td>--%>
<%--								<td class="usable month-start" data-value="2017-01-29">--%>
<%--									29--%>
<%--									<p class="color: #FF6600">--%>
<%--										少量--%>
<%--									</p>--%>
<%--								</td>--%>
<%--							</tr>--%>
						</tbody>
					</table>
					<div class="calendar-unfold">
						<p class="bottom-direction"></p>
					</div>
				</div>
				</section>
				<section class="select time prop_nv time_prop" style="border-top: 1px solid #d7d7d7;" id="timeRange">
				<label>
					服务面积
				</label>
				<ul class="clearfix" style="margin-top: 10px;">
					<li>
						<span class="prop_time prop_v" data-value="1">0-89㎡<em class="prop_v_remark"></em>
						</span>
					</li>
					<li>
						<span class="prop_time prop_v" data-value="2">90-159㎡<em class="prop_v_remark"></em>
						</span>
					</li>
					<li>
						<span class="prop_time prop_v" data-value="3">160-249㎡<em class="prop_v_remark"></em>
						</span>
					</li>
					<li>
						<span class="prop_time prop_v" data-value="4">250-300㎡<em class="prop_v_remark"></em>
						</span>
					</li>
				</ul>
				</section>
<%--				<section class="select prop_nv district_prop sku_prop" id="location">--%>
<%--				<label>--%>
<%--					服务地区--%>
<%--				</label>--%>
<%--				<ul class="clearfix">--%>
<%--				--%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:71" data-prompt="不包含鼓浪屿">思明区<em--%>
<%--							class="prop_v_remark"></em> </span>--%>
<%--					</li>--%>
<%----%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:72" data-prompt="">湖里区<em class="prop_v_remark"></em>--%>
<%--						</span>--%>
<%--					</li>--%>
<%----%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:90" data-prompt="">海沧区<em class="prop_v_remark"></em>--%>
<%--						</span>--%>
<%--					</li>--%>
<%----%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:460" data-prompt="灌口镇不提供服务">集美区<em--%>
<%--							class="prop_v_remark"></em> </span>--%>
<%--					</li>--%>
<%----%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:3754" data-prompt="新店镇、马巷镇可提供服务">翔安区<em--%>
<%--							class="prop_v_remark"></em> </span>--%>
<%--					</li>--%>
<%----%>
<%--					<li>--%>
<%--						<span class="prop_v" data-value="35:3755" data-prompt="禹洲大学城、大同街道、祥平街道、西柯镇可提供服务">同安区<em--%>
<%--							class="prop_v_remark"></em> </span>--%>
<%--					</li>--%>
<%----%>
<%--				</ul>--%>
<%--				<div class="district-prompt"--%>
<%--					style="display: none; color: #666; background: #faeed4; width: 92%; margin: 0 auto; line-height: 26px; text-align: left; border: 1px solid #f7a700; padding: 0px 10px 0px 10px;">--%>
<%--					<img src="http://m.homeking365.com/images/common/consume-icon03.png"--%>
<%--						style="vertical-align: middle; padding-right: 3px;">--%>
<%--					<span></span>--%>
<%--				</div>--%>
<%--				</section>--%>
				<div id="otherProperty">

				</div>
<%--				<section class="select">--%>
<%--				<label>--%>
<%--					数量--%>
<%--				</label>--%>
<%--				<div class="clearfix">--%>
<%--					<div class="hkCount_wrap">--%>
<%--						<span class="hkCount"><span class="hkCount_minus disabled">-</span> <input--%>
<%--								class="hkCount_num" id="quantity" type="text" value="1" disabled="disabled"> <span--%>
<%--							class="hkCount_add disabled">+</span> </span>--%>
<%--					</div>--%>
<%--				</div>--%>
<%--				</section>--%>
				<section class="clearfix order-btns ukbtn">
				<div class="serve_price_wrap">
				</div>
				<div class="clearfix"></div>
				<div style="padding-top: 60px;"></div>
				<aside class="fixed"
					style="width: 100%;height: 35px;background: #fff;border-top: 1px solid #d7d7d7;padding: 5px 0 9px;position: fixed;bottom: 0;left: 0;">
				<div>
					<a class="btn createOrder disabled" href="javascript:void(0);"
						style="position: inherit; width: 80%; margin: 0px auto; float: none;">请完善服务需求</a>
				</div>
				</aside>
				<div class="clearfix"></div>
				</section>
				<div class="serve_promotion_info"></div>
				<input type="hidden" id="money" value="${detail.money}">
				<form id="sevicesForm" name="sevicesForm" action="wximpl/checkOrder" method="get">
					<input type="hidden" name="did" value="${detail.detailId}">
					<input type="hidden" name="area">
					<input type="hidden" name="datetime">
					<input type="hidden" name="clientId" value="${clientId}">
				</form>
			</div>
			<div class="hk-home">
				<style>
.icon.icon1 {
	display: inline-block;
	width: 24px;
	height: 24px;
	background: url(common/images/icon.png) -1602px -13px no-repeat;
	background-size: auto 200%;
}
</style>
				<section>
				<div id="loginInfo">
					<a href="http://m.homeking365.com/user/center">
					<img src="http://m.homeking365.com/images/page/user-pic.png"> </a>
					<p>
						<a href="http://m.homeking365.com/user/center">18627742367</a>
					</p>
				</div>
				<ul id="cmenu">
					<li>
						<a href="http://m.homeking365.com"><i class="icon home"></i>首页</a>
					</li>
					<li>
						<a href="http://m.homeking365.com/activity/hkbg"><i class="icon clock"></i>限时特惠</a>
					</li>
					<li>
						<a href="http://m.homeking365.com/user/center"><i class="icon"></i>个人中心</a>
					</li>
					<!-- homestore新加代码 2015.12.30  开始 -->
					<li>
						<a href="http://m.homeking365.com/product"><i class="icon icon1"></i>HomeStore</a>
					</li>
					<!-- homestore新加代码 2015.12.30  结束-->
					<!-- <li><a href="http://m.homeking365.com/services/list?city=xiamen"><i class="icon coffee"></i>家庭服务</a></li> -->
					<!-- <li><a href="http://m.homeking365.com/product"><i class="icon tag"></i>家庭用品</a></li> -->
					<!-- <li><a href="http://m.homeking365.com"><i class="icon cal"></i>每日特惠</a></li> -->
					<li>
						<a href="http://m.homeking365.com/login/logout"><i class="icon power"></i>退出登录</a>
					</li>
				</ul>
				</section>
			</div>
		</div>
		<script type="text/javascript"
			src="http://mstatic.homeking365.com/js/plugin/hkCount/hkCount.js?v=20160128"></script>
		<script type="text/javascript">
	var nowDate = new Date(1484034678021);
	var servicesId = 8;
	var limitNum;
	if ("宅洁士居家保洁-4小时".indexOf("空调") >= 0) {
		limitNum = '10';
	} else {
		limitNum = '1';
	}
	var cycle = 60;

	var isCodeLimit = 'false';
</script>
		<script type="text/javascript" src="common/js/mobile/detail-order-V3.js"></script>
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
	</body>
</html>
