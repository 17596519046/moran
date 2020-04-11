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
        margin: 0px;
        padding: 0px;
    }
</style>

<body>
<div>

    <form class="form-horizontal" action="/equipment/updateEquipment">
        <input type="hidden" name="id" value="${equipment.id }" />
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name" placeholder="名称" value="${equipment.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="buyTime" class="col-sm-2 control-label">购入时间</label>
            <div class="col-sm-10">
                <input type="text" name="buyTime" class="form-control" id="buyTime" placeholder="购入时间"  value="${equipment.buyTime}">
            </div>
        </div>
        <div class="form-group">
            <label for="number" class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" name="number" class="form-control" id="number" placeholder="编号"  value="${equipment.number}">
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
