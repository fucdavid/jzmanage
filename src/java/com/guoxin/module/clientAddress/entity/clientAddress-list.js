$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editClientAddress",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveClientAddress();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
});

/**
 * 显示用户地址列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showClientAddressNowPageList(){
    if($('#pgClientAddress_nowPg').length > 0){
        showClientAddressPageList(parseInt($('#pgClientAddress_nowPg').text(),10));
    }else{
        showClientAddressPageList(1);
    }
}

/**
 * 用户地址分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function clientAddressPageselectCallback(page_index, jq){
    showClientAddressPageList(page_index+1);
}

/**
 * 用户地址分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showClientAddressPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["clientAddress.clientAddressName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "clientAddress/listAjax",
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
                    listHtml.push('<td>'+ (item.addressId==undefined?'':item.addressId) + '</td>');
                    listHtml.push('<td>'+ (item.clientId==undefined?'':item.clientId) + '</td>');
                    listHtml.push('<td>'+ (item.name==undefined?'':item.name) + '</td>');
                    listHtml.push('<td>'+ (item.phone==undefined?'':item.phone) + '</td>');
                    listHtml.push('<td>'+ (item.address==undefined?'':item.address) + '</td>');
                    listHtml.push('<td>'+ (item.deleteFlag==undefined?'':item.deleteFlag) + '</td>');
                    listHtml.push('<td>'+ (item.updateTime==undefined?'':item.updateTime) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showClientAddress('+ item.clientAddressId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteClientAddress('+ item.clientAddressId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbClientAddressList').html(listHtml.join(''));
                $('#pgClientAddress').empty();
                createClientAddressPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建用户地址分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createClientAddressPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgClientAddress").pagination(totalRows, {
            callback: clientAddressPageselectCallback,
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
 * 删除用户地址
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteClientAddress(objId){
    DilogConfirm('您确定要删除此用户地址吗？', function(){
        $.ajax({
            url: "clientAddress/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showClientAddressNowPageList();
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
 * 查看用户地址
 * @author caoxin
 * @createTime 2016-12-17
 */
function showClientAddress(objId){
    clearnForm();
    $.ajax({
        url: "clientAddress/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#taddressId').val(jsonData.addressId);
                $('#tclientId').val(jsonData.clientId);
                $('#tname').val(jsonData.name);
                $('#tphone').val(jsonData.phone);
                $('#taddress').val(jsonData.address);
                $('#tdeleteFlag').val(jsonData.deleteFlag);
                $('#tupdateTime').val(jsonData.updateTime);
                
                DialogCustomForm('编辑用户地址','divClientAddressForm','clientAddressFormDig');
                showClientAddressNowPageList();
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
    $('#taddressId').val('');
    $('#tclientId').val('');
    $('#tname').val('');
    $('#tphone').val('');
    $('#taddress').val('');
    $('#tdeleteFlag').val('');
    $('#tupdateTime').val('');
}

/**
 * 保存编辑用户地址
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveClientAddress(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#taddressId').val()) != ''){
        paraObj["addressId"] = $.trim($('#taddressId').val());
    }else{
        msgArr.push('地址ID不能为空!');
    }
    if($.trim($('#tclientId').val()) != ''){
        paraObj["clientId"] = $.trim($('#tclientId').val());
    }else{
        msgArr.push('用户ID不能为空!');
    }
    if($.trim($('#tname').val()) != ''){
        paraObj["name"] = $.trim($('#tname').val());
    }else{
        msgArr.push('用户姓名不能为空!');
    }
    if($.trim($('#tphone').val()) != ''){
        paraObj["phone"] = $.trim($('#tphone').val());
    }else{
        msgArr.push('用户电话不能为空!');
    }
    if($.trim($('#taddress').val()) != ''){
        paraObj["address"] = $.trim($('#taddress').val());
    }else{
        msgArr.push('用户地址不能为空!');
    }
    if($.trim($('#tdeleteFlag').val()) != ''){
        paraObj["deleteFlag"] = $.trim($('#tdeleteFlag').val());
    }else{
        msgArr.push('删除标记(0未删除 1已删除)不能为空!');
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
        url: "clientAddress/save",
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
                    DialogClose('clientAddressFormDig');
                    if($.trim($('#hdnClientAddressId').val()) != ''){
                        showClientAddressNowPageList();
                    }else{
                        showClientAddressPageList(1);
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
function showAddClientAddressDig(){
    clearEditForm();
    DialogCustomForm('新增用户地址','divClientAddressForm','clientAddressFormDig');
}
