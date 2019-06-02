<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/jquery-3.3.1.min.js"></script>
<style>
#con {
	width: 30%;
	margin: 30px auto;
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
</style>
<script>
	$(function() {
		$("#btn_add").click(function() {
			var txt=$("#inp_user_name").val();
			if(txt!=''){
			$.ajax({
				url : "add_user",
				type : "post",
				data : $("#add_from").serialize(),
				cache : false,
				dataType : 'json',
				success : function(data) {
					if (data.success === "ok") {
						alert("添加成功");
						chageMbx('所有用户');
						load('get_data');
					} else {
						alert("添加失败");
					}
				}
			});
			}else{
				layer.tips('用户名不能为空', '#inp_user_name');
			}
			
		});
	});
</script>


</head>
<body>


	<div id="con" class="layui-bg-gray">
		<div id="con_1">
			<p id="txt">添加用户</p>

			<form action="" method="post" id="add_from">
				<input type="text" name="username" class="layui-input"  id="inp_user_name" placeholder="请输入用户名" /> <br />

				<div>

					性别：<label>男&nbsp;&nbsp;<input type="radio" name="sex" value="M" />
					</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>女&nbsp;&nbsp;<input type="radio" name="sex" value="F"
						checked="checked" /></label>

				</div>
				<br /> <input type="button" value="添加"
					class="layui-btn layui-btn-fluid " id="btn_add" />
			</form>
		</div>
	</div>
</body>
</html>