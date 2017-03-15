<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>DisplayCourse</title>
</head>
<body>
	<form action="DisplayCourse" method="post">
		<table border="1">
			<tr>
				<th style="text-align: center">Code</th>
				<th style="text-align: center">Title</th>
				<th style="text-align: center">Prerequisites</th>
				<th style="text-align: center">Edit</th>
			</tr>

			<c:forEach items="${courses}" var="aa">
				<tr>

					<td>${aa.code }</td>
					<td>${aa.title }</td>
					<td><c:forEach items="${aa.prerequisites}" var="cc">                   
                    ${cc }
					</c:forEach></td>

					<td><a href="EditCourse?id=${aa.id}">Edit</a></td>
				</tr>
			</c:forEach>




		</table>
	</form>

	<p>
		<a href="AddCourse">Add Courses</a><br /> 
	    <br /><a href="Register">Register</a><br />
		<br /><a href="CoursePlaner">Course Planer</a><br />

	</p>

	<c:if test="${empty user }">
		<a href="Login">Login</a>
	</c:if>
	<c:if test="${not empty user }">
		<a href="Logout">Logout</a>

	</c:if>
</body>
</html>