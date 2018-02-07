$(document).ready(function(){
    //语法验证
    $.formValidator.initConfig({
        formid:"editAnutInfo",
        alertmessage:false,
        onerror:function(msg,obj,errorlist){
            var msgArr = [];
            $.map(errorlist,function(msg){
                msgArr.push(msg)
            });
            DilogValid('<span>' + msgArr.join('<br/>') + '</span>');
        },
        onsuccess:function(){
            saveAnutInfo();
            return false;
        }
    });
    
    //$("#txtName").formValidator({automodify:false}).inputValidator({min:1,onerror:"名称必须输入!"});
    //$("#txtNum").formValidator({automodify:false,empty:true}).regexValidator({ regexp: "num1", datatype:"enum", onerror: "必须是正数!" });
    
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
    if($.trim($('#txtParam').val()) != ''){
        paraObj["anutInfo.anutInfoName"] = $.trim($('#txtParam').val());
    }
    var loading = ShowLoading();
    $.ajax({
        url: "anutInfo/listAjax",
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
                    listHtml.push('<td>'+ (item.anutId==undefined?'':item.anutId) + '</td>');
                    listHtml.push('<td>'+ (item.anutName==undefined?'':item.anutName) + '</td>');
                    listHtml.push('<td>'+ (item.phone==undefined?'':item.phone) + '</td>');
                    listHtml.push('<td>'+ (item.address==undefined?'':item.address) + '</td>');
                    listHtml.push('<td>'+ (item.headImg==undefined?'':item.headImg) + '</td>');
                    listHtml.push('<td>'+ (item.state==undefined?'':item.state) + '</td>');
                    listHtml.push('<td><a class="btn btn-xs btn-link" href="javascript:showAnutInfo('+ item.anutInfoId +');">修改</a>');
                    listHtml.push('<a class="btn btn-xs btn-link" href="javascript:deleteAnutInfo('+ item.anutInfoId +');">删除</a></td>');
                    listHtml.push('</tr>');
                });
                
                $('#tbAnutInfoList').html(listHtml.join(''));
                $('#pgAnutInfo').empty();
                createAnutInfoPagination(jsonData.totalPages, jsonData.totalRows, jsonData.pageNum, jsonData.pageSize);
            }
        },
        error: function(e){
            HideLoading(loading); 
        }
    });
}

/**
 * 构建阿姨信息分页组件
 * @author caoxin
 * @createtime 2016-12-17
 */
function createAnutInfoPagination(totalPages, totalRows, pageNum, pageSize){
    if(totalPages > 1){
        $("#pgAnutInfo").pagination(totalRows, {
            callback: anutInfoPageselectCallback,
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
    clearnForm();
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
                $('#theadImg').val(jsonData.headImg);
                $('#tstate').val(jsonData.state);
                
                DialogCustomForm('编辑阿姨信息','divAnutInfoForm','anutInfoFormDig');
                showAnutInfoNowPageList();
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
    $('#theadImg').val('');
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
    if($.trim($('#tanutId').val()) != ''){
        paraObj["anutId"] = $.trim($('#tanutId').val());
    }else{
        msgArr.push('阿姨id不能为空!');
    }
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
    if($.trim($('#theadImg').val()) != ''){
        paraObj["headImg"] = $.trim($('#theadImg').val());
    }else{
        msgArr.push('阿姨头像不能为空!');
    }
    if($.trim($('#tstate').val()) != ''){
        paraObj["state"] = $.trim($('#tstate').val());
    }else{
        msgArr.push('状态(0空闲1繁忙)不能为空!');
    }
    
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
                    DialogClose('anutInfoFormDig');
                    if($.trim($('#hdnAnutInfoId').val()) != ''){
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
 * 清空数据并打开添加表单
 * @author caoxin
 * @createTime 2016-12-17
 */
function showAddAnutInfoDig(){
    clearEditForm();
    DialogCustomForm('新增阿姨信息','divAnutInfoForm','anutInfoFormDig');
}
