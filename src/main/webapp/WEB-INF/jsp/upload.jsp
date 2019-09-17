<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../upload/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="userFile" id="userFile" /><br />
		<input type="submit" value="上传" />
	</form>
</body>
</html>