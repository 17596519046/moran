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
        <input type="text" name="telphone" class="telphone" placeholder="手机号" autocomplete="off"/>
      </div>
      <div>
        <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
      </div>
      <button id="submit" type="button">登陆</button>
    </form>
  </div>
  <div id="reg">
    <h1>注册</h1>
    <form action="" method="post">
      <div>
        <input type="text" name="username1" class="username1" placeholder="名称" autocomplete="off"/>
      </div>
      <div>
        <input type="text" name="telphone1" class="telphone1" placeholder="手机号" autocomplete="off"/>
      </div>
      <div>
        <input type="password" name="password1" class="password1" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
      </div>
      <div>
        <input type="password" name="userCode1" class="userCode1" placeholder="学号/工号" oncontextmenu="return false" onpaste="return false" />
      </div>
      <button id="regsubmit" type="button">注册</button>
    </form>
  </div>
  <div style="margin:20px auto 0 auto;font-size: 14px;text-shadow: 0 1px 3px rgba(0,0,0,.2);">
    没有账号, <a id="toReg" style="color:blue;">去注册</a><a id="toSign" style="color:blue;">去登陆</a>
  </div>
  <div class="connect">
    <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
    <p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
  </div>
</div>
<div class="alert" style="display:none;border-radius:25px;">
  <div class="alert_con" style="border-radius:25px 25px 0 0;">
    <h2 style="border-radius:25px 25px 0 0;">提示</h2>
    <p id="ts"></p>
    <p id="ts1" style="line-height:30px"><a class="btn">确定</a></p>
  </div>
</div>

<script>
    $(".btn").click(function(){
        is_hide();
    })
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
    var reg = /^1(3[0-9]|5[1589]|7[013457]|8[6789])[0-9]{8}$/;//手机号正则
    // 登陆
    $("#submit").live('click',function(){
        var p = $("input[name=password]");
        var t = $("input[name=telphone]");
        if(t.val() == '' || p.val() ==''){
            $("#ts").html("用户名或密码不能为空~");
            is_show();
            return false;
        }else{
            //var reg = /^[0-9A-Za-z]+$/;字母和数字
            if(!reg.exec(t.val())){
                $("#ts").html("手机号错误");
                is_show();
                return false;
            }
            $.ajax({
                url:"/demo/UserLogin/login.do",
                data:{
                    telphone : t.val(),
                    password : p.val()
                },
                dataType: "json",
                type: 'POST',
                success:function(json) {
                    if(json.success) {
                        //$("#ts").html("登陆成功");
                        //is_show();
                        window.location.href= "/demo/home.do";
                        //return true;
                    } else {
                        $("#ts").html(json.msg);
                        is_show();
                        return false;
                    }
                }
            });
        }
    });
    // 注册
    $("#regsubmit").live('click',function(){
        var u = $("input[name=username1]");
        var p = $("input[name=password1]");
        var t = $("input[name=telphone1]");
        var code = $("input[name=userCode1]");
        if(u.val() == '' || p.val() == ''){
            $("#ts").html("用户名或密码不能为空~");
            is_show();
            return false;
        } else if(t.val() == ''){
            $("#ts").html("手机号不能为空~");
            is_show();
            return false;
        } else if (code.val() == '') {
            $("#ts").html("学号/工号不能为空~");
            is_show();
            return false;
        } else {
            if(!reg.exec(t.val())){
                $("#ts").html("请输入正确的手机号");
                is_show();
                return false;
            }
            $.ajax({
                url:"/demo/UserLogin/reg.do",
                data:{
                    telphone : t.val(),
                    password : p.val(),
                    name : u.val(),
                    phonecode : c.val(),
                    userCode : code.val(),
                },
                dataType: "json",
                type: 'POST',
                success:function(json) {
                    if(json.success) {
                        /* $("#ts").html(json.msg);
                        is_show();
                        return true; */
                        window.location.href= "/demo/home.do";
                    } else {
                        $("#ts").html(json.msg);
                        is_show();
                        return false;
                    }
                }
            });
        }
    });

    function is_hide(){
        $("#ts1").show();
        $(".alert").animate({"top":"-40%"}, 300)
    }
    function is_show(){
        $("#ts1").show();
        $(".alert").show().animate({"top":"45%"}, 300)
    }
    function is_hide1(){
        $("#ts1").hide();
        $(".alert").show().animate({"top":"45%"}, 300).fadeOut(2000);
    }

</script>
</body>
</html>
