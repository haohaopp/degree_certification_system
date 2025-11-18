<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>系统登录界面</title>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css"/>
    <script src="${ctx}/static/layui/layui.js"></script>
</head>
<body>
<%--判断是否有错误消息--%>
<c:if test="${msg!=null}">
    <script>
        alert("${msg}");
    </script>
</c:if>

<div style="width: 600px;margin: 50px auto;border: 2px #ccc solid;border-radius:10px;padding: 50px;background: rgba(255,255,255,0.9) ">
    <h1 style="text-align: center;">系统登录界面</h1>
    <br>
    <br>
    <br>
    <form name="addForm" class="layui-form" action="LoginServlet" method="post" style="padding-right: 80px;">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" value="admin"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登录密码</label>
            <div class="layui-input-block">
                <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" value="123456"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登录角色</label>
            <div class="layui-input-block">
                <input type="radio" name="role" value="学生" title="学生">
                <input type="radio" name="role" value="管理员" title="管理员" checked>
                <input type="radio" name="role" value="企业" title="企业">
                <input type="radio" name="role" value="教育机构" title="教育机构">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">立即提交</button>
                <a class="layui-btn  layui-btn-primary" href="register.jsp">点我注册</a>
            </div>
        </div>
    </form>
</div>


<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('form', function () {
        var form = layui.form;

        //…
    });
</script>

<style>
    body {
        background: url('static/bg4.jpg');
        background-repeat: no-repeat;
        background-size: 100% 100%;
        background-attachment: fixed;
    }

</style>
</body>
</html>
