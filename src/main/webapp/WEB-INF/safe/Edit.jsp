<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Expense</h1>
	<form:form action='/safe/process/edit/${safeTravel.id}' method='POST'
		modelAttribute="safeTravel">
		<input type="hidden" name="_method" value="put"/>

		<form:label path="name">Expense name:</form:label>
		<form:input type="text" path="name" />
		<form:errors path="name" />
		<br>

		<form:label path="vendor">Vendor:</form:label>
		<form:input type="text" path="vendor" />
		<form:errors path="vendor" />
		<br>

		<form:label path="amount">Amount:</form:label>
		<form:input type="number" path="amount" />
		<form:errors path="amount" />
		<br>

		<form:label path="description">Description:</form:label>
		<form:input type="text" path="description" />
		<form:errors path="description" />
		<br>



		<input type='submit' value='edit'>


	</form:form>
</body>
</html>