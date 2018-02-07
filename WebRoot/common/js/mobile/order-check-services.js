$(function() {
	// 星级保姆 - 地区提示
	if(servicesName.indexOf('保姆') >= 0){
		var addressTips = '';
		if($('#servicesTypeName').html().indexOf('H8') > 0 && $('#servicesTypeName').html().indexOf('住家') > 0 && $('#servicesTypeName').html().indexOf('不住家') < 0 ) {
			//住家
			switch (city) {
				case '北京市':addressTips = '可服务区域：朝阳,海淀,昌平,丰台,顺义,东城,西城';break;
				case '上海市':addressTips = '可服务区域：全市(金山,崇明,奉贤区除外)';break;
				case '广州市':addressTips = '可服务区域：天河,海珠,白云,番禺,越秀,荔湾';break;
				case '深圳市':addressTips = '可服务区域：南山,宝安,福田,罗湖,龙华,龙岗';break;
				case '厦门市':addressTips = '住家可服务区域：全市范围';break;
				default : addressTips = '城市识别有误';
			}
		}else{
			switch (city) {
				case '北京市':addressTips = '不住家可服务区域：朝阳全区';break;
				case '上海市':addressTips = '不住家可服务区域：闵行区 ,徐汇区 ,长宁区';break;
				case '广州市':addressTips = '不住家可服务区域：天河区 ,海珠区';break;
				case '深圳市':addressTips = '可服务区域：南山 ,宝安 ,福田 ,罗湖 ,龙华';break;
				case '厦门市':addressTips = '可服务区域：思明(除鼓浪屿外),湖里 ,海沧 ,集美';break;
				default : addressTips = '城市识别有误';
			}
		}
 		$('#addressTips').html(addressTips);
	}

	$('.demand ul li select').change(function() {
		var text = $(this).find('option:selected').text().substr(0);
		$(this).parent().find('.content').text(text);
		var title = $(this).parent().find('.title').text().substr(0);
	});
	// "您家的玻璃类型"
	$("input[name='boliType']").on("click", function() {
		$(this).parent().find('.content').val($(this).val());
		$(this).parent().find('.content').text($(this).val());
	});

	// 地址列表选择
	$('.order-address').on('click', 'label', function() {
		var id = $(this).attr('data-id');
		var name = $(this).find('.name').text();
		var tel = $(this).find('.tel').text();
		var address = $(this).find('.address').text();
		$('.user-info').find('label').attr('data-id', id);
		$('.user-info').find('.title').text(name);
		$('.user-info').find('.btn-link').text(tel);
		$('.user-info').find('.address').text(address);
		setActionAddress();
		sliderBackPage($(this).parents('.slide-page'), $('#mainPage'));
	});
	$('.address-list').on('click', 'label', function() {
		var id = $(this).attr('data-id');
//		editAddress(id);
		$('#adsId').val(id);
		$('#contactName').val($(this).find('.name').text());
		$('#contactPhone').val($(this).find('.tel').text());
		$('#address').val($(this).find('.address').text());
		slidePageToEditAddress();
	});
	// 优惠劵列表选择
	$('#coupon').on('click', function() {
		var pid = $('#submitOrder input[name="promotionId"]').val();
		var couponActivityId = $('#couponActivity').attr('data-id');
		if (pid) {
			alert("特惠订单不能使用优惠劵！");
		} else {
			sliderNextPage($('#mainPage'), $('#couponPage'));
		}
	});
	$('#couponPage').on('click', '.voucher-card', function() {
		var id = $(this).attr('data-id');
		var title = $(this).find('.voucher-title .t').text();
		var couponMoney = parseFloat($(this).find('.voucher-price').text()).toFixed(2);
		var discountType = $(this).attr('data-discountType');
		$('#coupon').find('.content').text(title);
		$('#coupon').attr('data-id', id);
		$('#coupon').attr('data-discountType', discountType);
		$('#coupon').attr('data-amount', couponMoney);
		clearCouponActivityTip();
		setTotalPrice();
		sliderBackPage($(this).parents('.slide-page'), $('#mainPage'));
		infoPrompt('选择“' + title + '”');
	});

	$('#couponActivity').on('click', function() {
		var pid = $('#submitOrder input[name="promotionId"]').val();
		if (pid) {
			alert("特惠订单不能参加优惠活动！");
		} else {
			sliderNextPage($('#mainPage'), $('#couponActivityPage'));
		}
	});

	// 余额使用
	$('#balance input[type="checkbox"]').click(function() {
		setTotalPrice(true);
	});
	// 提交按钮事件
	$('#submitBtn').click(function() {
		var homemaster = $("#homemaster").val();
		if (homemaster == 1) {
			$(".toolTip").css("display", "block");
		} else {
			if (!$(this).hasClass('disable')) {
				submitOrder();
			}
		}
	});

	//阅读协议
	$("#agreeCheckBox").click(function(){
		if($("#agreeCheckBox").is(':checked')){
			$("#submitBtn").removeClass("disable");
		}else{
			$("#submitBtn").addClass("disable");
		}
	});

	$("#myknow").click(function() {
		$(".toolTip").css("display", "none");
		if (!$(this).hasClass('disable')) {
			submitOrder();
		}
	});
	$("#I_know").click(function() {
		$(".toolTip").css("display", "none");
	});
	// 地址相关页切换管理

	$('#saveAddressBtn').on('click', function() {
		saveAddress();
	});
	$('#addressEditPage .delete').on('click', function() {
		delAddress();
	});
	$('#activateCouponBtn').on('click', function() {
		activateCoupon();
	});
	setActionAddress();
	var agreeXJJ = $('#agreeXJJ input[type="checkbox"]').is(':checked');
	var flaged =$("#xjj_xy").val();
	if(flaged!=null){
		if(agreeXJJ){
			$("#submitBtn").removeClass("disable");
		}else {
			$("#submitBtn").addClass("disable");
		}
	}
	//阅读星级家协议
	$("#agreeXJJ").click(function(){
		var agreeXJJ = $('#agreeXJJ input[type="checkbox"]').is(':checked');
		if(agreeXJJ){
			$("#submitBtn").removeClass("disable");
		}else{
			$("#submitBtn").addClass("disable");
		}
	});
});
/**
 * 激活优惠劵
 */
function activateCoupon() {
	var couponCode = $('#couponCode').val();
	var servicesId = $('#submitOrder input[name="servicesId"]').val();
	var skuId = $('#submitOrder input[name="skuId"]').val();
	var promotionId = $('#submitOrder input[name="promotionId"]').val();
	var serviceTime = $('#submitOrder input[name="datetime"]').val();
	var url = _webApp + '/user/coupon/activeUsableCoupon';
	$.post(url, {
		couponCode : couponCode,
		servicesId : servicesId,
		skuId : skuId,
		serviceTime : serviceTime,
		promotionId : promotionId
	}, function(data) {
		if (data.result == 'success') {
			var coupon = data.data;
			var html = '<div class="voucher-card" data-id="' + coupon.id + '" data-discountType="' + coupon.discountType + '"><div class="voucher-title green"><span class="t">' + coupon.name + '</span></div><div class="voucher-info"><span class="voucher-price">' + coupon.amount + '</span>元';
			if (coupon.discountType == 1) {
				html += '<span class="voucher-tips">直购</span>';
			} else {
				html += '<span class="voucher-tips" style="background-color: #37ACDA;">减额</span>';
			}
			html += '<span class="expiry-date"> 使用有效期至：' + coupon.useEndDate + '</span><p>' + coupon.detail + '</p>';
			if (coupon.partner) {
				html += '<p>合作单位：' + coupon.partner + '</p>';
			}
			html += '</div><i class="dotted"></i></div>';
			$('#couponPage').find('.no-voucher').remove();
			$('#couponPage .voucher-wrap').append(html);
			alert(data.message);
		} else {
			alert(data.message);
		}
	}, 'json');
}

/**
 * 设置总价
 */
function setTotalPrice(flag) {
	var couponId = $('#coupon').attr('data-id');
	var couponActivityId = $('#couponActivity').attr('data-id');
	// **** 20160302修改 开始
	var price;
	// 使用单价(有可能是特殊价格)进行结算
	var unitPrice = parseFloat($('#unitPrice').text().replace('￥', ''));
	var totalPriceHidden = parseFloat($('#totalPriceHidden').val());

	$('#unitPrice').text('￥' + unitPrice + ".00");
	$('#sumMoney').text('￥' + totalPriceHidden + ".00");
	price = totalPriceHidden;
	// ****20160302修改 结束
	var discountType = $('#coupon').attr('data-discountType');
	// 设置优惠劵抵扣金额
	var couponAmount = 0;
	var amount = $('#coupon').attr('data-amount');
	// 设置优惠活动抵扣金额.
	var couponActivityAmount = $('#couponActivity').attr('data-amount');
	var couponActivityDiscountType = $('#couponActivity').attr('data-discountType');
	if (couponActivityAmount != undefined && couponActivityAmount != "") {// 如果有优惠活动,怎设置优惠活动的优惠金额
		amount = couponActivityAmount;
	}

	if (amount) {
		var discountType = $('#coupon').attr('data-discountType');
		if (couponActivityDiscountType != undefined && couponActivityDiscountType != "") {// 优惠活动的优惠方式
			discountType = couponActivityDiscountType;
		}
		// 按照折扣类型处理计算
		if (discountType == 0) {
			couponAmount = amount;
		} else if (discountType == 1) {
			// **** 20160302修改 开始
			// couponAmount = unitPrice - amount;
			couponAmount = price - amount;
			// ****20160302修改 结束
		}
		$('#couponMoney').text('-￥' + currencyFormatted(couponAmount));
	} else {
		$('#couponMoney').text('￥0.00');
	}
	var sumMoney = parseFloat($('#sumMoney').text().replace('￥', ''));
	var totalPrice = sumMoney - parseFloat(couponAmount);

	// 如果总价+优惠金额不足以抵用金额，则使用可以使用余额抵扣
	var useBalance = $('#balance input[type="checkbox"]').prop("checked");
	if (totalPrice > 0 && useBalance) {
		var balanceMoney = parseFloat($('#balance .number').text());
		totalPrice = totalPrice - balanceMoney;
		// 如果余额大于需要支付的总价，则使用部分余额
		if (totalPrice < 0) {
			balanceMoney = balanceMoney + totalPrice;
			totalPrice = 0;
		}
		$('#balanceMoney').text('-￥' + parseFloat(balanceMoney).toFixed(2));
	}else{
		$('#balanceMoney').text('￥0.00');
	}
	// 设置
	totalPrice = parseFloat(totalPrice).toFixed(2);
	if (totalPrice < 0) {
		totalPrice = 0;
	}
	$('#totalPrice').text('￥' + totalPrice);
}

/**
 * 提交订单
 */
function submitOrder() {
	var locationId = $('.location').attr('data-id');
	$("#submitOrder input[name='addressId']").val(locationId);
	var account = $('#balance input[type="checkbox"]').prop("checked");
	if(account){
		$("#submitOrder input[name='account']").val(parseInt($(".number").text()));
	}else{
		$("#submitOrder input[name='account']").val(0);
	}
	var paymoney = $('#totalPrice').text();
	$("#submitOrder input[name='paymoney']").val(paymoney.split('￥')[1]);
	if (locationId) {
		$("#submitBtn").addClass('disable').html('<img src="common/images/loading-2.gif"/> 订单提交中……');
		$("#submitOrder form").submit();
	} else {
		alert("请先填写您的地址信息");
	}

}

/**
 * 储存地址
 *
 * @param {Object}
 *            form
 */
function saveAddress() {
	var addressId = $('#adsId').val();
	var clientId = $('#clientId').val();
	var name = $('#contactName').val();
	var phone = $('#contactPhone').val();
	var address = $('#address').val();
	if (!/^.+/.test(name)) {
		errorPrompt("请填写联系人！");
		return;
	}
	if (!/^1\d{10}$/.test(phone)) {
		errorPrompt("请填写正确的手机号码！");
		return;
	}
	if (!/^.+/.test(address)) {
		errorPrompt("请填写详细地址！");
		return;
	}
	$.ajax({
		url: 'clientAddress/save',
		type: 'post',
		dataType: 'json',
		data: {"name":name, "phone":phone, "address":address,"addressId":addressId,"clientId":clientId},
		success: function(jsonData){
			if (jsonData.errcode == 1) {
				alert(jsonData.msg);
			} else if(jsonData.errcode == -1){
				alert('系统错误！');
			} else {
				var id = jsonData.addressId;
				if ($('.address-list label[data-id="' + id + '"]').length) {
					var html = '<p class="c333"><span class="name">' + jsonData.name + '</span><span class="tel">' + jsonData.phone + '</span></p>' + '<p class="c999 address">' + jsonData.address + '</p>';
					$('.address-list label[data-id="' + id + '"]').html(html);
					$('.order-address label[data-id="' + id + '"]').html(html);
				} else {
					var addrHtml = '<li><a href="javascript:void(0);"><label data-id="' + jsonData.addressId + '">' + '<p class="c333"><span class="name">' + jsonData.name + '</span><span class="tel">' + jsonData.phone + '</span></p>' + '<p class="c999 address">' + jsonData.address + '</p>' + '</label></a></li>';
					$('.address-list ul').append(addrHtml);
					$('.order-address ul').append(addrHtml);
				}

				$('.order-address label').removeClass('active');
				$('.order-address label[data-id="' + id + '"]').addClass('active');

				var pageid = $('#addressEditPage .back').attr('data-slide');
				$('.user-info ul a').html(
						'<label data-id="' + id + '" class="location"> <span style="padding-left: 0px;" class="content"><span class="title">' + jsonData.name + '</span><br><span class="btn-link" style="padding-top: 6px;">' + jsonData.phone + '</span><br><span class="address" style="line-height:22px;">' + jsonData.address
						+ '</span></span> <i class="icon arrow"></i></label>');
				sliderBackPage($('#addressEditPage'), $('#' + pageid));
			}
			
//			if(jsonData.errcode == -1){
//				alert('系统错误！');
//			}else{
//				if(jsonData.errcode == 0){
//					alert(jsonData.msg);
//				}else{
//					alert(jsonData.msg);
//				}
//			}
		},
		error: function(e){
		}
	});
}	
	
	
//	var form = $('#addressFrom');
////	var prov = $(form).find('.prov option:selected').text();
////	var city = $(form).find('.city option:selected').text();
////	var dist = $(form).find('.dist option:selected').text();
////	$('input[name="province"]', form).val(prov);
////	$('input[name="city"]', form).val(city);
////	$('input[name="district"]', form).val(dist);
////	if (!/^.+/.test(prov)) {
////		errorPrompt("请选择省份！");
////		return false;
////	}
////	if (!/^.+/.test(city)) {
////		errorPrompt("请选择城市！");
////		return false;
////	}
////	if (!/^.+/.test(dist)) {
////		errorPrompt("请选择区域！");
////		return false;
////	}
//	var url = 'clientAddress/save';
//	var options = {
//		url : url,
//		beforeSubmit : function(arr, $form, options) {
//			var contacName = $('input[name="name"]', $form).val();
//			if (!/^.+/.test(contacName)) {
//				$('input[name="name"]', $form).focus();
//				errorPrompt("请填写联系人！");
//				return false;
//			}
//			var contactPhone = $('input[name="phone"]', $form).val();
//			if (!/^1\d{10}$/.test(contactPhone)) {
//				errorPrompt("请填写正确的手机号码！");
//				$('input[name="phone"]', $form).focus();
//				return false;
//			}
//			var address = $('input[name="address"]', $form).val();
//			if (!/^.+/.test(address)) {
//				$('input[name="address"]', $form).focus();
//				errorPrompt("请填写详细地址！");
//				return false;
//			}
////			var area = $('input[name="area"]', $form).val();
////			if (!/^\d+$/.test(area)) {
////				$('input[name="area"]', $form).focus();
////				errorPrompt("请填写正确的服务面积，纯数字格式！");
////				return false;
////			}
//			return true;
//		},
//		success : function(data) {
//			if (data.result == "success") {
//				var addr = data.data;
//				var id = addr.id;
//				if ($('.address-list label[data-id="' + id + '"]').length) {
//					var html = '<p class="c333"><span class="name">' + addr.contacts + '</span><span class="tel">' + addr.phone + '</span></p>' + '<p class="c999 address">' + addr.fullAddress + '</p>';
//					$('.address-list label[data-id="' + id + '"]').html(html);
//					$('.order-address label[data-id="' + id + '"]').html(html);
//				} else {
//					var addrHtml = '<li><a href="javascript:void(0);"><label data-id="' + addr.id + '">' + '<p class="c333"><span class="name">' + addr.contacts + '</span><span class="tel">' + addr.phone + '</span></p>' + '<p class="c999 address">' + addr.fullAddress + '</p>' + '</label></a></li>';
//					$('.address-list ul').append(addrHtml);
//					$('.order-address ul').append(addrHtml);
//				}
//
//				$('.order-address label').removeClass('active');
//				$('.order-address label[data-id="' + id + '"]').addClass('active');
//
//				var pageid = $('#addressEditPage .back').attr('data-slide');
//				$('.user-info ul a').html(
//						'<label data-id="' + id + '" class="location"> <span style="padding-left: 0px;" class="content"><span class="title">' + addr.contacts + '</span><br><span class="btn-link" style="padding-top: 6px;">' + addr.phone + '</span><br><span class="address" style="line-height:22px;">' + addr.fullAddress
//						+ '</span></span> <i class="icon arrow"></i></label>');
//				sliderBackPage($('#addressEditPage'), $('#' + pageid));
//			} else {
//				alert(data.message);
//			}
//		}
//	};
//	$(form).ajaxSubmit(options);

/**
 * 错误提示
 */
function errorPrompt(text) {
	alert(text);
}

/**
 * 编辑地址
 */
function editAddress(id) {
	var url = _webApp + '/user/location/getLocation';
	$.post(url, {
		id : id
	}, function(data) {
		if (data.result == "success") {
			$('#addressFrom').find('input[name="id"]').val(id);
			$('#addressFrom').find('input[name="contacts"]').val(data.contactName);
			$('#addressFrom').find('input[name="phone"]').val(data.contactPhone);
			$('#addressFrom').find('input[name="address"]').val(data.address);
			$('#addressFrom').find('input[name="area"]').val(data.area);
			$('#addressFrom').find('input[name="addressExtra"]').val(data.community);
			$('#addressFrom').find('input[name="province"]').val(data.province);
			$('#addressFrom').find('input[name="city"]').val(data.city);
			$('#addressFrom').find('select.pro').val(data.province);
			$('#addressFrom').find('select.cit').val(data.city);
			$('#addressFrom').find('select.dis').val(data.district).siblings('.content').text(data.district);
			$('#addressEditPage .delete').show();
			sliderNextPage($('#addressListPage'), $('#addressEditPage'));
		} else {
			alert(data.message);
		}
	}, 'json');
}

/**
 * 删除地址
 */
function delAddress() {
	var id = $('#addressFrom').find('input[name="id"]').val();
	var url = 'clientAddress/'+id+'/delete';
	$.get(url, function(data) {
		var addId = data.addressId;
		if (data.errcode == -1) {
			alert('系统出错！');
		} else if(data.errcode == 1){
			alert(data.msg);
		}else{
			$('.address-list label[data-id="' + id + '"]').parents('li').remove();
			$('.order-address label[data-id="' + id + '"]').parents('li').remove();
			$('.user-info ul a').html(
					'<label data-id="' + addId + '" class="location"> <span style="padding-left: 0px;" class="content"><span class="title">' + data.name + '</span><br><span class="btn-link" style="padding-top: 6px;">' + data.phone + '</span><br><span class="address" style="line-height:22px;">' + data.address
					+ '</span></span> <i class="icon arrow"></i></label>');
			$('.address-list label').removeClass('active');
			$('.address-list label[data-id="' + addId + '"]').addClass('active');
			$('.order-address label').removeClass('active');
			$('.order-address label[data-id="' + addId + '"]').addClass('active');
			sliderBackPage($('#addressEditPage'), $('#addressListPage'));
		}
	}, 'json');
}

/**
 * 设置活动地址
 */
function setActionAddress() {
	var id = $('.location').attr('data-id');
	$('.address-list label').removeClass('active');
	$('.address-list label[data-id="' + id + '"]').addClass('active');
	$('.order-address label').removeClass('active');
	$('.order-address label[data-id="' + id + '"]').addClass('active');
}

/**
 * 页面滑动控制
 */
function slidePage() {
	if (!$('.order-address li').length) {
		$('#addressEditPage .back').attr('data-slide', 'mainPage');
		$('#addressEditPage .delete').hide();
		sliderNextPage($('#mainPage'), $('#addressEditPage'));
	} else {
		$('#addressEditPage .back').attr('data-slide', 'addressListPage');
		sliderNextPage($('#mainPage'), $('#addressPage'));
	}
}

function slidePageToAddAddress() {
	$('#addressFrom').find('input').val('');
	sliderNextPage($('#addressListPage'), $('#addressEditPage'));
	$('#addressEditPage .delete').hide();
}

function slidePageToEditAddress(){
	sliderNextPage($('#addressListPage'), $('#addressEditPage'));
	$('#addressEditPage .delete').show();
}

/**
 * 检查活动口令
 */
function checkCouponActivityCode(id) {
	var code = "";
	var couponActivityDomId = "#couponActivityDom_" + id;
	$(couponActivityDomId).find('.voucher-statecos-ulb').find('li').each(function() {
		code += $(this).text();
	});
	if (code == "" || code.length < 4) {
		alert("亲,请输入4位优惠码哦");
		return;
	}
	$.ajax({
		type : "GET",
		url : "/user/coupon/checkCouponActivityCode",
		async : false,
		data : {
			id : id,
			code : code
		},
		dataType : "json",
		success : function(data) {
			if (data.code != 0) {
				$("#codeError" + id).show();
			} else {
				$("#codeError" + id).hide();

				var title = $(couponActivityDomId).find('.voucher-statecos-tit').text();
				var couponMoney = parseFloat($("#Amount" + id).text()).toFixed(2);
				var discountType = $(couponActivityDomId).attr('data-discountType');
				$('#couponActivity').find('.content').text(title);
				$('#couponActivity').attr('data-id', id);
				$('#couponActivity').attr('data-discountType', discountType);
				$('#couponActivity').attr('data-amount', couponMoney);
				clearCouponTip();
				setTotalPrice();
				sliderBackPage($(couponActivityDomId).parents('.slide-page'), $('#mainPage'));
				infoPrompt('选择“' + title + '”');
				if (id == '24' || id == '25') {
					$("#payTypeName").text("招行支付");
					$("#payTypeVal").attr('data-id', "61");
					$("#orderayPType").val("61");
				}
			}
		}
	});

}

function clearCouponActivityTip() {
	$('#couponActivity').attr('data-id', '');
	$('#couponActivity').attr('data-discountType', '');
	$('#couponActivity').attr('data-amount', '');
	$('#couponActivity').find('.content').text('选择参与优惠活动');
}

function clearCouponTip() {
	$('#coupon').attr('data-id', '');
	$('#coupon').attr('data-discountType', '');
	$('#coupon').attr('data-amount', '');
	$('#coupon').find('.content').text('选择使用优惠劵');
}