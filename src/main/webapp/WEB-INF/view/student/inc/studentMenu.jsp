<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href = "${pageContext.request.contextPath }/logout">로그아웃</a>
	<a href = "${pageContext.request.contextPath }/student/modifyStudentPw">비밀번호 수정</a>
		<!-- 
			지나간 시험(table : test) 리스트+점수 - 점수확인버턴 - 제출답안지확인(table : paper)
			오늘날짜 시험 리스트는 응시버턴 - 시험지출력(table : question x example) - 답안지제출(table : paper)
		-->
	<a href="${pageContext.request.contextPath}/student/test/testList">시험 응시</a>
	<a href="${pageContext.request.contextPath}">시험 확인</a>
	
</div>

