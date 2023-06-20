<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Expense Details</h1> <a href="/safe">Home</a>

<p>Expense Name: <c:out value="${SafeTravel.name }"/></p>
<p>Expense Description: <c:out value="${SafeTravel.description }"/></p>
<p>Vendor: <c:out value="${SafeTravel.vendor }"/></p>
<p>Amount Spent: <c:out value="${SafeTravel.amount }"/></p>
<p>Created at: <c:out value="${SafeTravel.createdAt }"/></p>


</body>
</html>