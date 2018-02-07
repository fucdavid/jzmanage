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
					<li><img src="common/images/4a-1.png" style="height:260px;">
					</li>
				</ul>
			</div>
			<div class="service-info">
				<p class="name">${serviceDetail.detailName}
					 - <span style="color: #2c83c7;">家务包年</span>
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
				<li><label class="detail_item_title" data-id="3180">星级家 - 套餐<i class="icon arrow active"></i></label>
					<div class="detail_item_content" style="display: block;">
						<p>
							<img src="common/images/4a-2.png" alt=""> 
						</p>
						<p>
							<img src="common/images/4a-3.png" alt=""> 
						</p></div>
				</li>
				<li><label class="detail_item_title" data-id="3181">星级家 - 概述<i class="icon arrow"></i></label>
					<div class="detail_item_content">
					<img src="common/images/star-4.png" alt=""> 
					<img src="common/images/star-5.png" alt=""> 
					<img src="common/images/star-6.png" alt=""> 
					<img src="common/images/star-7.png" alt=""> 
					<img src="common/images/star-8.png" alt=""> 
					<img src="common/images/star-9.png" alt="">
					</div>
				</li>
				<li><label class="detail_item_title" data-id="3182">星级家 - 稳定<i class="icon arrow"></i></label>
					<div class="detail_item_content"><p>
						<img src="common/images/star-10.png" alt="">
						<img src="common/images/star-11.png" alt=""> 
					</p>
					<p>
						<img src="common/images/star-12.png" alt=""> 
					</p>
					</div>
				</li>
				<li><label class="detail_item_title" data-id="3183">星级家 - 标准<i class="icon arrow"></i></label>
					<div class="detail_item_content" >
					<img src="common/images/star-13.jpg" alt="">
					<img src="common/images/star-14.jpg" alt="">
					<img src="common/images/star-15.jpg" alt="">
					<img src="common/images/star-16.jpg" alt="">
					<img src="common/images/star-17.jpg" alt="">
					<img src="common/images/star-18.jpg" alt="">
					<img src="common/images/star-19.jpg" alt="">
					<img src="common/images/star-20.jpg" alt="">
					<img src="common/images/star-21.jpg" alt=""></div>
				</li>
				<li><label class="detail_item_title" data-id="3184">星级家 - 员工<i class="icon arrow"></i></label>
					<div class="detail_item_content" >
					<img src="common/images/star-22.jpg" alt="">
					<img src="common/images/star-23.jpg" alt="">
					</div>
				</li>
				<li><label class="detail_item_title" data-id="3185">星级家 - 工具<i class="icon arrow"></i></label>
					<div class="detail_item_content" >
					<img src="common/images/star-24.png" alt="">
					<img src="common/images/star-25.png" alt="">
					<img src="common/images/star-26.png" alt=""></div>
				</li>
				<li><label class="detail_item_title" data-id="3186">星级家 - 保障<i class="icon arrow"></i></label>
					<div class="detail_item_content">
						<img src="common/images/star-27.png" alt="">
						<img src="common/images/star-28.png" alt="">
						<img src="common/images/star-29.png" alt="">
					</div>
				</li>
				<li><label class="detail_item_title" data-id="3187">星级家 - 亮点<i class="icon arrow"></i></label>
					<div class="detail_item_content" ><br>
					<table style="width:100%;" cellpadding="2" cellspacing="0" border="0" class="ke-zeroborder" bordercolor="#000000">
						<tbody>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-30.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">全年固定阿姨&nbsp;家务满意更省心</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 星级家包年用户专享美家星级固定服务人员，您可以按照个人标准挑选优秀的保洁人员，获取专属于您的固定保洁服务，减少不必要的沟通环节，更了解您的保洁需求，为您带来一室的干净整洁。</span> 
									</p>
								<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-31.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">科学排期&nbsp;制定专属保洁计划</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 根据您的需要，线下工作人员为您制定专门的保洁排期方案，更科学、更合理、更人性化，满足您一年的保洁需求。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-32.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">服务更多样&nbsp;深层清洁更卫生</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;">星级家·保洁包年除常规的宅洁士日式保洁外，更增加由德国引进的福维克清洁套装，同时提供各种家电清洗服务，360°守卫您的家庭卫生；</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;">套餐内服务项目可按比例置换，自由搭配，更灵活、更能满足不同家庭对不同保洁的需求。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-33.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;"> 专属门号牌&nbsp;VIP体验更高质效</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;">拥有专属门号牌，保洁阿姨扫码签到，系统记录打扫时长更有保障，让你享受星级家庭的尊贵体验。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-34.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">打包全年服务&nbsp;价格更优惠</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 星级家·保洁包年套餐，均价比单次订购优惠10%以上；</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 年底不加价，打破行业惯例，年底服务费比同行优惠50%以上；</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 法定节假日（除元旦节1月1号，劳动节5月1号，国庆节10月1号，除夕到来年初六这些时间不能提供服务）照常上门服务，价格不上涨，不收取额外费用。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-35.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">员工雇佣制&nbsp;阿姨更稳定</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 改变传统中介式家政服务，美家保洁阿姨一律合同签约，成为旗下正式员工，进行员工制管理；</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 阿姨享有底薪保障与合理的晋升机制，优秀阿姨不流失，有效维护人员稳定性。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-36.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">4小时工作制&nbsp;全程标准化服务</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 4小时定量完成用户家庭保洁所包含的服务项目，不偷懒、不拖时，服务更加规范化。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-37.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">七色保洁布&nbsp;分区使用更卫生</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;">美家在家为行业带来七色保洁布，规范化分区域使用，不同颜色、不同材质的保洁布适用于不同区域，干湿分离、避免交叉污染，干净更卫生。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td>
								</td>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/star-38.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-39.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">专业工具组&nbsp;超强清洁无死角</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 引进日本专业保洁工具组，区域使用划分明晰，应用多项专利技术，实现保洁服务无死角。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;" colspan="2">
									<p>
										<img src="common/images/star-40.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<br>
									<p>
										<img src="common/images/star-41.png" alt=""> 
									</p>
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">测评上市&nbsp;38万小时全国实测保障</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 美家在家的服务体系分别引进日本山崎产业株式会社和日本BEARS家政服务集团，经中国大陆38万小时的实用测试后正式投放市场。</span> 
									</p>
								</td>
							</tr>
							<tr>
								<td>
								</td>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/star-42.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-43.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">三重认证&nbsp;人员与服务放心更可靠</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 每位保洁人员，必须通过标准审核、三重认证方有机会正式上岗为您提供优质服务。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td>
								</td>
								<td style="vertical-align:top;">
									<p>
										<img src="common/images/star-44.png" alt=""> 
									</p>
									<p>
										<br>
									</p>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-45.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">统一培训&nbsp;满分上岗更专业</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 每位员工上岗前经过80课时的培训、实操、考核；</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 定期为员工进行在岗培训，持续提升服务技能。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-46.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">专注家庭日常保洁&nbsp;专业水准更放心</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 为了更好地服务于常住家庭日常保洁，宅洁士产品不适用于新装修房拓荒保洁、公共区域、办公场所、商铺、宿舍等区域，因为专一，所以专业。</span> 
									</p>
					<br>
								</td>
							</tr>
							<tr>
								<td style="vertical-align:top;">
									<img src="common/images/star-47.png" alt=""> 
								</td>
								<td>
									<p>
										<span style="color:#666666;line-height:1.5;font-family:SimSun;font-size:14px;">人性化管理&nbsp;阿姨整体素质更高</span> 
									</p>
									<p>
										<span style="color:#999999;font-family:SimSun;line-height:1.5;"> 一周六天，一天两次的4小时服务时间，美家用更加人性化的机制保障阿姨休息权益，提高阿姨整体素质，提升阿姨对工作的优越感，吸引更多优秀人才进入家政服务行业。</span> 
									</p>
								</td>
							</tr>
						</tbody>
					</table></div>
				</li>
				<li><label class="detail_item_title" data-id="3188">预定需知<i class="icon arrow"></i></label>
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
									<span style="color:#999999;font-family:SimSun;font-size:12px;line-height:1.5;"> 可在个人账户-服务订单-操作取消在订单服务时间提前20小时取消订单的，预定金额将返还至个人账户；订单服务20小时内取消订单，扣除30元空单费退还余额；3小时之内取消不退款。</span> 
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
	<script type="text/javascript">
	var servicesId = '72';
	//默认分享内容
	var share = {
		"title" : '在恩施这么多年了，终于有让人值得信赖的家政服务啦！  美家在家-专业家庭服务预定平台 #星级家·A4自由生活# 预订地址&gt;&gt;',
		"pic" : 'https://img.homeking365.com/5b4f38c3-2301-4ba6-95d7-86e16c1fc15a.jpg',
		"url" : 'http://m.homeking365.com/services/72',
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
