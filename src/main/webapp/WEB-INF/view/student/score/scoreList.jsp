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
			<h1>지난 시험 확인</h1>
		</div>
		
		<div>
			<table border = "1">
				<tr>
					<th>testTitle</th>
					<th>score</th>
					<th>testDate</th>
					<th>제출한 답안 확인</th>
				</tr>
				
				<c:forEach var="s" items="${scoreList }">
					<tr>
						<td>${s.testTitle }</td>
						<td>${s.score }</td>
						<td>${s.testDate }</td>
						<td>
							<a href = "${pageContext.request.contextPath }/student/paper/checkPaper?testNo=${s.testNo}">확인</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</body>
</html>