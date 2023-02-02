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
		<!-- empMenu include -->
		<!-- include, forwad 는 requestDispatcher 가 하는 기술이다. -->
		<!-- server context 가 필요 없다. -->
		<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
	
		<h1>사원 관리</h1>
	
		<a href = "${pageContext.request.contextPath }/employee/addEmp">사원 등록</a>
	
		<table border = "1">
			<thead>
				<tr>
					<th>empNo</th>
					<th>empId</th>
					<th>empName</th>
					<th>삭제</th>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach var="e" items="${list }">
					<tr>
						<td>${e.empNo }</td>
						<td>${e.empId }</td>
						<td>${e.empName }</td>
						<td>
							<a href = "${pageContext.request.contextPath }/employee/removeEmp?empNo=${e.empNo}">삭제</a>
						</td>
					</tr>			
				</c:forEach>
			</tbody>		
		</table>
		
		<!-- 검색 시작 -->
		<div>
			<form method = "get" action = "${pageContext.request.contextPath }/employee/empList">
				<input type = "text" name = "searchWord">
				<button type = "submit">이름검색</button>
			</form>
		</div>
		
		<!-- 검색 끝 -->
		
		
		<!-- 페이지 처리 시작 -->
		<!-- 페이지 처리 -->
		<div>
			<ul class="pagination justify-content-center">
				
				<!-- 페이지 처음 -->
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/employee/empList?currentPage=1&searchWord=${searchWord}">
						<span>처음</span>
					</a>
				</li>
				
				<!-- 페이지 이전(-10의 1페이지) -->
				<c:if test="${previousPage > 0}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/employee/empList?currentPage=${previousPage}&searchWord=${searchWord}">
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
						<a class="page-link" href="${pageContext.request.contextPath }/employee/empList?currentPage=${i}&searchWord=${searchWord}">
							<span>${i }</span>
						</a>
					</c:if>
					
							</li>
					
				</c:forEach>
		
				<!-- 페이지 다음(+10의 1페이지) -->
				<c:if test="${nextPage <= lastPage }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath }/employee/empList?currentPage=${nextPage}&searchWord=${searchWord}">
							<span>다음</span>
						</a>
					</li>
				</c:if>
		
				<!-- 페이지 마지막 -->
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath }/employee/empList?currentPage=${lastPage}&searchWord=${searchWord}">
						<span>마지막</span>
					</a>
				</li>
			</ul>
		</div>
		<!-- 페이지 처리 끝 -->	
				
		
		
		
	
	
	</body>
</html>