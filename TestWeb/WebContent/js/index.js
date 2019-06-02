
layui.use('element', function() {
	var element = layui.element;

	
	chageMbx('所有用户');
	load('get_data');
});

$(function(){
	
	chageMbx('所有用户');
	load('get_data');
});



function load(url) {
	$.ajax({
		url:url,
		cache:false,
		success:function (data){
			$("#content").html(data);
		}
	});
}

function chageMbx(str){
	$("#mbx cite").text(str);
}
