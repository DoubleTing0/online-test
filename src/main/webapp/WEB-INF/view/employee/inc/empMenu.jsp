<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href = "${pageContext.request.contextPath }/employee/logout">로그아웃</a>
	<a href = "${pageContext.request.contextPath }/employee/modifyEmpPw">비밀번호 수정</a>
	
	<a href = "${pageContext.request.contextPath }/employee/empList">사원 관리</a>
	<!-- 등록시 ID체크(employee + student + teacher) union all -->
	
	<a href = "${pageContext.request.contextPath }/teacher/teacherList">강사 관리</a>
	<!-- 강사 목록, 강사 삭제 -->
	
	<a href = "${pageContext.request.contextPath }/student/studentList">학생 관리</a>
	<!-- 학생 목록, 학생 삭제 -->
</div>