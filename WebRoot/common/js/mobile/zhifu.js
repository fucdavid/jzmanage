/*
 	   * 注意：
	   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
	   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
	   * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
	   *
	   * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
	   * 邮箱地址：weixin-open@qq.com
	   * 邮件主题：【微信JS-SDK反馈】具体问题
	   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
	   */
	   	var url = window.location.href.split('#')[0];
		$(document).ready(function(){
			$.ajax({
				url: 'zhifu/signJsSDK',
				type: 'post',
				dataType: 'json',
				data: {"url":url},
				success: function(jsonData){
					if(jsonData.errCode == 1){
						alert('系统错误！');	
					}else{
						 wx.config({
						      appId: jsonData.appId,
						      timestamp: jsonData.timestamp,
						      nonceStr: jsonData.nonceStr,
						      signature: jsonData.signature,
						      jsApiList: [
								'chooseWXPay'
						      ]
						  });
					}
				},
				error: function(e){
					}
				});
				payOrder();  
			});
/**
 * JSAPI支付提交订单
 * @return
 */
function payOrder(){
	var openId = $('#openIdRcv').val();
	var goodsInfo = $('#goodsInfo').val();
	var goodsFee = parseInt(parseFloat($('#goodsFee').val())*100);
	$.ajax({
		url: 'zhifu/prePayOrder',
		type: 'post',
		dataType: 'json',
		data: {"openid":openId, "body":goodsInfo, "total_fee":goodsFee},
		success: function(jsonData){
			if(jsonData.errCode == 1){
				alert('系统错误！');
			}else{
				if(jsonData.msgId == 1){
					alert(jsonData.msg);
				}else{
					wx.ready(function(){
						wx.chooseWXPay({
							appId:jsonData.appid, 
							nonceStr: jsonData.nonceStr, // 支付签名随机串，不长于 32 位
							package: jsonData.packages, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
							signType:'MD5',// 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
							timestamp: jsonData.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
							paySign: jsonData.sign, // 支付签名
							success: function (res) {
								if(res.errMsg == "chooseWXPay:ok" ) {
									// 支付成功后的回调函数
									$.ajax({
										url: 'wximpl/updatestate',
										type: 'post',
										dataType: 'json',
										data: {"orderCode":$('#orderCode').val()},
										success: function(jsonData){
											if(jsonData.errcode == -1){
												alert('系统错误！');	
											}else if(jsonData.errcode == 0){
												$('#res').html('支付成功');
												$('#toho').show(); 
											}
										},
										error: function(e){
											}
										});
							    }else{
							        alert(res.errMsg);
							        $('#res').html('该次操作出错，请继续支付');
							        $('#toho').show();
							        $('#cont').show();
							    }
							},
							cancel:function(res){
							    //支付取消
								$('#res').html('支付取消');
								$('#toho').show();
						        $('#cont').show();
							}
						});
					});
				}
			}
		},
		error: function(e){
		}
	});
}

function tohome() {
	window.location.href = "http://www.meijiajiazheng.com/jzmanage/wximpl/gohome?openId="+$('#openIdRcv').val();
}