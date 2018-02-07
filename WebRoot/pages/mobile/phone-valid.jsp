<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
	<%@ include file="../basic.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=yes" name="format-detection">
    <title>登录-美家到家</title>

<link type="text/css" href="common/css/mobile.css" rel="stylesheet">
<script type="text/javascript" src="common/js/jquery.min.js"></script>
    <style>
        .login-box {
            border: 1px solid #d7d7d7;
            background: #fff;
            border-radius: 8px;
            -webkit-border-radius: 8px;
            text-align: center;
            padding: 15px;
            position: relative;
        }

        .login-box img {
            margin: 0px auto;
            display: block;
            margin-bottom: 10px;
        }

        .login-dl {
            margin: 8px 0 24px 0;
        }

        .login-dl dt {
            padding-bottom: 8px;
        }

        .login-dl dd {
            float: left;
            width: 36px;
            margin: 0px 5px;
            text-align: center;
        }

        .login-dl dd a {
            display: inline-block;
        }

        .login-box-a p {
            margin-bottom: 0;
        }

        .login-box .input-wrap input[type="tel"] {
            height: 40px;
        }

        .login-box .cblue {
            color: #339ee2;
        }

        .login-box .corange {
            color: #ff9900;
        }

        .input-wrap span.append {
            border-left: 0px;
        }

        .input-wrap .cblue {
            text-align: right;
        }

        .phone-wrap {
            margin-bottom: 0;
            border-bottom: none;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
            text-align: left;
        }

        .captcha-wrap {
            margin-bottom: 0;
            border-radius: 0;
            text-align: left;
        }

        .code-wrap {
            display: none;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
            border-top: 0;
        }

        input {
            width: 100%;
        }

        .voice-wrap {
            line-height: 38px;
            font-size: 14px;
            color: #333;
            display: none;

        }

        .voice-wrap .voice-usable {
            color: #FF3300;
            text-decoration: underline;
        }

        .voice-wrap .voice-unusable {
            color: #d7d7d7;
            text-decoration: underline;
            display: none;
        }

        .login-box input[name="phone"], .login-box input[name="captcha"] {
            width: 100%;
        }

        .image-captcha {
            z-index: 999999;
            position: absolute;
            right: 5px;
            top: 5px;
            height: 30px;
        }

        .input-wrap.error {
            border: 1px solid #ff2222;
        }

        .send-code {
            z-index: 999999;
            position: absolute;
            right: 5px;
            top: 0px;
        }

        .account-wrap {
            margin-bottom: 0;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
            border: none;
        }

        .password-wrap {
            border-bottom: none;
            border-left: none;
            border-right: none;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
            margin-bottom: 0;
        }

        .protocol a {
            color: #339ee2 !important
        }
    </style>
</head>
<body dh="1" rlt="1">
<div class="hk-container">
    <div class="hk-main">
        <div class="slide-page" id="mainPage">
            <header>
                <a class="back" href="javascript:back()"></a>登录
                <div class="btns ">
                    <a class="hk-index" href="javascript:void(0);"></a>
                </div>
            </header>
            <article class="register">
                <h1>
                    <img src="common/images/logo.jpg">
                </h1>
                <div class="login-box">
                    <input type="hidden" value="" id="codevalid">
                    <input type="hidden" value="${openid}" id="openid">
                    <div id="boxPhone" class="login-box-item  ">
                           <div id="phoneLable" class="input-wrap phone-wrap">
                               <input placeholder="请输入手机号码" name="phone" id="phone" type="tel">
                           </div>
                           <div id="captchaLable" class="input-wrap captcha-wrap">
                               <input placeholder="请输入手机验证码" name="code" id="code" type="tel">
                               <span class="append cblue send-code" id="sendCodeBtn">发送验证码</span>
                           </div>
                           <a class="btn blue" href="javascript:phoneLoginSubmit();" style="margin-top:10px;">登录</a>
<%--                            <div class="protocol">登录即视为您已同意<a href="https://sso.homeking365.com/mobile/treaty">《美家到家用户协议》</a></div>--%>
                    </div>
                    <div id="boxPassword" class="login-box-item none">
                        <form action="https://sso.homeking365.com/login/passwordLogin" method="GET" id="passwordLoginForm">
                            <div class="input-group">
                                <div id="accountRow" class="input-wrap account-wrap">
                                    <input name="account" type="text" placeholder="手机/邮箱/用户名">
                                </div>
                                <div id="passwordRow" class="input-wrap password-wrap">
                                    <input name="password" type="password" placeholder="密码">
                                </div>
                            </div>
                            <a class="btn blue" href="javascript:passwordLoginSubmit();">登录</a>
                            <div class="protocol">登录即视为您已同意<a href="https://sso.homeking365.com/mobile/treaty">《美家在家用户协议》</a></div>
                        </form>
                    </div>
                </div>
<%--                <dl class="login-dl">--%>
<%--                    <dt>不！我要使用：</dt>--%>
<%--                    <dd>--%>
<%--                        <a href="javascript:switchPasswordlogin();" class="dd-a"><img src="/images/pages/mobile/login-icon-7.png" width="100%"></a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="javascript:switchPhonelogin();" class="dd-a"><img src="/images/pages/mobile/login-icon-1.png" width="100%"></a>--%>
<%--                    </dd>--%>
<%--                    <dd>--%>
<%--                        <a href="https://graph.qq.com/oauth2.0/authorize?response_type=code&amp;client_id=101055422&amp;redirect_uri=https%3A%2F%2Fsso.homeking365.com%2Fmobile%2FqqLogin&amp;scope=get_user_info&amp;state=http%3A%2F%2Fm.homeking365.com%2Fservices%2Forder%2FV3%2F241%3Fcode%3D" class="dd-a"><img src="/images/pages/mobile/login-icon-3.png" width="100%"></a>--%>
<%--                    </dd>--%>
<%--                    --%>
<%--                    <div class="clearfix"></div>--%>
<%--                </dl>--%>
                <div class="clearfix"></div>
<%--                <p>--%>
<%--                    <a class="btn-link " href="https://sso.homeking365.com/mobile/forget">忘记密码?</a> <a class="btn-link fr" href="https://sso.homeking365.com/mobile/register?redirectUrl=http%3A%2F%2Fm.homeking365.com%2Fservices%2Forder%2FV3%2F241%3Fcode%3D">新用户注册</a>--%>
<%--                </p>--%>
            </article>
        </div>
    </div>
</div>

<div class="message-wrap" id="tooltip" style="display: none;">
	<div class="message-box">
		<i class="icon exclamation-mark"></i><span class="message-text">请填写正确的手机号码</span>
	</div>
</div>

<script>
	$(function () {
		if(msg){
			tooltip(msg);
		}
	})
<%--	var _webApp = 'https://sso.homeking365.com';--%>
<%--	var redirectUrl = 'http://m.homeking365.com/services/order/V3/241?code=';--%>
	var msg = '';
	function tooltip(text) {
		$('#tooltip .message-text').text(text);
		$('#tooltip').show();
		window.setTimeout(function () {
			$('#tooltip').hide();
		}, 1500);
	}

	function back(){
		history.go(-1);
	}
</script>

<script src="common/js/mobile/mobile-login.js?20170512" type="text/javascript"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script type="text/javascript">
    /****************************自定义微信分享内容*********************************************/
   	var shareData = {
        "title" : '在恩施这么多年了，终于有让人值得信赖的家政服务啦！  美家到家-专业家庭服务预定平台 ',
        "link" : 'http://www.meijiajiazheng.com/jzmanage/wximpl/oauth',
        "imgUrl" : 'http://www.meijiajiazheng.com/jzmanage/common/images/share-bg.png',
    };
    /****************************自定义微信分享内容*********************************************/
	</script>
	<script type="text/javascript" src="common/js/wxJsSdkShare_crossdm.js"></script>
</body></html>
