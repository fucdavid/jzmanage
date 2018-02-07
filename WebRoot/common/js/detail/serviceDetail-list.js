$(document).ready(function(){
    
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
        paraObj["serviceDetail.detailName"] = $.trim($('#txtParam').val());
    }
//    var loading = ShowLoading();
    $.ajax({
        url: "serviceDetail/listAjax",
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
                    listHtml.push('<input type="hidden" id="ids_'+item.detailId+'" value="'+item.detailId+'"/>');
                    listHtml.push('<td style="text-align:center;">'+ (i+1) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.detailName==undefined?'':item.detailName) + '</td>');
//                    listHtml.push('<td style="text-align:center;">'+ (item.money==undefined?'':item.money) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.describes==undefined?'':item.describes) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.serviceName==undefined?'':item.serviceName) + '</td>');
//                    listHtml.push('<td style="text-align:center;">'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.moneya==undefined?'':item.moneya) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.moneyb==undefined?'':item.moneyb) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.moneyc==undefined?'':item.moneyc) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.moneyd==undefined?'':item.moneyd) + '</td>');
                    listHtml.push('<td style="text-align:center;"><a class="btn btn-default" href="javascript:;" onclick="showServiceDetail('+item.detailId+');"><span class="glyphicon glyphicon-send"></span>&nbsp;编辑</a>');
                    listHtml.push('</td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbServiceDetailList').html(listHtml.join(''));
                $('#pgServiceDetail').empty();
                createServiceDetailPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
//            HideLoading(loading); 
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
	clearEditForm();
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
                $('#tmoney').val(jsonData.money);
                $('#tdescribe').val(jsonData.describes);
                $('#tservice').val(jsonData.serviceName);
                $('#tmoneya').val(jsonData.moneya);	
                $('#tmoneyb').val(jsonData.moneyb);
                $('#tmoneyc').val(jsonData.moneyc);
                $('#tmoneyd').val(jsonData.moneyd);
                
                $('#divInfonewsForm').modal('show');
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
//    $('#tmoney').val('');
    $('#tdescribe').val('');
    $('#tservice').val('');
    $('#tmoneya').val('');
    $('#tmoneyb').val('');
    $('#tmoneyc').val('');
    $('#tmoneyd').val('');
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
    }
    if($.trim($('#tdetailName').val()) != ''){
        paraObj["detailName"] = $.trim($('#tdetailName').val());
    }else{
        msgArr.push('项目名称不能为空!');
    }
//    if($.trim($('#tmoney').val()) != ''){
//        paraObj["money"] = $.trim($('#tmoney').val());
//    }else{
//        msgArr.push('价格不能为空!');
//    }
    if($.trim($('#tdescribe').val()) != ''){
        paraObj["describes"] = $.trim($('#tdescribe').val());
    }else{
        msgArr.push('描述不能为空!');
    }
    if($.trim($('#tmoneya').val()) != '' && $.trim($('#tmoneyb').val()) != '' && $.trim($('#tmoneyc').val()) != '' && $.trim($('#tmoneyd').val()) != ''){
        paraObj["moneya"] = $.trim($('#tmoneya').val());
        paraObj["moneyb"] = $.trim($('#tmoneyb').val());
        paraObj["moneyc"] = $.trim($('#tmoneyc').val());
        paraObj["moneyd"] = $.trim($('#tmoneyd').val());
    }else{
        msgArr.push('价格不能为空!');
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
                	$('#divInfonewsForm').modal('hide');
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
 * 添加项目信息
 * @author cx
 * @createTime 2017-01-12
 */
function addAnutInfo(){
	$('h4').html('添加项目信息');
	clearEditForm();
	$('#divInfonewsForm').modal('show');
}
