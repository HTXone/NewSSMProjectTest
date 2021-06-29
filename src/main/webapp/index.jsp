<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.TestSys.entity.User" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/daohang.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/footer&cbl.css" />
		<script type="text/javascript" src="js/jquery-1.11.3.js" ></script>		
		<script type="text/javascript" src="js/bootstrap.js" ></script>
    	<script type="text/javascript" src="js/index.js"></script>		
		<script type="text/javascript" src="js/templet.js" ></script>
		<script type="text/javascript" src="js/hp.js" ></script>
		<title></title>

	</head>
	<body>
	<div id="main">
		<header id="header" data-spy="affix" data-offset-top="70">
			<nav class="navbar-inverse" id="daohang">
				<div class="daohang">
					<div class="navbar-header clearfix">
						<button type="button" class="zd" id="zd" >
							<span class="glyphicon glyphicon-align-justify"></span>
						</button>
						<a href="#" class="navbar-brand"><img src="img/qifeiye.png"/></a>
					</div>
					<div class="collapse navbar-collapse" id="daohangtiao">
						<ul class="nav navbar-nav">
							<li><a href="/StudentList.do">管理员</a></li>
							<li><a href="/TeacherClassesList.do?param=${user['id']}">教师</a></li>
							<li><a href="/simpleStudentIndex.jsp">学生</a></li>
							<li><a href="/StudentSelectedClass.do?studentID=10001">退课</a></li>
							<li ><a href="/ScoreList.do">打分</a></li>
							<li class="gy1"><a href="">${user}</a>

							</li>
								
						</ul>
						<ul class="zcdl nav navbar-nav pull-right">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.html">注册</a></li>
						</ul>
					</div>					
				</div>
				<div id="box">
					<div class="box1 col-sm-2 col-xs-2">
						<span id="X" class="glyphicon glyphicon-remove pull-right" ></span>
					</div>

				</div>
			</nav>
		</header>
		<div class="c">
			    <img class="img" src="img/child.jpg"/>
				<div class="video">
					<video autoplay="autoplay" muted="muted" loop="loop">
						<source type="video/webm" src="video/video1.webm"></source>
						<source type="video/mp4" src="video/video1.mp4"></source>
					</video>
				</div>
				<div class="cover">
					<div class="container  cc2">
						<div class="cover2" >
							<div class="co2-1">
								<p>自己做网站</p>
								<p>简单又省钱</p>
							</div>
							<div class="co2-2">
								<span>引领「响应式自助建站」潮流，每一套模板都是艺术品</span>
							</div>
							<a class="co2-3" href="" >免 费 创 建 账 户</a>
						</div>
					</div>
					<div class="container cc1">
						<div class="cover1 col-lg-6 col-md-6 pull-right" >
							<div class="co1 hide" id="con">
								<!--<p>做一个响应式网站</p>
								<p>让世界更好的了解您</p>-->
								<span>做一个响应式网站<br>让世界更好的了解您</span>
							</div>
							<div class="co1" id="show"></div>
							<div class="co2" >
								<p>真「响应式」自助建站平台</p>
								<p>艺术品级模板 引领自助建站潮流</p>
							</div>
							<a class="co3" href="" >免 费 创 建 账 户</a>
						</div>
					</div>
					<div class="container cc1">
						<div class="coverA"><a href="">
							<i class="glyphicon glyphicon-chevron-down"></i>
						</a></div>
					</div>
				</div>			
			</div>


	
	</div>
	</body>

	<script type="text/javascript">
		console.log("参数",'${user}');
	</script>
	
</html>
