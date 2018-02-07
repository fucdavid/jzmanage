<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
	<%@ include file="../basic.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=yes" name="format-detection">
    <meta name="referrer" content="no-referrer">
    <title>结算中心-美家在家-恩施家政服务预订平台</title>
    <meta content="恩施家政，家庭保洁，家电清洗，恩施月嫂，恩施保姆，家务包年" name="keywords">
    <meta content="美家在家恩施站当地领先家政服务预订平台，提供宅洁士居家保洁、金月子星级月嫂、家师傅家电清洗、星级家家务包年、家内助家务保姆等专业的家政服务。" name="description">
    
<link type="text/css" href="common/css/base.css" rel="stylesheet">
<link type="text/css" href="common/css/order.css?v=20160125" rel="stylesheet">

<script type="text/javascript" src="common/js/jquery.min.js"></script>
<script type="text/javascript" src="common/js/jquery.form.js"></script>
<script type="text/javascript" src="common/js/mobile/order-check-services.js?v=201702080808"></script>
<script type="text/javascript" src="common/js/common.js?v=201702080808"></script>
<%--<script src="//hm.baidu.com/hm.js?3c8ecbfa472e76b0340d7a701a04197e"></script><script type="text/javascript" src="http://mstatic.homeking365.com/js/common/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/jquery.mobile.custom.min.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/json2.js"></script>--%>
<%--<script type="text/javascript" src="http://mstatic.homeking365.com/js/common/common.js?v=151014"></script>--%>
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
		}else if(msg){
			infoPrompt(msg);
		}
	})
</script>

<%--    <script type="text/javascript" src="http://mstatic.homeking365.com/js/plugin/citySelectMobile/citySelect.js?v=20160201"></script>--%>
    <script type="text/javascript">
        var servicesName = '宅洁士居家保洁-4小时';
        $(document).ready(function () {
            //防后退
//			window.history.forward(1);
            $(".address").citySelect({
                url: 'http://m.homeking365.com/js/plugin/citySelectMobile/city.json?v=161230',
                prov: '福建省',
                city: city,
                dist: dist,
            });
            //政企活动js
            $('.voucher-statecos').click(function () {
                
                $.ajax({
                    type: "POST",
                    url: "http://m.homeking365.com/user/coupon/checkCountActivityUsedNum",
                    dataType: "json",
                    data: {"id": id},
                    success: function (data) {
                        if (data.code == 20161026) {
                            alert(data.msg);
                            sliderBackPage($('#couponActivityPage'), $('#mainPage'));
                        } else {
                            $('.voucher-statecos-password').css('display', 'block');
                            $('.voucher-statecos-bottom').css('display', 'none');
                        }
                    }
                });
            });
//			$('.voucher-statecos').click(function() {
//				$(this).find('.voucher-statecos-password').css('display', 'block');
//				$('.voucher-statecos-bottom').css('display', 'none');
//			});
            $(".voucher-statecos-ula li a").click(function () {
                var res = $(this).html();
                $(this).addClass('voucher-on').parent().siblings().children('a').removeClass('voucher-on');
                //$(this).parents().prev('.voucher-statecos-ulb').children('.voucher-statecos-ulb li').text('1');
                for (i = 0; i < 4; i++) {
                    if ($(this).parents().prevAll('.voucher-statecos-ulb').children('li').eq(i).text() == '') {
                        $(this).parents().prevAll('.voucher-statecos-ulb').children('li').eq(i).html(res);
                        return;
                    }
                }
            });
            $(".voucher-statecos-lose").click(function () {
                var j;
                for (i = 4; i >= 0; i--) {
                    if ($(this).parents().prevAll('.voucher-statecos-ulb').children('li').eq(i).text() != '') {
                        j = i;
                        break;
                    }
                }
                $(this).parent().prevAll('.voucher-statecos-ulb').children('li').eq(j).html("");
            });

            var id = $("#selCodeId").val();
            var title = $("#selTitle").val();
            var couponMoney = parseInt($("#selCouponMoney").val()).toFixed(2);
            var discountType = $("#selDiscountType").val();
            if (id != "" && title != "" && couponMoney != "" && discountType != "") {
                $('#coupon').find('.content').text(title);
                $('#coupon').attr('data-id', id);
                $('#coupon').attr('data-discountType', discountType);
                $('#coupon').attr('data-amount', couponMoney);
                clearCouponActivityTip();
                setTotalPrice();
                sliderBackPage($(this).parents('.slide-page'), $('#mainPage'));
                infoPrompt('选择“' + title + '”');
            }
        });

        var dist = null;
        
        var dist = '湖里区';
        

        var city = '恩施市';
        

        //春节保姆日租获取url中的参数
        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg); //匹配目标参数
            if (r != null)
                return unescape(decodeURI(r[2]));
            return null; //返回参数值
        }
        var type = decodeURI(getUrlParam('serviceType'));
        var serviceT = decodeURI(getUrlParam('serviceTime'));
        var flag = decodeURI(getUrlParam('flag'));
        var strs = null;
        if (type != '' && serviceT != '' && flag == '1') {
            strs = "服务类型：" + type + " | 服务时间：" + serviceT;
            $("#demandExplication").val(strs);
        }
        $('.prov').removeAttr("disabled");
    </script>
    <style type="text/css">
        .toolTip {
            position: fixed;
            top: 0px;
            left: 0px;
            background: rgba(0, 0, 0, 0.8);
            width: 100%;
            height: 1200px;
            z-index: 9999999;
            display: none;
        }

        .toolTip-div {
            width: 80%;
            height: auto;
            margin: 0 auto;
            background: #1ea8e7;
            position: relative;
            top: 14%;
            border-radius: 16px;
            padding: 10%;
            box-sizing: border-box;
        }

        .toolTip-text {
            color: white;
            font-size: 14px;
            line-height: 20px;
            text-indent: 2em;
        }

        .toolTip-btn {
            width: 100%;
            margin-top: 20px;
            text-align: center;
        }

        .toolTip-btn p {
            width: 50%;
            background: #ffdb38;
            height: 30px;
            line-height: 30px;
            border-radius: 5px;
            color: #ff6600;
            margin: 0 auto;
        }

        .pay-mode {
            display: none;
            background: rgba(0, 0, 0, 0.9);
            width: 100%;
            height: 100%;
            position: fixed;
            z-index: 999;
            top: 0;
            bottom: 0;
            left: 0
        }

        .pay-mode dl {
            width: 90%;
            margin: 0 auto;
            position: relative;
            font-size: 12px;
            top: 20%;
            background: #fff;
            border-radius: 10px;
            -webkit-border-radius: 10px
        }

        .pay-mode dl dt {
            border-bottom: 2px solid #ddd;
            padding: 10px;
            box-sizing: border-box;
            -wbkit-box-sizing: border-box
        }

        .pay-mode dl dd {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            box-sizing: border-box;
            -wbkit-box-sizing: border-box;
            *zoom: 1
        }

        .pay-mode dl dd:before, .pay-mode dl dd:after {
            content: "";
            display: table
        }

        .pay-mode dl dd:after {
            clear: both
        }

        .pay-mode dl dd .pay-mode-img {
            width: 40px;
            padding-right: 10px
        }

        .pay-mode dl dd .pay-mode-word {
            padding-top: 5px;
            color: #999
        }

        .pay-mode dl dd .pay-mode-word p {
            font-size: 14px;
            color: #333
        }

        .pay-mode dl dd .pay-mode-kuang {
            width: 20px;
            padding-top: 5px
        }

        .pay-mode dl dd .pay-mode-kuang span {
            width: 20px;
            height: 20px;
            border-radius: 20px;
            -webkit-border-radius: 20px;
            display: block;
            vertical-align: middle;
            border: 1px solid #7f838a;
            position: relative;
            float: left;
            margin-top: 5px
        }

        .pay-mode dl dd:last-child {
            border-bottom: none
        }

        .red-kuang {
            background: url(/images/page/order/icon11.png);
            background-size: 100% auto;
            border: 1px solid #ff4650 !important
        }

        .left {
            float: left;
        }

        .wrapper ul.b div {
            display: none;
            padding: 0 10px 0 0 !important;
            color: #999;
            line-height: inherit !important;
            margin-top: inherit !important;
        }

        .wrapper ul.b label span {
            min-width: inherit !important;
        }

        .order-check .user-info .title {
            width: auto;
        }
    </style>
</head>
<body class="order-detail order-check" dh="1" rlt="1">
<input type="hidden" id="selCodeId" value="">
<input type="hidden" id="selTitle" value="">
<input type="hidden" id="selCouponMoney" value="">
<input type="hidden" id="selDiscountType" value="">

<div class="hk-container">
    <div class="hk-main">
        <div class="slide-page" id="mainPage">
            
                <header><a class="back" href="javascript: history.go(-1);"></a>
                    结算中心
<%--                            <div class="btns ">--%>
<%--                                <a class="hk-home-btn" href="javascript:void(0);"></a>--%>
<%--                            </div>--%>
                </header>
            
            <section class="wrapper order-info" style="margin-top: 12px;">
                <label>订单信息</label>
                <ul>
                    <li class="clearfix">
                        <div class="clearfix"></div>

                        <div class="props">
                            <p class="btn-link name">${serviceDetail.detailName}</p>
                            <c:if test="${null != datetime}">
                                    <p>
                                        服务时间：
                                        ${datetime}
                                    </p>
                            </c:if>
                                <c:if test="${serviceDetail.detailId == 1}">
	                                <p>数量：${num}人</p>
                                </c:if>
                                <p>
                                    单价：<span class="red" id="unitPrice">￥${money}</span> <input type="hidden" id="originPrice" value="${money}">
                                </p>
                            <input type="hidden" id="totalPriceHidden" value="${money}">
                        </div>
                    </li>
                </ul>
            </section>
            <section class="wrapper user-info" style="margin-top: 0px;">
                <ul class="b">
                    <li>
                        <a href="javascript:slidePage();">
                        	<c:if test="${addressList== null || fn:length(addressList) == 0}">
                        		<label >
                        			<span style="padding-left: 0px;" >
		                        		请填写服务地址
                        			</span>
                        		</label>
                        	</c:if>
                        	<c:if test="${addressList!= null && fn:length(addressList) != 0}">
                                    <label data-id="${addressList[0].addressId}" class="location">
									<span style="padding-left: 0px;" class="content">
										<span class="title">${addressList[0].name}</span> <br>
										<span class="btn-link" style="padding-top: 6px;">${addressList[0].phone}</span><br>
										<span class="address" style="line-height: 22px;">${addressList[0].address}</span>
									</span>
                                        <i class="icon arrow"></i>
                                    </label>
                        	</c:if>
                        </a>
                    </li>
                </ul>
            </section>
<%--                <section class="wrapper demand"><label>服务需求</label>--%>
<%--                    <ul class="b" id="demand-tag">--%>
<%--                                    <li class="dkv" id="boli_a"><label> <span class="title">您家的玻璃类型?</span><br> <input type="hidden" class="content" value="单层玻璃"> <input type="radio" name="boliType" checked="" value="单层玻璃">单层玻璃 <input type="radio" name="boliType" style="margin-left: 10px" value="钢化层玻璃">钢化层玻璃 <input type="radio" name="boliType" style="margin-left: 10px" value="双层中空层">双层中空层--%>
<%--                                    </label></li>--%>
<%--                            <li class="dkv" id="boli">--%>
<%--                                <label> <span class="title">是否主擦玻璃？</span> <span style="padding-top: 6px;" class="content" id="boli_c"></span><i class="icon arrow"></i> <select>--%>
<%--                                    <option value="" selected="selected" style="display: none;"></option>--%>
<%--                                        <option name="s_0" value="0">是的，请把时间花在玻璃上，我要亮堂堂。</option>--%>
<%--                                        <option name="s_1" value="1">不需要，请把时间大部分安排在室内卫生细节。</option>--%>
<%--                                </select>--%>
<%--                                </label>--%>
<%--                            </li>--%>
<%--                            <li class="dkv">--%>
<%--                                <label> <span class="title">物品是否归位？</span> <span style="padding-top: 6px;" class="content"></span><i class="icon arrow"></i> <select>--%>
<%--                                    <option value="" selected="selected" style="display: none;"></option>--%>
<%--                                        <option name="s_0" value="0">是的，打扫时请注意物品归位。</option>--%>
<%--                                        <option name="s_1" value="1">不需要归位，可以整理有序排放我的物品。</option>--%>
<%--                                </select>--%>
<%--                                </label>--%>
<%--                            </li>--%>
<%--                        --%>
<%--                            <li class="other"><label class="disable"><span class="title">其他需求</span> <span class="content">您对订单有特殊需求可在此备注--%>
<%--						</span> </label>--%>
<%--                                <div style="display: block;">--%>
<%--                                    <textarea rows="3" id="serviceNR"></textarea>--%>
<%--                                </div>--%>
<%--                            </li>--%>
<%--                    </ul>--%>
<%--                </section>--%>
            

            <section class="wrapper pay-info"><label>支付信息</label>
                <ul class="b">
<%--                    <li id="selectPay">--%>
<%--                                        <label id="payTypeVal" data-id="21" class="payType"> <span class="title">支付方式</span>--%>
<%--                                            <span class="content" id="payTypeName">支付宝</span><i class="icon arrow"></i>--%>
<%--                    </label></li>--%>

<%--                    <li id="coupon"><a href="javascript:void(0);"><label><span class="title">优惠券</span><span class="content" style=" width: 300px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">选择使用优惠劵</span> <i class="icon arrow"></i></label></a>--%>
<%--                    </li>--%>
<%--                    <li id="couponActivity"><a href="javascript:void(0);"><label>--%>
<%--								<span class="title">企业特惠</span><span class="content">选择参与优惠活动</span> <i class="icon arrow"></i>--%>
<%--                    </label> </a></li>--%>
                    
                        <li><label id="balance"><span class="content"><input type="checkbox">使用余额：<span class="orange number">${clientInfo.money}.00</span></span></label></li>
                </ul>
            </section>
            <section class="wrapper order-price">
                <ul class="b">
                    <li class="nb"><label style="padding-bottom: 7px;"> <span class="title">商品总价</span><span class="content serve-price" id="sumMoney">￥${money}</span></label></li>
                    <li class="nb"><label style="padding-top: 7px; padding-bottom: 7px;"><span class="title">优惠抵用</span><span class="content" id="couponMoney">￥0.00</span>
                    </label></li>
                    <li class="nb"><label style="padding-top: 7px;"><span class="title">余额抵用</span><span class="content" id="balanceMoney">￥0.00</span>
                    </label></li>
                    <li><label><span class="title">总金额 </span><span class="red total-price" id="totalPrice">￥${money}</span> </label></li>
                </ul>

                <aside class="normal">
                    <div id="submitOrder" class="none">
                        <form action="wximpl/orderpay" method="POST">
                            <input type="hidden" name="clientId" value="${clientInfo.clientId}"> 
                            <input type="hidden" name="detailId" value="${serviceDetail.detailId}"> 
                            <input type="hidden" name="time" value="${datetime}">
                            <input type="hidden" name="peopleNum" value="${num}"> 
                            <input type="hidden" name="area" value="${num}"> 
                            <input type="hidden" name="addressId" > 
                            <input type="hidden" name="account"> 
                            <input type="hidden" name="discount">
                            <input type="hidden" name="paymoney"> 
                        </form>
                    </div>
                    <ul>
                        <li><a class="btn orange" href="javascript:void(0);" id="submitBtn">提交订单</a></li>
                    </ul>
                    <img class="none" src="http://mstatic.homeking365.com/images/common/loading-2.gif">
                </aside>
            </section>

        </div>
        <!-- 管理地址start -->
        <div class="slide-page" id="addressPage">
            <header><a class="back slide-back-btn" data-slide="mainPage" href="javascript: history.go(-1);"></a>选择家庭地址
            </header>
            <section class="wrapper order-address"><input type="hidden" value="">
                <ul class="b">
                		<c:forEach items="${addressList}" var="item" varStatus="i">
	                        <li><a href="javascript:void(0);"><label data-id="${item.addressId}" class="active">
	                            <p class="c333">
	                                <span class="name">${item.name}</span><span class="tel">${item.phone}</span>
	                            </p>
	                            <p class="c999 address">${item.address}</p>
	                        </label></a></li>
                		</c:forEach>
                </ul>
            </section>
            <aside class="normal">
                <ul>
                    <li><a class="btn orange slide-page-btn" id="manageAddressBtn" data-slide="addressListPage" href="javascript:void(0);">管理地址</a></li>
                </ul>
            </aside>
        </div>
        <!-- 管理地址end -->

        <!-- 编辑地址列表start -->
        <div class="slide-page" id="addressListPage">
            <header><a class="back slide-back-btn" data-slide="addressPage"></a>地址列表
            </header>
            <section class="wrapper address-list">
                <ul class="b">
                		<c:forEach items="${addressList}" var="item" varStatus="i">
	                        <li><a href="javascript:void(0);"><label data-id="${item.addressId}" class="active">
	                            <p class="c333">
	                                <span class="name">${item.name}</span><span class="tel">${item.phone}</span>
	                            </p>
	                            <p class="c999 address">${item.address}</p>
	                        </label></a></li>
                		</c:forEach>
                </ul>
            </section>
            <aside class="normal">
                <ul>
                    <li><a class="btn orange" id="addAddressBtn" href="javascript:slidePageToAddAddress();">新增地址</a></li>
                </ul>
            </aside>
        </div>
        <!-- 编辑地址列表end -->

        <!-- 编辑地址start -->
        <div class="slide-page" id="addressEditPage">
            <header><a class="back slide-back-btn" data-slide="addressListPage"></a>编辑地址
                <div class="btns ">
                    <a class="delete" href="javascript:void(0);"></a>
                </div>
            </header>
            <input type="hidden" id="clientId" value="${clientInfo.clientId}"> 
            <form method="post" id="addressFrom">
                <section class="wrapper address order-address-add"><input type="hidden" name="id" id="adsId" value="">
                    <ul class="b">
                        <li><label> <span class="active">联系人</span><input type="text" name="name" id="contactName" value="">
                        </label></li>
                        <li><label> <span class="active">手机号码</span> <input type="text" name="phone" id="contactPhone" value="">
                        </label></li>
<%--                        <li><label> <span class="active">省</span><span class="content disabled">福建省</span><i class="arrow"></i> <select class="prov" disabled="disabled"><option value="410000">河南省</option><option value="120000">天津</option><option value="110000">北京</option><option value="500000">重庆</option><option value="440000">广东省</option><option value="130000">河北省</option><option value="320000">江苏省</option><option value="510000">四川省</option><option value="350000">福建省</option><option value="430000">湖南省</option><option value="330000">浙江省</option><option value="210000">辽宁省</option><option value="370000">山东省</option><option value="310000">上海</option><option value="420000">湖北省</option></select>--%>
<%--                        </label></li>--%>
<%--                        <li><label> <span class="active">城市</span><span class="content  disabled">厦门市</span><i class="arrow"></i> <select class="city" disabled="disabled"><option value="350100">福州市</option><option value="350200">厦门市</option><option value="350300">莆田市</option><option value="350400">三明市</option><option value="350500">泉州市</option><option value="350600">漳州市</option><option value="350700">南平市</option><option value="350800">龙岩市</option><option value="350900">宁德市</option></select>--%>
<%--                        </label></li>--%>
<%--                        <li><label> <span class="active">地区</span><span class="content disabled">湖里区</span><i class="arrow"></i>--%>
<%--                            <select class="dist" disabled="disabled"><option value="350203">思明区</option><option value="350205">海沧区</option><option value="350206">湖里区</option><option value="350211">集美区</option><option value="350212">同安区</option><option value="350213">翔安区</option></select>--%>
<%--                        </label></li>--%>
                        <li><label> <span class="active">详细地址</span> <input type="text" name="address" id="address" value="">
                        </label></li>
<%--                        <li><label> <span class="active">小区楼盘</span> <input type="text" name="addressExtra" id="community" value="">--%>
<%--                        </label></li>--%>
<%--                        <li><label> <span class="active">服务面积</span> <input type="text" name="area" id="area" value="">--%>
<%--                        </label></li>--%>
                    </ul>
                </section>
            </form>
            <aside class="normal">
                <ul>
                    <li><a class="btn orange" id="saveAddressBtn" href="javascript:void(0);">保存地址信息</a></li>
                </ul>
            </aside>
        </div>
        <!-- 编辑地址end -->

        <div class="slide-page" id="couponPage">
            <header><a class="back slide-back-btn" data-slide="mainPage" href="javascript:void;"></a>优惠券
            </header>
            <div id="activity" style="position: absolute; width: 92px; height: 23px; left: 532px; top: 50px; transform: rotate(0deg); font-size: 13px; padding: 0px; border-radius: 0px; border-width: 0px; border-style: solid; line-height: 19px; font-weight: normal; font-style: normal; justify-content: flex-end; align-items: center; pointer-events: auto; z-index: 6; opacity: 1;">
                <p>激活新的优惠券</p>
                <div class="region gesture"></div>
            </div>
            <div id="close" style="display:none;position: absolute; width: 92px; height: 23px; left: 532px; top: 50px; transform: rotate(0deg); font-size: 13px; padding: 0px; border-radius: 0px; border-width: 0px; border-style: solid; line-height: 19px; font-weight: normal; font-style: normal; justify-content: flex-end; align-items: center; pointer-events: auto; z-index: 6; opacity: 1;">
                <p>关闭激活优惠券</p>
                <div class="region gesture"></div>
            </div>

            <section class="voucher-wrap" style="position: relative;top: 25px;">
                <div id="activityTips" style="display:none;width:318px;height:23px;left:22px;color:#b0b0b0;transform: rotate(0deg);-webkit-transform: rotate(0deg);font-size:13.0px;padding:0px;border-radius:0px;border-width:0px;border-style:solid;line-height:19px;font-weight:normal;font-style:normal;justify-content: flex-start;align-items: center;pointer-events:auto;z-index:7;opacity:1">
                    <p>如果您拥有优惠券激活码，请输入以激活新的优惠券。</p>
                </div>
                <div id="inputActivity" class="voucher-active" style="display:none;">
                    <label> <input type="text" id="couponCode" name="couponCode" placeholder="激活优惠券">
                    </label> <a class="btn-link fr" id="activateCouponBtn" href="javascript:void(0);">激活</a>
                </div>
                
                    <div class="no-voucher"></div>
                 </section>
        </div>
        <div class="slide-page" id="couponActivityPage">
            <header><a class="back slide-back-btn" data-slide="mainPage" href="javascript:void;"></a>企业特惠
            </header>
            <section class="voucher-wrap">
                <div class="no-voucher"></div>
             </section>
        </div>
    </div>
    

<div id="payChoose" class="pay-mode" style="display:none">
	<dl>
		<dt>选择支付方式</dt>
		
		
			<dd data-id="21" data-txt="支付宝">
				<div class="pay-mode-img left">
					<img src="http://m.homeking365.com/images/page/order/zhifu/21.png" width="100%">
				</div>
				<div class="pay-mode-word left" style="padding-top: 7px !important; ">
					<p>支付宝</p>
					推荐已安装支付宝APP的用户使用
				</div>
				<div class="pay-mode-kuang" style="float: right">
					<span></span>
				</div>
			</dd>
		
		<dd data-id="12" data-txt="中国银联">
			<div class="pay-mode-img left">
				<img src="http://m.homeking365.com/images/page/order/zhifu/12.png" width="100%">
			</div>
			<div class="pay-mode-word left" style="padding-top: 7px !important; ">
				<p>中国银联</p>
				便捷 、高效
			</div>
			<div class="pay-mode-kuang" style="float: right">
				<span></span>
			</div>
		</dd>
		<dd data-id="61" data-txt="招商银行">
			<div class="pay-mode-img left">
				<img src="http://m.homeking365.com/images/page/order/zhifu/61.png" width="100%">
			</div>
			<div class="pay-mode-word left" style="padding-top: 7px !important; ">
				<p>招商银行</p>
				借记卡、信用卡都可以
			</div>
			<div class="pay-mode-kuang" style="float: right">
				<span></span>
			</div>
		</dd>
	</dl>
</div>
<script>
	var _webApp = 'http://m.homeking365.com';
	$(".pay-mode").click(function() {
		$(".pay-mode").hide();
	})
	//选择支付方式
	$(".pay-mode dd").click(function() {
		$(this).find("span").addClass("red-kuang").parents("dd").siblings().find("span").removeClass("red-kuang");
		$(".pay-mode").hide();

		var payTypeVal=$(this).attr('data-id');
		var payTypeName=$(this).attr('data-txt');
		$("#payTypeVal").attr('data-id', payTypeVal);
		$("#payTypeName").text(payTypeName);

		var payImgSrc = _webApp+'/images/page/product/zhifu/'+payTypeVal+'.png';
		$("#payImg").attr("src",payImgSrc);
	})
	// 显示支付切换页面
	$('#selectPay').click(function() {
		var payTypeVal = $("#payTypeVal").attr('data-id');
		if (payTypeVal == 71) return false; // 建设银行不显示选择框
		$(".wrapper ul.b div").show();

		$(".pay-mode").show();
		$(".pay-mode").find("dd[data-id='"+payTypeVal+"']").find("span").addClass("red-kuang");
	});
</script>
<style>
	.pay-mode{display:none;background:rgba(0,0,0,0.9);width:100%;height:100%;position:fixed;z-index:999;top:0;bottom:0;left:0}
	.pay-mode dl{width:90%;margin:0 auto;position:relative;font-size:12px;top:20%;background:#fff;border-radius:10px;-webkit-border-radius:10px}
	.pay-mode dl dt{border-bottom:2px solid #ddd;padding:10px;box-sizing:border-box;-wbkit-box-sizing:border-box}
	.pay-mode dl dd{padding:10px;border-bottom:1px solid #ddd;box-sizing:border-box;-wbkit-box-sizing:border-box;*zoom:1}
	.pay-mode dl dd:before,.pay-mode dl dd:after{content:"";display:table}
	.pay-mode dl dd:after{clear:both}
	.pay-mode dl dd .pay-mode-img{width:40px;padding-right:10px}
	.pay-mode dl dd .pay-mode-word{padding-top:5px;color:#999}
	.pay-mode dl dd .pay-mode-word p{font-size:14px;color:#333}
	.pay-mode dl dd .pay-mode-kuang{width:20px;padding-top:5px}
	.pay-mode dl dd .pay-mode-kuang span{width:20px;height:20px;border-radius:20px;-webkit-border-radius:20px;display:block;vertical-align:middle;border:1px solid #7f838a;position:relative;float:left;margin-top:5px}
	.pay-mode dl dd:last-child{border-bottom:none}
	.red-kuang{background:url(/images/page/order/icon11.png);background-size:100% auto;border:1px solid #ff4650 !important}
	.left {
		float: left;
	}
	.wrapper ul.b div{
		display: none;
		padding: 0 10px 0 0 !important;
		color: #999;
		line-height: inherit !important;
		margin-top: inherit !important;
	}
	.wrapper ul.b label span{
		min-width: inherit !important;
	}
</style>

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



<div class="cnzz-stats" style="display: none;">
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
    $(document).ready(function () {
        $("#activity").click(function () {
            $("#activity").hide();
            $("#close").show();
            $("#activityTips").show();
            $("#inputActivity").show();
        })
        $("#close").click(function () {
            $("#activity").show();
            $("#close").hide();
            $("#activityTips").hide();
            $("#inputActivity").hide();
        })
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
</body></html>