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
            <td>设备编号</td>
            <td>预约人</td>
            <td>工号</td>
            <td>手机号</td>
            <td>预约时间</td>
            <td>归还时间</td>
            <td>状态</td>
        </tr>

        <c:forEach items="${all }" var="all">

            <tr>
                <td>${all.code}</td>
                <td>${all.name}</td>
                <td>${all.number}</td>
                <td>${all.userName}</td>
                <td>${all.userNumber}</td>
                <td>${all.userPhone}</td>
                <td>${all.appointTime}</td>
                <td>${all.returnTime}</td>
                <td><c:if test="${all.state == 1}">通过</c:if>
                    <c:if test="${all.state == 2}">拒绝</c:if>
                    <c:if test="${all.state == 3}">已归还</c:if>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>

</body>

</html>
