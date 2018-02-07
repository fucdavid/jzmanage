$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editServiceDetail",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveServiceDetail();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
});

/**
 * 显示服务详细信息列表当前页
 * @author cx
 * @createtime 2017-01-12
 */
function showServiceDetailNowPageList(){
    if($('#pgServiceDetail_nowPg').length > 0){
        showServiceDetailPageList(parseInt($('#pgServiceDetail_nowPg').text(),10));
    }else{
        showServiceDetailPageList(1);
    }
}

/**
 * 服务详细信息分页回调
 * @author cx
 * @createtime 2017-01-12
 */
function serviceDetailPageselectCallback(page_index, jq){
    showServiceDetailPageList(page_index+1);
}

/**
 * 服务详细信息分页
 * @author cx
 * @createtime 2017-01-12
 */
function showServiceDetailPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["serviceDetail.serviceDetailName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "serviceDetail/listAjax",
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
                    listHtml.push('<td>'+ (item.detailId==undefined?'':item.detailId) + '</td>');
                    listHtml.push('<td>'+ (item.detailName==undefined?'':item.detailName) + '</td>');
                    listHtml.push('<td>'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td>'+ (item.money==undefined?'':item.money) + '</td>');
                    listHtml.push('<td>'+ (item.describe==undefined?'':item.describe) + '</td>');
                    listHtml.push('<td>'+ (item.serviceId==undefined?'':item.serviceId) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showServiceDetail('+ item.serviceDetailId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteServiceDetail('+ item.serviceDetailId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbServiceDetailList').html(listHtml.join(''));
                $('#pgServiceDetail').empty();
                createServiceDetailPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建服务详细信息分页组件
 * @author cx
 * @createtime 2017-01-12
 */
function createServiceDetailPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgServiceDetail").pagination(totalRows, {
            callback: serviceDetailPageselectCallback,
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
 * 删除服务详细信息
 * @author cx
 * @createTime 2017-01-12
 */
function deleteServiceDetail(objId){
    DilogConfirm('您确定要删除此服务详细信息吗？', function(){
        $.ajax({
            url: "serviceDetail/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showServiceDetailNowPageList();
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
 * 查看服务详细信息
 * @author cx
 * @createTime 2017-01-12
 */
function showServiceDetail(objId){
    clearnForm();
    $.ajax({
        url: "serviceDetail/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tdetailId').val(jsonData.detailId);
                $('#tdetailName').val(jsonData.detailName);
                $('#tupdateTime').val(jsonData.updateTime);
                $('#tmoney').val(jsonData.money);
                $('#tdescribe').val(jsonData.describe);
                $('#tserviceId').val(jsonData.serviceId);
                
                DialogCustomForm('编辑服务详细信息','divServiceDetailForm','serviceDetailFormDig');
                showServiceDetailNowPageList();
            }
        },
        error: function(e){
        }
    });
}

/**
 * 清空编辑表单
 * @author cx
 * @createTime 2017-01-12
 */
function clearEditForm(){
    $('#tdetailId').val('');
    $('#tdetailName').val('');
    $('#tupdateTime').val('');
    $('#tmoney').val('');
    $('#tdescribe').val('');
    $('#tserviceId').val('');
}

/**
 * 保存编辑服务详细信息
 * @author cx
 * @createTime 2017-01-12
 */
function saveServiceDetail(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#tdetailId').val()) != ''){
        paraObj["detailId"] = $.trim($('#tdetailId').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tdetailName').val()) != ''){
        paraObj["detailName"] = $.trim($('#tdetailName').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tupdateTime').val()) != ''){
        paraObj["updateTime"] = $.trim($('#tupdateTime').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tmoney').val()) != ''){
        paraObj["money"] = $.trim($('#tmoney').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tdescribe').val()) != ''){
        paraObj["describe"] = $.trim($('#tdescribe').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tserviceId').val()) != ''){
        paraObj["serviceId"] = $.trim($('#tserviceId').val());
    }else{
        msgArr.push('不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "serviceDetail/save",
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
                    DialogClose('serviceDetailFormDig');
                    if($.trim($('#hdnServiceDetailId').val()) != ''){
                        showServiceDetailNowPageList();
                    }else{
                        showServiceDetailPageList(1);
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
 * @author cx
 * @createTime 2017-01-12
 */
function showAddServiceDetailDig(){
    clearEditForm();
    DialogCustomForm('新增服务详细信息','divServiceDetailForm','serviceDetailFormDig');
}
