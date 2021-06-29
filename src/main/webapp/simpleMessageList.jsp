<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>管理系统模板</title>
    <meta name="keywords" content="管理,后台,模板" />
    <meta name="description" content="管理系统模板" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="static/libs/bootstrap.addtabs/bootstrap.addtabs.css" rel="stylesheet">
    <link href="static/css/theme/default.css" rel="stylesheet">
	<link rel="stylesheet" href="static/css/font.css" />
	<link rel="stylesheet" href="static/css/weadmin.css" />
    <!--[if lt IE 9]>
        <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<jsp:include page="head.jsp"></jsp:include>
    <!-- 侧边菜单 -->
	<jsp:include page="side.jsp"></jsp:include>
    <div class="admin-body" id="tabs">
		<div class="weadmin-body">
			
			<div class="layui-row">
				<div class="pull-left">
					<h3>信息管理</h3>
					<br />
					<br />
				</div>
				<div class=" pull-right">
					<form class="layui-form layui-col-md12 we-search" action="/SelectStudent.do">
						学生搜索：
						<div class="layui-inline">
							<input type="text" name="param" placeholder="请输入用户名" autocomplete="off" class="layui-input" />
						</div>
						<button class="layui-btn" lay-submit="" lay-filter="sreach">
							<i class="layui-icon layui-icon-search"></i>
						</button>
					</form>
				</div>
				
			</div>
			<div class="weadmin-block">
				<button class="layui-btn" onclick="location.href='/simpleMessageAdd.jsp'">
					<i class="layui-icon layui-icon-add-circle-fine"></i>添加
				</button>
				<span class="fr" style="line-height:40px">共有数据 22 条</span>
			</div>
			<table class="layui-table" id="memberList">
				<thead>
					<tr>
						<th>发件人</th>
						<th>收件人</th>
						<th>信息</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${messages}" var="message">
					<tr>
						<td>${message.senderID}</td>
						<td>${message.reciverID}</td>
						<td>${message.message}</td>


					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="panel-footer">
					<c:if test="${pageInfo != null}">
						<nav style="text-align: center">
							<ul class="pagination">
								<li><a href="${PageUrl}?pageNo=${pageInfo.navigateFirstPage}&param=${param1}">&laquo;第一页</a></li>
								<c:if test="${pageInfo.pageNum-2>0 }">
									<li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-2}&param=${param1}">${pageInfo.pageNum-2}</a></li>
								</c:if>
								<c:if test="${pageInfo.hasPreviousPage }">
									<li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-1}&param=${param1}">${pageInfo.pageNum-1}</a></li>
								</c:if>
								<li class="active"><a href="">${pageInfo.pageNum}</a></li>
								<c:if test="${pageInfo.hasNextPage }">
									<li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+1}&param=${param1}">${pageInfo.pageNum+1}</a></li>
								</c:if>
								<c:if test="${pageInfo.pageNum+2<=pageInfo.pageSize }">
									<li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+2}&param=${param1}">${pageInfo.pageNum+2}</a></li>
								</c:if>

								<li><a href="${PageUrl}?pageNo=${pageInfo.navigateLastPage}&param=${param1}">最后一页&raquo;</a></li>
							</ul>
						</nav>
					</c:if>
			    </div>

		</div>
		
    </div>
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="static/libs/bootstrap.addtabs/bootstrap.addtabs.js"></script>
    <script src="static/js/admin_.js"></script>
</body>

</html>