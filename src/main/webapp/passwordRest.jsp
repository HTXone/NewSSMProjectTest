<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>密码修改</title>
	<meta name="keywords" content="管理,后台,模板" />
	<meta name="description" content="管理系统模板" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	<!-- 顶栏 -->
	<jsp:include page="head.jsp"></jsp:include>

	<!-- 侧边菜单 -->
	<jsp:include page="side.jsp"></jsp:include>
	<!-- 中间主体 -->
	<div class="admin-body" id="tabs">
		<div class="weadmin-body">
			<div  id="content">
				<div class="row">

					<div class="col-md-10">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<h1 style="text-align: center;">修改密码</h1>
								</div>
							</div>
							<div class="panel-body">
								<form name="reset" class="form-horizontal" role="form" action="/PWDCharge.do" id="editfrom" method="post" onsubmit="return check()">
									<div class="form-group" hidden="hidden">
										<label for="inputEmail3" class="col-sm-2 control-label">UserID</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" name="UserID" id="inputEmail3" value="${user['id']}" >
										</div>
									</div>
									<div class="form-group">
										<label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="oldPassword" id="inputEmail3" placeholder="请输入旧密码" >
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
										<div class="col-sm-10">
											<input type="password" name="password1" class="form-control" id="inputPassword3" placeholder="请输入密码">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
										<div class="col-sm-10">
											<input type="password" name="password2" class="form-control" id="inputPassword3" placeholder="请再次输入密码">
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

	<div class="container" id="footer">
	<div class="row">
		<div class="col-md-12"></div>
	</div>
	</div>
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
	<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="static/libs/bootstrap.addtabs/bootstrap.addtabs.js"></script>
	<script src="static/js/admin_.js"></script>
</body>
<script>
    $("#nav li:nth-child(4)").addClass("active")
    function check() {
        if(reset.oldPassword.value==""||reset.oldPassword.value==null)
        {alert("请输入旧账户密码");return false;}
        if(reset.password1.value==""||reset.password1.value==null)
        {alert("请输入重置密码");return false;}
        if(reset.password2.value==""||reset.password2.value==null)
        {alert("请输入再次输入密码");return false;}
        if(reset.password1.value != reset.password2.value)
        {alert("两次密码不正确");return false;}
    }
</script>
</html>