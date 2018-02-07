<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<%@ include file="../basic.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=yes" name="format-detection">
<title>美家到家-家政服务预订平台</title>

<link type="text/css" href="common/css/base.css" rel="stylesheet">
<link type="text/css" href="common/css/services.css" rel="stylesheet">
<script type="text/javascript" src="common/js/jquery.min.js"></script>
<script>
	var _webApp = 'http://m.homeking365.com';
	var city = '厦门';
	//提示相关信息
	var infoTips = '';
	var msg = '';
	$(function() {
		//提示信息
		if (infoTips) {
			infoPrompt(infoTips);
		}else if(msg){
			infoPrompt(msg);
		}
	})
</script>

</head>
<body class="service-detail" dh="1" rlt="1">
	
	<div class="hk-container">
		<div class="hk-main">
			<header> 
			<a class="back back-btn" href="javascript:;" onclick="javascript :history.back(-1);"></a> 服务详细
			<div class="btns">
				<a class="hk-home-btn" href="javascript:void(0);"></a>
			</div>
			</header>
			<section class="banner">
			<div class="slider" id="slider" style="visibility: visible;">
				<ul class="swipe-wrap" style="height: 235px">
					<li><img src="http://m.homeking365.com/images/page/space.png" style="height:260px;background-image: url(https://img.homeking365.com/92f8f9e3-a78c-4c55-99ad-657878ea6df3.jpg)">
						 <!-- 视频播放 -->
						<div class="videoa" style="position: fixed; z-index: 999999; width: 100%; height: 100%; top: 0px; bottom: 0px; display: none; background: #000;">
							<video id="video2" webkit-playsinline="" preload="" loop="" controls="controls" style=" margin-top:5rem;width:100%;">
							<source src="" type="video/mp4"> </video>
							<div class="play-btn" style="color: #fff; font-size: 14px; border: 1px solid #fff; border-radius: 10px; -webkit-border-radius: 10px; padding: 5px 10px; width: 100px; margin: 0 auto; margin-top: 30px; text-align: center">返回</div>
						</div> <script>
					var a = function(e){
						e.preventDefault();
					}
					var myVideo1 = document.getElementById('video2');
					$('.play-wrap').click(function(){
						$('.videoa').css('display','block');
						myVideo1.play();
						document.addEventListener('touchmove', a, false);
					})
					$('.play-btn').click(function(event) {
						$('.videoa').css('display','none');
						myVideo1.pause();
						document.removeEventListener('touchmove', a, false); 
					});
					</script></li>
				</ul>
			</div>
			<div class="service-info">
				<p class="name">家师傅·空调专业清洗
					 - <span style="color: #2c83c7;">专业</span>
					
					 - <span style="color: #f7a700;">可靠</span>
					
				</p>
				<p>值得信赖的空调清洗服务</p>
				<p class="price">
					<span>￥<em>${serviceDetail.money}</em>/台
					</span>
					
				</p>
			</div>
			<style>
.voucher-card {
	color: #fff;
	border-radius: 8px;
	font-size: 16px;
	overflow: hidden;
	position: relative;
	width: 96%;
	margin-left: 1%;
	border: 1px solid #eee;
	margin-bottom: 2px;
}

.green {
	background: #a0d884;
	height: 30px;
	width: 100%;
}

.dotted {
	position: absolute;
	left: 5px;
	top: 2px;
	width: 6px;
	height: 98%;
	background: url(../../../images/page/dotted.png) repeat;
	background-size: 6px auto;
}

.youhuiquan {
	width: 92%;
	margin-left: 8%;
	padding: 10px 0;
}
</style>
					<div style="width:100%;border-top:1px solid #eee;"></div>
					<p style="line-height:2rem;text-indent:1rem;">您尚未登录，无法匹配优惠券！！</p>
			<div style="clear: both;"></div>
			</section>
			<nav>
			<ul class="commitment clearfix">
				<li><a href="javascript:void(0);"><i class="item1"></i></a></li>
				<li><a href="javascript:void(0);"><i class="item2"></i></a></li>
				<li><a href="javascript:void(0);"><i class="item3"></i></a></li>
			</ul>
			<div class="wave-line"></div>
			</nav>
<%--				<section class="wrapper"> <label> 用户评价</label>--%>
<%--				<ul class="ib">--%>
<%--					<li class="lf">--%>
<%--						<div class="rate">--%>
<%--							<img src="http://m.homeking365.com/images/page/rate-imgs/9.png"><span class="orange">91%</span><br>--%>
<%--							非常满意--%>
<%--						</div>--%>
<%--						<div>--%>
<%--							<p>--%>
<%--								已经有<span class="orange">155</span>人评价此服务--%>
<%--							</p>--%>
<%--							<p>--%>
<%--								<span class="orange">91%</span>的会员满意此服务--%>
<%--							</p>--%>
<%--						</div>--%>
<%--					</li>--%>
<%--					<li onclick="showComment(94)" class="rt"><i class="icon arrow"></i></li>--%>
<%--				</ul>--%>
<%--				</section>--%>
			<section class="wrapper detail_intro"> <label>服务介绍</label>
			<ul class="b">
							<li><label class="detail_item_title" data-id="420">服务产品介绍<i class="icon arrow active"></i></label>
								<div class="detail_item_content" style="display: block;"><p>
	<span style="font-size:14px;line-height:2;color:#333333;"> “家师傅”是美家到家自有的家电维修品牌。主要为家庭用户提供空调、油烟机、灶台的深度清洗服务、管道疏通及家电维修等专业服务，满足家庭各类维修、维护需求。</span> 
</p>
<p>
	<span style="font-size:14px;line-height:2;color:#333333;"><br>
</span> 
</p>
<p>
	<span style="font-size:14px;line-height:2;color:#333333;"><img src="http://img.homeking365.com/9823fd15-25c7-4e5f-8e7b-7d12816ffa01.png" alt="家师傅.空调清洗"><br>
</span> 
</p>
<p>
	<span style="font-size:14px;line-height:2;color:#333333;"> 家师傅·空调清洗服务针对客户季节变换过程中，空调闲置及运行阶段过程中的细菌、霉菌及污垢深度保洁和清洗服务。主要提供：空调运营状况检测、氨气压力检测、室内机喷雾清洗，室内机过滤网拆装清洗，室内机冷凝器养护、室外机高压水冲洗服务。</span> 
</p>
<p>
	<br>
</p></div></li>
<%--							<li><label class="detail_item_title" data-id="421">服务适用范围<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
<%--							<li><label class="detail_item_title" data-id="422">服务内容<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
<%--							<li><label class="detail_item_title" data-id="423">服务特点<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
<%--							<li><label class="detail_item_title" data-id="424">服务费用<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
<%--							<li><label class="detail_item_title" data-id="427">服务流程<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
<%--							<li><label class="detail_item_title" data-id="426">服务保障<i class="icon arrow"></i></label>--%>
<%--								<div class="detail_item_content"></div></li>--%>
							<li><label class="detail_item_title" data-id="1880">预定需知<i class="icon arrow"></i></label>
								<div class="detail_item_content"></div></li>
			</ul>
			</section>
			<aside class="fixed">
			<ul>
				<li><a class="city" href="javascript:void(0);"><i class="icon location"></i> <br> <span class="cityName">恩施</span>
						<select id="citySelect">
							
								<option value="xiamen" selected="">恩施</option>
							
								<option value="beijing">北京</option>
							
								<option value="shanghai">上海</option>
							
								<option value="shenzhen">深圳</option>
							
								<option value="guangzhou">广州</option>
							
								<option value="fuzhou">福州</option>
							
								<option value="chengdu">成都</option>
							
								<option value="nanjing">南京</option>
							
								<option value="hangzhou">杭州</option>
							
								<option value="wuxi">无锡</option>
							
								<option value="quanzhou">泉州</option>
							
								<option value="zhangzhou">漳州</option>
							
								<option value="longyan">龙岩</option>
							
								<option value="dongguan">东莞</option>
							
								<option value="foshan">佛山</option>
							
								<option value="jinan">济南</option>
							
								<option value="qingdao">青岛</option>
							
								<option value="suzhou">苏州</option>
							
								<option value="ningbo">宁波</option>
							
								<option value="wenzhou">温州</option>
							
								<option value="nantong">南通</option>
							
								<option value="jiangyin">江阴</option>
							
								<option value="changsha">长沙</option>
							
								<option value="wuhan">武汉</option>
							
								<option value="shijiazhuang">石家庄</option>
							
								<option value="rizhao">日照</option>
							
								<option value="tianjin">天津</option>
							
								<option value="chongqing">重庆</option>
							
								<option value="zhengzhou">郑州</option>
							
								<option value="zhuhai">珠海</option>
							
					</select> </a></li>
				<li><a class="btn orange" href="/services/order/V3/94?code=">立即预定</a></li>
				<li><a class="share-btn" href="javascript:void(0);"><i class="icon share"></i> <br> 分享</a></li>
			</ul>
			</aside>
			<div class="share-wrap none">
				<div class="share-base">
					<div class="shareContent">
						<ul class="jointlogin">
							<!--朋友圈-->
							<li><a href="javascript:weiboShare();" class="weibo"></a></li>
							<li><a href="javascript:qzoneShare();" class="qzone"></a></li>
							<!-- <li><a target="_blank" href="#" class="weixin"></a></li>-->
						</ul>
						<div class="closeShare">暂不分享</div>
					</div>
				</div>
			</div>
			<div id="dialoga">
				<div class="dialog-img01">
					<img src="http://m.homeking365.com/images/page/icon03.png" width="22%">
				</div>
				<p>
					点击右上角的<span class="span-a"><img src="http://m.homeking365.com/images/page/icon02.png" width="15%"></span>就可以分享到朋友圈，据说100%的人分享后可以获得美家服务代金券，拥有并使用它，家里会变得窗明几净，家庭和谐。
				</p>
				<div class="close-a">
					<a href="" onclick="closeaBg();">我知道了</a>
				</div>
			</div>
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
		<a href="http://m.homeking365.com/login"><img src="http://m.homeking365.com/images/page/user-head.png"></a>
		<p>
			<a href="http://m.homeking365.com/login">登录</a><a href="http://m.homeking365.com/login/register">注册</a>
		</p>
	</div>
	<ul id="cmenu">
		<li><a href="http://m.homeking365.com"><i class="icon home"></i>首页</a></li>
		<li><a href="http://m.homeking365.com/activity/hkbg"><i class="icon clock"></i>限时特惠</a></li>
		<li><a href="http://m.homeking365.com/user/center"><i class="icon"></i>个人中心</a></li>
		<!-- homestore新加代码 2015.12.30  开始 -->
		<li><a href="http://m.homeking365.com/product"><i class="icon icon1"></i>HomeStore</a></li>
		<!-- homestore新加代码 2015.12.30  结束-->
		<!-- <li><a href="http://m.homeking365.com/services/list?city=xiamen"><i class="icon coffee"></i>家庭服务</a></li> -->
		<!-- <li><a href="http://m.homeking365.com/product"><i class="icon tag"></i>家庭用品</a></li> -->
		<!-- <li><a href="http://m.homeking365.com"><i class="icon cal"></i>每日特惠</a></li> -->
	</ul>
</section>
		</div>
	</div>
	<script type="text/javascript">
	var servicesId = '94';
	//默认分享内容
	var share = {
		"title" : '在恩施这么多年了，终于有让人值得信赖的家政服务啦！  美家在家-专业家庭服务预定平台 #家师傅·空调专业清洗# 预订地址&gt;&gt;',
		"pic" : 'https://img.homeking365.com/9d843703-1a48-42f8-ae09-c850e220c577.jpg',
		"url" : 'http://m.homeking365.com/services/94',
	}
	$(function(){
		$('.detail-cona').click(function(){
			$('html,body').animate({scrollTop:$('#detail-lia').offset().top+25}, 800);
			$('.detail_item_content').css('display','block')
		})
	})
	
	var isFromApp =null
	//判断访问终端
    var browser={
    versions:function(){
        var u = navigator.userAgent, app = navigator.appVersion;
        return {
            weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
        };
    }(),
    language:(navigator.browserLanguage || navigator.language).toLowerCase()
}
	//显示灰色 jQuery 遮罩层
	function showaBg() {
		if(browser.versions.weixin){
			$("#dialoga").show();
			return;
		}
		if(isFromApp){
			window.location.href=window.location.href+'?weixin-share=0&title='+encodeURI(share.title,"utf-8")+'&pic='+encodeURI(share.pic,"utf-8")+"&url="+encodeURI(share.url,"utf-8");
			return;
		}
		alert("浏览器暂不支持微信分享！");
		
	}
	//关闭灰色 jQuery 遮罩
	function closeaBg() {
		$("#dialoga").hide();
	} 	
</script>
	<script type="text/javascript" src="http://m.homeking365.com/js/plugin/swipe/swipe.js"></script>
	<script type="text/javascript" src="http://m.homeking365.com/js/pages/services/services-intor.js?=20160125"></script>
	<script type="text/javascript" src="common/js/syscommon.js"></script>
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
