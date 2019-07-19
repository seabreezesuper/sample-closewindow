function doLoad(){

    //1秒钟刷新一次
    setInterval(function() {
    	getCloseFlag();
    }, 1000);
}

function getCloseFlag() {
	var postData = {};

	$.ajax({
		type : "post",
		url : "/ajaxGetCloseFlag",
		data : postData,

		success : function(data) {
			if(data == '1'){
				window.close();
			}			
		},
		error : function(data) {

			alert("所请求的页面有异常！");
		}
	});
}