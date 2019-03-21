<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 리스트</title>
<link rel="stylesheet" type="text/css"
	href="${conPath }/semantic/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="${conPath }/semantic/semantic.js"></script>
<style>
#line{
	font-size: 1.2em;
	line-height:40px;
}
#title {
	text-align: center;
	margin-bottom: 30px;
}

#paging {
	text-align: center;
}

b {
	color: red;
}
</style>
</head>
<body>
	<c:if test="${not empty msg }">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header">
				<i class="user secret icon"></i>관리자 리스트
			</h2>
		</div>
		<div class="ui middle aligned divided list">
			<c:forEach var="dto" items="${listAdmin }">
				<div class="item" id="line">
					<div class="right floated content">
						<div class="ui button"
							onclick="location='${conPath}/deleteAdminastor.do?aId=${dto.aId}'">
							관리자 삭제
						</div>
					</div>
					<i class="user circle icon"></i>
					<div class="content">${dto.aId }</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>