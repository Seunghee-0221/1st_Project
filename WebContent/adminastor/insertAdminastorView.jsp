<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 등록</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<style>
		#insert_form{width:400px; margin:0 auto;}
		b{font-weight:bold; color:red;}
		#title{text-align:center; margin-bottom:30px;}
	</style>
	<script>
		$(document).ready(function(){
			$('input[name="aId"]').keyup(function(){
				if($('input[name="aId"]').val().length < 4){
					$('#idMsg').html('<b>아이디를 4자이상 입력하세요</b>');
					$('#idChk').attr('disabled', true);
				} else {
					$('#idMsg').html('');
					$('#idChk').attr('disabled', false);
				}
			});
			$('#idChk').click(function(){
				var aId = $('input[name="aId"]').val();
				$.ajax({
					url : '${conPath}/aIdChk.do',
					type : 'post',
					data : "aId="+aId,
					dataType : 'html',
					success : function(data){
						$('#idMsg').html(data);
					}
				});
			});
			$('input[name="aPw"]').keyup(function(){
				if($('input[name="aPw"]').val().length < 6){
					$('#pwMsg').html('<b>비밀번호는 6자이상 입력하세요</b>');
				} else {
					$('#pwMsg').html('');
				}
			});
			$('input[name="aPwChk"]').keyup(function(){
				if($('input[name="aPw"]').val() != $('input[name="aPwChk"]').val()){
					$('#pwChkMsg').html('<b>비밀번호 불일치</b>');
				} else {
					$('#pwChkMsg').html('');
				}
			});
			$("#insert_form").submit(function() {
				if($('input[name="aIdChkMsg"]').val() != "사용가능한 아이디입니다"){
					alert('아이디 중복체크를 해주세요');
					return false;
				}
				if($('input[name="aPw"]').val().length < 6){
					alert('비밀번호는 6자이상 입력해주세요');
					$('input[name="aPw"]').val('');
					$('input[name="aPwChk"]').val('');
					$('input[name="aPw"]').focus();
					return false;
				}
				if($('input[name="aPw"]').val() != $('input[name="aPwChk"]').val()){
					alert('비밀번호와 비밀번호 확인을 동일하게 입력해주세요');
					$('input[name="aPw"]').val('');
					$('input[name="aPwChk"]').val('');
					$('input[name="aPw"]').focus();
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<c:if test="${admin.aMaster != 1 }">
		<script>
			location='${conPath}/main.do';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header"><i class="user plus icon"></i>관리자 등록</h2>
		</div>
		<form class="ui form" action="${conPath }/insertAdminastor.do" method="post" id="insert_form">
			<div class="field">
				<label><b>* </b>관리자 아이디</label> <input type="text" name="aId"
					placeholder="관리자 아이디" autocomplete="off" required="required">
					<span id="idMsg"></span>
					<input type="button" class="mini ui right floated button" id="idChk" value="중복체크" disabled="disabled">					
			</div>
			<div class="field">
				<label><b>* </b>비밀번호</label> <input type="password" name="aPw"
					placeholder="비밀번호" required="required">
					<div id="pwMsg"></div>
			</div>
			<div class="field">
				<label><b>* </b>비밀번호 확인</label> <input type="password" name="aPwChk"
					placeholder="비밀번호 확인" required="required">
					<div id="pwChkMsg"></div>
			</div>
			<input type="submit" class="ui button" value="관리자 등록">
			<input type="reset" class="ui right floated button" value="취소">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>