<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>会员列表-WeAdmin Frame型后台管理系统-WeAdmin 1.0</title>
		<meta name="renderer" content="webkit" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<link rel="stylesheet" href="../../static/css/font.css" />
		<link rel="stylesheet" href="../../static/css/weadmin.css" />
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
		  <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
		  <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<div class="weadmin-nav">
			<span class="layui-breadcrumb">
				<a href="javascript:;">首页</a> <a href="javascript:;">会员管理</a>
				<a href="javascript:;"> <cite>会员列表</cite></a>
			</span>
			<a class="layui-btn layui-btn-sm" style="margin-top:3px;float:right" href="javascript:location.replace(location.href);"
			 title="刷新">
				<i class="layui-icon layui-icon-refresh"></i>
				<!-- <i class="layui-icon" style="line-height:30px">&#x1002;</i> -->
			</a>
		</div>

		<div class="weadmin-body">
			<div class="layui-row">
				<form class="layui-form layui-col-md12 we-search">
					会员搜索：
					<div class="layui-inline">
						<input class="layui-input" placeholder="开始日" name="start" id="start" />
					</div>
					<div class="layui-inline">
						<input class="layui-input" placeholder="截止日" name="end" id="end" />
					</div>
					<div class="layui-inline">
						<input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input" />
					</div>
					<button class="layui-btn" lay-submit="" lay-filter="sreach">
						<i class="layui-icon layui-icon-search"></i>
					</button>
				</form>
			</div>
			<div class="weadmin-block">
				<button class="layui-btn layui-btn-danger" onclick="delAll()">
					<i class="layui-icon layui-icon-delete"></i>批量删除
				</button>
				<button class="layui-btn" onclick="WeAdminShow('添加用户','./add.html',600,400)">
					<i class="layui-icon layui-icon-add-circle-fine"></i>添加
				</button>
				<span class="fr" style="line-height:40px">共有数据：88 条</span>
			</div>
			<table class="layui-table" id="memberList">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						<th>ID</th>
						<th>用户名</th>
						<th>性别</th>
						<th>手机</th>
						<th>邮箱</th>
						<th>地址</th>
						<th>加入时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ss}" var="emp">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.userName}</td>
						<td>${emp.PWD}</td>
						<td>${emp.role}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<div>
					<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a>
					<span class="current">2</span> <a class="num" href="">3</a>
					<a class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
				</div>
			</div>
		</div>
		<!--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>-->
		<script src="../../lib/layui/layui.js" charset="utf-8"></script>
		<script src="../../static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>
