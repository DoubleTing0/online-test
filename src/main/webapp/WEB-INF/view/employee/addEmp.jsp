<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		
	</head>
	
	<body>
		<div>
			<h1>사원 등록</h1>
		</div>
		
		<div>
			<h3>${errorMsg }</h3>
		</div>
		
		
		<div>
			<form action = "${pageContext.request.contextPath }/employee/addEmp" method = "post">
				<table>
					<!-- ID -->
					<tr>
						<td>ID</td>
						<td>
							<input type = "text" name = "empId">
						</td>
					</tr>	
					
					<!-- Password -->					
					<tr>
						<td>Password</td>
						<td>
							<input type = "password" name = "empPw">
						</td>
					</tr>						
					
					<!-- Name -->
					<tr>
						<td>Name</td>
						<td>
							<input type = "text" name = "empName">
						</td>
					</tr>						
				</table>
				
				<div>
					<button type = "submit">사원 등록</button>
				</div>
			</form>
		</div>
	</body>
</html>