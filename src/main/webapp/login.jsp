<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/footer&cbl.css" />
		<link rel="stylesheet" href="css/daohang.css" />
		<script type="text/javascript" src="js/jquery-1.11.3.js" ></script>		
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/templet.js" ></script>
		<script type="text/javascript" src="js/hp.js" ></script>
		<title></title>
	</head>
	<body>
		<div id="main">
			<nav class=" navbar-inverse" id="daohang">
				<div class="daohang">
					<div class="navbar-header clearfix">
						<button type="button" class="zd" id="zd" >
							<span class="glyphicon glyphicon-align-justify"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="daohangtiao">
						<span class="close"><a href="index.jsp"><i></i></a></span>
					</div>						
				</div>
				<div id="box">
					<div class="box1 col-sm-2 col-xs-2">
						<span id="X" class="glyphicon glyphicon-remove pull-right" ></span>
					</div>
					<div class="box2 col-sm-10 col-xs-10" >
						<ul id="ul1"class="clearfix">
							<li><a href="index.jsp">首页</a></li>

						</ul>
						<div id="wd1">
							<ul>
								<li id="fanhui1"><a>返回上一级</a></li>

							</ul>
						</div>
						<div id="gy1" >
							<ul id="ul2">
								<li id="fanhui2"><a>返回上一级</a></li>

							</ul>
						</div>
						<div id="gc" >
							<ul >
								<li id="fanhui3"><a>返回上一级</a></li>

							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="main">	
			<div class="container">
				<div class="c2">
					<a href=""></a><span>
						<!-- <img src="img/qifeiye.png" /> -->
						<h1 style="color: #ffffff;">未来已来</h1>
					</span></a>
					<p>从这里开启学习之旅</p>	
				</div>
				<div class="c3" >
					<form action="/login.do" method="post">
						<div class="form-group">
    						<label for="usernameoremail">用户ID</label>
    						<input type="text" class="form-control" id="usernameoremail" name = "userID">
  						</div>
  						<div class="form-group">
    						<label for="password">密码</label>
    						<input type="password" class="form-control" id="password" name = "userPWD">
  						</div>
						<c:if test="${loginfail == 1}">
						  	<span style="margin-left: 10px;color: #FFFFFF;">用户名或密码错误</span>
						</c:if>
  						<!-- <div class="checkbox">
    						<label>
     		 					<input type="checkbox"> 记住我（请在私人计算机上使用此功能）
    						</label>
  						</div> -->
  						<div class="c3-1">
							<button id="denglu" type="submit" class="btn btn-default btn1">登录</button>  

						</div>
						<!-- <div class="c3-2 clearfix">
							<span class="c3-2-2">其他账号登录：</span>
							<div class="c3-2-1">
								<a href="" title="使用腾讯QQ登录"><span class="s1"></span></a>
								<a href="" title="使用微信登录"><span class="s2"></span></a>
								<a href="" title="使用谷歌登录"><span class="s3"></span></a>
								<a href="" title="使用脸书登录"><span class="s4"></span></a>
							</div>
						</div> -->

					</form>
				</div>
			</div>
		</div>
		<<!-- ul class="cbl" >
			<li><a href="#">
				<div class="icon d1"><i class="i1"></i><span class="title">在线客服</span></div>
			</a></li>
			<i class="clearfix"></i>
			<li><a href="#">
				<div class="icon d2"><i class="i2"></i><span class="title">4006285729</span></div>
			</a></li>
			<i class="clearfix"></i>
			<li><a  href="#">
				<div class="icon"><i class="i3"></i><span class="title">教程中心</span></div>
			</a></li>
			<i class="clearfix"></i>
			<li ><a  href="#">
				<div class="icon d4" data-toggle="tooltip" data-placement = "left" title="<img src='img/erweima.png'><br/> 关注微信 " data-html="true"><i class="i4"></i></div>
			</a></li>
		</ul> -->
		</div>
		
	</body>
	<script>
		loginfail = 0
	</script>
</html>
