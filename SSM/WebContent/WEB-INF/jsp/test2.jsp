<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>我是test2</h2>
	<table width=500 border="1"  cellspacing="0">
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>性别</th>
		</tr>
		
		<c:forEach items="${list }" var="Temp">
		<tr>
			<td>${Temp.id }</td>
			<td>${Temp.name}</td>
			<td>${Temp.sex}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>