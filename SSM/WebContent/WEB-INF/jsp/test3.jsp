<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test3</title>
</head>
<body>
	<h3>我是test3</h3>
	<table width="300" border="1" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
		</tr>
	<c:forEach var ="temp" items="${list }">
		<tr>
			<td>${temp.id }</td>
			<td>${temp.name }</td>
			<td>${temp.sex }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>