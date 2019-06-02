<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="layui/layui.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
.site-block {
	padding: 20px;
	border: 1px solid #eee;
	margin-top: 10px;
}

.site-text {
	position: relative;
}
</style>

</head>
<body class="layui-layout-body">
	<%
		if (session.getAttribute("username") == null && null == session.getAttribute("pwd")) {
			out.print("<script> window.location.href='login.jsp'; </script>");
		}
	%>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="layui/images/face/8.gif" class="layui-nav-img"> <%
 	out.print(session.getAttribute("username"));
 %>
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="logout" id="userout">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">所有商品</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:chageMbx('列表一'); load('list1.JSP');">列表一</a>
							</dd>
							<dd>
								<a href="javascript:chageMbx('列表二');load('list2.html');">列表二</a>
							</dd>
							<dd>
								<a href="javascript:chageMbx('列表三');load('list3.html');">列表三</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">解决方案</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">列表一</a>
							</dd>
							<dd>
								<a href="javascript:;">列表二</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">

<!-- 面包屑 -->
				<span class="layui-breadcrumb" id="mbx">
				 <a href="">首页</a> 
				 <a href="">所有商品</a>
				 <a><cite>列表一</cite></a>
				</span>
				<div id="content">
				
				
				
				</div>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			2018 © mcandroid.cn
		</div>
	</div>

</body>
</html>
