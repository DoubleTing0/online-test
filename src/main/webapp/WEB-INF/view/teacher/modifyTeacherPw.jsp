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
			<h1>${loginTeacher.teacherName }님 비밀번호 수정</h1>
		</div>
		
		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/teacher/modifyTeacherPw">
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