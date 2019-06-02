<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<script src="layui/layui.js"></script>
<link rel="stylesheet" href="layui/css/layui.css" />
<style>
.main {
	width: 80%;
	margin: 30px auto;
}
</style>
</head>
<body>
	<div class="main">
		<table class="layui-table" lay-size="sm">
			<tr>
				<th>编号</th>
				<th>时间</th>
				<th>金额</th>
				<th>支付方式</th>
				<th>消费类型</th>
				<th>备注</th>
			</tr>
			<c:forEach items="${page.list }" var="temp">
				<tr>
					<td>${temp.id }</td>
					<td><fmt:formatDate pattern="yyyy年MM月dd日" value="${temp.date}" /></td>
					<td>￥ ${temp.money }</td>
					<td>${temp.pay_mode }</td>
					<td>${temp.type }</td>
					<td>${temp.msg }</td>
				</tr>
			</c:forEach>
		</table>
		总页数：${page.total} <br />
		当前页：${page.pageNum }<br />
		<a href="index" >首页</a>
		<a href="index?start=${page.pageNum-1 }" <c:if test="${page.total<=1 }">  onclick="javascript:return false;</c:if>>上一页</a>
		
		<a href="index?start=${page.pageNum+1 }" <c:if test="${page.pageNum>=page.total}">  onclick="javascript:return false;"</c:if>>下一页</a>
		<a href="index?start=${page.total}">末页</a>
	</div>
</body>
</html>