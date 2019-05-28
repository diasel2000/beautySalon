<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="lang"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        <%@include file="/style/style.css" %>
    </style>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>



<p style="color: red;">${errorString}</p>

<form method="POST"  action="${pageContext.request.contextPath}/loginPage" >
    <h3><fmt:message key="loginPage" /></h3>

    <input type="hidden" name="redirectId" value="${param.redirectId}" />
        <div class="form-row">
            <fmt:message key="login" />
            <input type="text" name="login" id="login" value= "${requestScope.login}" />
        </div>
        <div class="form-row">
            <fmt:message key="password" />
            <input type="password" name="password" id="password" value= "${requestScope.password}" />
        </div>

                <p>  <input type="submit" value= "<fmt:message key="submit" />" /><p>
                <a href="${pageContext.request.contextPath}/"><fmt:message key="cancel" /></a>


</form>
<p style="color:blue;"><fmt:message key="login" />:</p>

</body>
</html>