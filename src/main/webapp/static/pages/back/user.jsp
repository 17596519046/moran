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
        font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
        font-size: 14px;
        line-height: 1.42857143;
    }
    .button {
        cursor: pointer;
        margin-top: 25px;
        margin-bottom: 10px;
        width: 100px;
        height: 25px;
        padding: 0;
        background: #ef4300;
        -moz-border-radius: 6px;
        -webkit-border-radius: 6px;
        border-radius: 6px;
        border: 0px;
        -moz-box-shadow:
                0 15px 30px 0 rgba(255,255,255,.25) inset,
                0 2px 7px 0 rgba(0,0,0,.2);
        -webkit-box-shadow:
                0 15px 30px 0 rgba(255,255,255,.25) inset,
                0 2px 7px 0 rgba(0,0,0,.2);
        box-shadow:
                0 15px 30px 0 rgba(255,255,255,.25) inset,
                0 2px 7px 0 rgba(0,0,0,.2);
        font-family: 'PT Sans', Helvetica, Arial, sans-serif;
        font-size: 14px;
        font-weight: 700;
        text-shadow: 0 1px 2px rgba(0,0,0,.1);
        -o-transition: all .2s;
        -moz-transition: all .2s;
        -webkit-transition: all .2s;
        -ms-transition: all .2s;
    }
    .button a{
        color: #ffffff;
    }
    td{border:solid #add9c0; border-width:0px 1px 1px 0px; padding:10px 0px; padding: 10px}
    table{border:solid #add9c0; border-width:1px 0px 0px 1px;}
</style>

<body>

<div>

    <button class="button"><a class="btn btn-default" href="../../static/pages/back/userinsert.jsp" role="button">添加管理员</a></button>

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
