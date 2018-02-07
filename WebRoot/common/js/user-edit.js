$(document).ready(function(){
	
});

/**
 * 保存编辑用户记录
 * @author Rocye
 * @createTime 2015-10-15
 */
function saveUser(){
	var msgArr = [];
	var paraObj = {};
	if($.trim($('#hdnUserId').val()) != ''){
        paraObj["userId"] = $('#hdnUserId').val();
    }
    if($.trim($('#tloginName').val()) != ''){
        paraObj["loginName"] = $.trim($('#tloginName').val());
    }else{
    	msgArr.push('登录名不能为空!');
    }
    if($.trim($('#tpassword').val()) != ''){
        paraObj["password"] = $.trim($('#tpassword').val());
    }else{
        msgArr.push('密码不能为空!');
    }
    if($.trim($('#tuserName').val()) != ''){
        paraObj["userName"] = $.trim($('#tuserName').val());
    }else{
        msgArr.push('姓名不能为空!');
    }
    if($.trim($('#tbirthday').val()) != ''){
        paraObj["birthday"] = $.trim($('#tbirthday').val());
    }
    if($.trim($('#tuserPhone').val()) != ''){
        paraObj["userPhone"] = $.trim($('#tuserPhone').val());
    }
    if($.trim($('#tuserEmail').val()) != ''){
        paraObj["userEmail"] = $.trim($('#tuserEmail').val());
    }
    if($.trim($('#theadImg').attr('src')) != ''){
        paraObj["headImg"] = $.trim($('#theadImg').attr('src'));
    }
    
    if(msgArr.length > 0){
    	DilogWarning(msgArr.join('<br/>'));
    	return ;
    }
	$.ajax({
		url: "user/save",
		type: "post",			// 数据发送方式          
		dataType : "json",		// 接受数据格式
		data : paraObj,
		success : function(jsonData){
			if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
				DilogError('出错了!请联系管理员!');
			}else{
				if(jsonData.errcode == 0){
					self.location = $('base').attr('href') + 'user/list'
				}else{
					DilogError(jsonData.msg);
				}
			}
		},
		error: function(e){
		}
	});
}

/**
 * 上传图像
 * @author Rocye
 * @createtime 2015-03-04
 */
function uploadHeadImg(thiz, upType){
	var fileId = $(thiz).attr('id');
    var filepath = $('#'+fileId).val();
    var extname = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length);
    extname = extname.toLowerCase();// 处理了大小写
    if (extname != "jpg" && extname != "jpeg" && extname != "bmp" && extname != "png" && extname != "gif") {
        DilogError("请上传图片(jpg,jpeg,bmp,png,gif)");
        $(thiz).replaceWith('<input type="file" id="'+ fileId +'" name="fileHeadImg" onchange="uploadHeadImg(this,1)"/>');
        return;
    }
    
    //显示进度条
    var loading = ShowLoading();
    $.ajaxFileUpload({
        url:'user/upload',
        secureuri:false,
        fileElementId:'fileHeadImg',
        dataType: 'json',
        data: {'upType':upType},
        success: function (data , status){
            HideLoading(loading);       //上传完成隐藏进度条
            if(data.errcode == -2){
                top.location.reload(true);
            }else if(data.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                if(data.length > 0){
                	$('#theadImg').attr('src', data[0]);
                }else{
                	DilogError('没有找到要上传的文件!');
                }
            }
        },
        error: function (data, status, e){
            DilogError("上传文件失败"+e);
            HideLoading(loading);       //上传完成隐藏进度条
        }
    });
}

