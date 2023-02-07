<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		
	</head>
	
	<body>
		<div>
			<h1>문제 수정</h1>
		</div>
		
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/question/modifyQuestion?testNo=${testNo }&questionNo=${questionNo}&exampleNo1=${exampleNo1 }&exampleNo2=${exampleNo2 }&exampleNo3=${exampleNo3 }&exampleNo4=${exampleNo4 }">
				<div>
					<table>
						<tr>
							<td>문제번호</td>
							<td>
								<input type = "text" name = "questionIdx" value = "${questionIdx }">
							</td>
						</tr>
						
						<tr>
							<td>문제</td>					
							<td>
								<textarea cols = "50" rows = "5" name = "questionTitle">${questionTitle }</textarea>
							</td>					
						</tr>
						
						<tr>
							<td>보기 1</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle1">${exampleTitle1 }</textarea>
							</td>				
							<td>
								<c:if test="${answer1 == '정답' }">
									<input type = "radio" name = "answer1" value = "정답" checked>정답
									<input type = "radio" name = "answer1" value = "오답">오답
								</c:if>
								<c:if test="${answer1 == '오답' }">
									<input type = "radio" name = "answer1" value = "정답">정답
									<input type = "radio" name = "answer1" value = "오답" checked>오답
								</c:if>								
							</td>
						</tr>				
						
						<tr>
							<td>보기 2</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle2">${exampleTitle2 }</textarea>
							</td>				
							<td>
								<c:if test="${answer2 == '정답' }">
									<input type = "radio" name = "answer2" value = "정답" checked>정답
									<input type = "radio" name = "answer2" value = "오답">오답
								</c:if>
								<c:if test="${answer2 == '오답' }">
									<input type = "radio" name = "answer2" value = "정답">정답
									<input type = "radio" name = "answer2" value = "오답" checked>오답
								</c:if>	
							</td>
						</tr>				
						
						<tr>
							<td>보기 3</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle3">${exampleTitle3 }</textarea>
							</td>				
							<td>
								<c:if test="${answer3 == '정답' }">
									<input type = "radio" name = "answer3" value = "정답" checked>정답
									<input type = "radio" name = "answer3" value = "오답">오답
								</c:if>
								<c:if test="${answer3 == '오답' }">
									<input type = "radio" name = "answer3" value = "정답">정답
									<input type = "radio" name = "answer3" value = "오답" checked>오답
								</c:if>	
							</td>
						</tr>				
						
						<tr>
							<td>보기 4</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle4">${exampleTitle4 }</textarea>
							</td>				
							<td>
								<c:if test="${answer4 == '정답' }">
									<input type = "radio" name = "answer4" value = "정답" checked>정답
									<input type = "radio" name = "answer4" value = "오답">오답
								</c:if>
								<c:if test="${answer4 == '오답' }">
									<input type = "radio" name = "answer4" value = "정답">정답
									<input type = "radio" name = "answer4" value = "오답" checked>오답
								</c:if>	
							</td>
						</tr>				
					</table>
				</div>
				
				<div>
					<button type = "submit">문제 수정</button>
				</div>
			
			
			
			</form>
		
		</div>
	</body>
</html>