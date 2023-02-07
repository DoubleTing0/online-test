<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		
	</head>
	
	<body>
		<!-- 선생님 메뉴 -->
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
		
		<div>
			<h1>${testOneList.get(0).testTitle } 시험 관리</h1>
		</div>
		
		<!-- 문제 추가 -->
		<div>
			<h1>문제 추가</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/question/addQuestion?testNo=${testOneList.get(0).testNo}">
				<div>
					<table>
						<tr>
							<td>문제번호</td>
							<td>
								<input type = "text" name = "questionIdx">
							</td>
						</tr>
						
						<tr>
							<td>문제</td>					
							<td>
								<textarea cols = "50" rows = "5" name = "questionTitle"></textarea>
							</td>					
						</tr>
						
						<tr>
							<td>보기 1</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle1"></textarea>
							</td>				
							<td>
								<input type = "radio" name = "answer1" value = "정답">정답
								<input type = "radio" name = "answer1" value = "오답">오답
							</td>
						</tr>				
						
						<tr>
							<td>보기 2</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle2"></textarea>
							</td>				
							<td>
								<input type = "radio" name = "answer2" value = "정답">정답
								<input type = "radio" name = "answer2" value = "오답">오답
							</td>
						</tr>				
						
						<tr>
							<td>보기 3</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle3"></textarea>
							</td>				
							<td>
								<input type = "radio" name = "answer3" value = "정답">정답
								<input type = "radio" name = "answer3" value = "오답">오답
							</td>
						</tr>				
						
						<tr>
							<td>보기 4</td>				
							<td>
								<textarea cols = "50" rows = "5" name = "exampleTitle4"></textarea>
							</td>				
							<td>
								<input type = "radio" name = "answer4" value = "정답">정답
								<input type = "radio" name = "answer4" value = "오답">오답
							</td>
						</tr>				
					</table>
				</div>
				
				<div>
					<button type = "submit">문제 등록</button>
				</div>
			</form>
		</div>
		
		
		<c:forEach var="t" items="${testOneList }">
			<div>
				<span>${t.questionIdx }번 </span>
				<span>${t.questionTitle }</span>
			</div>
			
			<div>
				<span>(1) ${t.exampleIdx1 }</span>
			</div>
			
			<div>
				<span>(2) ${t.exampleIdx2 }</span>
			</div>
			
			<div>
				<span>(3) ${t.exampleIdx3 }</span>
			</div>
			
			<div>
				<span>(4) ${t.exampleIdx4 }</span>
			</div>
			
			<div>&ensp;</div>
		
		</c:forEach>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>