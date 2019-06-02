<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ID:${id }</h2>
<h2><% 
String id2=(String)request.getAttribute("id2");
if(!"".equals(id2)){
	out.print("ID2:"+id2);
}
%></h2>
</body>
</html>