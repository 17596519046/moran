<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>


<style>
    body {
        margin: 20px 0 0 0;
        padding: 0px;
        font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
        font-size: 14px;
        line-height: 1.42857143;
    }
</style>

<body>
<div>

    <form class="form-horizontal" action="/back/updateUser">
        <input type="hidden" name="id" value="${user.id }" />
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input style="width: 30%" type="text" name="name" class="form-control" id="name" placeholder="姓名" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="number" class="col-sm-2 control-label">工号/学号</label>
            <div class="col-sm-10">
                <input style="width: 30%" type="text" name="number" class="form-control" id="number" placeholder="工号/学号"  value="${user.number}">
            </div>
        </div>
        <div class="form-group">
            <label for="grade" class="col-sm-2 control-label">班级</label>
            <div class="col-sm-10">
                <input style="width: 30%" type="text" name="grade" class="form-control" id="grade" placeholder="班级" value="${user.grade}">
            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">手机号</label>
            <div class="col-sm-10">
                <input style="width: 30%" type="text" name="phone" class="form-control" id="phone" placeholder="手机号" value="${user.phone}">
            </div>
        </div>
        <div class="form-group">
            <label for="entranceTime1" class="col-sm-2 control-label">入学时间</label>
            <div class="col-sm-10">
                <input style="width: 30%" name="entranceTime1" id="entranceTime1" class="form-control"  type="date" value="${user.entranceTime1}" />
            </div>
        </div>
        <div class="form-group">
            <label for="graduateTime1" class="col-sm-2 control-label">毕业时间</label>
            <div class="col-sm-10">
                <input style="width: 30%" name="graduateTime1" id="graduateTime1" class="form-control"  type="date" value="${user.graduateTime1}" />
            </div>
        </div>
        <div class="form-group">
            <label for="role1" class="col-sm-2 control-label">角色</label>
            <div class="col-sm-10">
                <label class="checkbox-inline">
                    <input type="radio" name="role" id="role1" value="1" <c:if test="${user.role==1 }">checked="checked"</c:if> > 管理员
                </label>
                <label class="checkbox-inline">
                    <input type="radio" name="role" id="role2" value="2" <c:if test="${user.role==2 }">checked="checked"</c:if> > 老师
                </label>
                <label class="checkbox-inline">
                    <input type="radio" name="role" id="role3" value="3" <c:if test="${user.role==3 }">checked="checked"</c:if> > 学生
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>
