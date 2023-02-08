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
			<h1>시험 등록</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/test/addTest">
				<div>
					testTitle : 
					<input type = "text" name = "testTitle">
				</div>
				
				<div>
					<button type = "submit">등록</button>
				</div>				
			</form>
		
		</div>
		
	</body>
</html>