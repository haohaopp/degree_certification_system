<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ul class="layui-nav layui-bg-green" lay-filter="">
    <li class="layui-nav-item"><a href="#">基于区块链fabric的学位认证系统</a></li>
    <c:if test="${sessionScope.loginUser.username==null}">
        <li class="layui-nav-item"><a href="${ctx}/login.jsp">用户登陆</a></li>
        <li class="layui-nav-item"><a href="${ctx}/register.jsp">用户注册</a></li>
    </c:if>
    <c:if test="${sessionScope.loginUser.username!=null}">
        <%--判断是否是管理员--%>
        <c:if test="${sessionScope.loginUser.role=='管理员'}">
            <li class="layui-nav-item"><a href="${ctx}/UserinfoServlet?type=query">用户管理</a></li>
            <li class="layui-nav-item"><a href="${ctx}/DegreesServlet?type=query">学位证书管理</a></li>
            <li class="layui-nav-item"><a href="${ctx}/OrganizationsServlet?type=query">机构企业管理</a></li>
            <li class="layui-nav-item"><a href="${ctx}/User_institution_bindingsServlet?type=query">学生关系管理</a></li>
            <li class="layui-nav-item"><a href="${ctx}/DegreesServlet?type=show">区块查询</a></li>
        </c:if>
        <%--判断不是管理员--%>
        <c:if test="${sessionScope.loginUser.role=='学生'}">
            <li class="layui-nav-item"><a href="${ctx}/DegreesServlet?type=myQuery&id=${sessionScope.loginUser.user_id}">我的证书</a></li>
        </c:if>
        <c:if test="${sessionScope.loginUser.role=='企业'}">
            <li class="layui-nav-item"><a href="${ctx}/UserinfoServlet?type=send&&id=${sessionScope.loginUser.user_id}">企业证书颁发</a></li>
            <li class="layui-nav-item"><a href="${ctx}/DegreesServlet?type=myQueryTwo&id=${sessionScope.loginUser.user_id}">我颁发的证书</a></li>
        </c:if>
        <c:if test="${sessionScope.loginUser.role=='教育机构'}">
            <li class="layui-nav-item"><a href="${ctx}/UserinfoServlet?type=send&id=${sessionScope.loginUser.user_id}">机构证书颁发</a></li>
            <li class="layui-nav-item"><a href="${ctx}/DegreesServlet?type=myQueryTwo&id=${sessionScope.loginUser.user_id}">我颁发的证书</a></li>
        </c:if>
        <li class="layui-nav-item"><a href="${ctx}/UserinfoServlet?type=edit&id=${sessionScope.loginUser.user_id}">个人中心</a>
        </li>
        <li class="layui-nav-item"><a href="${ctx}/LoginOutServlet">退出登陆</a></li>
        <li class="layui-nav-item">
            <a style="color: white; font-weight: 700;font-size: 20px;"
               href="#">${sessionScope.loginUser.username} 【${sessionScope.loginUser.role}】</a>
        </li>
    </c:if>
</ul>
