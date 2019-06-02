<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="layer/layer.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<style>
#con {
	width: 80%;
	margin: 0;
	padding: 30px;
}

#con_1 {
	width: 100%;
	margin: 30px auto;
}

#txt {
	color: #009688;
	font-size: 20px;
	margin-bottom: 20px;
}

.class1 {
	width: 100%;
}

</style>


<script>


	$(function() {

		$("#btn_update").click(function() {
			
		 $.ajax({
				url : "edit_user",
				type : "post",
				data : $("#add_from").serialize(),
				cache : false,
				dataType : 'json',
				success : function(data) {
					if (data.edit === "ok") {
						alert("修改成功");
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭当前iframe页面
						parent.load('get_data');
						
						
					} else {
						alert("修改失败");
					}
				}
			}); 
		});
	});
</script>


</head>
<body>

	<div id="con" class="layui-bg-gray">
		<div id="con_1">
			<p id="txt">修改信息</p>
			<form action="" method="post" id="add_from">
			<input type="hidden" name="id"value="${map.id }" />
				<h3>用户名：</h3>
				<input type="text" name="username" value="${map.name }"  class="class1 layui-input"/> <br />

				<div>
				
					<h3>性别：</h3>
					<label>男<input type="radio" name="sex" value="M"
						<c:if test="${map.sex=='M'}">checked="checked"</c:if> />
					</label> <label>女<input type="radio" name="sex" value="F"
						<c:if test="${map.sex=='F'}">checked="checked"</c:if> /></label>

				</div>
				<br />

				<button id="btn_update" class=" layui-btn layui-btn-normal layui-btn-fluid">提交修改</button>
			</form>
		</div>
	</div>
</body>
</html>