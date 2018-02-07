$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editTicket",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveTicket();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
});

/**
 * 显示优惠券信息列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showTicketNowPageList(){
    if($('#pgTicket_nowPg').length > 0){
        showTicketPageList(parseInt($('#pgTicket_nowPg').text(),10));
    }else{
        showTicketPageList(1);
    }
}

/**
 * 优惠券信息分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function ticketPageselectCallback(page_index, jq){
    showTicketPageList(page_index+1);
}

/**
 * 优惠券信息分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showTicketPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["ticket.ticketName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "ticket/listAjax",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : paraObj,
        success : function(jsonData){
            HideLoading(loading);
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                var listHtml = [];
                $.each(jsonData.items, function(i,item){
                    listHtml.push('<tr>');
                    listHtml.push('<td>'+ (item.ticketId==undefined?'':item.ticketId) + '</td>');
                    listHtml.push('<td>'+ (item.type==undefined?'':item.type) + '</td>');
                    listHtml.push('<td>'+ (item.sum==undefined?'':item.sum) + '</td>');
                    listHtml.push('<td>'+ (item.clientd==undefined?'':item.clientd) + '</td>');
                    listHtml.push('<td>'+ (item.startTime==undefined?'':item.startTime) + '</td>');
                    listHtml.push('<td>'+ (item.endTime==undefined?'':item.endTime) + '</td>');
                    listHtml.push('<td>'+ (item.isUse==undefined?'':item.isUse) + '</td>');
                    listHtml.push('<td>'+ (item.deleteFlag==undefined?'':item.deleteFlag) + '</td>');
                    listHtml.push('<td>'+ (item.ticketCode==undefined?'':item.ticketCode) + '</td>');
                    listHtml.push('<td>'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showTicket('+ item.ticketId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteTicket('+ item.ticketId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbTicketList').html(listHtml.join(''));
                $('#pgTicket').empty();
                createTicketPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建优惠券信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createTicketPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgTicket").pagination(totalRows, {
            callback: ticketPageselectCallback,
            current_page:pageNum-1,
            num_edge_entries:1,
            num_display_entries:5,
            items_per_page:pageSize,
            show_if_single_page:true,
            show_ext:true
        });
    }
}

/**
 * 删除优惠券信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteTicket(objId){
    DilogConfirm('您确定要删除此优惠券信息吗？', function(){
        $.ajax({
            url: "ticket/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showTicketNowPageList();
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
 * 查看优惠券信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function showTicket(objId){
    clearnForm();
    $.ajax({
        url: "ticket/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tticketId').val(jsonData.ticketId);
                $('#ttype').val(jsonData.type);
                $('#tsum').val(jsonData.sum);
                $('#tclientd').val(jsonData.clientd);
                $('#tstartTime').val(jsonData.startTime);
                $('#tendTime').val(jsonData.endTime);
                $('#tisUse').val(jsonData.isUse);
                $('#tdeleteFlag').val(jsonData.deleteFlag);
                $('#tticketCode').val(jsonData.ticketCode);
                $('#tupdateTime').val(jsonData.updateTime);
                
                DialogCustomForm('编辑优惠券信息','divTicketForm','ticketFormDig');
                showTicketNowPageList();
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
    $('#tticketId').val('');
    $('#ttype').val('');
    $('#tsum').val('');
    $('#tclientd').val('');
    $('#tstartTime').val('');
    $('#tendTime').val('');
    $('#tisUse').val('');
    $('#tdeleteFlag').val('');
    $('#tticketCode').val('');
    $('#tupdateTime').val('');
}

/**
 * 保存编辑优惠券信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveTicket(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#tticketId').val()) != ''){
        paraObj["ticketId"] = $.trim($('#tticketId').val());
    }else{
        msgArr.push('优惠券ID不能为空!');
    }
    if($.trim($('#ttype').val()) != ''){
        paraObj["type"] = $.trim($('#ttype').val());
    }else{
        msgArr.push('优惠类型不能为空!');
    }
    if($.trim($('#tsum').val()) != ''){
        paraObj["sum"] = $.trim($('#tsum').val());
    }else{
        msgArr.push('金额不能为空!');
    }
    if($.trim($('#tclientd').val()) != ''){
        paraObj["clientd"] = $.trim($('#tclientd').val());
    }else{
        msgArr.push('用户ID不能为空!');
    }
    if($.trim($('#tstartTime').val()) != ''){
        paraObj["startTime"] = $.trim($('#tstartTime').val());
    }else{
        msgArr.push('有效开始时间不能为空!');
    }
    if($.trim($('#tendTime').val()) != ''){
        paraObj["endTime"] = $.trim($('#tendTime').val());
    }else{
        msgArr.push('有效结束时间不能为空!');
    }
    if($.trim($('#tisUse').val()) != ''){
        paraObj["isUse"] = $.trim($('#tisUse').val());
    }else{
        msgArr.push('是否使用(0未使用 1已使用)不能为空!');
    }
    if($.trim($('#tdeleteFlag').val()) != ''){
        paraObj["deleteFlag"] = $.trim($('#tdeleteFlag').val());
    }else{
        msgArr.push('删除标记(0未删除 1已删除)不能为空!');
    }
    if($.trim($('#tticketCode').val()) != ''){
        paraObj["ticketCode"] = $.trim($('#tticketCode').val());
    }else{
        msgArr.push('兑换码不能为空!');
    }
    if($.trim($('#tupdateTime').val()) != ''){
        paraObj["updateTime"] = $.trim($('#tupdateTime').val());
    }else{
        msgArr.push('更新时间不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "ticket/save",
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
                    DialogClose('ticketFormDig');
                    if($.trim($('#hdnTicketId').val()) != ''){
                        showTicketNowPageList();
                    }else{
                        showTicketPageList(1);
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
 * 清空数据并打开添加表单
 * @author caoxin
 * @createTime 2016-12-17
 */
function showAddTicketDig(){
    clearEditForm();
    DialogCustomForm('新增优惠券信息','divTicketForm','ticketFormDig');
}
