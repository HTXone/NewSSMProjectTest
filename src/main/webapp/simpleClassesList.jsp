<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.TestSys.entity.Classes" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>课程管理</title>
    <meta Name="keywords" content="管理,后台,模板" />
    <meta Name="description" content="管理系统模板" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta Name="viewport" content="width=device-width, initial-scale=1">
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
					<h3>课程管理</h3>
					<br />
					<br />
				</div>
				<c:if test="${user['role'] == 0}">
					<div class=" pull-right">
						<form class="layui-form layui-col-md12 we-search" action="/SelectClasses.do">
							课程搜索：
							<div class="layui-inline">
								<input type="text" Name="param" placeholder="请输入课程名" autocomplete="off" class="layui-input" />
							</div>
							<button class="layui-btn" lay-submit="" lay-filter="sreach">
								<i class="layui-icon layui-icon-search"></i>
							</button>
						</form>
					</div>
				</c:if>
				
			</div>
			<div class="weadmin-block">
				<c:if test="${user['role']==0}">
				<button class="layui-btn" onclick="location.href='/toAddClasses.do'">
					<i class="layui-icon layui-icon-add-circle-fine"></i>添加
				</button></c:if>
				<span class="fr" style="line-height:40px">共有数据 ${pageInfo.total} 条</span>
			</div>
			<table class="table table-bordered">
				        <thead>
				            <tr>
								<th>课程号</th>
								<th>课程名称</th>
								<th>授课老师编号</th>
								<th>上课时间</th>
								<th>上课地点</th>
								<th>周数</th>
								<th>课程类型</th>
								<th>学分</th>
								<c:if test="${Selected!=1}"><th>操作</th></c:if>
								<c:if test="${user['role'] == 2 && Selected==1}"><th>成绩</th></c:if>
				            </tr>
				        </thead>
				        <tbody>
						<c:forEach  items="${classess}" var="item">
							<tr>
								<td>${item.courseID}</td>
								<td>${item.courseName}</td>
								<td>${item.teacherID}</td>
								<td>${item.courseTime}</td>
								<td>${item.classRoom}</td>
								<td>${item.courseWeek}</td>
								<td>${item.courseType}</td>
								<td>${item.score}</td>
								<td>
									<c:if test="${user['role'] == 0}"><button class="btn btn-default btn-xs btn-info" onClick="location.href='/toEditClasses.do?ID=${item.courseID}'">修改</button></c:if>
									<c:if test="${user['role'] == 2 && Selected==0}"><button class="btn btn-default btn-xs btn-info" onClick="location.href='/SelectedCourse.do?courseID=${item.courseID}&studentID=${user['id']}'">选课</button></c:if>
									<c:if test="${user['role'] == 2 && Selected==2}"><button class="btn btn-default btn-xs btn-info" onClick="location.href='/RemoveSelectedCourse.do?courseID=${item.courseID}&studentID=${user['id']}'">退课</button></c:if>
									<c:if test="${user['role'] == 1}"><button class="btn btn-default btn-xs btn-info" onClick="location.href='/CourseScoreList.do?param=${item.courseID}'">打分</button></c:if>
									<c:if test="${user['role'] == 0}"><button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/DeleteClass.do?courseID=${item.courseID}'">删除</button></c:if>
									<c:if test="${user['role'] == 2 && Selected==1}">${item.mark}</c:if>
									<!--弹出框-->
								</td>
							</tr>
						</c:forEach>
				        </tbody>
			    </table>
			<jsp:include page="footer.jsp"></jsp:include>
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