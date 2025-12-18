<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>用户信息列表页面</title>
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
        <tr class="layui-bg-green">
            <th>用户编号</th>
            <th>用户名</th>
            <th>用户角色</th>
            <th>用户邮箱</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${userinfoList}" var="v">
            <tr>
                <td>${v.user_id}</td>
                <td>${v.username}</td>
                <td>${v.role}</td>
                <td>${v.email}</td>
                <td>${v.created_at}</td>
                <td style="width: 180px;">
                    <a href="degreesAdd.jsp?sid=${v.user_id}&oid=${sessionScope.loginUser.user_id}" class="layui-btn layui-btn-danger layui-btn-sm">颁发证书</a>
                    <a href="UserinfoServlet?type=get&id=${v.user_id}" class="layui-btn layui-btn-primary layui-btn-sm">详情</a>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
