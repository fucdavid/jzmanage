$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editAdvice",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveAdvice();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
});

/**
 * 显示用户建议列表当前页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showAdviceNowPageList(){
    if($('#pgAdvice_nowPg').length > 0){
        showAdvicePageList(parseInt($('#pgAdvice_nowPg').text(),10));
    }else{
        showAdvicePageList(1);
    }
}

/**
 * 用户建议分页回调
 * @author caoxin
 * @createtime 2016-12-17
 */
function advicePageselectCallback(page_index, jq){
    showAdvicePageList(page_index+1);
}

/**
 * 用户建议分页
 * @author caoxin
 * @createtime 2016-12-17
 */
function showAdvicePageList(pgNum){
    var paraObj = {};
    paraObj["pageNum"] = pgNum;
    if($.trim($('#txtParam').val()) != ''){
        paraObj["advice.adviceName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "advice/listAjax",
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
                    listHtml.push('<td>'+ (item.adviceId==undefined?'':item.adviceId) + '</td>');
                    listHtml.push('<td>'+ (item.content==undefined?'':item.content) + '</td>');
                    listHtml.push('<td>'+ (item.userId==undefined?'':item.userId) + '</td>');
                    listHtml.push('<td>'+ (item.deleteFlag==undefined?'':item.deleteFlag) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showAdvice('+ item.adviceId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteAdvice('+ item.adviceId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbAdviceList').html(listHtml.join(''));
                $('#pgAdvice').empty();
                createAdvicePagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建用户建议分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createAdvicePagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgAdvice").pagination(totalRows, {
            callback: advicePageselectCallback,
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
 * 删除用户建议
 * @author caoxin
 * @createTime 2016-12-17
 */
function deleteAdvice(objId){
    DilogConfirm('您确定要删除此用户建议吗？', function(){
        $.ajax({
            url: "advice/"+ objId +"/delete",
            type: "get",           // 数据发送方式          
            dataType : "json",      // 接受数据格式
            success : function(jsonData){
                if(jsonData.errcode == -2){
                    top.location.reload(true);
                }else if(jsonData.errcode == -1){
                    DilogError('出错了!请联系管理员!');
                }else{
                    if(jsonData.errcode == 0){
                        showAdviceNowPageList();
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
 * 查看用户建议
 * @author caoxin
 * @createTime 2016-12-17
 */
function showAdvice(objId){
    clearnForm();
    $.ajax({
        url: "advice/"+ objId +"/show",
        type: "get",           // 数据发送方式          
        dataType : "json",      // 接受数据格式
        success : function(jsonData){
            if(jsonData.errcode == -2){
                top.location.reload(true);
            }else if(jsonData.errcode == -1){
                DilogError('出错了!请联系管理员!');
            }else{
                $('#tadviceId').val(jsonData.adviceId);
                $('#tcontent').val(jsonData.content);
                $('#tuserId').val(jsonData.userId);
                $('#tdeleteFlag').val(jsonData.deleteFlag);
                
                DialogCustomForm('编辑用户建议','divAdviceForm','adviceFormDig');
                showAdviceNowPageList();
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
    $('#tadviceId').val('');
    $('#tcontent').val('');
    $('#tuserId').val('');
    $('#tdeleteFlag').val('');
}

/**
 * 保存编辑用户建议
 * @author caoxin
 * @createTime 2016-12-17
 */
function saveAdvice(){
    var msgArr = [];
    var paraObj = {};
    if($.trim($('#tadviceId').val()) != ''){
        paraObj["adviceId"] = $.trim($('#tadviceId').val());
    }else{
        msgArr.push('意见反馈ID不能为空!');
    }
    if($.trim($('#tcontent').val()) != ''){
        paraObj["content"] = $.trim($('#tcontent').val());
    }else{
        msgArr.push('意见内容不能为空!');
    }
    if($.trim($('#tuserId').val()) != ''){
        paraObj["userId"] = $.trim($('#tuserId').val());
    }else{
        msgArr.push('用户ID不能为空!');
    }
    if($.trim($('#tdeleteFlag').val()) != ''){
        paraObj["deleteFlag"] = $.trim($('#tdeleteFlag').val());
    }else{
        msgArr.push('删除标记(0未删除 1已删除)不能为空!');
    }
    
    if(msgArr.length > 0){
        DilogWarning(msgArr.join('<br/>'));
        return ;
    }
    $.ajax({
        url: "advice/save",
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
                    DialogClose('adviceFormDig');
                    if($.trim($('#hdnAdviceId').val()) != ''){
                        showAdviceNowPageList();
                    }else{
                        showAdvicePageList(1);
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
function showAddAdviceDig(){
    clearEditForm();
    DialogCustomForm('新增用户建议','divAdviceForm','adviceFormDig');
}
