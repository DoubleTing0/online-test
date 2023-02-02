<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href = "${pageContext.request.contextPath }/logout">로그아웃</a>
	<a href = "${pageContext.request.contextPath }/employee/modifyEmpPw">비밀번호 수정</a>
	
	<a href = "${pageContext.request.contextPath }/employee/empList">사원 관리</a>
	<!-- 등록시 ID체크(employee + student + teacher) union all -->
	
	<a href = "${pageContext.request.contextPath }/employee/teacherList">선생님 관리</a>
	<!-- 선생님 목록, 선생님 삭제 -->
	
	<a href = "${pageContext.request.contextPath }/employee/studentList">학생 관리</a>
	<!-- 학생 목록, 학생 삭제 -->
</div>