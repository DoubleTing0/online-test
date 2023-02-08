<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
	<!-- jQuery -->
	<!-- CDN 주소 추가 방식 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    		
		
		<script>
			$(document).ready(function() {
				
				$('.cbFalse').hide();
				
				let checkboxDiv = $('.checkboxDiv');
				
				checkboxDiv.on('click', '.cb', function () {
					
					let checkbox = $(this);
					
					let check1 = checkbox.parent().find('#true')
					let check2 = checkbox.parent().find('#false')
					
					if(check1.is(':checked')) {
						check2.prop('checked',false);
					} else {
						check2.prop('checked',true);
						
					}
					
				});
				 
			});
		
		</script>
		
	</head>
	<body>
		test page
		<!-- foreach 시작 -->
		<form method = "post" action = "${pageContext.request.contextPath }/test5">
			<div class = "checkboxDiv">
				<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
				<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
			</div>
			<div class = "checkboxDiv">
				<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
				<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
			</div>
			<div class = "checkboxDiv">
				<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
				<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
			</div>
			<div class = "checkboxDiv">
				<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
				<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
			</div>
			
				<button type = "submit">버튼</button>
		</form>
		<!-- foreach 끝 -->
	</body>
</html>