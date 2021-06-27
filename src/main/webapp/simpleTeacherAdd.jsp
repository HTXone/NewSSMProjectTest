<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.TestSys.entity.Teacher" %>
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

	<jsp:include page="head.jsp"></jsp:include>
	<!-- 侧边菜单 -->
	<jsp:include page="side.jsp"></jsp:include>
    <div class="admin-body" id="tabs">
		<div class="weadmin-body">
			
			<div id="content">
				<div class="row">

					<div class="col-md-10">
						<div class="panel panel-default">
						    <div class="panel-heading">
								<div class="row">
							    	<h1 style="text-align: center;">添加教师信息</h1>
								</div>
						    </div>
						    <div class="panel-body">
								<form class="form-horizontal" role="form" action="/AddTeacher.do" id="editfrom">
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
									    <div class="col-sm-10">
									      <input type="text" class="form-control" id="inputPassword3" name="userName" placeholder="请输入姓名">
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">性别</label>
									    <div class="col-sm-10">
										    <label class="checkbox-inline">
											   	<input type="radio" name="sex" value="男" checked>男
											</label>
											<label class="checkbox-inline">
												<input type="radio" name="sex" value="女">女
											</label>
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">出生年份</label>
									    <div class="col-sm-10">
										    <input type="date" value="1996-09-02" name="birthYear"/>
									    </div>
									  </div>
									  <div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="degree">学历：</label>
										<div class="col-sm-10">
											<select class="form-control" name="degree">
												<option value="本科">本科</option>
												<option value="硕士">硕士</option>
												<option value="博士">博士</option>
											</select>
										</div>
									  </div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label" name="title">职称：</label>
										<div class="col-sm-10">
											<select class="form-control" name="title">
												<option value="普通教师">普通教师</option>
												<option value="助教">助教</option>
												<option value="讲师">讲师</option>
												<option value="副教授">副教授</option>
												<option value="教授">教授</option>
											</select>
										</div>
									</div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">入职时间</label>
									    <div class="col-sm-10">
										    <input type="date" value="2015-09-02" name="grade"/>
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