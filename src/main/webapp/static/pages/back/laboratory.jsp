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

    <a class="btn btn-default" href="../../static/pages/back/laboratoryinsert.jsp" role="button">添加设备</a>

    <table>
        <tr>
            <td>名称</td>
            <td>楼号</td>
            <td>创建时间</td>
            <td>使用人姓名</td>
            <td>使用人工号</td>
            <td>是否预约</td>
        </tr>

        <c:forEach items="${all }" var="all">

            <tr>
                <td>${all.name}</td>
                <td>${all.buildingNo}</td>
                <td>${all.createTime1}</td>
                <td>${all.userName}</td>
                <td>${all.userNumber}</td>
                <td><c:if test="${all.isAppointment == 1}">已预约</c:if><c:if test="${all.isAppointment == 0}">未预约</c:if></td>
                <td>
                    <a href="/laboratory/getLaboratory?id=${all.id }">修改</a>
                    <a href="/laboratory/deleteLaboratory?id=${all.id }">删除</a>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>

</body>

</html>
