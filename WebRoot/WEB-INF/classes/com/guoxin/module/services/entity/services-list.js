$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editServices",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveServices();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
});

/**
 * 显示服务模块列表当前页
 * @author cx
 * @createtime 2017-01-12
 */
function showServicesNowPageList(){
    if($('#pgServices_nowPg').length > 0){
        showServicesPageList(parseInt($('#pgServices_nowPg').text(),10));
    }else{
        showServicesPageList(1);
    }
}

/**
 * 服务模块分页回调
 * @author cx
 * @createtime 2017-01-12
 */
function servicesPageselectCallback(page_index, jq){
    showServicesPageList(page_index+1);
}

/**
 * 服务模块分页
 * @author cx
 * @createtime 2017-01-12
 */
function showServicesPageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["services.servicesName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "services/listAjax",
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
                    listHtml.push('<td>'+ (item.serviceId==undefined?'':item.serviceId) + '</td>');
                    listHtml.push('<td>'+ (item.serviceName==undefined?'':item.serviceName) + '</td>');
                    listHtml.push('<td>'+ (item.describe==undefined?'':item.describe) + '</td>');
                    listHtml.push('<td>'+ (item.deleteFlag==undefined?'':item.deleteFlag) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showServices('+ item.servicesId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteServices('+ item.servicesId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbServicesList').html(listHtml.join(''));
                $('#pgServices').empty();
                createServicesPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建服务模块分页组件
 * @author cx
 * @createtime 2017-01-12
 */
function createServicesPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgServices").pagination(totalRows, {
            callback: servicesPageselectCallback,
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
 * 删除服务模块
 * @author cx
 * @createTime 2017-01-12
 */
function deleteServices(objId){
    DilogConfirm('您确定要删除此服务模块吗？', function(){
        $.ajax({
            url: "services/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showServicesNowPageList();
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
 * 查看服务模块
 * @author cx
 * @createTime 2017-01-12
 */
function showServices(objId){
    clearnForm();
    $.ajax({
        url: "services/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tserviceId').val(jsonData.serviceId);
                $('#tserviceName').val(jsonData.serviceName);
                $('#tdescribe').val(jsonData.describe);
                $('#tdeleteFlag').val(jsonData.deleteFlag);
                
                DialogCustomForm('编辑服务模块','divServicesForm','servicesFormDig');
                showServicesNowPageList();
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
    $('#tserviceId').val('');
    $('#tserviceName').val('');
    $('#tdescribe').val('');
    $('#tdeleteFlag').val('');
}

/**
 * 保存编辑服务模块
 * @author cx
 * @createTime 2017-01-12
 */
function saveServices(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#tserviceId').val()) != ''){
        paraObj["serviceId"] = $.trim($('#tserviceId').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tserviceName').val()) != ''){
        paraObj["serviceName"] = $.trim($('#tserviceName').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tdescribe').val()) != ''){
        paraObj["describe"] = $.trim($('#tdescribe').val());
    }else{
        msgArr.push('不能为空!');
    }
    if($.trim($('#tdeleteFlag').val()) != ''){
        paraObj["deleteFlag"] = $.trim($('#tdeleteFlag').val());
    }else{
        msgArr.push('不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "services/save",
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
                    DialogClose('servicesFormDig');
                    if($.trim($('#hdnServicesId').val()) != ''){
                        showServicesNowPageList();
                    }else{
                        showServicesPageList(1);
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
function showAddServicesDig(){
    clearEditForm();
    DialogCustomForm('新增服务模块','divServicesForm','servicesFormDig');
}
