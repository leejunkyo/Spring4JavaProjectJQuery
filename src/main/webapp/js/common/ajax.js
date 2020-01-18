function _ajaxPOST(url,param,successBack){
	_Ajax(url,'POST',param,successBack);
}

function _ajaxGET(url,param,successBack){
	_Ajax(url,'GET',param,successBack);
}

function _Ajax(url,type,param,successBack){
	console.log(param);
	var sData = param;
	 
	 $.ajax({
         url:url,
         type:type,
         async: false ,
         data:sData,
         dataType:'json',
         timeout: 3000,
         contentType : 'application/json; charset=UTF-8',
         error: function (request, status, error) {      
        	 
         }, success: function (data) {
        	 successBack(data);
        	 
         }, beforeSend: function () {
        	 
         }
         
     });
	 
}