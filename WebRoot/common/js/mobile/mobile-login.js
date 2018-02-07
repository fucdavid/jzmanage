$(function () {
    redirectUrl = $('#redirectUrl').val();

    //发送短信验证码
    $('#sendCodeBtn').click(function () {
        if (!$(this).hasClass('disable')) {
            sendCode($(this));
        }
    });
});
//重定向地址
var redirectUrl = 'wximpl/gohome';
//图片验证码KEY
var captchaKey = '';


/**
 * 随机字符串
 * @param n
 * @returns {string}
 */
function randomStr(n) {
    var res = "";
    var chars = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    for (var i = 0; i < n; i++) {
        var id = Math.ceil(Math.random() * 35);
        res += chars[id];
    }
    return res;
}

/**
 * 手机动态登陆提交
 */
function phoneLoginSubmit() {
    if (checkPhone() && checkCode()) {
        var url = 'wximpl/save'
        var phone = $.trim($('input[name="phone"]').val());
        var code = $.trim($('input[name="code"]').val());
        var codevalid = $('#codevalid').val();
        var openid = $('#openid').val();
        $.post(url, {
            phone: phone,
            code: code,
            codevalid:codevalid,
            openid:openid
        }, function (result) {
            if (result.errcode == 0) {
                window.location.href = "wximpl/gohome?openId=" + result.code;
            } else {
                tooltip(result.code);
            }
        }, 'json');
    }
}


/**
 * 发送短信验证码
 */
function sendCode(obj) {
    if (checkPhone()) {
        var phone = $.trim($('input[name="phone"]').val());
        obj.addClass('disable').text('发送中···');
        var paraObj = {};
        paraObj["phone"] = phone;
        $.ajax({
            url: "wximpl/getcode",
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
                    	$('#codevalid').val(jsonData.code);
                    	countdown();
                    	tooltip("短信验证码已发送成功，请注意查收！");
                    }else{
                    	tooltip(sonData.msg);
                        $('#sendCodeBtn').html('发送验证码').removeClass('disable');
                    }
                }
            },
            error: function(e){
            }
        });
    }
}
/**
 * 倒计时
 */
var timer = 0;
function countdown() {
    clearInterval(timer);
    var count = 60;
    $('#sendCodeBtn').html('<span class="corange">' + count + 's</span>');
    timer = setInterval(function () {
        count--;
        $('#sendCodeBtn').html('<span class="corange">' + count + 's</span>');
        if (count == 0) {
            clearInterval(timer);
            $('#sendCodeBtn').html('发送验证码').removeClass('disable');
        }
        if (count == 45) {
            $("#voiceCode").show();
        }
    }, 1000);
}

/**
 * 返回动作
 */
function back() {
    var redirectUrl = $('#redirectUrl').val();
    if (redirectUrl) {
        history.go(-1);
    } else {
        window.location.href = _webApp;
    }
}

/**
 * 检查手机
 * @returns {boolean}
 */
function checkPhone() {
    var phone = $.trim($('input[name="phone"]').val());
    if (!/^1\d{10}$/.test(phone)) {
        tooltip('请填写正确的手机号码');
        $("#phoneLable").addClass("error").click(function () {
            $(this).removeClass('error').unbind("click");
        });
        return false;
    } else {
        return true;
    }
}

/**
 *  检查手机验证码
 * @returns {boolean}
 */
function checkCode() {
    var code = $.trim($('input[name="code"]').val());
    if (!/^\d{6}$/.test(code)) {
        tooltip('请输入6位手机验证码');
        $("#codeLabel").addClass("error").click(function () {
            $(this).removeClass('error').unbind("click");
        });
        return false;
    } else {
        return true;
    }
}