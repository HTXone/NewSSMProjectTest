<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>EMPNO</th>
            <th>ENAME</th>
            <th>JOB</th>
            <th>SALARY</th>
        </tr>
       <c:forEach items="${ss}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.userName}</td>
                <td>${emp.PWD}</td>
                <td>${emp.role}</td>
            </tr>
       </c:forEach>
    </table>
</body>
</html>
