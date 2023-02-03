<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
		<!-- Bootstrap CDN 시작 -->
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Bootstrap CDN 끝 -->		
		
		
	</head>
	
	<body>
		<div>
			<!-- empMenu -->
			<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
		</div>
	
		<div>
			<h1>학생 목록</h1>
		</div>
		
		<div>
			<a href = "${pageContext.request.contextPath }/employee/addStudent">학생 등록</a>
		</div>
		
		<!-- 학생 목록 -->
		<div>
			<table border = "1">
				<tr>
					<th>No</th>
					<th>ID</th>
					<th>Name</th>
					<th>삭제</th>
				</tr>
				<c:forEach var="s" items="${list }">
					<tr>
						<td>${s.studentNo }</td>
						<td>${s.studentId }</td>
						<td>${s.studentName }</td>
						<td>
							<a href = "${pageContext.request.contextPath }/employee/removeStudent?studentNo=${s.studentNo }">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- 검색 시작 -->
		<div>
			<form method = "get" action = "${pageContext.request.contextPath }/employee/studentList">
				<input type = "text" name = "searchWord">
				<button type = "submit">이름검색</button>
			</form>
		</div>
		
		<!-- 검색 끝 -->		
		
		<!-- 페이지 처리 시작 -->
		<div>
			<ul class="pagination justify-content-center">
				
				<!-- 페이지 처음 -->
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/employee/studentList?currentPage=1&searchWord=${searchWord}">
						<span>처음</span>
					</a>
				</li>
				
				<!-- 페이지 이전(-10의 1페이지) -->
				<c:if test="${previousPage > 0}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/employee/studentList?currentPage=${previousPage}&searchWord=${searchWord}">
							<span>이전</span>
						</a>
					</li>
				</c:if>
		
				<!-- 페이지 1 ~ 10 -->
				<c:forEach var="i" items="${pageList }">
					<!-- 현재페이지 active 속성 부여 -->
					<c:choose>
						<c:when test="${currentPage == i}">
							<li class = "page-item active">
						</c:when >
						<c:otherwise>
							<li class = "page-item">
						</c:otherwise>
					</c:choose>
				
					<!-- 마지막 페이지 까지만 출력 -->
					<c:if test="${i <= lastPage }">
						<a class="page-link" href="${pageContext.request.contextPath }/employee/studentList?currentPage=${i}&searchWord=${searchWord}">
							<span>${i }</span>
						</a>
					</c:if>
					
							</li>
					
				</c:forEach>
		
				<!-- 페이지 다음(+10의 1페이지) -->
				<c:if test="${nextPage <= lastPage }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/employee/studentList?currentPage=${nextPage}&searchWord=${searchWord}">
							<span>다음</span>
						</a>
					</li>
				</c:if>
		
				<!-- 페이지 마지막 -->
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/employee/studentList?currentPage=${lastPage}&searchWord=${searchWord}">
						<span>마지막</span>
					</a>
				</li>
			</ul>
		</div>		
		<!-- 페이지 처리 끝 -->
		
		
		
	</body>
</html>