<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<body>

<header>
    <style>
        <%@include file="/style/style.css" %>
    </style>
    <meta charset="UTF-8">
    <title><fmt:message key="index.title" /></title>

</header>
<nav>
    <ul class="topmenu">
        <li><a href="${pageContext.request.contextPath}/admin">
            <fmt:message key="admin" />
        </a></li>
        <li><a href="${pageContext.request.contextPath}/masterPages">
            <fmt:message key="masterPages" />
        </a></li>
        <li><a href="${pageContext.request.contextPath}/userInfo">
            <fmt:message key="userInfo" />
        </a>
        </li>
        <li><a href="${pageContext.request.contextPath}/loginPage">
            <fmt:message key="login" />
        </a>
            <ul class="submenu">
                <li><a href="${pageContext.request.contextPath}/registration">
                    <fmt:message key="registration" />
                </a></li>
                <li><a href="${pageContext.request.contextPath}/loginPage">
                    <fmt:message key="login" />
                </a></li>
                <li><a href="${pageContext.request.contextPath}/logout">
                    <fmt:message key="logout" />
                </a></li>
            </ul>
        </li>
    </ul>
</nav>

</header>
&nbsp;
<span style="color:forestgreen">[ ${loginedUser.login} ]</span>
<h2>Hi</h2>
</body>
</html>
