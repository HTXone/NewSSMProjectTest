<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.TestSys.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<i class="glyphicon glyphicon-play admin-side-toggle"></i>

<div class="admin-side" style="background-color: #e4fbff;">
    <ul class="nav nav-pills nav-stacked remove-radius">
        <li class="active">
            <a href="#">
                <i class="glyphicon glyphicon-th-large"></i>
                系统菜单
                <i class="pull-right glyphicon glyphicon-align-justify" id="sideToggle"></i>
            </a>
        </li>
        <c:if test="${user['role']== 0}">
            <li>
                <!-- 分组菜单 -->
                <a href="#" class="list-group-item-info" data-toggle="collapse" data-target="#userAndOrg">
                    <i class="glyphicon glyphicon-th-large"></i> 人员组织 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                </a>
                <ul class="list-group collapse in" id="userAndOrg">
                    <li class="list-group-item"><a href="/StudentList.do"  ><i class="glyphicon glyphicon-user"></i> 学生管理</a></li>
                    <li class="list-group-item"><a href="/TeacherList.do"  ><i class="glyphicon glyphicon-inbox"></i> 教师管理</a></li>
                    <li class="list-group-item"><a href="/ClassesList.do"  ><i class="glyphicon glyphicon-road"></i> 课程管理</a></li>
                </ul>
            </li>
        </c:if>
        <c:if test="${user['role']> 0}">
            <li>
                <a href="#" class="list-group-item-info" data-toggle="collapse" data-target="#perm">
                    <i class="glyphicon glyphicon-info-sign"></i> 用户操作 <span class="pull-right glyphicon glyphicon-chevron-up"></span>
                </a>
                <ul class="list-group collapse" id="perm">
                    <c:if test="${user['role'] == 1}">
                        <li class="list-group-item"><a href="/TeacherClassesList.do?param=${user['id']}" data-addtab="roles" url="/roles"><i class="glyphicon glyphicon-user"></i> 教授课程</a></li>
                    </c:if>
                    <c:if test="${user['role'] == 2}">
                        <li class="list-group-item"><a href="/StudentsClassesList.do;" data-addtab="menus" url="/menus"><i class="glyphicon glyphicon-align-justify"></i> 选课管理</a></li>
                        <li class="list-group-item"><a href="/StudentSelectedClass.do?param=${user['id']}" data-addtab="permissions" url="/permissions"><i class="glyphicon glyphicon-lock"></i> 退课管理</a></li>
                        <li class="list-group-item"><a href="/StudentScore.do?param=${user['id']}" data-addtab="permissions" url="/permissions"><i class="glyphicon glyphicon-lock"></i> 成绩查看</a></li>
                    </c:if>
                </ul>
            </li>
        </c:if>
        <li>
            <a href="#" class="list-group-item-info" data-toggle="collapse" data-target="#setting">
                <i class="glyphicon glyphicon-wrench"></i> 用户信息设置 <span class="pull-right glyphicon glyphicon-chevron-up"></span>
            </a>
            <ul class="list-group collapse" id="setting">
                <li class="list-group-item"><a href="/passwordRest.jsp;" data-addtab="dict" url="/dict"><i class="glyphicon glyphicon-book"></i> 修改密码</a></li>
                <li class="list-group-item"><a href="/MessageList.do?param=${user['id']}" data-addtab="dict" url="/dict"><i class="glyphicon glyphicon-book"></i> 收件箱</a></li>
                <li class="list-group-item"><a href="/SendMessageList.do?param=${user['id']}" data-addtab="dict" url="/dict"><i class="glyphicon glyphicon-book"></i> 发件箱</a></li>
            </ul>
        </li>
    </ul>
</div>

