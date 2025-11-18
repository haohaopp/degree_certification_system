<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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

    <form class="layui-form layui-form-pane" action="OrganizationsServlet?type=save" method="post" style="margin: 50px auto;">
        <div class="layui-form-item">
            <label class="layui-form-label">机构编号</label>
            <div class="layui-input-block">
                <input type="text" name="org_id" id="org_id" value="<%=new String(String.valueOf(System.currentTimeMillis())).substring(5)%>" lay-verify autocomplete="off"
                       placeholder="请输入机构编号"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">机构名称</label>
            <div class="layui-input-block">
                <input type="text" name="org_name" id="org_name" value="" lay-verify autocomplete="off"
                       placeholder="请输入机构名称"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">机构类型</label>
            <div class="layui-input-block">
                <input type="text" name="org_type" id="org_type" value="" lay-verify autocomplete="off"
                       placeholder="请输入机构类型"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="contact_email" id="contact_email" value="" lay-verify autocomplete="off"
                       placeholder="请输入联系邮箱"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="contact_phone" id="contact_phone" value="" lay-verify autocomplete="off"
                       placeholder="请输入联系电话"
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
