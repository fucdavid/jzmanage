$(document).ready(function(){
    
});

/**
 * 显示客户信息列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showClientInfoNowPageList(){
    if($('#pgClientInfo_nowPg').length > 0){
        showClientInfoPageList(parseInt($('#pgClientInfo_nowPg').text(),10));
    }else{
        showClientInfoPageList(1);
    }
}

/**
 * 客户信息分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function clientInfoPageselectCallback(page_index, jq){
    showClientInfoPageList(page_index+1);
}

/**
 * 客户信息分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showClientInfoPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["clientInfo.telephone"] = $.trim($('#txtParam').val());
    }
//    var loading = ShowLoading();
    $.ajax({
        url: "clientInfo/listAjax",
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
                    listHtml.push('<td style="text-align:center;">'+ (i+1) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.telephone==undefined?'':item.telephone) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.openId==undefined?'':item.openId) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.money==undefined?'':item.money) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td style="text-align:center;"><a class="btn btn-default" href="javascript:;" onclick="showClientInfo('+item.clientId+');"><span class="glyphicon glyphicon-send"></span>&nbsp;编辑</a>');
                    listHtml.push('</td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbClientInfoList').html(listHtml.join(''));
                $('#pgClientInfo').empty();
                createClientInfoPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
//            HideLoading(loading); 
        }
    });
}

/**
 * 构建客户信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createClientInfoPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgClientInfo").pagination(totalRows, {
            callback: clientInfoPageselectCallback,
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
 * 删除客户信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteClientInfo(objId){
    DilogConfirm('您确定要删除此客户信息吗？', function(){
        $.ajax({
            url: "clientInfo/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showClientInfoNowPageList();
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
 * 查看客户信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function showClientInfo(objId){
	clearEditForm();
    $.ajax({
        url: "clientInfo/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tclientId').val(jsonData.clientId);
                $('#ttelephone').val(jsonData.telephone);
                $('#tmoney').val(jsonData.money);
                $('#topenId').val(jsonData.openId);
                
                $('#divInfonewsForm').modal('show');
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
    $('#tclientId').val('');
    $('#ttelephone').val('');
    $('#tmoney').val('');
    $('#topenId').val('');
}

/**
 * 保存编辑客户信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveClientInfo(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#tclientId').val()) != ''){
        paraObj["clientId"] = $.trim($('#tclientId').val());
    }
    if($.trim($('#ttelephone').val()) != ''){
        paraObj["telephone"] = $.trim($('#ttelephone').val());
    }else{
        msgArr.push('手机号不能为空!');
    }
    if($.trim($('#tmoney').val()) != ''){
        paraObj["money"] = $.trim($('#tmoney').val());
    }else{
        msgArr.push('余额不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "clientInfo/save",
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
                    if($.trim($('#hdnClientInfoId').val()) != ''){
                        showClientInfoNowPageList();
                    }else{
                        showClientInfoPageList(1);
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
function showAddClientInfoDig(){
    clearEditForm();
    DialogCustomForm('新增客户信息','divClientInfoForm','clientInfoFormDig');
}
