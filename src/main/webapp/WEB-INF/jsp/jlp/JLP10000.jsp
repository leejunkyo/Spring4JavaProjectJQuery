<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="/WEB-INF/include/common.jspf"%>
<title>로그인페이지</title>
</head>
<body>
	<div class="login">
		<form id="login-page" class="page">
			<h3>로그인</h3>
			<p>아이디(ID)</p>
			<input class="textBox" type="text" id="cusId" name="cusId">
			<p>비밀번호(Password)</p>
			<input class="textBox" type="password" id="cusPwd" name="cusPwd">
			<div class="mt15 fr">
				<button type="button" class="btn success wd100 ht31"
					onclick="login()">로그인</button>
				<button type="button" class="btn cancel wd100 ht31" onclick="join()">회원가입</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	var loginform = document.getElementById('login-page');
	loginform.method = "POST";
	
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
		loginform.action = "/jlp/login.do";
		loginform.submit();
	}
	function join() {
		loginform.action = "/jlp/join.do";
		loginform.submit();
	}
</script>
</html>
