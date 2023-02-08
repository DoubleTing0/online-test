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
			<h1>시험 응시</h1>
		</div>
		
		<div>
			<table border = "1">
				<tr>
					<th>testNo</th>
					<th>testTitle</th>
					<th>testDate</th>
				</tr>
				
				<c:forEach var="t" items="${testList }">
					<tr>
						<td>${t.testNo }</td>
						
						<td>
							<a href = "${pageContext.request.contextPath }/student/test/testOne?testNo=${t.testNo }">${t.testTitle }</a>
						</td>
						
						<td>${t.testDate }</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</body>
</html>