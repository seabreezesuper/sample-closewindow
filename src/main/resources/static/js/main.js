window.onbeforeunload=function(event){
    // ajax设置session，将closeFlag设为1
	var postData = {};

	$.ajax({
		type : "post",
		url : "/ajaxSetCloseFlag",
		data : postData,

		success : function(data) {
			// alert(data);
		},
		error : function(data) {

			alert("所请求的页面有异常！");
		}
	});
}