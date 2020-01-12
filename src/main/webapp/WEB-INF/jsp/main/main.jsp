<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/common.jspf"%>
<script type="text/javascript">
	
	var tabCnt = 0;
	
	document.addEventListener("DOMContentLoaded", function(){
		/* sidebar */
		$(function () {
			/** sidebar  */
			$('.sidebar .subMenu').click( function() {
				
				$('.sidebar .subMenu').find('ul').click( function() {
					return false;
				});
				
				if($(this).find('ul').css('display') == 'block'){
					$(this).find('ul').slideUp(500);
				}else{
					$(this).find('ul').slideDown(500);
				}
			});
			$('.sidebar .subMenu li').click( function() {
				 var tabNm = $(this).find('a').text();
				 var src   = $(this).find('a').attr('href');
				 tabCreat(tabNm, src);
			});
		});
		
		
		/** 정보입력  */
		document.getElementById('cusNm').innerHTML = '${cusNm}';
		
	    
	});
	/** 뒤로가기 방지*/
	history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
	};
	/** 세션로그 아웃 */
	function logOut(){
		 Confirm("로그아웃 하시겟습니까?","알림",function succecc(flag){
			 if(flag){
				 var form = document.createElement("form");
				 form.setAttribute("charset", "UTF-8");
				 form.setAttribute("method", "Post");  //Post 방식
				 form.setAttribute("action", "/jcp/logOut.do"); //요청 보낼 주소
				 document.body.appendChild(form);
				 form.submit(); 
			 }
		 });
		
	}
	
	/* tab Create*/
    function tabCreat(tabNm, src){
    	if($('ul.tabs li').length == 10){
    		Alert("10개 이상의 화면을 생성할수 없습니다.");
    		return;
    	}
    	src = '/sample/openSampleList.do';
    	var tabName = '<li id="tabli'+tabCnt+'" rel="tab'+tabCnt+'"><div class="tabNm" onClick="tabClick(\'tabli'+tabCnt+'\');">'+tabNm+'</div><div class="tabIcon" onClick="tabDel(\'tabli'+tabCnt+'\');"><img class="tabCanImg"  src="../../image/common/cancel.png"/></div></li>';
    	var ifrNm   = '<div id="tab'+tabCnt+'" class="tab_content"><iframe id="iframe" src="'+src+'"></iframe></div>';
    	$('.content .tabs').append(tabName);
    	$('.content .tab_container').append(ifrNm);
    	tabClick('tabli'+tabCnt);
    	tabCnt++;
    };
	
	/* tab Click */
	function tabClick(tabId){
		$('ul.tabs li').removeClass('active').css('color', '#333');
		$('#'+tabId).addClass('active').css('color', 'darkred');
		$('.tab_content').hide()
		var activeTab = $('#'+tabId).attr('rel');
		$("#" + activeTab).fadeIn();
		
	}
	
	/* tab Del */  
	function tabDel(tabId){
		
		 var activeTab = $('#'+tabId).attr("rel");
		 $('#'+tabId).remove();
		 $("#" + activeTab).remove();
		 tabClick($("ul.tabs li:last-child").attr('id'))
	}
	
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPJ4</title>
</head>
<body>
	<div class="headWrap">
		<div class="tit_logo">
			<div class="main">SP4J</div>
			<div class="sub">(Spring4Java)</div>
		</div>
		<nav class="listMenu">
		<ul>
			<li class="mainMenu"><a href="#Link" title="Link">Jquery</a>
				<ul>
					<li><a class="subMenu" href="#Link" title="Link">Link » </a>
						<ul>
							<li><a class="subMenu" href="#Link" title="Link">Link</a></li>
							<li><a class="subMenu" href="#Link" title="Link">Link</a></li>
						</ul>
					</li>
					<li><a class="subMenu" href="#Link" title="Link">Link » </a>
						<ul>
							<li><a class="subMenu" href="#Link" title="Link">Link</a></li>
							<li><a class="subMenu" href="#link" title="Link">Link</a></li>
							<li><a class="subMenu" href="#Link" title="Link">Link </a></li>
						</ul>
					</li>
					<li><a class="subMenu" href="#Link" title="Link">Link » </a>
						<ul>
							<li><a class="subMenu" href="#Link" title="Link">Link</a></li>
							<li><a class="subMenu" href="#Link" title="Link">Link</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
		</nav>
	</div>
	<div class="loginInfo">
		<div class="infoText">
			<span id="cusNm"></span>님 환영합니다!
			<button type="button" class="btn success wd52 ht20" style='font-size:1px;' onclick="logOut()">로그아웃</button>
		</div>
	</div>
	<div class="container">
		<div class="sidebar">
			<div>
				<div class="titMenu">Jquery</div>
				<div class="subMenu"><a href="#">1</a>
					<ul>
						<li><a href="#">1-1</a></li>
						<li><a href="#">엄청나게긴화면명으로테스트를합시다.</a></li>
						<li><a href="#">1-3</a></li>
					</ul>
				</div>
				<div class="subMenu"><a href="#">2</a>
					<ul>
						<li><a href="#">2-1</a></li>
						<li><a href="#">2-2</a></li>
						<li><a href="#">2-3</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content">
			<ul class="tabs">
		    </ul>
		    <div class="tab_container">
		    </div>
	   </div>
	</div>
</body>
</html>