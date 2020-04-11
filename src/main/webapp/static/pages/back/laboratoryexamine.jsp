<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
</head>


<style>
    body {
        margin: 0px;
        padding: 0px;
    }
</style>

<body>

<div>

    <table>
        <tr>
            <td>预约编号</td>
            <td>名称</td>
            <td>楼号</td>
            <td>预约时间</td>
            <td>预约人</td>
            <td>工号</td>
            <td>归还时间</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${laboratoryList }" var="all">

            <tr>
                <td>${all.code}</td>
                <td>${all.name}</td>
                <td>${all.buildingNo}</td>
                <td>${all.appointTime}</td>
                <td>${all.userName}</td>
                <td>${all.userNumber}</td>
                <td>${all.returnTime}</td>
                <td>
                    <a href="/laboratory/appointmentLaboratory?id=${all.id }&state=1">通过</a>
                    <a href="/laboratory/appointmentLaboratory?id=${all.id }&state=2">拒绝</a>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>

</body>

</html>
