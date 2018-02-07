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
					 - <span style="color: #2c83c7;">深度保洁</span>
					
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
<%--				<section class="wrapper"> <label> 用户评价</label>--%>
<%--				<ul class="ib">--%>
<%--					<li class="lf">--%>
<%--						<div class="rate">--%>
<%--							<img src="http://m.homeking365.com/images/page/rate-imgs/9.png"><span class="orange">95%</span><br>--%>
<%--							非常满意--%>
<%--						</div>--%>
<%--						<div>--%>
<%--							<p>--%>
<%--								已经有<span class="orange">107</span>人评价此服务--%>
<%--							</p>--%>
<%--							<p>--%>
<%--								<span class="orange">95%</span>的会员满意此服务--%>
<%--							</p>--%>
<%--						</div>--%>
<%--					</li>--%>
<%--					<li onclick="showComment(277)" class="rt"><i class="icon arrow"></i></li>--%>
<%--				</ul>--%>
<%--				</section>--%>
			<section class="wrapper detail_intro"> <label>服务介绍</label>
			<ul class="b">
				<li><label class="detail_item_title" data-id="1890">服务介绍<i class="icon arrow active"></i></label>
					<div class="detail_item_content" style="display: block;">
						<p class="MsoNormal">
							<span style="color:#333333;font-size:14px;line-height:2;">福维克深度清洁套餐是美家到家由德国引进的家庭深层次除菌除污服务。更专业的系统设备搭配更标准化的培训方案，重新定义清洁与卫生的新观念，为您与家人带来更健康的居住环境。</span> 
						</p>
						<p class="MsoNormal">
							<br>
						</p>
						<p>
							<img src="common/images/shendu-2.png" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p class="MsoNormal">
							<br>
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">服务费用：${serviceDetail.moneya}元/套</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;"> 服务项目：</span><span style="color:#333333;font-size:14px;line-height:2;">360°墙壁掸尘服务</span> 
						</p>
						<span style="color:#333333;font-size:14px;line-height:2;"> 
						<p style="text-indent:5em;">
							窗帘除螨除尘服务
						</p>
						<p style="text-indent:5em;">
							布艺沙发除螨服务
						</p>
						<p style="text-indent:5em;">
							床垫床品除螨服务
						</p>
						<p style="text-indent:5em;">
							地板抛光打蜡服务
						</p>
						</span> 
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;"> 服务适用范围：</span><span style="color:#333333;font-size:14px;line-height:2;">日常家庭室内深度保洁</span> 
						</p>
						<p>
							<br>
						</p>
					</div>
				</li>
				<li><label class="detail_item_title" data-id="1891">服务亮点<i class="icon arrow"></i></label>
					<div class="detail_item_content" ><span style="font-size:16px;line-height:2;">100%德国进口设备 守卫健康家庭</span> 
						<p>
							<br>
						</p>
						<span style="color:#333333;font-size:14px;line-height:2;">美家引进最专业的福维克清洁系统设备，不同工具组合分区域、分材质使用，清洁力度更强、细菌污垢无处滋生，还原家庭健康居室。</span> 
						<p>
							<br>
						</p>
						<p>
							<img src="common/images/shendu-3.png" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="font-size:16px;line-height:2;"> 5大服务项目 &nbsp;零死角深度保洁</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;"> 360°墙壁掸尘、窗帘除螨除尘、布艺沙发除螨、床垫床品除螨、地板抛光打蜡——五大服务项目，美家想您所想，满足家庭深度保洁一切需求，帮您严守边角细节。</span> 
						</p>
						<p>
							<span style="font-size:16px;"><span style="font-size:14px;"><img src="common/images/shendu-4.jpg" width="100%" alt=""><br>
						</span></span> 
						</p>
						<p>
							<span style="font-size:16px;line-height:2;"> 定时工作制 &nbsp;规范服务有保障</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">美家为套餐内每个服务项目制定了最合理的服务时间，服务人员上门必须严格根据服务时间标准化完成所有服务项目，不偷懒、不拖时、更高效，维护用户权益，服务更加规范化。</span> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<img src="common/images/shendu-5.jpg" width="100%" alt=""> 
						</p>
						<p>
							<br>
						</p>
						<p>
							<span style="font-size:16px;line-height:2;">三重认证 &nbsp;人员与服务放心更可靠</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">每位保洁人员，必须通过标准审核、三重认证方有机会正式上岗为您提供优质服务。</span> 
						</p>
						<p>
							<span style="font-size:14px;line-height:1.5;"><img src="common/images/shendu-6.jpg" width="100%" alt=""><br>
						</span> 
						</p>
						<p>
							<span style="font-size:16px;line-height:2;">统一培训 &nbsp; 满分上岗更专业</span> 
						</p>
						<p>
							<span style="color:#333333;font-size:14px;line-height:2;">每位员工上岗前经过80课时的培训、实操、考核；<br>
						定期为员工进行在岗培训，持续提升服务技能。<br>
						</span> 
						</p>
						<p style="text-align:left;">
							<img src="common/images/shendu-7.jpg" width="100%" alt=""> 
						</p>
						<p>
							<span style="color:#333333;font-family:SimSun;font-size:14px;line-height:2;"><br>
						</span> 
						</p></div>
				</li>
				<li><label class="detail_item_title" data-id="1892">服务内容<i class="icon arrow"></i></label>
					<div class="detail_item_content" ><p>
						<img src="common/images/shendu-8.jpg" width="100%" alt=""> 
					</p>
					<p>
						<img src="common/images/shendu-9.jpg" width="100%" alt="">
						<img src="common/images/shendu-10.jpg" width="100%" alt="">
						<img src="common/images/shendu-11.jpg" width="100%" alt="">
						<img src="common/images/shendu-12.jpg" width="100%" alt="">
						<img src="common/images/shendu-13.jpg" width="100%" alt="">
						<img src="common/images/shendu-14.jpg" width="100%" alt="">
						<img src="common/images/shendu-15.jpg" width="100%" alt="">
						<img src="common/images/shendu-16.jpg" width="100%" alt="">
						<img src="common/images/shendu-17.jpg" width="100%" alt=""> 
					</p></div>
				</li>
				<li><label class="detail_item_title" data-id="1893">服务保障<i class="icon arrow"></i></label>
					<div class="detail_item_content" ><img src="common/images/shendu-18.jpg" width="100%" alt=""></div>
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
<%--				<li><a class="city" href="javascript:void(0);"><i class="icon location"></i> <br> <span class="cityName">恩施</span>--%>
<%--						<select id="citySelect">--%>
<%--							--%>
<%--								<option value="xiamen" selected="">恩施</option>--%>
<%--							--%>
<%--								<option value="beijing">北京</option>--%>
<%--							--%>
<%--								<option value="shanghai">上海</option>--%>
<%--							--%>
<%--								<option value="shenzhen">深圳</option>--%>
<%--							--%>
<%--								<option value="guangzhou">广州</option>--%>
<%--							--%>
<%--								<option value="fuzhou">福州</option>--%>
<%--							--%>
<%--								<option value="chengdu">成都</option>--%>
<%--							--%>
<%--								<option value="nanjing">南京</option>--%>
<%--							--%>
<%--								<option value="hangzhou">杭州</option>--%>
<%--							--%>
<%--								<option value="wuxi">无锡</option>--%>
<%--							--%>
<%--								<option value="quanzhou">泉州</option>--%>
<%--							--%>
<%--								<option value="zhangzhou">漳州</option>--%>
<%--							--%>
<%--								<option value="longyan">龙岩</option>--%>
<%--							--%>
<%--								<option value="dongguan">东莞</option>--%>
<%--							--%>
<%--								<option value="foshan">佛山</option>--%>
<%--							--%>
<%--								<option value="jinan">济南</option>--%>
<%--							--%>
<%--								<option value="qingdao">青岛</option>--%>
<%--							--%>
<%--								<option value="suzhou">苏州</option>--%>
<%--							--%>
<%--								<option value="ningbo">宁波</option>--%>
<%--							--%>
<%--								<option value="wenzhou">温州</option>--%>
<%--							--%>
<%--								<option value="nantong">南通</option>--%>
<%--							--%>
<%--								<option value="jiangyin">江阴</option>--%>
<%--							--%>
<%--								<option value="changsha">长沙</option>--%>
<%--							--%>
<%--								<option value="wuhan">武汉</option>--%>
<%--							--%>
<%--								<option value="shijiazhuang">石家庄</option>--%>
<%--							--%>
<%--								<option value="rizhao">日照</option>--%>
<%--							--%>
<%--								<option value="tianjin">天津</option>--%>
<%--							--%>
<%--								<option value="chongqing">重庆</option>--%>
<%--							--%>
<%--								<option value="zhengzhou">郑州</option>--%>
<%--							--%>
<%--								<option value="zhuhai">珠海</option>--%>
<%--							--%>
<%--					</select> </a></li>--%>
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
