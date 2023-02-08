<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
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
		<div>
			<h1>시험지</h1>
		</div>
		
		<c:if test="${testOneList != null }">
		
			<div>
				<form method = "post" action = "${pageContext.request.contextPath }/student/paper/addPaper?testNo=${testNo}">
					<table border = "1">
						<c:forEach var="t" items="${testOneList }">
								<tr>
									<td></td>
									<td>${t.questionIdx }번</td>
									<td>${t.questionTitle }</td>
								</tr>
								
								<tr>
									<td>
										<div class = "checkboxDiv">
											<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
											<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
										</div>
									</td>
									<td>(1)</td>
									<td>${t.exampleTitle1 }</td>
								</tr>
								
								<tr>
									<td>
										<div class = "checkboxDiv">
											<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
											<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
										</div>
									</td>
									<td>(2)</td>
									<td>${t.exampleTitle2 }</td>
								</tr>
								
								<tr>
									<td>
										<div class = "checkboxDiv">
											<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
											<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
										</div>
									</td>
									<td>(3)</td>
									<td>${t.exampleTitle3 }</td>
								</tr>
								
								<tr>
									<td>
										<div class = "checkboxDiv">
											<input type = "checkbox" name = "checkbox" class = "cb" id = "true" value = "정답">
											<input type = "checkbox" name = "checkbox" class = "cbFalse" id = "false" value = "오답" checked>
										</div>
									</td>
									<td>(4)</td>
									<td>${t.exampleTitle4 }</td>
								</tr>
								
								<tr>
									<td colspan = "3">&nbsp;</td>
								</tr>
						</c:forEach>
					</table>
					<div>
						<button type = "submit">제출</button>
					</div>
				</form>
			</div>
		</c:if>
		
	</body>
</html>