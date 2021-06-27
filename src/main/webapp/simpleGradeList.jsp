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
                                    <h1 class="col-md-5">已选该课程学生名单</h1>
                                </div>
                            </div>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>学号</th>
                                    <th>姓名</th>
                                    <th>分数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${selectedCourseList}" var="item">
                                    <tr>
                                        <td>${item.studentID}</td>
                                        <td>${item.userName}</td>
                                        <c:if test="${!item.over}">
                                            <td>未打分</td>
                                            <td>
                                                <button class="btn btn-default btn-xs btn-info" onclick="location.href='/mark.do?courseID = ${courseID},studentID = ${item.studentID},studentName = ${item.studentName}}'">打分</button>
                                            </td>
                                        </c:if>
                                        <c:if test="${item.over}">
                                            <td>${item.mark}</td>
                                            <td>已打分</td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="panel-footer">
                                <c:if test="${pageInfo != null}">
                                    <nav style="text-align: center">
                                        <ul class="pagination">
                                            <li><a href="${PageUrl}?pageNo=${pageInfo.navigateFirstPage}">&laquo;第一页</a></li>
                                            <c:if test="${pageInfo.pageNum-2>0 }">
                                                <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-2}">${pageInfo.pageNum-2}</a></li>
                                            </c:if>
                                            <c:if test="${pageInfo.hasPreviousPage }">
                                                <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-1}">${pageInfo.pageNum-1}</a></li>
                                            </c:if>
                                            <li class="active"><a href="">${pageInfo.pageNum}</a></li>
                                            <c:if test="${pageInfo.hasNextPage }">
                                                <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+1}">${pageInfo.pageNum+1}</a></li>
                                            </c:if>
                                            <c:if test="${pageInfo.pageNum+2<=pageInfo.pageSize }">
                                                <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+2}">${pageInfo.pageNum+2}</a></li>
                                            </c:if>

                                            <li><a href="${PageUrl}?pageNo=${pageInfo.navigateLastPage}">最后一页&raquo;</a></li>
                                        </ul>
                                    </nav>
                                </c:if>
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