initWxConfig();
/**
 * 通过跨域Ajax进行JS-SDK的配置
 * @author Rocye
 * @ateTime 2015-01-28
 * @return
 */
function initWxConfig(){
	var url = location.href.split('#')[0];
	console.log(url);
	$.ajax({
		url: "zhifu/signJsSDK",
		type: "post",			// 数据发送方式          
		dataType : "json",		// 接受数据格式
		data : {"url":url},
		success : function(jsonData){
			if(jsonData.error == 1){
				alert('发生错误,请联系管理员!');
			}else{
				wx.config({
		            debug: false,
		            appId: jsonData.appId,
		            timestamp: jsonData.timestamp,
		            nonceStr: jsonData.nonceStr,
		            signature: jsonData.signature,
		            jsApiList: [
		              'checkJsApi',
		              'onMenuShareTimeline',
		              'onMenuShareAppMessage',
		              'onMenuShareQQ',
		              'onMenuShareWeibo'
		            ]
		        });
				wx.ready(function() {
					wx.onMenuShareAppMessage(shareData);
					wx.onMenuShareTimeline(shareData);
					wx.onMenuShareQQ(shareData);
					wx.onMenuShareWeibo(shareData);
				});
			}
		},
		error: function(e){
		}
	});
}



