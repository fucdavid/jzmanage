//封装弹出框
function DilogSucceed(msg){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'succeed',content:msg, cancelVal:'关闭',cancel: true});
}
function DilogSucceed(msg, fun){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'succeed',content:msg, cancelVal:'关闭',cancel: true, close:fun});
}
function DilogError(msg){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'error',content:msg, cancelVal:'关闭',cancel: true});
}
function DilogValid(msg){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'face-sad',content:msg, cancelVal:'关闭',cancel: true});
}
function DilogWarning(msg){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'warning',content:msg, cancelVal:'关闭',cancel: true});
}
function DilogWarning(msg, fun){
	$.dialog({width:200,height: 60,resize:false,stack:true,lock: true,opacity: 0.2,icon:'warning',content:msg, cancelVal:'关闭',cancel: true, close:fun});
}
function DilogConfirm(msg, fun){
	$.dialog({
		width:200,height: 60,
		resize:false,lock: true,opacity: 0.2,
		icon:'question',
	    content: msg,
	    ok: fun,
	    cancelVal: '取消',
	    cancel: true //为true等价于function(){}
	});
}

//带取消息回调
function DilogConfirm2(msg, fun, cfun){
	$.dialog({
		width:200,height: 60,
		resize:false,lock: true,opacity: 0.2,
		icon:'question',
	    content: msg,
	    ok: fun,
	    cancelVal: '取消',
	    cancel: cfun
	});
}

//带时间自动消失
function DilogTime(msg, tim){
	$.dialog({width:200,height: 60,resize:false,lock: true,opacity: 0.2, icon:'succeed', time:tim, content:msg, cancelVal:'关闭',cancel: true});
}

/**
 * 封装基础弹出层
 * @author Rocye
 * @param _title 标题
 * @param _divId 页面要弹出的DIV或其它的ID
 * @param _digId 给你的弹出框定义唯一标识，防止重复弹出
 * @param _closeFun 关闭事件，可选
 * @createtime 2014-01-09
 */
function DialogCustomForm(_title,_divId,_digId,_closeFun){
	$.dialog({resize:false,lock: true,title:_title,padding:'5px 15px',
        background: '#000000', // 背景色
        opacity: 0.2,   // 透明度
        content: document.getElementById(_divId),
        id: _digId,
        padding: 0,
        //zIndex: 900,
        close: _closeFun
    });
}
function DialogCustomForm(_title,_divId,_digId){
	$.dialog({resize:false,lock: true,title:_title,padding:'5px 15px',
        background: '#000000', // 背景色
        opacity: 0.2,   // 透明度
        content: document.getElementById(_divId),
        padding: 0,
        //zIndex: 900,
        id: _digId
    });
}

//关闭定弹框ID的窗体
function DialogClose(digId){
	$.dialog.list[digId].close();
}

/**
 * 封装loading框
 * @author Rocye
 * @createtime 2013-12-24
 */
function ShowLoading(){
	//开始上传打开进度条
    $('.ibody').height($('body').height());	//设置遮罩区域高度
	//显示进度条
	var loading = new ol.loading({id:"ibody"});
	loading.show();
    $('.ol_loading').css('top', ($(window).height()/2 + $(document).scrollTop()) + 'px');
    return loading
}

/**
 * 封装loading框
 * @author Rocye
 * @createtime 2013-12-24
 */
function HideLoading(loading){
	loading.hide();		//上传完成关闭进度条
	$('.ibody').height(0);
//	$('.ibody').parent().hide();
}

/**
 *  将数字格式化成金额
 */
function fmoney(s, n){
   n = n > 0 && n <= 20 ? n : 2;
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
   var l = s.split(".")[0].split("").reverse(),
   r = s.split(".")[1];
   t = "";
   for(i = 0; i < l.length; i ++ ){
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
   }
   return t.split("").reverse().join("") + "." + r;
}


//通过ID对其进行loading处理
function loadingBtnById(_id){
	var tagName = $(_id).prop('tagName');
	var clazz = $(_id).attr('class');
	var btnText = '';
	if($.trim($(_id).text()) != ''){
		btnText = 'loading';
	}
	var lodingBtn = $('<'+ tagName +' class="'+ clazz +'">'+ btnText +'</'+ tagName +'>');
	$(_id).after(lodingBtn);
	$(_id).hide();
	return lodingBtn;
}

//设置所有Ajax全局的头部参数
$.ajaxSetup({headers:{"gxAjax":"true"}});

$(function(){
	$('ul.cotrs>li').eq($('#menuId').val()).addClass("act");
	$('.detail_intro .detail_item_title').click(function() {
		var tr = $(this).parent().find('.arrow').attr('class');
		if(tr.indexOf('active') > -1){
			$(this).parent().find('.arrow').attr('class','icon arrow');
			$(this).parent().find('.detail_item_content').hide();
		}else{
			$(this).parent().find('.arrow').attr('class','icon arrow active');
			$(this).parent().find('.detail_item_content').show();
		}
	});
	})
