<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>

<body>

<div style="width: 99%; height: 100px; background: #4C84FF; margin: auto">
    <img src="../../img/image/backhome.jpg" width="100%" height="100px"/>
</div>

<div style="padding: 5px;">
    <div id="sidebar" class="sidebar py-3" style="width: 20%; float: left">
        <div class="list-group" style="text-align: center">
            <c:if test="${User.role == 1 || User.role == 4}">
                <a href="/back/user" target="right" class="list-group-item" >用户管理</a>
                <a href="/equipment/equipment" target="right" class="list-group-item" >设备管理</a>
                <a href="/laboratory/laboratory" target="right" class="list-group-item" >实验室管理</a>
                <a href="/equipment/getEquipmentappiont" target="right" class="list-group-item" >设备详情</a>
                <a href="/laboratory/getlaboratoryappiont" target="right" class="list-group-item" >实验室详情</a>
                <a href="/equipment/selectEquipmentUserInfo" target="right" class="list-group-item" >设备审核</a>
                <a href="/laboratory/selectLaboratoryUserInfo" target="right" class="list-group-item" >实验室审核</a>
            </c:if>

            <c:if test="${User.role == 2 || User.role == 3}">
                <a href="/equipment/equipment" target="right" class="list-group-item" >设备详情</a>
                <a href="/laboratory/laboratory" target="right" class="list-group-item" >实验室管理</a>
                <a href="/equipment/getMyEquipment" target="right" class="list-group-item" >我的设备</a>
                <a href="/laboratory/getMylaboratory" target="right" class="list-group-item" >我的实验室</a>
            </c:if>

        </div>
    </div>
    <div class="sidebar py-3" style="width: 79%; float: right">
        <div class="embed-responsive embed-responsive-4by3">
            <c:if test="${User.role == 1 || User.role == 4}"><iframe id="aa" name="right" class="embed-responsive-item" src="/back/user"></iframe></c:if>
            <c:if test="${User.role == 2 || User.role == 3}"><iframe id="aa" name="right" class="embed-responsive-item" src="/equipment/equipment"></iframe></c:if>
        </div>
    </div>
</div>

</body>

</html>
