
// json으로 보낼때
function HttpJson(type,url,data) {
	console.log(url,data);
  	let result;
	$.ajax({
		type: type,
        url: url,
        data: data,
        dataType: 'json',
		contentType: 'application/json; charset=utf-8',
        async: false,
        success: function(data) {
      	    result = data;
        },
		error : function (jqXHR, textStatus, errorThrown){
			console.log(jqXHR);  //응답 메시지
			console.log(textStatus); //"error"로 고정인듯함
			console.log(errorThrown);
		}
  	});

	return result;
}

// 단일로 보낼때
function HttpAjax(type,url,data) {
	console.log(url,data);
  	let result;
	$.ajax({
		type: type,
        url: url,
        data: data,
        async: false,
        success: function(data) {
      	    result = data;
        },
		error : function (jqXHR, textStatus, errorThrown){
			console.log(jqXHR);  //응답 메시지
			console.log(textStatus); //"error"로 고정인듯함
			console.log(errorThrown);
		}
  	});

	return result;
}