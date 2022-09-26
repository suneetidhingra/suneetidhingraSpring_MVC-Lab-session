<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student</title>
</head>

<body>

	<div class="container">

		<h3>Student Directory</h3>
		<hr>

		<p class="h4 mb-4">Student Details</p>

		<form:form action="/StudentDebateRegistration/students/save" method="POST" modelAttribute="Student">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Student.id}" />

			<div class="form-inline">
				<input type="text" name="name" value="${Student.name}"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			
			Department:
			<form:select path="department">
				<form:options items="${Student.departments}" />
		 	</form:select>
			<br>
			<br>

			Country:
			<form:select path="country">
				<form:options items="${Student.countries}" />
		 	</form:select>
			<br>
			<br>
			<button type="submit" class="btn btn-info col-2">Save</button>

		</form:form>

		<hr>
		<a href="/StudentDebateRegistration/students/list">Back to Student List</a>

	</div>
</body>

</html>










