<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="gxtag" uri="http://www.guoxinad.com.cn/gxtag"%>
<!-- head 头部 -->
<div class="container-fluid m-head">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="logo"><img src="common/images/logox-a.png" alt=""/></div>
            </div>
            <div class="col-md-4 pull-right">
<%--            	<a class="btn btn-hot" href="home">返回首页</a>--%>
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <span>您好，<%=u.getLoginName()%>！</span>
                <a class="btn-out" href="logout">退出</a>
                <a class="btn-edit" href="javascript:setPassWord();">修改密码</a>
            </div>
        </div>
    </div>
</div>

<!-- nav 导航 -->
<div class="container-fluid m-nav">
    <div class="container">
        <ul class="nav nav-pills nav-justified cotrs">
            <li><a href="order/list">订单管理</a></li>
            
            <li><a href="anutInfo/list">阿姨管理</a></li>
<%--            <li role="presentation" class='dropdown'>--%>
<%--                <a class="dropdown-toggle" data-toggle="dropdown" href="anutInfo/list" role="button" aria-haspopup="true" aria-expanded="false">阿姨管理  </a>--%>
<%--                <ul class="dropdown-menu">--%>
<%--                    <li><a href="resourcefile/2/list">资讯使用规范</a></li>--%>
<%--                    <li><a href="resourcefile/3/list">活动使用规范</a></li>--%>
<%--                    <li><a href="resourcefile/1/list">指导手册</a></li>--%>
<%--                    <li><a href="resourcefile/5/list">话术回复模板</a></li>--%>
<%--                    <li><a href="caseShare/list">案例分享</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
            
            <li><a href="clientInfo/list">客户管理</a></li>
            <li><a href="advice/list">意见反馈</a></li>
            <li><a href="serviceDetail/list">服务项目管理</a></li>
            <%if(u.getLoginName().equals("admin")){%>
            <li><a href="user/list">用户管理</a></li>
            <%}%>
        </ul>
    </div>
</div>

	<%--修改密码弹层 --%>
    <div class="modal fade" id="setPassWord" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                </div>
                <input type="hidden" value="<%=u.getUserId()%>" id="uId">
                <input type="hidden" value="<%=u.getLoginName()%>" id="uName">
                <input type="hidden" value="<%=u.getPassword()%>" id="uPassword">
                <div class="modal-body">
                    <input type="password" id="firstpas" class="form-control" style="width:90%;" placeholder="请输入原密码" onblur="validPas()"/>
                </div>
                <div class="modal-body">
                    <input type="password" id="senondpas" class="form-control" style="width:90%;" placeholder="请输入新密码"/>
                </div>
                <div class="modal-body">
                    <input type="password" id="confirmpas" class="form-control" style="width:90%;" placeholder="请确认新密码"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-hot" onclick="submitPas();">提交</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    	function setPassWord(){
    		$('#firstpas').val('');
    		$('#senondpas').val('');
    		$('#confirmpas').val('');
	    	$('#setPassWord').modal('show');
    	}
    	
    	function submitPas(){
    		var msgArr = [];
    		var paraObj = {};
    		paraObj["userId"] = $.trim($('#uId').val());
    		paraObj["userName"] = $.trim($('#uName').val());
    		if($.trim($('#firstpas').val()) == ''){
    			alert('请输入原密码!');
    			return;
    		}
    		if($.trim($('#senondpas').val()) == ''){
    			alert('请输入新密码!');
    			return;
    		}
    		if($.trim($('#confirmpas').val()) == ''){
    			alert('请确认新密码!');
    			return;
    		}
    		if($.trim($('#senondpas').val()) != $.trim($('#confirmpas').val())){
    			alert('新密码输入不一致，请重新输入!');
    			return;
    		}else{
    			paraObj["password"] = $.trim($('#confirmpas').val());
    		}
    		$.ajax({headers:{"gxAjax":"true"},
			        url: "user/save",
			        type: "post",           // 数据发送方式          
			        dataType : "json",      // 接受数据格式
			        data : paraObj,
			        success : function(jsonData){
			        	  if(jsonData.errcode == 0){
			        	  		 $('#setPassWord').modal('hide');
					        	 alert(jsonData.msg);
			        	  }else{
			        		     alert('出错了!请联系管理员!');
			        	  }
			        },
			        error: function(e){
			        	 HideLoading(loading);
			        	 alert('出错了!请联系管理员!');
			        }
			    });
    	}
    	 
    	function validPas(){
    		var paraObj = {};
    		paraObj["originalpas"] = $.trim($('#uPassword').val());
    		paraObj["password"] = $.trim($('#firstpas').val());
    		paraObj["userName"] = $.trim($('#uName').val());
    		
    		if($.trim($('#firstpas').val()) != ''){
	    		$.ajax({headers:{"gxAjax":"true"},
				        url: "user/confirm",
				        type: "post",           // 数据发送方式          
				        dataType : "json",      // 接受数据格式
				        data : paraObj,
				        success : function(jsonData){
				        	  if(jsonData.errcode == 0){
						        	 
				        	  }else{
				        		  $('#firstpas').val('');
				        		  alert(jsonData.msg);
				        	  }
				        },
				        error: function(e){
				        	 HideLoading(loading);	
				        	 alert('出错了!请联系管理员!');
				        }
				    });
    		}
    	}
    </script>
