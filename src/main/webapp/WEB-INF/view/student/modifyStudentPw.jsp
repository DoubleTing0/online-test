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
			<h1>${loginStudent.studentName }님 비밀번호 수정</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/student/modifyStudentPw">
				<div>
					<table border = "1">
						<tr>
							<td>현재 비밀번호</td>
							<td>
								<input type = "password" name = "oldPw">
							</td>
						</tr>
					
						<tr>
							<td>새로운 비밀번호</td>
							<td>
								<input type = "password" name = "newPw">
							</td>
						</tr>
					
					</table>
				</div>
				
				<div>
					<button type = "submit">수정</button>
				</div>
			
			
			</form>
		</div>		
		
	</body>
</html>