<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<table>
		<thead>
			<tr>
				<th>Expense Name</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="SafeTravel" items="${allTravels}">
				<tr>
					<td><a href="/safe/${SafeTravel.id}"><c:out value="${SafeTravel.name}" /></a></td>
					<td><c:out value="${SafeTravel.vendor}" /></td>
					<td><c:out value="${SafeTravel.amount}" /></td>
					<td><a href="/safe/edit/${SafeTravel.id }">Edit</a>
					 ||
						<form action="safe/delete/${SafeTravel.id }" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<form:form action='/safe/process/create' method='POST'
		modelAttribute="safeTravel">

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



		<input type='submit' value='send'>


	</form:form>


</body>
</html>