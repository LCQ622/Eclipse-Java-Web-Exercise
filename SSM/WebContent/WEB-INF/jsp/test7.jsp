<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test7</title>
</head>
<body>
	<h3>我是test7</h3>
	<form action="test8">
		用户名：<input type="text" name="username" value="${username }"/><br /> 密码：<input type="text"
			name="pwd"  value="${pwd }"/><br /> <input type="submit" value="提交" />
	</form>
</body>
</html>