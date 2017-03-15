<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>AddCourses</title>
</head>
<body>
	<form action="AddCourse" method="post">
		<table border="1">

			<tr>
				<td>Code:</td>
				<td><input type="text" name="code" /></td>
			</tr>
			
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			

			<tr>
				<td style="vertical-align: top">Prerequisite(s):</td>
				<td>
				<c:forEach items="${courses}" var="entry">
						<ul>
							<li>${entry.code}<input name="check" type="checkbox"
								value="${entry.code}" /></li>

						</ul>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1"><input name="add" type="submit"
					value="Add" /></td>
			</tr>
		</table>







	</form>
</body>
</html>