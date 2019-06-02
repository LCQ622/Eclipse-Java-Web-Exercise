var lay;
layui.use([ 'element', "layer" ], function() {
	var element = layui.element;
	lay = layui.layer;
});
$(function() {
	$("button").click(function() {
		$.ajax({
			url : "usercheck",
			data : {
				username : $("input[name=username]").val(),
				pwd : $("input[name=pwd]").val()
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.result === "ok") {
					window.location.href="index";
				} else {
					lay.alert(data.msg);
				}
			}
		});

	});

});