<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>后台管理</title>
  <!-- CSS -->
  <link rel="stylesheet" href="${ctx}/static/css/reset.css">
  <link rel="stylesheet" href="${ctx}/static/css/supersized.css">
  <link rel="stylesheet" href="${ctx}/static/css/style.css">
  <!-- Javascript -->
  <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
</head>
<style>
  body{
    background: #B3C0D1;
  }
</style>
<body oncontextmenu="return false">

<div class="page-container">
  <div id="login">
    <h1>登陆</h1>
    <form action="" method="post">
      <div>
        <input type="text" name="phone" class="phone" placeholder="手机号" autocomplete="off"/>
      </div>
      <div>
        <input type="text" name="number" class="number" placeholder="工号/学号" oncontextmenu="return false" onpaste="return false" />
      </div>
      <button id="submit" type="button">登陆</button>
    </form>
  </div>
  <div id="reg">
    <h1>注册</h1>
    <form action="" method="post">
      <div>
        <input type="text" name="name1" class="name1" placeholder="姓名" autocomplete="off"/>
      </div>
      <div>
        <input type="text" name="number1" class="number1" placeholder="工号/学号" autocomplete="off"/>
      </div>
      <div>
        <input type="text" name="phone1" class="phone1" placeholder="手机号" autocomplete="off"/>
      </div>
      <div>身份
        <select name="role1">
          <option name="role1" value="3">学生</option>
          <option name="role1" value="2">老师</option>
        </select>
      </div>
      <button id="regsubmit" type="button">注册</button>
    </form>
  </div>
  <div style="margin:20px auto 0 auto;font-size: 14px;text-shadow: 0 1px 3px rgba(0,0,0,.2);">
    没有账号, <a id="toReg" style="color:blue;">去注册</a><a id="toSign" style="color:blue;">去登陆</a>
  </div>
</div>

<script>
    $(document).ready(function(){
        $("#reg").hide();
        $("#login").show();
        $("#toSign").hide();
        $("#toReg").show();
    });
    $("#toReg").click(function(){
        $("#login").hide();
        $("#reg").show();
        $("#toSign").show();
        $("#toReg").hide();
    });
    $("#toSign").click(function(){
        $("#login").show();
        $("#reg").hide();
        $("#toSign").hide();
        $("#toReg").show();
    });
    // 注册
    $("#regsubmit").live('click',function(){
        var p = $("input[name=phone1]");
        var n = $("input[name=number1]");
        var name = $("input[name=name1]");
        var role = $("select[name=role1]");
        $.ajax({
            url:"/back/updateUser.do",
            data:{
                name : name.val(),
                number : n.val(),
                phone : p.val(),
                id : 0,
                role : role.val(),
            },
            dataType: "json",
            type: 'POST',
            success:function(json) {
                // if(json.success) {
                window.location.href= "/back/index.do";
                // } else {
                //     alert(json.msg);
                //     return false;
                // }
            }
        });
    });

    // 登陆
    $("#submit").live('click',function(){
        var p = $("input[name=phone]");
        var n = $("input[name=number]");
        if(n.val() == '' || p.val() ==''){
            alert("工号，手机号不能为空");
            return false;
        }else{
            $.ajax({
                url:"/back/toLogin.do",
                data:{
                    number : n.val(),
                    phone : p.val()
                },
                dataType: "json",
                type: 'POST',
                success:function(json) {
                    if(json.success) {
                        window.location.href= "/back/index.do";
                    } else {
                        alert("手机号，工号错误");
                        return false;
                    }
                }
            });
        }
    });


</script>
</body>
</html>
