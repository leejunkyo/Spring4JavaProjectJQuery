<%@ include file="/WEB-INF/jsp/common/ifmHead.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", function(){
		_ajaxGET(
				 '/jsm/jsm10110/jsm10110List.do'
				,''
				,function success(data){
					 vData = data.jsm10110List;
					 vHtml = "";
					 
					 for (var idx = 0; idx < vData.length; idx++) {
						 vHtml += "<td>"+vData[idx].exerciseParts +"</td>";
						 vHtml += "<td>"+vData[idx].exerciseName +"</td>";
					 }
					 
					 $("#grid tbody").append(vHtml);
					 
				});
	});
		
</script>
<body>
	<table class="tbl mt5" id="grid">
		<colgroup>
			<col width="40%" />
			<col width="60%" />
		</colgroup>
		<thead>
			<tr>
				<th>운동부위</th>
				<th>운동이름</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>

	<%@ include file="/WEB-INF/jsp/common/ifmFoot.jsp"%>