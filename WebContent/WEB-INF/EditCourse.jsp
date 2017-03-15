<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Courses</title>
</head>
<body>

	<form action="EditCourse" method="post">
		<table border="1">

			<tr>
				<td>Code:</td>
				<td><input type="text" name="code" value="${entry.code }" /></td>
			</tr>

			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" value="${entry.title }" /></td>
			</tr>


			<tr>
				<td style="vertical-align: top">Prerequisite(s):</td>
				<td><c:forEach items="${courses}" var="c">

						<c:if test="${c.code ne entry.code }">
							<c:if test="${fn:contains(entry.prerequisites, c.code)}">

								<input type="checkbox" name="check" checked="checked"
									value="${c.code}" />${c.code}<br />

							</c:if>

							<c:if test="${not fn:contains(entry.prerequisites, c.code)}">
								<input type="checkbox" name="check" value="${c.code}" />${c.code }<br />
							</c:if>

						</c:if>

						<input type="hidden" name="id" value="${entry.id}" />
					</c:forEach></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1"><input name="save" type="submit"
					value="Save" /></td>
			</tr>
		</table>
	</form>

</body>
</html>