<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学位证书添加页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">
    <!--引入导航条-->
    <jsp:include page="nav.jsp"></jsp:include>

    <div class="layui-container">
        <div class="layui-row" style="margin: 20px;">
            <div class="layui-col-md4" style="text-align: center;">
                <img src="static/${codeImg}" height="220" width="220" class="img-responsive img-rounded "
                     style="display: inline-block;padding: 8px;border: 2px solid red; border-radius: 8px;"/>
                <h3 style="text-align: center;color: red">扫我查看证书溯源</h3>
            </div>
            <div class="layui-col-md8">
                <table class="layui-table">
                    <tbody>
                    <tr>
                        <td style="width:150px;">证书编号</td>
                        <td>${degrees.degree_id}</td>
                    </tr>
                    <tr>
                        <td style="width:150px;">学生姓名</td>
                        <td>${degrees.userUser.username} 邮箱：${degrees.userUser.email}</td>
                    </tr>
                    <tr>
                        <td style="width:150px;">机构名称</td>
                        <td>${degrees.orgUser.org_name} 【${degrees.orgUser.org_type}】 电话：${degrees.orgUser.contact_phone}</td>
                    </tr>
                    <tr>
                        <td style="width:150px;">学位名称</td>
                        <td>${degrees.degree_name}</td>
                    </tr>
                    <tr>
                        <td style="width:150px;">颁发日期</td>
                        <td>${degrees.issue_date}</td>
                    </tr>
                    <tr>
                        <td style="width:150px;">证书状态</td>
                        <td>${degrees.status}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
