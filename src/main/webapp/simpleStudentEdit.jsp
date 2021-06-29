<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.TestSys.entity.Student" %>
<%@ page import="java.util.*" %>



<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>学生管理</title>
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
    <jsp:include page="head.jsp"></jsp:include>
    <!-- 侧边菜单 -->
    <jsp:include page="side.jsp"></jsp:include>
    <div class="admin-body" id="tabs">
		<div class="weadmin-body">
			
			<div  id="content">
				<div class="row">

					<div class="col-md-10">
						<div class="panel panel-default">
						    <div class="panel-heading">
								<div class="row">
							    	<h1 style="text-align: center;">修改学生信息</h1>
								</div>
						    </div>
						    <div class="panel-body">
								<form class="form-horizontal" role="form" action="/EditStudent.do" id="editfrom" method="post">
									  <div class="form-group ">
									    <label for="inputEmail3" class="col-sm-2 control-label" >学号</label>
									    <div class="col-sm-10">
									      <input readonly="readonly" type="number" class="form-control" id="inputEmail3" name="userID" placeholder="请输入学号"
										  <c:if test='${student!=null}'>
												 value="${student.userID}"
										  </c:if>>
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
									    <div class="col-sm-10">
									      <input type="text" class="form-control" id="inputPassword3" name="userName" placeholder="请输入姓名" value="${student.userName}">
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
									    <div class="col-sm-10" >
                                            <div class="col-sm-10">
                                                <input type="date" value="<fmt:formatDate value="${student.birthYear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthYear"/>
                                            </div>
                                        </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">入学时间</label>
									    <div class="col-sm-10" >
                                            <div class="col-sm-10">
                                                <input type="date" value="<fmt:formatDate value="${student.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/>
                                            </div>
									    </div>
									  </div>
									  <div class="form-group">
									    <label for="inputPassword3" class="col-sm-2 control-label" name="grade">所属院系</label>
									    <div class="col-sm-10">
										    <select class="form-control" name="collegeID" id="college">
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
	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="static/libs/bootstrap.addtabs/bootstrap.addtabs.js"></script>
    <script src="static/js/admin_.js"></script>
</body>
<script type="text/javascript">
    $("#nav li:nth-child(2)").addClass("active")

    var collegeSelect = $("#college option");
    for (var i=0; i<collegeSelect.length; i++) {
        if (collegeSelect[i].value == '${student.collegeID}') {
            collegeSelect[i].selected = true;
        }
    }


    $(function () {

        $('#datetimepicker1').datetimepicker({
            format: 'YYYY/MM/DD',
            locale: moment.locale('zh-cn'),
            defaultDate: "2020-02-08",

        });

        $('#datetimepicker2').datetimepicker({
            format: 'YYYY/MM/DD',
            locale: moment.locale('zh-cn')

        });

    });



</script>

</html>