<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<%@ include file="../basic.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=yes" name="format-detection">
<title>家洁士-美家到家-家政服务预订平台</title>

<link type="text/css" href="common/css/base.css" rel="stylesheet">
<link type="text/css" href="common/css/services.css" rel="stylesheet">
<script type="text/javascript" src="common/js/jquery.min.js"></script>
<script type="text/javascript">
<%--	var _webApp = 'http://m.homeking365.com';--%>
</script>

</head>
<body class="service-detail">
	<div class="hk-container">
		<div class="hk-main">
			<header> 
			<a class="back back-btn" href="javascript:;" onclick="javascript :history.back(-1);"></a> 服务详细
<%--			<div class="btns">--%>
<%--				<a class="hk-home-btn" href="javascript:void(0);"></a>--%>
<%--			</div>--%>
			</header>
			<section class="banner">
			<div class="slider" id="slider" style="visibility: visible;">
				<ul class="swipe-wrap" style="height: 235px">
					<li><img src="common/images/meijia-bg.jpg" style="height:260px;background-image: url(http://img.homeking365.com/f8187097-4faf-4ed6-bd86-bf8d0ff3c503.jpg)"></li>
				</ul>
			</div>
			<div class="service-info">
				<p class="name">${serviceDetail.detailName}</p>
				<p>${serviceDetail.describes}</p>
				<p class="price">
					<span>￥<em>${serviceDetail.moneya}</em>/人
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
<%--					<p style="line-height:2rem;text-indent:1rem;">您尚未登录，无法匹配优惠券！！</p>--%>
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
			
			<section class="wrapper detail_intro"> <label>服务介绍</label>
			<ul class="b">
				<li><label class="detail_item_title" data-id="2693">家洁士 - 介绍<i class="icon arrow active"></i></label>
					<div class="detail_item_content" style="display: block;">
						<p style="text-indent:2em;">
							<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">家洁士是美家到家推出的专业家庭保洁服务，为行业带来<span>4</span>小时标准服务制，雇佣式的员工管理、规范化的培训流程、专业的保洁工具为您提供更佳的保洁体验。</span> 
						</p>
						<p style="text-indent:2em;">
							<br>
						</p>
						<p>
							<br>
						</p>
						<p style="text-indent:2em;">
							<span style="font-size:14px;font-family:SimSun;color:#333333;line-height:2;"></span> 
						</p>
						<p>
							<img src="common/images/jujia-1.png" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;">服务费用：<span style="color:#333333;">${serviceDetail.money}元/人/次</span> </span> 
						</p>
						<p>
							<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;"><span style="color:#333333;"><span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:28px;">预约有效期：</span><span style="font-family:SimSun;font-size:14px;line-height:28px;color:#333333;">90天</span><br>
						</span></span> 
						</p>
						<p>
							<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;">适用范围：<span style="color:#333333;">本产品仅适用于日常家庭室内保洁，<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;"><span style="color:#333333;">新房开荒保洁不在服务范围</span></span><span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;"></span>，</span></span><span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">不可用于学校、办公室、商铺
						、出租房、新装修房、长期未入住房、集体宿舍楼等房子类型保洁。</span> 
						</p>
						<p style="text-align:left;">
							<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">为了让您拥有更好的服务性价比，建议您参考以下标准进行人员预订</span> 
						</p>
						<p>
							<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;"><img src="common/images/jujia-2.png" alt=""><br></span> 
						</p>
					</div>
				</li>
				<li><label class="detail_item_title" data-id="2694">家洁士 - 标准<i class="icon arrow"></i></label>
					<div class="detail_item_content">
						<p>
							<img src="common/images/jujia-3.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-4.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-5.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-6.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-7.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-8.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-9.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-10.png" alt=""> 
						</p>
						<p>
							<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;">注明：<span style="color:#333333;">家洁士服务仅适用于日常家庭基础保洁，<span style="color:#E56600;font-family:SimSun;font-size:14px;line-height:2;"><span style="color:#333333;">厨柜内部（含内部陈设物品）、窗帘、字画、古董、宗教陈设、易损易碎摆件、天花板及附属品（吊灯、吊顶等）等深度服务项目，不在家洁士保洁范围之内。</span></span><span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;"></span>，</span></span><span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">如您有以上保洁需求请致电客服热线0718—8999099（家务事，我帮您！）了解相关深度保洁服务。</span> 
						</p>		
					</div>
				</li>
				<li><label class="detail_item_title" data-id="2695">家洁士 - 工具<i class="icon arrow"></i></label>
					<div class="detail_item_content">
						<p>
							<img src="common/images/jujia-11.png" alt=""> 
						</p>
						<p>
							<img src="common/images/jujia-12.png" alt=""> 
						</p>
					</div>
				</li>
				<li><label class="detail_item_title" data-id="2696">家洁士 - 亮点<i class="icon arrow"></i></label>
					<div class="detail_item_content">
						<table style="width:100%;" cellpadding="0" cellspacing="0" align="left" border="0" class="ke-zeroborder">
						<tbody>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-13.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="line-height:1.5;color:#333333;font-family:SimSun;font-size:14px;">员工雇佣制 阿姨更稳定</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;">改变传统中介式家政服务美家保洁阿姨一律合同签约，成为旗下正式员工进行员工制管理；
阿姨享有底薪保障与合理的晋升机制，优秀阿姨不流失，有效维护人员稳定性。</span> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-15.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">七色保洁布 分区使用更卫生</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;">美家在家为行业带来七色保洁布，规范化分区域使用，不同颜色、不同材质的保洁布适用于
不同区域，干湿分离、避免交叉污染，干净更卫生。<br></span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"></span> 
									</p>
									<p>
										<img src="common/images/jujia-14.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-16.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">专业工具组 超强清洁无死角</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> 引进日本专业保洁工具组，区域使用划分明晰，应用多项专利技术，实现保洁服务无死角。</span> 
									</p>
									<p>
										<img src="common/images/jujia-17.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-18.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">三重认证 人员与服务放心更可靠</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> 每位保洁人员，必须通过标准审核、三重认证方有机会正式上岗为您提供优质服务。</span> 
									</p>
									<p>
										<img src="common/images/jujia-19.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-20.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">统一培训 满分上岗更专业</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> 每位员工上岗前经过80课时的培训、实操、考核；
定期为员工进行在岗培训，持续提升服务技能。</span> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
						</tbody>
				</table>
				<br>
					</div>
				</li>
<%--				<li><label class="detail_item_title" data-id="2697">家洁士 - 保障<i class="icon arrow"></i></label>--%>
<%--					<div class="detail_item_content">--%>
<%--					</div>--%>
<%--				</li>--%>
				<li><label class="detail_item_title" data-id="2699">预定需知<i class="icon arrow"></i></label>
					<div class="detail_item_content" style="display: none;">
					<table style="width:100%;" cellpadding="0" cellspacing="0" align="left" border="0" class="ke-zeroborder">
						<tbody>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-21.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="line-height:1.5;color:#333333;font-family:SimSun;font-size:14px;">预定</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;">预定成功后，付款选择在线支付，服务订单会为您保留30分钟（从预定成功时间算起），30分钟后如还末付款成功，系统将自动取消该服务订单。</span> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-22.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">更改或取消</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;">订单服务前2小时更改订单，可在“美家在家”APP，“美家在家公众号”个人账户-服务订单-操作更改或取消，如有其他疑问在工作时间拨打0718—8999099电话或联系在线客服。</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"></span> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/jujia-23.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
								<td>
									<p>
										<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">产生临时退改费</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> （1）订单服务开始前2小时内至服务开始后1小时要求更改服务时间或取消订单的;<br>
										（2）停水：如您未在订单服务开始前2小时致电美家在家或在服务开始后1小时内因突发的停水导致无法服务的;<br>
										（3）或因您的原因导致保洁师无法入户服务，保洁师将等待1个小时后离开的。<br>
										以上美家在家将向您收取50元作为临时退改费，取消您本次保洁次数，并将余款退回。
										</span> 
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
						</tbody>
				</table>
				<br>
				</div>
			</li>
			</ul>
			</section>
			<aside class="fixed">
			<ul>
			<li></li>
				<li><a class="btn orange" href="wximpl/generate/${serviceDetail.detailId}_${clientId}">立即预定</a></li>
<%--				<li><a class="share-btn" href="javascript:void(0);"><i class="icon share"></i> <br> 分享</a></li>--%>
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
					<img src="http://m.homeking365.com/images/pagse/icon03.png" width="22%">
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
	</section>
		</div>
	</div>
	<script type="text/javascript">
	var servicesId = '8';
	
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
	<script type="text/javascript" src="common/js/swipe.js"></script>
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
</body>
</html>
