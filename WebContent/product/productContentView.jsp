<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 상세정보</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
</head>
<body>
	<div class="ui container">
		<br>
		<h2 class="ui top attached block header">
			${product.pName }
		</h2>
		<div class="ui bottom attached segment">
			<h4 class="ui right floated header">
				가격 : <fmt:formatNumber value="${product.pPrice }" pattern="##,###,###"/>
				원
			</h4>
			<div class="ui clearing divider"></div>
			${product.pContent }
		</div>
		<br><br>
	</div>
</body>
</html>