<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生关系添加页面</title>
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
                <td style="width:150px;">信息编号</td>
                    <td>${user_institution_bindings.binding_id}</td>
            </tr>
            <tr>
                <td style="width:150px;">学生编号</td>
                    <td>${user_institution_bindings.student_id}</td>
            </tr>
            <tr>
                <td style="width:150px;">机构编号</td>
                    <td>${user_institution_bindings.org_id}</td>
            </tr>
            <tr>
                <td style="width:150px;">绑定时间</td>
                    <td>${user_institution_bindings.bind_date}</td>
            </tr>
        </tbody>
    </table>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
