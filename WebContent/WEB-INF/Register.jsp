<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>
</head>
<body>

	<form action="Register" method="post">
		<table border="1">
			<tr>
				<td>Username*:</td>
				<td><input type="text" name="Username" /></td>
			</tr>
			
			
			<tr>
				<td>Password*:</td>
				<td><input type="text" name="Password" /></td>
			</tr>
		
			<tr>
				<td>Re-Type Password*:</td>
				<td><input type="text" name="Re-Password" /></td>
			</tr>
			

			<tr>
				<td>First Name(Optional):</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			
			<tr>
				<td>Last Name(Optional):</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			



			<td colspan="2" rowspan="1"><input name="register" type="submit"
				value="Register" /></td>

		</table>	
		
		
           
		
	</form>
	<c:if test="${error ne null}">
       <td> <font color="red" size="5">${error}</font></td>
        </c:if>
	
	
	
</body>
</html>