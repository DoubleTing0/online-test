<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href = "${pageContext.request.contextPath }/logout">로그아웃</a>
	<a href = "${pageContext.request.contextPath }/teacher/modifyTeacherPw">비밀번호 수정</a>
		<!-- 
			시험회차(table : test) 관리(시험회차 CRUD)
		 	개별시험회차 클릭하면 그 회차의 문제 리스트 출력(문제 CRUd) 
		 	개별문제 클릭하면 그 문제의 보기 리스트 출력(보기 CRUd)
		 -->
	<a href="${pageContext.request.contextPath}/teacher/testList">시험관리</a>
	
</div>