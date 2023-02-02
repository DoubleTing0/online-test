<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<!-- jQuery -->
		<!-- CDN 주소 추가 방식 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>		
		
		<script>
		
			$(document).ready(function() {
				
				$('#cbEmployee').change(function() {
					$('#checkboxForm').submit();
				});
				
				$('#cbTeacher').change(function() {
					$('#checkboxForm').submit();
				});
				
				$('#cbStudent').change(function() {
					$('#checkboxForm').submit();
				});				
				
				
				console.log($('#cbEmployee').is(':checked'))
				
				if($('#cbEmployee').is(':checked')) {
					$('#employeeForm').show();
					$('#teacherForm').hide();
					$('#studentForm').hide();
				}
				
				if ($('#cbTeacher').is(':checked')){
					$('#employeeForm').hide();
					$('#teacherForm').show();
					$('#studentForm').hide();
				}
				
				if ($('#cbStudent').is(':checked')){
					$('#employeeForm').hide();
					$('#teacherForm').hide();
					$('#studentForm').show();
				}
				
			});
		
		</script>
		
	</head>
	
	<body>
		<c:if test="${loginEmp == null && loginTeacher == null && loginStudent == null }">
			<div>
				<h1>로그인</h1>
			</div>
				
			<div>
				<form id = "checkboxForm" method = "post" action = "${pageContext.request.contextPath }/login">
					<c:if test="${user == 'employee' || user == null }">
						<input type = "radio" name = "user" id = "cbEmployee" value = "employee" checked>사원
						<input type = "radio" name = "user" id = "cbTeacher" value = "teacher">선생님
						<input type = "radio" name = "user" id = "cbStudent" value = "student">학생
					</c:if>
					<c:if test="${user == 'teacher' }">
						<input type = "radio" name = "user" id = "cbEmployee" value = "employee">사원
						<input type = "radio" name = "user" id = "cbTeacher" value = "teacher" checked>선생님
						<input type = "radio" name = "user" id = "cbStudent" value = "student">학생
					</c:if>
					<c:if test="${user == 'student' }">
						<input type = "radio" name = "user" id = "cbEmployee" value = "employee">사원
						<input type = "radio" name = "user" id = "cbTeacher" value = "teacher">선생님
						<input type = "radio" name = "user" id = "cbStudent" value = "student" checked>학생
					</c:if>
				</form>
			</div>
						
			<!-- Employee -->
			<div>
				<form id = "employeeForm" action = "${pageContext.request.contextPath }/loginEmp" method = "post">
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
						
			<!-- Teacher -->
			<div>
				<form id = "teacherForm" action = "${pageContext.request.contextPath }/loginTeacher" method = "post">
					<table border = "1">
						<tr>
							<td>ID</td>
							<td>
								<input type = "text" name = "teacherId">
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<input type = "password" name = "teacherPw">
							</td>
						</tr>
					
					</table>
				
					<div>
						<button type = "submit">로그인</button>
					</div>
				
				</form>
			</div>
						
			<!-- Student -->
			<div>
				<form id = "studentForm" action = "${pageContext.request.contextPath }/loginStudent" method = "post">
					<table border = "1">
						<tr>
							<td>ID</td>
							<td>
								<input type = "text" name = "studentId">
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<input type = "password" name = "studentPw">
							</td>
						</tr>
					
					</table>
				
					<div>
						<button type = "submit">로그인</button>
					</div>
				
				</form>
			</div>
		</c:if>
		
		<!-- 로그인 한 경우 -->
		<c:if test="${loginEmp != null || loginTeacher != null || loginStudent != null }">
			
			<!-- 사원 로그인 성공할 경우 -->
			<c:if test="${loginEmp != null }">
				
				<!-- 사원 메뉴 -->
				<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>			
			
				${loginEmp.empName } 님! 반갑습니다.
			
			</c:if>
			
			<!-- 선생님 로그인 성공할 경우 -->
			<c:if test="${loginTeacher != null }">
				
				<!-- 선생님 메뉴 -->
				<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>			
			
				${loginTeacher.teacherName } 님! 반갑습니다.
			
			</c:if>
			
			<!-- 학생 로그인 성공할 경우 -->
			<c:if test="${loginStudent != null }">
				
				<!-- 학생 메뉴 -->
				<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>			
			
				${loginStudent.studentName } 님! 반갑습니다.
			
			</c:if>			
		
		
		</c:if>
		
		
		
		
	</body>
</html>