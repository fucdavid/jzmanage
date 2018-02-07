$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editOrder",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveOrder();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
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
    if($.trim($('#txtParam').val()) != ''){
        paraObj["order.orderName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "order/listAjax",
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
                    listHtml.push('<td>'+ (item.orderId==undefined?'':item.orderId) + '</td>');
                    listHtml.push('<td>'+ (item.orderCode==undefined?'':item.orderCode) + '</td>');
                    listHtml.push('<td>'+ (item.clentId==undefined?'':item.clentId) + '</td>');
                    listHtml.push('<td>'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td>'+ (item.comment==undefined?'':item.comment) + '</td>');
                    listHtml.push('<td>'+ (item.state==undefined?'':item.state) + '</td>');
                    listHtml.push('<td>'+ (item.money==undefined?'':item.money) + '</td>');
                    listHtml.push('<td>'+ (item.discount==undefined?'':item.discount) + '</td>');
                    listHtml.push('<td>'+ (item.account==undefined?'':item.account) + '</td>');
                    listHtml.push('<td>'+ (item.deleteFlag==undefined?'':item.deleteFlag) + '</td>');
                    listHtml.push('<td>'+ (item.service==undefined?'':item.service) + '</td>');
                    listHtml.push('<td>'+ (item.peopleNum==undefined?'':item.peopleNum) + '</td>');
                    listHtml.push('<td>'+ (item.area==undefined?'':item.area) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showOrder('+ item.orderId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteOrder('+ item.orderId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbOrderList').html(listHtml.join(''));
                $('#pgOrder').empty();
                createOrderPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建订单信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createOrderPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgOrder").pagination(totalRows, {
            callback: orderPageselectCallback,
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
