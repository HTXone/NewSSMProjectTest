<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel-footer">
    <c:if test="${pageInfo != null}">
        <nav style="text-align: center">
            <ul class="pagination">
                <li><a href="${PageUrl}?pageNo=${pageInfo.navigateFirstPage}&param=${param1}">&laquo;第一页</a></li>
                <c:if test="${pageInfo.pageNum-2>0 }">
                    <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-2}&param=${param1}">${pageInfo.pageNum-2}</a></li>
                </c:if>
                <c:if test="${pageInfo.hasPreviousPage }">
                    <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum-1}&param=${param1}">${pageInfo.pageNum-1}</a></li>
                </c:if>
                <li class="active"><a href="">${pageInfo.pageNum}</a></li>
                <c:if test="${pageInfo.hasNextPage }">
                    <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+1}&param=${param1}">${pageInfo.pageNum+1}</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNum+2<=pageInfo.pages}">
                    <li><a href="${PageUrl}?pageNo=${pageInfo.pageNum+2}&param=${param1}">${pageInfo.pageNum+2}</a></li>
                </c:if>

                <li><a href="${PageUrl}?pageNo=${pageInfo.navigateLastPage}&param=${param1}">最后一页&raquo;</a></li>
            </ul>
        </nav>
    </c:if>
</div>