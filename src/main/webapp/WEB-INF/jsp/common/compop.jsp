<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="mask" id="maskPop">
	<div class="compop" id="alertPop">
		<div class="popHead"><div class="headFont">알림</div></div>
	    <div class="alert">
			<div class="alertFont" id="alertFont"></div>
			<div class="fr alertBtn"><button class="btn success wd100 ht31" onclick="alertClose()">확인</button></div>
		</div>
	</div>
	<div class="compop" id="confirm">
		<div class="popHead"><div class="headFont" id="confirmHead">앙헤드띠</div></div>
	    <div class="alert">
			<div class="alertFont" id="confirmFont"></div>
			<div class="fr alertBtn">
			<button class="btn success wd100 ht31" id="confirmOk">확인</button>
			<button class="btn cancel wd100 ht31"  id="confirmNo">취소</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var alertpop = document.getElementById("alertPop");
	var confirm = document.getElementById("confirm");
	var maskPop = document.getElementById("maskPop");
	
	$(function() {
		$( "#alertPop" ).draggable();
		$( "#confirm" ).draggable();
	});
	
	function Alert(str) {
		
		var width = alertpop.offsetWidth;
		var height = alertpop.offsetHeight;
		
		maskPop.style.display = 'block';
		
		alertpop.style = { 'left' : ($(window).width() - width) / 2, 'top' : ($(window).height() - height) / 2 };
		
		
		document.getElementById("alertFont").innerHTML = str;
		
		alertpop.style.display = 'block';
		
	}
	function alertClose(){
		alertpop.style.display = 'none';
		maskPop.style.display = 'none';
	}
	
	function Confirm(str, head,func) {
		if(head != ""){
			document.getElementById("confirmHead").innerHTML = head;
		}else{
			document.getElementById("confirmHead").innerHTML = "알림";
		}
		var width = confirm.offsetWidth;
		var height = confirm.offsetHeight;
		
		maskPop.style.display = 'block';
		
		confirm.style = { 'left' : ($(window).width() - width) / 2, 'top' : ($(window).height() - height) / 2 };
		confirm.style.display = 'block';
		
		document.getElementById("confirmFont").innerHTML = str;
		
		modalConfirm(function(confirm){
			if(confirm){
				func(true);
			}else{
				func(false);
			}
		});
		
	}
	
	var modalConfirm = function (callback){
		
		document.getElementById('confirmOk').onclick = function(){
			callback(true);
			confirm.style.display = 'none';
			maskPop.style.display = 'none';
		}
		
		document.getElementById('confirmNo').onclick = function(){
			callback(false);
			confirm.style.display = 'none';
			maskPop.style.display = 'none';
		}
		
		
	};
	
	
</script>