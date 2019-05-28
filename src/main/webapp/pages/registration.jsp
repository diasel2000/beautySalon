<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="lang"/>

<html>
<head>
    <title><fmt:message key="registration" /></title>
    <style>
        <%@include file="/style/style.css" %>
    </style>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>

<h2><fmt:message key="reg.page" /></h2>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/registration">
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <table border="0">
        <td><fmt:message key="createAcc" /></td><br/>
        <tr>
            <td><fmt:message key="login" /></td>
            <td><input type="text" name="login" value= "${requestScope.login}" /> </td>
        </tr>
        <tr>
            <td><fmt:message key="password" /></td>
            <td><input type="password" name="password" value= "${requestScope.password}" /> </td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "<fmt:message key="submit" />" />
                <a href="${pageContext.request.contextPath}/"><fmt:message key="cancel"/></a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
