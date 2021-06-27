<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.TestSys.entity.Classes" %>
<%@ page import="java.util.*" %>


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

    <div class="admin-body" id="tabs">
		<div class="weadmin-body">
			<div id="content">
				<div class="row">

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<h1 style="text-align: center;">添加课程信息</h1>
								</div>
							</div>
							<div class="panel-body">
								<form class="form-horizontal" role="form" action="/AddClasses.do" id="editfrom" method="post">
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">课程名称</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputPassword3" name="courseName" placeholder="请输入课程名称">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="grade">授课老师编号</label>
										<div class="col-sm-10">
											<select class="form-control" name="teacherID">
												<c:forEach items="${teacherList}" var="item">
													<option value="${item.userID}">${item.userName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">上课时间</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="courseTime" placeholder="请输入上课时间">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">上课地点</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="classRoom" placeholder="上课地点">
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-2 control-label">周数</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" name="courseWeek" placeholder="请输入周数">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="courseType">课程的类型：</label>
										<div class="col-sm-10">
											<select class="form-control" name="courseType">
												<option value="必修课">必修课</option>
												<option value="选修课">选修课</option>
												<option value="公共课">公共课</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="grade">所属院系</label>
										<div class="col-sm-10">
											<select class="form-control" name="collegeID">
												<c:forEach items="${collegeList}" var="item">
													<option value="${item.collegeID}">${item.collegeName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-2 control-label">学分：</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" name="score" placeholder="请输入学分">
										</div>
									</div>
									<div class="form-group" style="text-align: center">
										<button class="btn btn-default" type="submit">提交</button>
										<button class="btn btn-default" type="reset">重置</button>
									</div>
								</form>
							</div>
			
						</div>
			
					</div>
				</div>
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