<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>机构企业添加页面</title>
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
                <td style="width:150px;">机构编号</td>
                    <td>${organizations.org_id}</td>
            </tr>
            <tr>
                <td style="width:150px;">机构名称</td>
                    <td>${organizations.org_name}</td>
            </tr>
            <tr>
                <td style="width:150px;">机构类型</td>
                    <td>${organizations.org_type}</td>
            </tr>
            <tr>
                <td style="width:150px;">联系邮箱</td>
                    <td>${organizations.contact_email}</td>
            </tr>
            <tr>
                <td style="width:150px;">联系电话</td>
                    <td>${organizations.contact_phone}</td>
            </tr>
        </tbody>
    </table>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
