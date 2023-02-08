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
			<h1>시험 목록</h1>
		</div>
		
		<div>
			<a href = "${pageContext.request.contextPath }/teacher/test/addTest">시험등록</a>
		</div>
		
		<div>
			<table border = "1">
				<tr>
					<th>testNo</th>
					<th>testTitle</th>
					<th>testDate</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				
				<c:forEach var="t" items="${testList }">
					<tr>
						<td>${t.testNo }</td>
						
						<td>
							<a href = "${pageContext.request.contextPath }/teacher/test/testOne?testNo=${t.testNo }">${t.testTitle }</a>
						</td>
						
						<td>${t.testDate }</td>
						
						<td>
							<a href ="${pageContext.request.contextPath }/teacher/test/modifyTest?testNo=${t.testNo }">수정</a>
						</td>
						
						<td>
							<a href ="${pageContext.request.contextPath }/teacher/test/removeTest?testNo=${t.testNo }">삭제</a>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
		
	</body>
</html>