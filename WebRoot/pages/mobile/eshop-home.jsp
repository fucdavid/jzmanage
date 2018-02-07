<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
	<%@ include file="../basic.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=yes" name="format-detection">
    <title>美家家政-家政服务预订平台</title>
    
<link type="text/css" href="common/css/base.css" rel="stylesheet">

<script type="text/javascript" src="common/js/jquery.min.js"></script>
</head>
<body>
<div class="carnival_main">
    <!--官网进入弹窗-->
    <div class="hk-container">
        <div class="hk-main">
            <header>
            	<img src="common/images/logo-a.png" style="height: 28px; margin-top: 5px">
            </header>
            <!--个人中心弹窗-->
<%--            <div class="tp-coupon none" id="userCoupon" style="display: none;">--%>
<%--                <div class="tp-coupon-box">--%>
<%--                    --%>
<%--                    <div class="tp-coupon-word">--%>
<%--                        <div class="tp-coupon-word-top">--%>
<%--                            <div>--%>
<%--                                <i><img src="http://mstatic.homeking365.com/images/common/icon-a.png" width="100%"></i>您的个人账户中已有<span style="color: #ef5165;" id="couponNum"></span>张抵用券--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div style="clear: both;"></div>--%>
<%--                    </div>--%>
<%--                    <ul class="tp-coupon-ul" id="couponList">--%>
<%----%>
<%--                    </ul>--%>
<%--                    <div class="tp-coupon-more">--%>
<%--                        显示更多 进入<a href="http://m.homeking365.com/user/center">个人中心</a><span id="coupon-close" class="tp-coupon-close"><img src="http://mstatic.homeking365.com/images/common/icon-b.png" width="100%">--%>
<%--							关闭</span>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <section class="banner">
                <div class="slider" id="slider" style="visibility: visible;">
                    <ul class="swipe-wrap" style="width: 100%;">
                            <li data-index="0" style="width: 100%; left: 0px; transition-duration: 0ms; transform: translate(0px, 0px) translateZ(0px);"><a> <img src="common/images/meijia-bg.jpg" ></a></li>
                    </ul>
                </div>
                <ul class="slider-btn">
                        <li class="active"></li>
                </ul>
            </section>
            <section style="border-top: 1px solid #D5DAE0;">
                <div class="y-row">
                    <div class="y-span4" style="width: 49.9%;position: relative;">
                    	<span class="line-left"></span>
                                <a href="wximpl/services/1_${clientId}"><img src="common/images/pic07.png" width="100%"></a>
                    </div>
                    <div class="y-span4" style="width: 49.9%;position: relative;">
                    	<span class="line-left"></span>
                                <a href="JavaScript:showMsg();"><img src="common/images/pic02.png" width="100%"></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="y-row">
                    <div class="y-span4" style="width: 49.9%;position: relative;">
                        <span class="line-left"></span>
                                <a href="wximpl/services/3_${clientId}"><img style="width: 100%;" src="common/images/pic06.png" ></a>
                    </div>
                     <div class="y-span4" style="width: 49.9%;position: relative;">
                        <span class="line-left"></span>
                                <a href="wximpl/services/4_${clientId}"><img style="width: 100%;" src="common/images/pic05.png" ></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </section>
            <!-- 2017.05.15修改 -->
            <section class="homestore-shownew" style="width: 100%;margin-top: 10px;">
                <a href="JavaScript:showMsg();"><img src="common/images/pic10_v1.jpg" width="100%"></a>
            </section>
            <!-- 2016.03.23结束 -->
<%--                <section class="nav wrap">--%>
<%--                    <ul class="nav-ul">--%>
<%--                            <li><a href="http://m.homeking365.com/activity/ad2015">--%>
<%--                                <div class="nav-li-left">--%>
<%--                                    <p class="li-p-a" style="color:#CD00CD">美家TVC</p>--%>
<%--                                    <p class="li-p-b">让家务归美家，让生活归生活</p>--%>
<%--                                </div>--%>
<%--                                <div class="nav-li-img">--%>
<%--                                    <img src="http://img.homeking365.com/a1d8f0ae-5d5e-44f1-ad7b-350cac048da6.png">--%>
<%--                                </div>--%>
<%--                            </a></li>--%>
<%--                            <li><a href="http://m.homeking365.com/coop/qfb">--%>
<%--                                <div class="nav-li-left">--%>
<%--                                    <p class="li-p-a" style="color:#FF7F00">企福宝</p>--%>
<%--                                    <p class="li-p-b">更受欢迎的员工福利方案</p>--%>
<%--                                </div>--%>
<%--                                <div class="nav-li-img">--%>
<%--                                    <img src="http://img.homeking365.com/94d4d6e9-109d-4c08-8120-c1831bb02b8d.png">--%>
<%--                                </div>--%>
<%--                            </a></li>--%>
<%--                            <li><a href="http://m.homeking365.com/activity/star/2015">--%>
<%--                                <div class="nav-li-left">--%>
<%--                                    <p class="li-p-a" style="color:">星级家</p>--%>
<%--                                    <p class="li-p-b">稳定服务选包年，家务省心一整年</p>--%>
<%--                                </div>--%>
<%--                                <div class="nav-li-img">--%>
<%--                                    <img src="http://img.homeking365.com/d9010c8d-7dce-4039-944c-91b04592e042.jpg">--%>
<%--                                </div>--%>
<%--                            </a></li>--%>
<%--                            <li><a href="http://m.homeking365.com/activity/doubledenier?wxjsapi=true&amp;hmsr=shuangdan">--%>
<%--                                <div class="nav-li-left">--%>
<%--                                    <p class="li-p-a" style="color:#FF0000">狂欢双旦</p>--%>
<%--                                    <p class="li-p-b">春节保洁特惠马上订</p>--%>
<%--                                </div>--%>
<%--                                <div class="nav-li-img">--%>
<%--                                    <img src="http://img.homeking365.com/a99a8057-083e-4f3b-90d7-53fcec2702ff.png">--%>
<%--                                </div>--%>
<%--                            </a></li>--%>
<%--                    </ul>--%>
<%--                    <div class="clearfix"></div>--%>
<%--                </section>--%>
<footer>
<%--	<ul>--%>
<%--		<li><a href="http://m.homeking365.com">首页</a></li>--%>
<%--		<li><a href="http://m.homeking365.com/user/order">订单</a></li>--%>
<%--		<li><span class="current">手机版 </span></li>--%>
<%--		<li><a href="http://www.homeking365.com?display=pc">电脑版</a></li>--%>
<%--		<li><a href="http://m.homeking365.com/user/center">个人中心</a></li>--%>
<%--	</ul>--%>
	<img src="common/images/logo-a.png">
	<p>
		服务热线：<a href="tel:0718—8999099">0718—8999099</a> 家务事 我帮您
	</p>
	<p class="copyright">©2016 恩施市美家创新家政有限责任公司 版权所有</p>
</footer>
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

        <div class="mypopup" style="display: none;">
            <div class="mypre-popupbox4">
                <img src="http://mstatic.homeking365.com/images/page/close.png" class="mypre-popup-close">
                <div class="mypre-popuptext"><p>美家APP即将重大改版!</p></div>
                <div class="mypre-popuptext2">在此之前，建议您移步微信公众号，关注“美家在家公众号”，服务更便捷，还有一大波福（好）利（慷）等着您哦！</div>
                <div class="mypre-popupbtn4">我知道了</div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $(function () {
            var isFromApp = ""
            if (isFromApp == "true") {
//                alert("亲，美家APP即将迎来重磅改版，在此之前，建议您可以移步微信公众号关注“美家在家公众号”，服务更便捷，还有一大波福利等着您哦！");
                $('.mypopup').css("display","block");
            }
            $('#userCoupon').hide();

            $("img.lazy").lazyload();
            //城市选择
            $('#city').click(function (e) {
                if ($('.city-layer').is(':visible')) {
                    $(".city-layer").hide();
                } else {
                    $(".city-layer").show();
                }

            });
            $('.city-box').click(function (e) {
                e.stopPropagation();
            });
            $('.city-layer').click(function (e) {
                $(".city-layer").hide();
            });
            //幻灯片
            if ($('#slider').length) {
                $('#slider').Swipe({
                    auto: 5000,
                    speed: 600,
                    callback: function (index) {
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
            //关闭优惠券提示列表
            $("#coupon-close").click(function () {
                $(".tp-coupon").slideUp("slow");
                $.cookie("coupontips", "showed", {
                    expires: 7
                });
            });
            //关闭app弹窗
            $(".mypre-popup-close").click(function(){
                $('.mypopup').css("display","none");
            })
            $(".mypre-popupbtn4").click(function(){
                $('.mypopup').css("display","none");
            })
        })
        function initCard() {
            var coupontips = $.cookie("coupontips");
            if (coupontips != 'showed') {
                $.post(_webApp + '/user/coupon/userCouponAbout', function (result) {
                    if (result.code == 0) {
                        if (result.data.size > 0) {
                            showUserCoupon(result.data);
                        }

                    }
                }, 'json');
            }
        }
        function showUserCoupon(data) {
            $('#couponNum').text(data.size);
            var listHtml = '';
            for (var i in data.list) {
                var coupon = data.list[i];
                listHtml += '<li><span><a href="http://m.homeking365.com/qr/coupon/view?couponCodeId=' + coupon.id + '">立即使用</a></span>' + coupon.name + '</li>';
            }
            $('#couponList').html(listHtml);
            $('#userCoupon').show();
        }

    </script>
    <script type="text/javascript">
        $('.popup3_close').click(function () {
            $('.carnival_popup3').css('display', 'none');
        })
        function showMsg(){
			alert("即将上线，敬请期待");
            }
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
</div></body></html>