$(document).ready(function(){
	if(!$.support.leadingWhitespace){      //如果是IE6-IE8
		$('#browerAlert').removeClass('hide');
	}
	$(document).keyup(function(e) {
        var key = (e.keyCode) || (e.which) || (e.charCode);	//兼容IE(e.keyCode)和Firefox(e.which)
        if (key == 13){
        	document.forms[0].submit();
        }
    });
	
	//看是否有cookie，有的话赋值
	var userName = $.cookie('userName');
	var password = $.cookie('password');
	if(userName != null){
		$("#chkRemember").prop('checked', true);
		$('#tLoginName').val(userName);
	}
	if(password != null){
		$("#chkRemember").prop('checked', true);
		$('#tPassword').val(password);
	}
});

//生成或取消cookie 
function generateCookie(){
	var chkRemember = $("#chkRemember").prop('checked');
	if(chkRemember){
		$.cookie("userName", $("#tLoginName").val(), {expires: 365});		//一年的期限
		$.cookie("password", $("#tPassword").val(), {expires: 365});
	}else{
		$.cookie("userName", '', {expires: -1});						    //删除Cookie
		$.cookie("userName", null);
		$.cookie("password", '', {expires: -1});
        $.cookie("password", null);
	}
	return true;
}
