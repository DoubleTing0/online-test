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
			<h1>학생 등록</h1>
		</div>

		<div>
			<form method = "post" action = "${pageContext.request.contextPath }/student/addStudent">
				<div>
					<table border = "1">
						<tr>
							<th>ID</th>
							<td>
								<input type = "text" name = "studentId">
							</td>
						</tr>
					
						<tr>
							<th>Password</th>
							<td>
								<input type = "password" name = "studentPw">
							</td>
						</tr>
					
						<tr>
							<th>Name</th>
							<td>
								<input type = "text" name = "studentName">
							</td>
						</tr>
					</table>
				</div>
				
				<div>
					<button type = "submit">등록</button>
				</div>
			
			</form>
		</div>		
	</body>
</html>