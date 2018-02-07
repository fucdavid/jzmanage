$(document).ready(function(){
    
});

/**
 * 显示阿姨信息列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showAnutInfoNowPageList(){
    if($('#pgAnutInfo_nowPg').length > 0){
        showAnutInfoPageList(parseInt($('#pgAnutInfo_nowPg').text(),10));
    }else{
        showAnutInfoPageList(1);
    }
}

/**
 * 阿姨信息分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function anutInfoPageselectCallback(page_index, jq){
    showAnutInfoPageList(page_index+1);
}

/**
 * 阿姨信息分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showAnutInfoPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#paraPhone').val()) != ''){
        paraObj["anutInfo.phone"] = $.trim($('#paraPhone').val());
    }
//    var loading = ShowLoading();
    $.ajax({
        url: "anutInfo/listAjax",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : paraObj,
        success : function(jsonData){
//            HideLoading(loading);
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                var listHtml = [];
                $.each(jsonData.items, function(i,item){
                    listHtml.push('<tr>');
                    listHtml.push('<input type="hidden" id="ids_'+item.anutId+'" value="'+item.anutId+'"/>');
                    listHtml.push('<td style="text-align:center;">'+ (i+1) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.anutName==undefined?'':item.anutName) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.phone==undefined?'':item.phone) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.address==undefined?'':item.address) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    if(item.state == 0){
                    	listHtml.push('<td style="text-align:center;">空闲</td>');
                    }else if(item.state == 1){
                    	listHtml.push('<td style="text-align:center;">繁忙</td>');
                    }
                    listHtml.push('<td style="text-align:center;"><a class="btn btn-default" href="javascript:;" onclick="showAnutInfo('+item.anutId+');"><span class="glyphicon glyphicon-send"></span>&nbsp;编辑</a>');
                    listHtml.push('<a class="btn btn-default" href="javascript:;" onclick="deleteAnutInfo('+item.anutId+');"><span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbAnutList').html(listHtml.join(''));
                $('#pgAnutInfo').empty();
                createAnutInfoPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
//            HideLoading(loading); 
        }
    });
}

/**
 * 构建阿姨信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createAnutInfoPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 0){
        $("#pgAnutInfo").pagination(totalRows, {
            callback: anutInfoPageselectCallback,
            current_page:pageNum-1,
            num_edge_entries:1,
            num_display_entries:5,
            items_per_page:pageSize,
            show_if_single_page:true,
            show_ext:true
        });
    }else{
    	$("#pgAnutInfo").html('<div style="text-align:center;width:100%;">没有找到匹配的记录</div>');
    }
}

/**
 * 删除阿姨信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteAnutInfo(objId){
    DilogConfirm('您确定要删除此阿姨信息吗？', function(){
        $.ajax({
            url: "anutInfo/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showAnutInfoNowPageList();
                    }else{
                        DilogError(jsonData.msg);
                    }
                }
            },
            error: function(e){
            }
        });
    });
}

/**
 * 查看阿姨信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function showAnutInfo(objId){
	clearEditForm();
    $.ajax({
        url: "anutInfo/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tanutId').val(jsonData.anutId);
                $('#tanutName').val(jsonData.anutName);
                $('#tphone').val(jsonData.phone);
                $('#taddress').val(jsonData.address);
//                $('#theadImg').val(jsonData.headImg);
//                $('#tstate').val(jsonData.state);
                
                $('#divInfonewsForm').modal('show');
//                showAnutInfoNowPageList();
            }
        },
        error: function(e){
        }
    });
}

/**
 * 清空编辑表单
 * @author caoxin
 * @createTime 2016-12-17
 */
function clearEditForm(){
    $('#tanutId').val('');
    $('#tanutName').val('');
    $('#tphone').val('');
    $('#taddress').val('');
//    $('#theadImg').val('');
    $('#tstate').val('');
}

/**
 * 保存编辑阿姨信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveAnutInfo(){
    var msgArr = [];
    var paraObj = {};
    paraObj["anutId"] = $.trim($('#tanutId').val());
//    if($.trim($('#tanutId').val()) != ''){
//        paraObj["anutId"] = $.trim($('#tanutId').val());
//    }else{
//        msgArr.push('阿姨id不能为空!');
//    }
    if($.trim($('#tanutName').val()) != ''){
        paraObj["anutName"] = $.trim($('#tanutName').val());
    }else{
        msgArr.push('阿姨姓名不能为空!');
    }
    if($.trim($('#tphone').val()) != ''){
        paraObj["phone"] = $.trim($('#tphone').val());
    }else{
        msgArr.push('阿姨手机号不能为空!');
    }
    if($.trim($('#taddress').val()) != ''){
        paraObj["address"] = $.trim($('#taddress').val());
    }else{
        msgArr.push('阿姨住址不能为空!');
    }
//    if($.trim($('#theadImg').val()) != ''){
//        paraObj["headImg"] = $.trim($('#theadImg').val());
//    }else{
//        msgArr.push('阿姨头像不能为空!');
//    }
//    if($.trim($('#tstate').val()) != ''){
//        paraObj["state"] = $.trim($('#tstate').val());
//    }else{
//        msgArr.push('状态(0空闲1繁忙)不能为空!');
//    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "anutInfo/save",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : paraObj,
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                if(jsonData.errcode == 0){
                	$('#divInfonewsForm').modal('hide');
                    if($.trim($('#tanutId').val()) != ''){
                        showAnutInfoNowPageList();
                    }else{
                        showAnutInfoPageList(1);
                    }
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
 * 添加阿姨信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function addAnutInfo(){
	$('h4').html('添加阿姨信息');
	clearEditForm();
	$('#divInfonewsForm').modal('show');
}