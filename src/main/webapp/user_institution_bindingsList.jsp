<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 项目绝对路径-->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>学生关系列表页面</title>
    <!-- 引入css样式和js文件-->
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/layui/css/layui.css"/>
    <script type="text/javascript" src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-fluid">
    <!--引入导航条-->
    <jsp:include page="nav.jsp"></jsp:include>

    <form class="layui-form" action="User_institution_bindingsServlet?type=query" method="post" style="margin-top: 10px;">
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
                    <a href="User_institution_bindingsServlet?type=add" class="layui-btn layui-btn-blue"><i
                            class="layui-icon layui-icon-add-circle"></i> 添加
                    </a>
                </div>
            </div>
        </div>
    </form>

    <table class="layui-table">
        <tbody>
        <tr class="layui-bg-green">
            <th>信息编号</th>
            <th>学生编号</th>
            <th>机构编号</th>
            <th>绑定时间</th>
            <th>操作</th>
        </tr>


        <c:forEach items="${user_institution_bindingsList}" var="v">
            <tr>
                <td>${v.binding_id}</td>
                <td>${v.student_id}</td>
                <td>${v.org_id}</td>
                <td>${v.bind_date}</td>
                <td>
                    <a href="User_institution_bindingsServlet?type=edit&id=${v.binding_id}" class="layui-btn layui-btn layui-btn-sm">修改</a>
                    <a href="User_institution_bindingsServlet?type=delete&id=${v.binding_id}" class="layui-btn layui-btn-danger layui-btn-sm">删除</a>
                    <a href="User_institution_bindingsServlet?type=get&id=${v.binding_id}" class="layui-btn layui-btn-primary layui-btn-sm">详情</a>
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
