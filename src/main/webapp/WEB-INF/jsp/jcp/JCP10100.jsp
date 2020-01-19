<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/ifmCommon.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="joinContainer">
		<div class="join">
			<div class="main">
				<div class="user_field">
					<form class="details" autocomplete="off" id="login-page" onSubmit="return false;">
						<div class="mt15">
							<input type="text" id="cusNm" name="cusNm"  placeholder="UserName" value=""/>
						</div>
						<div class="mt15">
							<input type="text" placeholder="Id" id="cusId" name="cusId" value=""/>
						</div>
						<div class="mt15">
							<input type="password" id="cusPwd" name="cusPwd" placeholder="Password" autocomplete="new-password" value=""/>
						</div>
						<button class="btn success wd70 ht30 fr mt15" onClick="join();">Join</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function join(){
	
	if($('#cusNm').val() == ''){
		Alert("이름을 입력하세요.");
		return false;
	}
	
	if($('#cusId').val() == ''){
		Alert("아이디를 입력하세요.");
		return false;
	}
	
	if($('#cusPwd').val() == ''){
		Alert("비밀번호를 입력하세요.");
		return false;
	}
	
	_ajaxGET(
			 '/jcp/jcp10100/join.do'
			, $("#login-page").serializeObject()
			,function success(data){
				 	var result = data.result;
				 	if(result == '1111'){
				 		Alert('중복된 아이디가 존재합니다.');
				 	}else{
				 		parent.popClose();
				 	}
				 
			 });
}


</script>
</html>