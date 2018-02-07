<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.guoxin.common.util.Config"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <%@ include file="../basic.jsp"%>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>订单管理</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <link type="text/css" href="common/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="common/css/progress-bar.css" rel="stylesheet" />
        <link type="text/css" href="common/css/loading.css" rel="stylesheet" />
        <link type="text/css" href="common/css/pagination.css" rel="stylesheet" />
        <link type="text/css" href="common/css/style.css" rel="stylesheet">
	</head>

	<body>
	    <%--头部--%>
        <%@ include file="../base/header.jsp"%>
        
        <div class="container m-source">
            <ol class="breadcrumb">
                <li>订单管理</li>
<%--                <li class="active">资讯素材</li>--%>
            </ol>

            <!-- 模块 编辑按钮 -->
            <div class="btn-toolbar row" role="toolbar" aria-label="..." style="margin-bottom:20px;">
                <%if(u.getLoginName() == "xx"){%>
                <button type="button" class="btn btn-default" data-toggle="modal" onclick="showAddInfonewsDig();"><span class="glyphicon glyphicon-open"></span> 上传</button>
                <button type="button" class="btn btn-default" onclick="batchDelInfonews();"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                <%}%>
                <div class="form-inline pull-right">
                    <div class="form-group ">
                        <input type="text" class="form-control input-key" id="paraOrderCode" placeholder="请输入订单号">
                    </div>
                    <button type="button" class="btn btn-default btn-search" onclick="showOrderPageList(1);"><span class="glyphicon glyphicon-search"></span> 搜索</button>
                </div>
            </div>

            <!-- 模块 表格 -->
            <table class="table table-bordered table-hover" style="background-color:#fff;">
                <thead>
                    <tr style="background-color:#f0f0f0;">
                        <th width="5%">序号</th>
                        <th width="10%">订单号</th>
                        <th width="8%">手机号</th>
                        <th width="7%">订单状态</th>
                        <th width="13%">服务项目</th>
                        <th width="7%">服务面积</th>
<%--                        <th width="4%">优惠抵用</th>--%>
<%--                        <th width="4%">余额抵扣</th>--%>
                        <th width="4%">付款金额</th>
                        <th width="8%">预定服务时间</th>
                        <th width="15%">下单时间</th>
                        <th width="8%">派单地址</th>
                        <th width="15%">操作</th>
                    </tr>
                </thead>
                <tbody id="tbOrderList">
	            <c:forEach items="${pageInfo.items}" var="item" varStatus="i">
	               <tr>
	                    <input type="hidden" id="ids_${item.orderId}" value="${item.orderId}"/>
	                    <td style="text-align:center;">${i.count}</td>
	                    <td style="text-align:center;">${item.orderCode}</td>
	                    <td style="text-align:center;">${item.telephone}</td>
	                    <c:if test="${item.state == 0}"><td style="text-align:center;">未付款</td></c:if>
	                    <c:if test="${item.state == 1}"><td style="text-align:center;color:#FF0000">已付款</td></c:if>
	                    <c:if test="${item.state == 2}"><td style="text-align:center;color:#FF00FF">已派单</td></c:if>
	                    <c:if test="${item.state == 3}"><td style="text-align:center;color:#008000;">已完成</td></c:if>
	                    <c:if test="${item.state == 4}"><td style="text-align:center;color:#0000FF">已取消</td></c:if>
	                    <c:if test="${item.state == 5}"><td style="text-align:center;color:#800000">申请退款</td></c:if>
	                    <c:if test="${item.state == 6}"><td style="text-align:center;color:#00FF00">已退款</td></c:if>
	                    <td style="text-align:center;">${item.detailName}</td>
	                    <c:choose>
	                    <c:when test="${item.area == 1}">
	                    	<td style="text-align:center;">0-89</td>
	                    </c:when>
	                     <c:when test="${item.area == 2}">
	                    	<td style="text-align:center;">90-159</td>
	                    </c:when>
	                     <c:when test="${item.area == 3}">
	                    	<td style="text-align:center;">160-249</td>
	                    </c:when>
	                     <c:when test="${item.area == 4}">
	                    	<td style="text-align:center;">250-300</td>
	                    </c:when>
	                    <c:otherwise>
	                    	<td style="text-align:center;">-</td>
	                    </c:otherwise>
	                    </c:choose>
<%--	                    <td style="text-align:center;">${item.discount}</td>--%>
<%--	                    <td style="text-align:center;">${item.account}</td>--%>
	                    <td style="text-align:center;">${item.paymoney}</td>
	                    <td style="text-align:center;"><fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd" /></td>
	                    <td style="text-align:center;"><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                    <td style="text-align:center;">${item.address}</td>
	                    <td style="text-align:center;">
	                    <c:choose>
	                    	<c:when test="${item.state == 1}">
	                    	<a class="btn btn-default" href="javascript:;" onclick="updateState(${item.orderId},${item.state});"><span class="glyphicon glyphicon-send"></span> 确认派单</a>
	                    	</c:when><c:when test="${item.state == 2}">
	                    	<a class="btn btn-default" href="javascript:;" onclick="updateState(${item.orderId},${item.state});"><span class="glyphicon glyphicon-send"></span> 确认完成</a>
	                    	</c:when><c:when test="${item.state == 5}">
	                    	<a class="btn btn-default" href="javascript:;" onclick="updateState(${item.orderId},${item.state});"><span class="glyphicon glyphicon-send"></span> 确认退款</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		-
	                    	</c:otherwise>
	                    </c:choose>
	                    </td>
	                </tr>
	           </c:forEach>
	           </tbody>
            </table>
	           <tfoot>
	             <tr>
	                <td colspan="8"><div class="page" id="pgOrder"></div></td>
	             </tr>
	           </tfoot>
        </div>
	</body>
	
	<%-- 查看详情弹层 --%>
    <div class="modal fade" id="divInfonewsForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <input type="hidden" id="hdnInewsId" />
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">详细订单信息</h4>
                </div>
                <div class="modal-body">
                	<table class="table table-bordered table-hover" style="background-color:#fff;">
		                <thead>
		                    <tr style="background-color:#f0f0f0;">
		                    	<th width="50%">订单地址</th>
                        		<th width="50%">用户评价</th>
		                    </tr>
                		</thead>
                		<tr>
		                    <td style="text-align:center;">不错哦</td>
		                    <td style="text-align:center;">呵呵</td>
	                    </tr>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="menuId" value="0">
    <div id="ibody" class="ibody"></div>
    <script type="text/javascript" src="common/js/jquery.min.js"></script>
    <script type="text/javascript" src="common/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="common/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="common/js/swfobject.js"></script>
    <script type="text/javascript" src="common/js/jquery.bgiframe.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="common/js/loading-min.js"></script>
    <script type="text/javascript" src="common/js/jquery.pagination.js"></script>
    <script type="text/javascript" src="common/js/dialog/jquery.artDialog.js?skin=black"></script>
    <script type="text/javascript" src="common/js/syscommon.js?160412"></script>
    <script type="text/javascript" src="common/js/order/order-list.js"></script>
	<script type="text/javascript">createOrderPagination(${pageInfo.totalPages},${pageInfo.totalRows},${pageInfo.pageNum},${pageInfo.pageSize});</script>
</html>
