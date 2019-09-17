<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src="./static/js/jquery.min.js"></script>
		<link rel="text/css" href="./static/css/bootstrap.css">
		<script type="text/javascript" src="./static/js/bootstrap.min.js"></script>
	</head>
<body>
	<form action="../lion/login" class="form-horizontal">
		<input type="text" name="username" id="username" class="form-control">
		<input type="password" name="password" id="password" class="form-control">
		<input type="submit" class="btn btn-default">
	</form>
</body>
</html>