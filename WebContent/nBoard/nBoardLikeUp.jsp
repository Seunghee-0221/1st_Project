<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<input type="hidden" name="likeState" value="2">
	<div class="ui red button">
		<i class="heart icon"></i>좋아요
	</div>
	<a class="ui basic red left pointing label">
		${nBoard.nbLike }
	</a>
</body>
</html>