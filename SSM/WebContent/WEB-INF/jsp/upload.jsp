<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传文件</title>
</head>
<body>
<form action="upsub" method="post" enctype="multipart/form-data">
文本1:<input type="text" name="msg1" />
文本2:<input type="text" name="msg2" />
上传文件：<input type="file" name="file"/>
<input type="submit" value="提交" />
</form>
</body>
</html>