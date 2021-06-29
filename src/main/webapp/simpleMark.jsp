<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.TestSys.entity.Score" %>
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
	<jsp:include page="side.jsp"></jsp:include>

    <div class="admin-body" id="tabs">
		<div class="weadmin-body">
			<div class="" id="content">
				<div class="row">

					<div class="col-md-10">
						<div class="panel panel-default">
						    <div class="panel-heading">
								<div class="row">
							    	<h1 style="text-align: center;">学生打分</h1>
								</div>
						    </div>
						    <div class="panel-body">
								<form name="reset" class="form-horizontal" role="form" action="/Mark.do" id="editfrom" method="post" onsubmit="return check()">
									<div class="form-group">
<%--										<label for="inputEmail3" class="col-sm-2 control-label">课程</label>--%>
										<div class="col-sm-10">
											<input  readonly="readonly" type="hidden" class="form-control" name="courseID" id="inputEmail3" value="${courseID}">
										</div>
									</div>
									<div class="form-group">
									    <label for="inputEmail3" class="col-sm-2 control-label">学号</label>
									    <div class="col-sm-10">
									      <input  readonly="readonly" type="text" class="form-control" name="studentID" id="inputEmail3" value="${studentID}">
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
									    <div class="col-sm-10">
									      <input  readonly="readonly" type="text" name="studentName" class="form-control" id="inputPassword3" value="${studentName}">
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">成绩</label>
									    <div class="col-sm-10">
									      <input type="number" name="mark" class="form-control" id="inputPassword3" placeholder="请输入成绩">
									    </div>
									  </div>
									  <div class="form-group" style="text-align: center">
										<button class="btn btn-default" type="submit">提交</button>
										<button class="btn btn-default">重置</button>
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