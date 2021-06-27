<%@ page pageEncoding="UTF-8" %>


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
        <li>
            <a href="#" class="list-group-item-info" data-toggle="collapse" data-target="#perm">
                <i class="glyphicon glyphicon-info-sign"></i> 用户操作 <span class="pull-right glyphicon glyphicon-chevron-up"></span>
            </a>
            <ul class="list-group collapse" id="perm">
                <li class="list-group-item"><a href="javascript:void(0);" data-addtab="roles" url="/roles"><i class="glyphicon glyphicon-user"></i> 教授课程</a></li>
                <li class="list-group-item"><a href="javascript:void(0);" data-addtab="menus" url="/menus"><i class="glyphicon glyphicon-align-justify"></i> 选课管理</a></li>
                <li class="list-group-item"><a href="javascript:void(0);" data-addtab="permissions" url="/permissions"><i class="glyphicon glyphicon-lock"></i> 退课管理</a></li>
                <li class="list-group-item"><a href="javascript:void(0);" data-addtab="permissions" url="/permissions"><i class="glyphicon glyphicon-lock"></i> 成绩查看</a></li>
            </ul>
        </li>
        <li>
            <a href="#" class="list-group-item-info" data-toggle="collapse" data-target="#setting">
                <i class="glyphicon glyphicon-wrench"></i> 用户信息设置 <span class="pull-right glyphicon glyphicon-chevron-up"></span>
            </a>
            <ul class="list-group collapse" id="setting">
                <li class="list-group-item"><a href="javascript:void(0);" data-addtab="dict" url="/dict"><i class="glyphicon glyphicon-book"></i> 修改密码</a></li>
            </ul>
        </li>
    </ul>
</div>

