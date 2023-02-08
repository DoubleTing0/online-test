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
			<h1>시험지 만들기</h1>
		</div>
		
		<!-- 문제 추가 -->
		<div>
			<h1>문제 추가</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/question/addQuestion?testNo=${testNo}">
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
		
		<c:if test="${testOneList != null }">
		
			<div>
				<table border = "1">
					<c:forEach var="t" items="${testOneList }">
						<tr>
							<td>${t.questionIdx }번</td>
							
							<td colspan = "2">${t.questionTitle }</td>
							<td rowspan = "5">
								<a href = "${pageContext.request.contextPath }/teacher/question/modifyQuestion?questionNo=${t.questionNo}&exampleNo1=${t.exampleNo1 }&exampleNo2=${t.exampleNo2 }&exampleNo3=${t.exampleNo3 }&exampleNo4=${t.exampleNo4 }">수정</a>						
							</td>
							<td rowspan = "5">
								<a href = "${pageContext.request.contextPath }/teacher/question/removeQuestion?testNo=${t.testNo }&questionNo=${t.questionNo}&exampleNo1=${t.exampleNo1 }&exampleNo2=${t.exampleNo2 }&exampleNo3=${t.exampleNo3 }&exampleNo4=${t.exampleNo4 }">삭제</a>
							</td>
						</tr>
						
						<tr>
							<td>(1)</td>
							<td>${t.exampleTitle1 }</td>
							<td>${t.answer1 }</td>
						</tr>
						
						<tr>
							<td>(2)</td>
							<td>${t.exampleTitle2 }</td>
							<td>${t.answer2 }</td>
						</tr>
						
						<tr>
							<td>(3)</td>
							<td>${t.exampleTitle3 }</td>
							<td>${t.answer3 }</td>
						</tr>
						
						<tr>
							<td>(4)</td>
							<td>${t.exampleTitle4 }</td>
							<td>${t.answer4 }</td>
						</tr>
						
						<tr>
							<td colspan = "5">&nbsp;</td>
						</tr>
					
					</c:forEach>
				
				</table>
			</div>
		</c:if>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>