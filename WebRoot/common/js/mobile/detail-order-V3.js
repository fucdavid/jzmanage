$(function () {
	// 日历事件
    $("#canlender td.usable").click(function () {
        $("#canlender td").removeClass('active');
        $(this).addClass('active');
        serviceDate = $(this).attr('data-value');
        if(!$('section.prop_nv .prop_v').hasClass('active')){
        	$('.createOrder').text('选择服务面积');
        }
        if($('section.prop_nv .prop_v').hasClass('active')){
        	$('.createOrder').text('生成服务订单');
            $('.createOrder').removeClass('disabled');
        }
    });
	
	$('section.prop_nv .prop_v').click(function () {
		$("section.prop_nv .prop_v").removeClass('active');
        $(this).addClass('active');
        area = $(this).attr('data-value');
        if(!$('#canlender td.usable').hasClass('active')){
        	$('.createOrder').text('选择服务时间');
        }
        if($('#canlender td.usable').hasClass('active')){
        	$('.createOrder').text('生成服务订单');
            $('.createOrder').removeClass('disabled');
        }
    });
    // 生成服务订单按钮
    $('.createOrder').click(function () {
        if (!$(this).hasClass('disabled')) {
             submitServices();
        }
    });
});
/**
 * 获取服务日期
 */
function getServicesDate() {
    return serviceDate;
}

/**
 * 设置价格
 */
function setPrice(sku, quantity) {
    var tp;
    if (sku.number - quantity >= 0) {
        $('#sevicesForm input[name="skuid"]').val(sku.id);
        $('.createOrder').text('生成服务订单');
        $('.createOrder').removeClass('disabled');
    } else {
        $('.createOrder').text('预订已满');
        $('.createOrder').addClass('disabled');
    }
    // 特殊价格
    if (sku.specialPrice) {
        var otp = sku.price * quantity;
        tp = sku.specialPrice * quantity;
        var tips = sku.specialText;
        var priceHtml = '<p class="price-original">原价：<span>￥' + currencyFormatted(otp) + '</span></p>' + '<p class="price-activity">活动价格：<span class="price-text">￥<span class="price-num">' + currencyFormatted(tp) + '</span><em class="price-tips">' + tips + '</em></span></p>';
        $('.serve_price_wrap').html(priceHtml);
    } else {
        tp = sku.price * quantity;
        var priceHtml = '<p>总价：<span class="price-text">￥<span class="price-num">' + currencyFormatted(tp) + '</span></span></p>';
        $('.serve_price_wrap').html(priceHtml).removeClass('special_price');
    }
    // 优惠促销
    if (sku.hasPromotion) {
        var dateText = serviceDate.format('yyyy-MM-dd').replace(/-/g, '');
        var promotionHtml = '今日有限时特惠活动哦！<a style=" color:#0793d9; text-decoration:underline;" href="' + _webApp + '/services/sprom/' + servicesId + '_' + dateText + '">去看看</a>';
        $('.serve_promotion_info').html(promotionHtml).show();
    } else {
        $('.serve_promotion_info').hide();
    }
}

/**
 * 提交服务订单
 */
function submitServices() {
    $('#sevicesForm input[name="datetime"]').val(getServicesDate());
    $('#sevicesForm input[name="area"]').val(area);
    var $form = $('#sevicesForm');
    $form.submit();
}
