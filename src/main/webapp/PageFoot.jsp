<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="static/libs/bootstrap.addtabs/bootstrap.addtabs.css" rel="stylesheet">
<link href="static/css/theme/default.css" rel="stylesheet">
<link rel="stylesheet" href="static/css/font.css" />
<link rel="stylesheet" href="static/css/weadmin.css" />
<!--[if lt IE 9]>
<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


<div class="panel-footer">
    <c:if test="${pageInfo != null}">
        <nav style="text-align: center">
            <ul class="pagination">
                <li><a href="/StudentList.do?pageNo=${pageInfo.navigateFirstPage}">&laquo;第一页</a></li>
                <c:if test="${pageInfo.pageNum-2>0 }">
                    <li><a href="/StudentList.do?pageNo=${pageInfo.pageNum-2}">${pageInfo.pageNum-2}</a></li>
                </c:if>
                <c:if test="${pageInfo.hasPreviousPage }">
                    <li><a href="/StudentList.do?pageNo=${pageInfo.pageNum-1}">${pageInfo.pageNum-1}</a></li>
                </c:if>
                <li class="active"><a href="">${pageInfo.pageNum}</a></li>
                <c:if test="${pageInfo.hasNextPage }">
                    <li><a href="/StudentList.do?pageNo=${pageInfo.pageNum+1}">${pageInfo.pageNum+1}</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNum+2<pageInfo.pageSize }">
                    <li><a href="/StudentList.do?pageNo=${pageInfo.pageNum+2}">${pageInfo.pageNum+2}</a></li>
                </c:if>

                <li><a href="/StudentList.do?pageNo=${pageInfo.navigateLastPage}">最后一页&raquo;</a></li>
            </ul>
        </nav>
    </c:if>
</div>


<script src="lib/layui/layui.js" charset="utf-8"></script>
<script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="static/libs/bootstrap.addtabs/bootstrap.addtabs.js"></script>
<script src="static/js/admin_.js"></script>