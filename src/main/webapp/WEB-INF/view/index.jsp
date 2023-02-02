<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		
	</head>
	
	<body>
		<c:if test="${loginEmp != null }">
			
			<!-- 사원 메뉴 -->
			<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>			
		
			${loginEmp.empName } 님! 반갑습니다.
		
		</c:if>
		
		<c:if test="${loginTeacher != null }">
			
			<!-- 선생님 메뉴 -->
			<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>			
		
			${loginTeacher.teacherName } 님! 반갑습니다.
		
		</c:if>
		
		<c:if test="${loginStudent != null }">
			
			<!-- 학생 메뉴 -->
			<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>			
		
			${loginStudent.studentName } 님! 반갑습니다.
		
		</c:if>
		
	</body>
</html>