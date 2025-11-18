<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学位证书列表页面</title>
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
            <th>证书编号</th>
            <th>学生编号</th>
            <th>学生姓名</th>
            <th>机构编号</th>
            <th>颁发机构</th>
            <th>学位名称</th>
            <th>颁发日期</th>
            <th>证书状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${degreesList}" var="v">
            <tr>
                <td>${v.degree_id}</td>
                <td>${v.student_id}</td>
                <td>${v.userUser.username}</td>
                <td>${v.org_id}</td>
                <td>${v.orgUser.org_name}</td>
                <td>${v.degree_name}</td>
                <td>${v.issue_date}</td>
                <td>${v.status}</td>
                <td>
                    <a href="DegreesServlet?type=get&id=${v.degree_id}" class="layui-btn layui-btn-primary layui-btn-sm">详情</a>
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
