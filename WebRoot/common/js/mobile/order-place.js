function submit(){
		var paraObj = {};
	    paraObj["clientId"] = $.trim($('#clientId').val());
	    paraObj["serviceId"] = $.trim($('#serviceId').val());
	    paraObj["peopleNum"] = $.trim($('#peopleNum').val());
	    if($.trim($('#time').val()) == ''){
		    alert("请选择时间！");
		    return;
	    }else{
	    	paraObj["time"] = $.trim($('#time').val());
		    }
		$.ajax({
			url: "order/save",
	        type: "post",           // 数据发送方式          
	        dataType : "json",      // 接受数据格式
	        data : paraObj,
	        success : function(jsonData){
				if(jsonData.errcode == 0){
					alert("订单已提交");
					window.location = "order/ydorder?clientId=" + $.trim($('#clientId').val());
					}
				if(jsonData.errcode == 1){
					alert("订单提交失败");
					}
			},
			});
		}