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

    <form class="layui-form" action="DegreesServlet?type=query" method="post" style="margin-top: 10px;">
        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-inline">
                <div class="layui-input-inline" style="">
                    <input type="text" class="layui-input dateIcon" name="keyword" id="keyword"
                           value="${keyword}"
                           placeholder="请输入学生编号搜索关键词"
                           style="width: 240px;">
                </div>
                <div class="layui-input-inline">
                    <button type="submit" class="layui-btn layui-btn-blue"><i
                            class="layui-icon layui-icon-search"></i> 搜索
                    </button>
                </div>
                <div class="layui-input-inline">
                    <a href="DegreesServlet?type=add" class="layui-btn layui-btn-blue"><i
                            class="layui-icon layui-icon-add-circle"></i> 添加
                    </a>
                </div>
            </div>
        </div>
    </form>

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
            <c:if test="${uid==v.org_id}">
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
            </c:if>
        </c:forEach>
        </tbody>
    </table>


    <!--引入版权区域-->
    <jsp:include page="foot.jsp"></jsp:include>

</div>


</body>
</html>
