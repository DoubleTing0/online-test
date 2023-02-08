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
			<h1>시험 수정</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/test/modifyTest?testNo=${test.testNo }">
				<div>
					testTitle : 
					<input type = "text" name = "testTitle" value = "${test.testTitle }">
				</div>
				
				<div>
					<button type = "submit">수정</button>
				</div>
			
			</form>
		</div>
		
	</body>
</html>