$(document).ready(function(){
});

/**
 * 显示订单信息列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showOrderNowPageList(){
    if($('#pgOrder_nowPg').length > 0){
        showOrderPageList(parseInt($('#pgOrder_nowPg').text(),10));
    }else{
        showOrderPageList(1);
    }
}

/**
 * 订单信息分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function orderPageselectCallback(page_index, jq){
    showOrderPageList(page_index+1);
}

/**
 * 订单信息分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showOrderPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#paraOrderCode').val()) != ''){
        paraObj["order.orderCode"] = $.trim($('#paraOrderCode').val());
    }
//    var loading = ShowLoading();
    $.ajax({
        url: "order/listAjax",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : paraObj,
        success : function(jsonData){
    		$('#paraOrderCode').val('');
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
                    listHtml.push('<td style="text-align:center;">'+ (item.orderCode==undefined?'':item.orderCode) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.telephone==undefined?'':item.telephone) + '</td>');
                    if(item.state == 0){
                    	listHtml.push('<td style="text-align:center;">未付款</td>');
                    }else if(item.state == 1){
                    	listHtml.push('<td style="text-align:center;">已付款</td>');
                    }else if(item.state == 2){
                    	listHtml.push('<td style="text-align:center;">已派单</td>');
                    }else if(item.state == 3){
                    	listHtml.push('<td style="text-align:center;">已完成</td>');
                    }else if(item.state == 4){
                    	listHtml.push('<td style="text-align:center;">已取消</td>');
                    }else if(item.state == 5){
                    	listHtml.push('<td style="text-align:center;">申请退款</td>');
                    }else if(item.state == 6){
                    	listHtml.push('<td style="text-align:center;">已退款</td>');
                    }
                    listHtml.push('<td style="text-align:center;">'+ (item.detailName==undefined?'':item.detailName) + '</td>');
                    if(item.area == 1){
                    	listHtml.push('<td style="text-align:center;">0-89</td>');
                    }else if(item.area == 2){
                    	listHtml.push('<td style="text-align:center;">90-159</td>');
                    }else if(item.area == 3){
                    	listHtml.push('<td style="text-align:center;">160-249</td>');
                    }else if(item.area == 4){
                    	listHtml.push('<td style="text-align:center;">250-300</td>');
                    }else{
                    	listHtml.push('<td style="text-align:center;">-</td>');
                    }
//                    listHtml.push('<td style="text-align:center;">'+ (item.discount==undefined?'':item.discount) + '</td>');
//                    listHtml.push('<td style="text-align:center;">'+ (item.account==undefined?'':item.account) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.paymoney==undefined?'':item.paymoney) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+(item.time==undefined?'':item.time)+'</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td style="text-align:center;">'+ (item.address) + '</td>');
                    listHtml.push('<td style="text-align:center;">');
                    if(item.state == 1){
                    	listHtml.push('<a class="btn btn-default" href="javascript:;" onclick="updateState('+item.orderId+','+item.state+');"><span class="glyphicon glyphicon-send"></span>确认派单</a>');
                    }else if(item.state == 2){
                    	listHtml.push('<a class="btn btn-default" href="javascript:;" onclick="updateState('+item.orderId+','+item.state+');"><span class="glyphicon glyphicon-send"></span>确认完成</a>');
                    }else if(item.state == 5){
                    	listHtml.push('<a class="btn btn-default" href="javascript:;" onclick="updateState('+item.orderId+','+item.state+');"><span class="glyphicon glyphicon-send"></span>确认退款</a>');
                    }else{
                    	listHtml.push('-');
                    }
                    listHtml.push('</td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbOrderList').html(listHtml.join(''));
                $('#pgOrder').empty();
                createOrderPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
//            HideLoading(loading); 
        }
    });
}

/**
 * 构建订单信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createOrderPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalRows > 0){
        $("#pgOrder").pagination(totalRows, {
            callback: orderPageselectCallback,
            current_page:pageNum-1,
            num_edge_entries:1,
            num_display_entries:5,
            items_per_page:pageSize,
            show_if_single_page:true,
            show_ext:true
        });
    }else{
		$("#pgOrder").html('<div style="text-align:center;width:100%;">没有找到匹配的记录</div>');
	}
}

/**
 * 删除订单信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteOrder(objId){
    DilogConfirm('您确定要删除此订单信息吗？', function(){
        $.ajax({
            url: "order/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showOrderNowPageList();
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
 * 查看订单信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function showOrder(objId){
    clearnForm();
    $.ajax({
        url: "order/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#torderId').val(jsonData.orderId);
                $('#torderCode').val(jsonData.orderCode);
                $('#tclentId').val(jsonData.clentId);
                $('#tupdateTime').val(jsonData.updateTime);
                $('#tcomment').val(jsonData.comment);
                $('#tstate').val(jsonData.state);
                $('#tmoney').val(jsonData.money);
                $('#tdiscount').val(jsonData.discount);
                $('#taccount').val(jsonData.account);
                $('#tdeleteFlag').val(jsonData.deleteFlag);
                $('#tservice').val(jsonData.service);
                $('#tpeopleNum').val(jsonData.peopleNum);
                $('#tarea').val(jsonData.area);
                
                DialogCustomForm('编辑订单信息','divOrderForm','orderFormDig');
                showOrderNowPageList();
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
    $('#torderId').val('');
    $('#torderCode').val('');
    $('#tclentId').val('');
    $('#tupdateTime').val('');
    $('#tcomment').val('');
    $('#tstate').val('');
    $('#tmoney').val('');
    $('#tdiscount').val('');
    $('#taccount').val('');
    $('#tdeleteFlag').val('');
    $('#tservice').val('');
    $('#tpeopleNum').val('');
    $('#tarea').val('');
}

/**
 * 保存编辑订单信息
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveOrder(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#torderId').val()) != ''){
        paraObj["orderId"] = $.trim($('#torderId').val());
    }else{
        msgArr.push('订单Id不能为空!');
    }
    if($.trim($('#torderCode').val()) != ''){
        paraObj["orderCode"] = $.trim($('#torderCode').val());
    }else{
        msgArr.push('订单号不能为空!');
    }
    if($.trim($('#tclentId').val()) != ''){
        paraObj["clentId"] = $.trim($('#tclentId').val());
    }else{
        msgArr.push('客户id不能为空!');
    }
    if($.trim($('#tupdateTime').val()) != ''){
        paraObj["updateTime"] = $.trim($('#tupdateTime').val());
    }else{
        msgArr.push('更新时间不能为空!');
    }
    if($.trim($('#tcomment').val()) != ''){
        paraObj["comment"] = $.trim($('#tcomment').val());
    }else{
        msgArr.push('订单评论不能为空!');
    }
    if($.trim($('#tstate').val()) != ''){
        paraObj["state"] = $.trim($('#tstate').val());
    }else{
        msgArr.push('订单状态(0未付款，1已付款，2已派单，3已完成，4已取消)不能为空!');
    }
    if($.trim($('#tmoney').val()) != ''){
        paraObj["money"] = $.trim($('#tmoney').val());
    }else{
        msgArr.push('订单金额不能为空!');
    }
    if($.trim($('#tdiscount').val()) != ''){
        paraObj["discount"] = $.trim($('#tdiscount').val());
    }else{
        msgArr.push('优惠抵用不能为空!');
    }
    if($.trim($('#taccount').val()) != ''){
        paraObj["account"] = $.trim($('#taccount').val());
    }else{
        msgArr.push('账户抵扣不能为空!');
    }
    if($.trim($('#tdeleteFlag').val()) != ''){
        paraObj["deleteFlag"] = $.trim($('#tdeleteFlag').val());
    }else{
        msgArr.push('删除标记(0未删除 1已删除)不能为空!');
    }
    if($.trim($('#tservice').val()) != ''){
        paraObj["service"] = $.trim($('#tservice').val());
    }else{
        msgArr.push('服务项目不能为空!');
    }
    if($.trim($('#tpeopleNum').val()) != ''){
        paraObj["peopleNum"] = $.trim($('#tpeopleNum').val());
    }else{
        msgArr.push('需要服务人数不能为空!');
    }
    if($.trim($('#tarea').val()) != ''){
        paraObj["area"] = $.trim($('#tarea').val());
    }else{
        msgArr.push('需要服务面积不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "order/save",
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
                    DialogClose('orderFormDig');
                    if($.trim($('#hdnOrderId').val()) != ''){
                        showOrderNowPageList();
                    }else{
                        showOrderPageList(1);
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
function showAddOrderDig(){
    clearEditForm();
    DialogCustomForm('新增订单信息','divOrderForm','orderFormDig');
}

function updateState(orderId,state){
	var upstate ;
	if(state == 1){
		upstate = 2;
	}
	if(state == 2){
		upstate = 3;
	}
	if(state == 5){
		upstate = 6
	}
	$.ajax({
        url: "order/save",
        type: "post",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        data : {"state":upstate,"orderId":orderId},
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                if(jsonData.errcode == 0){
                	showOrderNowPageList();
                }else{
                    DilogError(jsonData.msg);
                }
            }
        },
        error: function(e){
        }
    });
}