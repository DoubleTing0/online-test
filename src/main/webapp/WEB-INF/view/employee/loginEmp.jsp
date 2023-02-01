<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		
	</head>
	
	<body>
		<div>
			<h1>로그인</h1>
		</div>
		
		<div>
			<form action = "${pageContext.request.contextPath }/employee/loginEmp" method = "post">
				<table border = "1">
					<tr>
						<td>ID</td>
						<td>
							<input type = "text" name = "empId">
						</td>
					</tr>
					<tr>
						<td>Password</td>
						<td>
							<input type = "password" name = "empPw">
						</td>
					</tr>
				
				</table>
			
				<div>
					<button type = "submit">로그인</button>
				</div>
			
			</form>
		</div>
		
	</body>
</html>