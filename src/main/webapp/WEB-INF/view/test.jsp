<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	test page
	<div>
		<c:forEach var="x" items="${list }">
		
			<c:if test="${x.tTestNo == x.qTestNo }">
				<div>${x.qQuestionIdx }</div>
			
			
			
			
			
			</c:if>
		
		
		
		
		
		
		
		</c:forEach>
		
	
	</div>
</body>
</html>