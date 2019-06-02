<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="layer/layer.js"></script>
<script src="layui/layui.js"></script>
<script>
	
	function edit(id) {
	layer.open({
			  type: 2,
			  title: '修改用户信息',
			  shadeClose: true,
			  shade: 0.8,
			  skin: 'layui-layer-rim',
			  area: ['380px', '55%'],
			  content: 'edit_user?type=1&id='+id
			}); 
	
	}

	function del(id) {
		layer.confirm("你确定要删除？", {
			btn : [ "yes", "on" ],
			btn2 : function(index) {
				layer.close(index);
				layer.msg("还好没删除ヾ(ﾟ∀ﾟゞ)");
			}

		}, function(index) {
			$.ajax({
				url:"del_user",
				type:"post",
				data:{
					id:""+id
				},dataType:"json",
				success:function(data){
					if(data.del==='ok'){
						layer.msg("删除成功");
						chageMbx('所有用户');
						load('get_data');
					}else if(data.del==='err'){
						layer.msg(data.msg);
						hageMbx('所有用户');
						load('get_data');
					}
				}
			});
			layer.close(index);
			chageMbx('所有用户');
			load('get_data');
		});
	}
</script>


<table class="layui-table" id="demo" lay-size="sm">
	<tr>
		<th><strong>ID</strong></th>
		<th><strong>姓名</strong></th>
		<th><strong>性别</strong></th>
		<th><strong>操作</strong></th>
	</tr>
	<c:forEach var="temp" items="${list }">
		<tr>
			<td>${temp.id}</td>
			<td>${temp.name }</td>
			<td>${temp.sex }</td>
			<td>
				<button class="layui-btn layui-btn-sm" onclick="edit(${temp.id});">修改</button>
				<button class="layui-btn  layui-btn-sm layui-btn-danger"
					onclick="del(${temp.id});">删除</button>
			</td>
		</tr>
	</c:forEach>
</table>

<div id="list_div"></div>
