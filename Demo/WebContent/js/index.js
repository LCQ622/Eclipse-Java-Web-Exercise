var form;
layui.use(['element','form'], function() {
	var element = layui.element;
	 form=layui.form;
});


$(function() {

});

function load(url) {
	$.ajax({
		url:url,
		success:function (data){
			$(content).html(data);
		}
	});
}

function chageMbx(str){
	$("#mbx cite").text(str);
}