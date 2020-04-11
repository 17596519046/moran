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

    <a class="btn btn-default" href="../../static/pages/back/userinsert.jsp" role="button">添加管理员</a>

    <table>
        <tr>
            <td>姓名</td>
            <td>工号/学号</td>
            <td>手机号</td>
            <td>班级</td>
            <td>入学时间</td>
            <td>毕业时间</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${all }" var="all">

            <tr>
                <td>${all.name}</td>
                <td>${all.number}</td>
                <td>${all.phone}</td>
                <td>${all.grade}</td>
                <td>${all.entranceTime1}</td>
                <td>${all.graduateTime1}</td>
                <td>${all.createTime1}</td>
                <td>
                    <a href="/back/getUserId?userId=${all.id }">修改</a>
                    <a href="/back/removeUser?userId=${all.id }">删除</a>
                </td>
            </tr>

        </c:forEach>


    </table>
</div>

</body>

</html>
