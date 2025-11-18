<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户信息添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">
    <!--引入导航条-->
    <jsp:include page="nav.jsp"></jsp:include>

    <table class="layui-table">
        <tbody>
            <tr>
                <td style="width:150px;">用户编号</td>
                    <td>${userinfo.user_id}</td>
            </tr>
            <tr>
                <td style="width:150px;">用户名</td>
                    <td>${userinfo.username}</td>
            </tr>
            <tr>
                <td style="width:150px;">用户密码</td>
                    <td>${userinfo.password}</td>
            </tr>
            <tr>
                <td style="width:150px;">用户角色</td>
                    <td>${userinfo.role}</td>
            </tr>
            <tr>
                <td style="width:150px;">用户权限</td>
                    <td>${userinfo.permissions}</td>
            </tr>
            <tr>
                <td style="width:150px;">用户邮箱</td>
                    <td>${userinfo.email}</td>
            </tr>
            <tr>
                <td style="width:150px;">创建时间</td>
                    <td>${userinfo.created_at}</td>
            </tr>
        </tbody>
    </table>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
