<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <style>
        <%@include file="/style/style.css" %>
    </style>
    <meta charset="UTF-8">
    <title><fmt:message key="admin" /></title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>

<h3><fmt:message key="adminPage.panel" /></h3>

Hello, This is a protected page!

</body>
</html>
