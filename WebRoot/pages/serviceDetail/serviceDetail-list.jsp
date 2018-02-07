<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.guoxin.common.util.Config"%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <%@ include file="../basic.jsp"%>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>服务项目管理</title>
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
                <li>服务项目管理</li>
<%--                <li class="active">资讯素材</li>--%>
            </ol>

            <!-- 模块 编辑按钮 -->
            <div class="btn-toolbar row" role="toolbar" aria-label="..." style="margin-bottom:20px;">
<%--                <button type="button" class="btn btn-default" data-toggle="modal" onclick="addAnutInfo();"><span class="glyphicon glyphicon-open"></span> 添加</button>--%>
<%--                <button type="button" class="btn btn-default" onclick="batchDelInfonews();"><span class="glyphicon glyphicon-trash"></span> 删除</button>--%>
<%--                <div class="form-inline pull-right">--%>
<%--                    <div class="form-group ">--%>
<%--                        <input type="text" class="form-control input-key" id="paraPhone" placeholder="请输入手机号">--%>
<%--                    </div>--%>
<%--                    <button type="button" class="btn btn-default btn-search" onclick="showAnutInfoPageList(1);"><span class="glyphicon glyphicon-search"></span> 搜索</button>--%>
<%--                </div>--%>
            </div>

            <!-- 模块 表格 -->
            <table class="table table-bordered table-hover" style="background-color:#fff;">
                <thead>
                    <tr style="background-color:#f0f0f0;">
                        <th width="3%">序号</th>
                        <th width="13%">项目名称</th>
                        <th width="24%">描述</th>
                        <th width="10%">所属栏目</th>
                        <th width="10%">0-89㎡</th>
                        <th width="10%">90-159㎡</th>
                        <th width="10%">160-249㎡</th>
                        <th width="10%">250-300㎡</th>
<%--                        <th width="20%">更新时间</th>--%>
                        <th width="10%">操作</th>
                    </tr>
                </thead>
                <tbody id="tbServiceDetailList">
	            <c:forEach items="${pageInfo.items}" var="item" varStatus="i">
	               <tr>
	                    <input type="hidden" id="ids_${item.detailId}" value="${item.detailId}"/>
	                    <td style="text-align:center;">${i.count}</td>
	                    <td style="text-align:center;">${item.detailName}</td>
	                    <td style="text-align:center;">${item.describes}</td>
	                    <td style="text-align:center;">${item.serviceName}</td>
	                    <td style="text-align:center;">${item.moneya}</td>
	                    <td style="text-align:center;">${item.moneyb}</td>
	                    <td style="text-align:center;">${item.moneyc}</td>
	                    <td style="text-align:center;">${item.moneyd}</td>
<%--	                    <td style="text-align:center;"><fmt:formatDate value="${item.updateTime}" pattern="yyyy-MM-dd HH:mm" /></td>--%>
	                    <td style="text-align:center;">
	                    	<a class="btn btn-default" href="javascript:;" onclick="showServiceDetail(${item.detailId});"><span class="glyphicon glyphicon-send"></span>&nbsp;编辑</a>
<%--	                    	<a class="btn btn-default" href="javascript:;" onclick="deleteAnutInfo(${item.detailId});"><span class="glyphicon glyphicon-floppy-remove"></span>&nbsp;删除</a>--%>
	                    </td>
	                </tr>
	           </c:forEach>
	           </tbody>
            </table>
	           <tfoot>
	             <tr>
	                <td colspan="8"><div class="page" id="pgServiceDetail"></div></td>
	             </tr>
	           </tfoot>
        </div>
	</body>
	
	<%-- 上传素材弹层 --%>
    <div class="modal fade" id="divInfonewsForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <input type="hidden" id="tdetailId" />
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">编辑项目信息</h4>
                </div>
                <div class="modal-body">
                    <input type="text" id="tdetailName" class="form-control" style="width:90%;" placeholder="项目名称"/>
                </div>
<%--                <div class="modal-body">--%>
<%--                    <input type="text" id="tmoney" class="form-control" style="width:90%;" placeholder="项目费用"/>--%>
<%--                </div>--%>
                <div class="modal-body">
                    <input type="text" id="tdescribe" class="form-control" style="width:90%;" placeholder="描述"/>
                </div>
                <div class="modal-body">
                    <input type="text" id="tservice" class="form-control" readonly="true" style="width:90%;" placeholder="所属栏目"/>
                </div>
                <div class="modal-body">
                    <input type="text" id="tmoneya" class="form-control" style="width:90%;" placeholder="0-89㎡项目费用"/>
                </div>
                <div class="modal-body">
                    <input type="text" id="tmoneyb" class="form-control" style="width:90%;" placeholder="90-159㎡项目费用"/>
                </div>
                <div class="modal-body">
                    <input type="text" id="tmoneyc" class="form-control" style="width:90%;" placeholder="160-249㎡项目费用"/>
                </div>
                <div class="modal-body">
                    <input type="text" id="tmoneyd" class="form-control" style="width:90%;" placeholder="250-300㎡项目费用"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-hot" onclick="saveServiceDetail();">提交</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="menuId" value="4">
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
    <script type="text/javascript" src="common/js/detail/serviceDetail-list.js"></script>
	<script type="text/javascript">createServiceDetailPagination(${pageInfo.totalPages},${pageInfo.totalRows},${pageInfo.pageNum},${pageInfo.pageSize});</script>
</html>
