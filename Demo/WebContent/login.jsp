
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>登录</title>
<script src="js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="css/login.css">
<script src="layui/layui.js"></script>
<script src="js/login.js"></script>
</head>
<body class="layui-bg-gray">
	<%
		if (session.getAttribute("username") != null && null != session.getAttribute("pwd")) {
			out.print("<script> alert('您已经登录了，如需重新登录，请在主页登出');</script>");
			out.print("<script> window.location.href='index.jsp'; </script>");
		}
	%>
	<div id="top"></div>
	<div id="content" class="layui-main">
		<div id="form" class="layui-main">
			<div>


				<p id="txt">登录</p>
				<div class="layui-progress " id="jdt">
					<div class="layui-progress-bar layui-bg-green" lay-percent="20%"></div>
				</div>
				<!--  去除form 便签 使用 ajax提交-->
				<input type="text" name="username" class="layui-input"
					placeholder="请输入用户名"><br> <input type="password"
					name="pwd" class="layui-input" placeholder="请输入密码"><br>
				<button class="layui-btn layui-btn layui-btn-fluid">立即登录</button>
			</div>
		</div>
	</div>

	<div id="footer">
		<hr>
		<div>2018 © mcandroid.cn</div>
	</div>
</body>
</html>