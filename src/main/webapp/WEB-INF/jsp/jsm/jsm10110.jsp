<%@ include file="/WEB-INF/jsp/common/ifmHead.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/css/chat.css'/>"/>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function(){
		chat(1)
	});
	function chat(seq){
		var param = 'seq='+seq		
		_ajaxGET(
				 '/jsm/jsm10110/jsm10110List.do'
				,param
				,function success(data){
					vData = data.jsm10110List[0];
					$('.chatMain').append('<div class="qt"><div class="cont">'+vData.CONT+'</div></div>'); 
					
					
					$('.chatMain .as').each( function() {
						$(this).prop('onclick','');
					});
					
					if( vData.NXT_SEQ != null){
						var nxtSeq = vData.NXT_SEQ.split(',');
						var nxtTitle = vData.NXT_TITLE.split(',');
							
						for(var idx = 0; idx < nxtSeq.length; idx++){
							$('.chatMain').append('<div class="as" onclick="chat('+nxtSeq[idx]+')"><div class="cont">'+nxtTitle[idx]+'</div></div>');
						}
					}
					
					
				});
	}
</script>
<body>
	<div class="chatMain">
	</div>

	<%@ include file="/WEB-INF/jsp/common/ifmFoot.jsp"%>