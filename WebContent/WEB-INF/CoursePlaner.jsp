<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Course Planer</title>
</head>
<body>
	<form action="CoursePlaner" method="post">
		<table border="1">
			<tr>
				<th></th>
				<th style="text-align: center">Code</th>
				<th style="text-align: center">Title</th>
				<th style="text-align: center">Prerequisites</th>

			</tr>

			<c:forEach items="${courses}" var="aa" varStatus="status">
				<tr>
					<td><input type="checkbox" name="check" value="${aa.code}" />

					</td>
					<td>${aa.code }</td>
					<td>${aa.title }</td>


					<td><c:forEach items="${aa.prerequisites}" var="cc">                   
                    ${cc }
                    </c:forEach></td>
				</tr>
				<input type="hidden" name="id" value="${entry.id}" />
			</c:forEach>


		</table>
		<br />
		<input type="submit" name="next" value="Next" />
	</form>
</body>
</html>