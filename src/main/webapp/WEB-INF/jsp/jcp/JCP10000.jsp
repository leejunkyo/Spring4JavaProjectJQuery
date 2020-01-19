<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/include/common.jspf"%>
<title>로그인페이지</title>
</head>
<body>
 	<div class="loginContainer">
		<div class="login">
			<div class="header">
				<span class="info">Login</span>
				<div class="prompt">
					<span class="ask">Don't have account?</span>
					<button class="btn success wd75 ht29" onClick="join();">sign up</button>
				</div>
			</div>
			<div class="main">
				<div class="user_field">
					<form class="details" autocomplete="off" id="login-page">
						<div class="mt20">
							<input type="text" placeholder="Id" id="cusId" name="cusId" />
						</div>
						<div class="mt20">
							<input type="password" id="cusPwd" name="cusPwd" placeholder="Password" autocomplete="new-password"/>
						</div>
					</form>
				</div>
			</div>
			<button class="btn success wd70 ht30 fr mr18" onClick="login();">Login</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	var loginform = document.getElementById('login-page');
	loginform.method = "POST";
	
	document.getElementById('cusId').value = '';
	document.getElementById('cusPwd').value = '';
	
 	var firstVisit = '${firstVisit}';
	if(firstVisit == ""){
		loginform.action = "/server/firstVisit.do";
		loginform.submit();
	} 
	
	var result = '${result}';
	
	if(result != ""){
		Alert(result);
	}
	
	function login() {
		document.getElementById('cusPwd').value = SHA256(document.getElementById('cusPwd').value);
		loginform.action = "/jcp/login.do";
		loginform.submit();
	}
	function join() {
		
		LayerPop({
			viewNm : '회원가입'  ,
			width  : 400       ,
			height : 300       ,
			url    : '/jcp/jcp10100/openPage.do',
			param  : {}       
			
		});
		
		
	}
	/* document.getElementById('cusPwd').value = SHA256(document.getElementById('cusPwd').value);
	loginform.action = "/jcp/join.do";
	loginform.submit(); */
</script>
</html>
