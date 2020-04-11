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

    <c:if test="${User.role == 1 || User.role == 4}"><a class="btn btn-default" href="../../static/pages/back/equipmentinsert.jsp" role="button">添加设备</a></c:if>

    <table>
        <tr>
            <td>名称</td>
            <td>购入时间</td>
            <td>设备编号</td>
            <c:if test="${User.role == 1 || User.role == 4}"><td>使用人姓名</td></c:if>
            <c:if test="${User.role == 1 || User.role == 4}"><td>使用人工号</td></c:if>
            <td>是否预约</td>
        </tr>

        <c:forEach items="${all }" var="all">

            <tr>
                <td>${all.name}</td>
                <td>${all.buyTime}</td>
                <td>${all.number}</td>
                <c:if test="${User.role == 1 || User.role == 4}"><td>${all.userName}</td></c:if>
                <c:if test="${User.role == 1 || User.role == 4}"><td>${all.userNumber}</td></c:if>
                <td><c:if test="${all.isAppointment == 1}">已预约</c:if><c:if test="${all.isAppointment == 0}">未预约</c:if><c:if test="${all.isAppointment == 2}">使用中</c:if></td>
                <td>
                    <c:if test="${User.role == 1 || User.role == 4}"><a href="/equipment/getEquipment?id=${all.id }">修改</a></c:if>
                    <c:if test="${User.role == 1 || User.role == 4}"><a href="/equipment/deleteEquipment?id=${all.id }">删除</a></c:if>
                    <c:if test="${User.role == 3 || User.role == 2}"><a href="/equipment/insertUserEquipment?id=${all.id }">预约</a></c:if>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>

</body>

</html>
