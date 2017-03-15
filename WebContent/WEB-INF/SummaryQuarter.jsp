<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>All the Courses</title>
</head>
<body>


	<form action="CoursePlaner" method="post">
		<c:forEach items="${summaryCourses}" var="summaryCourses">
		<br/>
			${summaryCourses.quarter} ${summaryCourses.year}
			<table border="1">
				<tr>

					<th style="text-align: center">Code</th>
					<th style="text-align: center">Title</th>
					<th style="text-align: center">Prerequisites</th>

				</tr>

				<c:forEach items="${summaryCourses.coursesQuar}" var="summary">


					<tr>

						<td>${summary.code}</td>
						<td>${summary.title}</td>

						<td><c:forEach items="${summary.prerequisites}" var="pre">                   
                    ${pre }
                    </c:forEach></td>
					</tr>
					
				</c:forEach>


			</table>
		</c:forEach>
	</form>
<form action="RemoveSession" method="get">
 <br />
 </form>
 <a href="RemoveSession" >done</a>
</body>
</html>