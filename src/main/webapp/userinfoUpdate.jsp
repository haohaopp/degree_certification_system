<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%--获取当前时间--%>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
<fmt:formatDate var="nowTime" value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
<html>
<head>
    <title>用户信息修改页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">
    <!--引入导航条-->
    <jsp:include page="nav.jsp"></jsp:include>

    <form class="layui-form layui-form-pane" action="UserinfoServlet?type=update" method="post" style="margin: 50px auto;">
        <div class="layui-form-item">
            <label class="layui-form-label">用户编号</label>
            <div class="layui-input-block">
                <input type="text" name="user_id" readonly id="user_id"   value="${userinfo.user_id}" lay-verify autocomplete="off"
                       placeholder="请输入用户编号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username"  id="username"   value="${userinfo.username}" lay-verify autocomplete="off"
                       placeholder="请输入用户名"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-block">
                <input type="text" name="password"  id="password"   value="${userinfo.password}" lay-verify autocomplete="off"
                       placeholder="请输入用户密码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户角色</label>
            <div class="layui-input-block">
                <input type="text" name="role"  id="role"   value="${userinfo.role}" lay-verify autocomplete="off"
                       placeholder="请输入用户角色"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户权限</label>
            <div class="layui-input-block">
                <input type="text" name="permissions"  id="permissions"   value="${userinfo.permissions}" lay-verify autocomplete="off"
                       placeholder="请输入用户权限"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email"  id="email"   value="${userinfo.email}" lay-verify autocomplete="off"
                       placeholder="请输入用户邮箱"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建时间</label>
            <div class="layui-input-block">
                <input type="text" name="created_at"  id="created_at"   value="${userinfo.created_at}" lay-verify autocomplete="off"
                       placeholder="请输入创建时间"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>


</div>



</body>
</html>
