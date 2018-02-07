<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<%@ include file="../basic.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=yes" name="format-detection">
<title>美家家政-家政服务预订平台</title>
<link type="text/css" href="common/css/base.css" rel="stylesheet">
<link type="text/css" href="common/css/services.css" rel="stylesheet">
<script type="text/javascript" src="common/js/jquery.min.js"></script>
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
					<li><img src="common/images/shendu-1.png" style="height:260px;background-image: url()">
						</li>
				</ul>
			</div>
			<div class="service-info">
				<p class="name">${serviceDetail.detailName}
					
					 - <span style="color: #f7a700;">套餐</span>
					
				</p>
				<p>${serviceDetail.describes}</p>
				<p class="price">
					<span>￥<em>${serviceDetail.moneya}</em>/套
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
				<li><label class="detail_item_title" data-id="1890">服务介绍<i class="icon arrow active"></i></label>
					<div class="detail_item_content" style="display: block;">
						<p class="MsoNormal">
							<span style="color:#333333;font-size:14px;line-height:2;">美家根据房屋装修的特征进行专业审核与研究，制定了“5步6标准”的开荒保洁服务标准，确保您的新家干净明亮，安安心心入住!</span> 
						</p>
						<p>
							<br>
						</p>
					</div>
				</li>
				<li><label class="detail_item_title" data-id="1891">服务亮点<i class="icon arrow"></i></label>
					<div class="detail_item_content" ><span style="font-size:16px;line-height:2;">5步6标准</span> 
						<p>
							<br>
						</p>
						<p>
							<img src="common/images/new-1.png" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="font-size:16px;line-height:2;"> 5步</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;"> 1、擦玻璃——使用玻璃刮，抹水器，无泡玻璃水，强力清洁剂，彻底清除污垢（窗框清理，保护膜的清理，窗户缝的吸尘，保洁公司提醒您对一些顽固的水泥点胶质可用玻璃铲刀去除）药水中有防静电成分，经擦拭过的玻璃、窗框晶莹光亮，不沾尘。</span> 
						</p>
						<p>
							<span style="font-size:16px;"><span style="font-size:14px;"><img src="common/images/new-2.png" width="100%" alt=""><br>
						</span></span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">2、全面牵尘养护——使用大功率真空吸尘器、牵尘器，将所有墙面、台面、暖气罩内、天花板、装饰吊顶、各种橱柜、纱窗、灯具等易附灰尘的材料，用品，家具表面擦拭，然后对其进行专业养护，洁瓷剂、不锈钢光亮剂、铁艺水及清洁蜡的使用可对各种材料镀上保护膜使其光亮照人，日常养护更加容易。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">3、洗地面——地砖表面使用高档强力洗地机配合硬质地坪清洗剂处理，真空吸水机清理，使地面清洁更显光泽。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">4、厨厕除污消毒——使用酸性清洁剂、高效去油剂、水锈净、消毒剂的你专业药剂进行特别处理使厨厕内各种设备、用具洁净光亮，更易护理。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">5、装修痕迹的清理——针对装修后遗留的漆点、胶迹、涂料点、水泥块、铅笔痕使用清洁球、专业铲刀、除胶剂、稀释等专用药剂进行细微处理。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<img src="common/images/new-3.png" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<img src="common/images/new-4.png" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="font-size:16px;line-height:2;">6标准</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">1、玻璃标准——目视无水痕、无手印、无污渍、光亮洁净。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">2、卫生间标准——墙体无色差、无明显污渍、无涂料点、无胶迹、洁具洁净光亮、不锈钢管件光亮洁净、地面无死角、无遗漏、无异味。<br></span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">3、厨房标准——墙体无色差、无明显污渍、无涂料点、无胶迹、不锈钢管件光亮洁净、地面无死角、无遗漏。<br></span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">4、卧室及大厅标准——墙壁无尘土、灯具洁净，开关盒洁净无胶渍，排风口、空调出风口无灰尘、无胶点。<br></span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">5、门及框标准——无胶渍、无漆点、触摸光滑、有光泽，门沿上无尘土。<br></span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">6、地面的标准——木制地板无胶渍、洁净，瓷砖无尘土、无漆点、无水泥渍、有光泽，石材无污渍、无胶点、光泽度高。<br></span> 
						</p>
						</div>
				</li>
				<li><label class="detail_item_title" data-id="1894">预定需知<i class="icon arrow"></i></label>
					<div class="detail_item_content" style="display: none;"><table style="width:100%;" cellpadding="0" cellspacing="0" align="left" border="0" class="ke-zeroborder">
					<tbody>
						<tr>
							<td style="vertical-align:top;">
								<p>
									<img src="http://img.homeking365.com/68f39373-4a18-470c-b992-3026c5d365ba.png" alt=""> 
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
									<img src="http://img.homeking365.com/bd8c40e7-509d-4ec2-8d82-ea6ef826a54a.png" alt=""> 
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
									<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">更改</span> 
								</p>
								<p>
									<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;">订单服务前20小时更改订单，可在个人账户-服务订单-操作更改；订单服务20小时内更改订单，我们将收取30元的空单费后给予更改。<br>
				如遇停水状况：请提前20小时拨打0718—8999099进行订单修改，若突发停水导致无法服务，在服务人员已出发的情况，我们将收取30元的上门费。<br>
				无法入户服务：若因雇主原因导致无法入户服务，服务人员在等待一小时后将自行离开，视同服务完成。或者雇主可以支付30元上门费后更改服务时间。<br>
				</span> 
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
									<img src="http://img.homeking365.com/9e94335a-acb4-4d8a-9843-be66e1494e7f.png" alt=""> 
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
									<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;">取消</span> 
								</p>
								<p>
									<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> 可在个人账户-服务订单-操作取消在订单服务时间提前20小时取消订单的，预定金额将100%返还至个人账户；订单服务20小时内取消订单，扣除30元空单费退还余额；3小时之内取消不退款。</span> 
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
<br></div></li>
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
	var servicesId = '277';
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
</body></html>
