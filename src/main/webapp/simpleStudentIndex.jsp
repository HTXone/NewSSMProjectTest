<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>管理系统模板</title>
        <meta Name="keywords" content="管理,后台,模板" />
        <meta Name="description" content="管理系统模板" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta Name="viewport" content="width=device-width, initial-scale=1">
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
    <jsp:include page="side.jsp"></jsp:include><div class="admin-body" id="tabs">
        <div class="weadmin-body">
            <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
            <blockquote class="layui-elem-quote">
                欢迎：${user['userName']}

            </blockquote>
            <div id="main" style="width: 100%;height:400px;"></div>
            <blockquote class="layui-elem-quote">
                平均分：${StudentCount[3]}
            </blockquote>
        </div></div>
        <script src="echart/echarts.min.js"></script>
        <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;

        option = {
            title: {
                text: '成绩统计表',
                subtext: '/////',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
            },
            series: [
                {
                    name: '已修学分',
                    type: 'pie',
                    radius: '50%',
                    data: [
                        {value: ${StudentCount[0]}, name: '必修课'},
                        {value: ${StudentCount[1]}, name: '选修课'},
                        {value: ${StudentCount[2]}, name: '公共课'},

                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        option && myChart.setOption(option);
    </script>
    </body>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script src="static/js/eleDel.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="static/libs/bootstrap.addtabs/bootstrap.addtabs.js"></script>
    <script src="static/js/admin_.js"></script>
</html>