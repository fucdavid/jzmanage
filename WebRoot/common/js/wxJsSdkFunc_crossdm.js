initWxConfig();
/**
 * 通过跨域Ajax进行JS-SDK的配置
 * @author Rocye
 * @ateTime 2015-01-28
 * @return
 */
function initWxConfig(){
	var url = location.href.split('#')[0];
	$.ajax({
		url: "http://wedding.weiyihui.com.cn/weix3/wximpl-getWxConfigCrossDomain.wx",
		type: "get",			// 数据发送方式          
		dataType : "jsonp",		// 接受数据格式
		jsonp: 'jsoncallback',
		data : {"url":url},
		success : function(jsonData){
			if(jsonData.error == 1){
				//alert('发生错误,请联系管理员!');
			}else{
				wx.config({
		            debug: false,
		            appId: jsonData.appId,
		            timestamp: jsonData.timestamp,
		            nonceStr: jsonData.nonceStr,
		            signature: jsonData.signature,
		            jsApiList: [
		              'checkJsApi',
		              'hideMenuItems',
		              'hideAllNonBaseMenuItem',
		              'closeWindow'
		            ]
		        });
				wx.ready(function() {
					wx.hideAllNonBaseMenuItem();
				});
			}
		},
		error: function(e){
		}
	});
}



