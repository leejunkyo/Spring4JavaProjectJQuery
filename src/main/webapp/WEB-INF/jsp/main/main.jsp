<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/common.jspf"%>
<script type="text/javascript">
/** 뒤로가기 방지*/
history.pushState(null, null, location.href);
	window.onpopstate = function () {
	    history.go(1);
	};
	var id = 0;
	document.addEventListener("DOMContentLoaded", function(){
		_ajaxGET(
				 '/jmp/menuList.do'
				,''
				,function success(data){
					 
					 var vData = data.cumnifList;
					 var vHtml = '';
					 
					 //상단메뉴바
					 for(var idx = 0; idx < vData.length; idx++){
						 var dData = vData[idx];
						 var menuId = dData.menuId;
						 var menuWidth = dData.menuPgNm.byteLength()*7;
						 if(menuWidth < 80){
							 menuWidth = 80;
						 }
						 if(menuId.length == 2){
							 if(idx != 0){
								 vHtml += '</ul></li>';
							 }
							 vHtml += '<li class="mainMenu"><a onclick=upMenuClick("lv1","'+dData.menuPgId+'") title="'+dData.menuPgNm+'">'+dData.menuPgNm+'</a><ul>'
						 }
						 if(menuId.length == 4){
							 if(idx != 1){
								 vHtml += '</ul></li>';
							 }
							 vHtml += '<li><a class="subMenu" onclick=upMenuClick("lv2","'+dData.menuPgId+'") title="'+dData.menuPgNm+'">'+dData.menuPgNm+'</a><ul>';
						 }
						 if(menuId.length == 6){
							 vHtml += '<li onclick=upMenuClick("lv3","'+dData.menuPgId+'") ref="'+dData.menuPgUrl+'"><a class="subMenu wd'+menuWidth+'" ref="'+dData.menuPgId+'" title="'+dData.menuPgNm+'">'+dData.menuPgNm+'</a></li>'
						 }
						 if((parseInt(idx)+1) == vData.length){
							 vHtml += '</ul></li></ul></li>'
						 }
					 }
					 document.getElementById('upMenu').innerHTML = vHtml;
					 
					 //사이드메뉴바
					 vHtml = "";
					 
					 for(var idx = 0; idx < vData.length; idx++){
						 
						 var dData = vData[idx];
						 var menuId = dData.menuId;
						 if(idx == 0){
							 vHtml += '<div id="'+dData.menuPgId+'" class="sideTab">';
						 }
						 
						 if(menuId.length == 2){
							 vHtml += '<div class="titMenu" id="'+dData.menuPgId+'">'+dData.menuPgNm+'</div>';
						 }
						 
						 if(menuId.length == 4){
							 if(idx != 1){
								 vHtml += '</ul></div>';
							 }
							 vHtml += '<div class="subMenu"><a id="'+dData.menuPgId+'">'+dData.menuPgNm+'</a><ul>';
						 }
						 
						 if(menuId.length == 6){
							 vHtml += '<li ref="'+dData.menuPgUrl+'"><a id="'+dData.menuPgId+'">'+dData.menuPgNm+'</a></li>';
						 }
						 
						 if((parseInt(idx)+1) == vData.length){
							 vHtml += '</ul></div></div>';
						 }
					 }
					 document.getElementById('sideMenu').innerHTML = vHtml;

				 });
		
		$(function () {
			
			/** sidebar  */
			$('.sidebar .subMenu').click( function() {
				
				$('.sidebar .subMenu').find('ul').click( function() {
					return false;
				});

				if($(this).find('ul').css('display') == 'block'){
					$(this).find('ul').slideUp(300);
				}else{
					$(this).find('ul').slideDown(300);
				}
				
			});
			$('.sidebar .subMenu li').click( function() {
				 var tabNm = $(this).find('a').text();
				 var tabId = $(this).find('a').attr('id');
				 var src   = $(this).attr('ref');
				 tabCreat(tabNm, src ,tabId);
			});
			$('.sidebar .sideTab').first().css('display','block');
			$('.sidebar .subMenu').first().find('ul').trigger('click');
		});
		
		
		/** 정보입력  */
		document.getElementById('cusNm').innerHTML = '${cusNm}';
	    
	});
	
	/** 상단메뉴 */
	function upMenuClick(op,id){
		
		$('.sidebar .sideTab').css('display','none');
		if(op == 'lv1'){
			$('.sidebar #'+id).css('display','block');
			
		}else if(op == 'lv2'){
			var tabId = $('#'+id);
			tabId.parent().children( 'ul' ).css('display','block');
			tabId.parent().parent().prop('style','display:block');
			
		}else if(op == 'lv3'){
			var tabId = $('#'+id);
			tabId.parent().parent().parent().parent().css('display','block');
			var tabNm = tabId.text();
			var src   = tabId.parent().attr('ref');
			tabId.parent().parent().css('display','block');
			tabCreat(tabNm, src , id);
		}
		
	}

	
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
    function tabCreat(tabNm, src , id){
    	if($('ul.tabs li').length == 10){
    		Alert("10개 이상의 화면을 생성할수 없습니다.");
    		return;
    	}
    	var tabId = 'tabli'+id;
    	var createFlag = false;
    	$('ul.tabs li').each(function(){
    		if($(this).attr('id') == tabId){
    			tabClick(tabId);
    			createFlag = true;
    		};
    	});
    	
    	if(createFlag){
    		return;
    	} 
    	
    	//src = '/sample/openSampleList.do';
    	var tabName = '<li id="tabli'+id+'" rel="tab'+id+'"><div class="tabNm" onClick="tabClick(\'tabli'+id+'\');">'+tabNm+'</div><div class="tabIcon" onClick="tabDel(\'tabli'+id+'\');"><img class="tabCanImg"  src="../../image/common/cancel.png"/></div></li>';
    	var ifrNm   = '<div id="tab'+id+'" class="tab_content"><iframe style="border: none;" id="iframe'+id+'" src="'+src+'" ref="'+tabNm+'"></iframe></div>';
    	$('.content .tabs').append(tabName);
    	$('.content .tab_container').append(ifrNm);
    	tabClick('tabli'+id);
    	
    };
	
	/* tab Click */
	function tabClick(tabId){
		$('ul.tabs li').removeClass('active').css('color', '#333');
		$('#'+tabId).addClass('active').css('color', '#4597ff');
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
			<ul id="upMenu"></ul>
		</nav>
	</div>
	<div class="loginInfo">
		<div class="infoText">
			<span id="cusNm"></span>님 환영합니다!
			<button type="button" class="btn success wd52 ht20" style='font-size:1px;' onclick="logOut()">로그아웃</button>
		</div>
	</div>
	<div class="container">
		<div class="sidebar" id="sideMenu">
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