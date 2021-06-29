<%@ page pageEncoding="UTF-8" %>
<div class="admin-header">
    <div class="container-fluid">
        <div class="pull-left">
            <h1 style="color: #FFFFFF;"><a style="color: white" href="index.jsp">教务管理系统</a></h1>
        </div>
        <div class="pull-right">
            <div class="admin-header-bar">
                <a href="login.html" onclick="return confirm('您确定要退出系统吗？');"><i class="glyphicon glyphicon-log-out"></i> 退出</a>
                <i class="vertical-separator"></i>
            </div>
            <div class="user">
                当前用户：<span class="label label-default">${user['userName']}</span>
            </div>
        </div>

    </div>
</div>