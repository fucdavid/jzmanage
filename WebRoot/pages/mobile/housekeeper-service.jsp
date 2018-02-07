<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html lang="en" data-dpr="1" style="font-size: 36px;"><head>
	<%@ include file="../basic.jsp"%>
    <meta charset="UTF-8">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>星管家·家务包年</title>
    <link rel="stylesheet" href="common/css/housekeeper.css?20171">
    <script src="common/js/hm.js?2017"></script>
    <script src="common/js/flexible.js?2017"></script>
    <style>@charset "utf-8";html{color:#000;background:#fff;overflow-y:scroll;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%}html *{outline:0;-webkit-text-size-adjust:none;-webkit-tap-highlight-color:rgba(0,0,0,0)}html,body{font-family:sans-serif}body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,code,form,fieldset,legend,input,textarea,p,blockquote,th,td,hr,button,article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{margin:0;padding:0}input,select,textarea{font-size:100%}table{border-collapse:collapse;border-spacing:0}fieldset,img{border:0}abbr,acronym{border:0;font-variant:normal}del{text-decoration:line-through}address,caption,cite,code,dfn,em,th,var{font-style:normal;font-weight:500}ol,ul{list-style:none}caption,th{text-align:left}h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:500}q:before,q:after{content:''}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-.5em}sub{bottom:-.25em}a:hover{text-decoration:underline}ins,a{text-decoration:none}</style>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">--%>
    <script src="common/js/jquery.min.js"></script>
</head>
<body style="font-size: 12px;" rlt="1">
<a href="wximpl/checkOrder?did=9&clientId=${clientId}"class="housekeeper-button">
    <span>立即预定</span>
</a>
<div class="housekeeper">
    <div class="h-banner">
        <div class="h-banner-logo"></div>
        <h2 class="h-banner-title"></h2>
        <h2 class="h-banner-subtitle">把星级酒店服务<span>订</span>回家</h2>
        <h2 class="h-banner-content"><span>15+项</span>日常家务全包揽<br>回家一刻，<span>焕然一新</span></h2>
    </div>
    <div class="h-standard">
        <h2 class="h-standard-title">你的苦恼，我包办！<br>酒店式客房服务横扫烦人家务</h2>
        <h2 class="h-standard-subtitle">星管家为用户提供酒店级内务打理 <br>打扫、整理、洗衣、洗碗<br>一揽子包办日常高频家务</h2>
        <div class="h-standard-server">
            <h3 class="h-standard-server-title"></h3>
            <h3 class="h-standard-server-subtitle">（下单后默认执行标准服务）</h3>
        </div>
        <div class="h-standard-items">
            <div class="item"></div>
            <div class="item"></div>
            <div class="item"></div>
            <div class="item"></div>
        </div>
    </div>
    <div class="h-server">
        <h2 class="h-server-title">你的需要，我照办！</h2>
        <h2 class="h-server-subtitle">几十项家务服务任你随心吩咐 </h2>
    </div>
    <div class="h-train">
        <h2 class="h-train-title">
            引入全球顶级酒店客房服务培训体系<br>让星级服务名副其实
        </h2>
        <h2 class="h-train-subtitle">
            采用全球顶级酒店客房服务培训体系，<br>
            我们为专职管家制定了全年的技能进阶培养与考核计划，<br>
            让您在家也能体验顶级酒店星级服务。
        </h2>
    </div>
    <div class="h-tool">
        <h2 class="h-tool-title">
            星级<b>不是</b>虚无的标准<br>星级<b>是</b>看得见的认真
        </h2>
        <h2 class="h-tool-subtitle">工具全面升级。专供服务工具包配备25+全能工具组<br>专业服务依赖技能，更依赖工具，满足日常打理的方方面面。</h2>
    </div>
    <div class="h-housekeeper">
        <h2 class="h-housekeeper-title">比<b>保姆</b>更划算，比<b>管家</b>还操心</h2>
        <h2 class="h-housekeeper-subtitle">不当好保姆的管家不是好管家</h2>
        <h2 class="h-housekeeper-content">
            星管家一揽子包办日常高频家务，省心无需过问。<br>雇主再也不用费神找保姆，不用月月按时付薪，<br>也不用日日提供食宿，<br>比全天保姆更灵活、自由，性价比自然完胜！
        </h2>
    </div>
    <div class="h-stand">
        <h2 class="h-stand-title">固定服务人员稳定服务<br><b>365天</b>品质如一</h2>
        <h2 class="h-stand-subtitle">每一位星级管家都是美家的专职员工。<br>您大可放心的把满意的管家固定下来，<br>享受一整年稳定省心的家务服务。</h2>
    </div>
    <div class="h-insurance">
        <h2 class="h-insurance-title">
            <b>200<span>万</span></b>雇主定制险<br>还有什么能够阻挡<br>你对家务解放的向往
        </h2>
        <h2 class="h-insurance-subtitle">
            丢了？碎了？坏了？少了？美家负责到底！<br>做足这一切，是源自美家对雇主的负责与关切。
        </h2>
    </div>
    <div class="h-users">
        <h2 class="h-users-title">
            <b>6年</b>专注家庭服务<br><b>120万</b>家庭共同选择
        </h2>
        <h2 class="h-users-subtitle">
            创新引进日本工具组<br>创新使用七色保洁布<br>创新使用双桶分区服务<br>创新使用一次性保洁布
        </h2>
    </div>
    <div class="h-high-end">
    </div>
    <div class="h-process"></div>
    <div class="h-promise"></div>
    <div class="h-declare">
        <h2 class="h-declare-title">- 预订须知 -</h2>
        <div class="h-declare-item">
            <h2 class="title"><b>预订说明：</b></h2>
            <h3 class="content">预订成功后，付款选择在线支付，服务订单会为您保留30分钟（从预订成功时间算起），30分钟后如还末付款成功，系统将自动取消该服务订单。</h3>
        </div>
        <div class="h-declare-item">
            <h2 class="title"><b>订单更改：</b></h2>
            <h3 class="content">
                变更服务时间：如您需要更改固定服务时间，请提前2小时在美家在家微信公众号、app或者电话联系更改，但更改固定服务时间很可能需要更换固定保洁师，因为在您更改至固定服务时间段该保洁师已有其他固定客户需要服务。如您在订单服务开始前2小时内至服务开始后1小时内的期间内要求更改服务时间，将产生50元的空单费账单，未及时支付将视为服务完成，具体的收费标准以服务协议说明为准。</h3>
            <h3 class="content">无法入户服务：因停水、或您的个人原因导致保洁师无法入户服务，将可能产生50元的空单费账单，未及时支付将视为服务完成，具体的收费标准以服务协议说明为准。</h3>
        </div>
        <div class="h-declare-item">
            <h2 class="title"><b>取消或修改时间：</b></h2>
            <h3 class="content">服务开始前2小时更改订单，可在个人账户-服务订单-操作取消或更改时间。</h3>
        </div>
    </div>
    <div class="h-footer">
        <h2 class="content">©2016 恩施市美家创新家政有限责任公司 版权所有</h2>
    </div>
</div>
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