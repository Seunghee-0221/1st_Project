<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<style>
		#join_form{width:400px; margin:0 auto;}
		b{font-weight:bold; color:red;}
		#title{text-align:center; margin-bottom:30px;}
	</style>
	<script>
		$(document).ready(function(){
			$('input[name="mId"]').keyup(function(){
				if($('input[name="mId"]').val().length < 4){
					$('#idMsg').html('<b>아이디를 4자이상 입력하세요</b>');
					$('#idChk').attr('disabled', true);
				} else {
					$('#idMsg').html('');
					$('#idChk').attr('disabled', false);
				}
			});
			$('#idChk').click(function(){
				var mId = $('input[name="mId"]').val();
				$.ajax({
					url : '${conPath}/mIdChk.do',
					type : 'post',
					data : "mId="+mId,
					dataType : 'html',
					success : function(data){
						$('#idMsg').html(data);
					}
				});
			});
			$('input[name="mPw"]').keyup(function(){
				if($('input[name="mPw"]').val().length < 6){
					$('#pwMsg').html('<b>비밀번호는 6자이상 입력하세요</b>');
				} else {
					$('#pwMsg').html('');
				}
			});
			$('input[name="mPwChk"]').keyup(function(){
				if($('input[name="mPw"]').val() != $('input[name="mPwChk"]').val()){
					$('#pwChkMsg').html('<b>비밀번호 불일치</b>');
				} else {
					$('#pwChkMsg').html('');
				}
			});
			$('input[name="mNickname"]').keyup(function(){
				$('#nicknameMsg').html('');
			});
			$('#nicknameChk').click(function(){
				var mNickname = $('input[name="mNickname"]').val();
				if(mNickname.length == 0){
					$('#nicknameMsg').html('<b>닉네임을 입력하세요</b>');
				} else {
					$.ajax({
						url : '${conPath}/mNicknameChk.do',
						type : 'post',
						data : "mNickname="+mNickname,
						dataType : 'html',
						success : function(data){
							$('#nicknameMsg').html(data);
						}
					});
				}
			});
			$("#join_form").submit(function() {
				if($('input[name="mIdChkMsg"]').val() != "사용가능한 아이디입니다"){
					alert('아이디 중복체크를 해주세요');
					return false;
				}
				if($('input[name="mPw"]').val().length < 6){
					alert('비밀번호는 6자이상 입력해주세요');
					$('input[name="mPw"]').val('');
					$('input[name="mPwChk"]').val('');
					$('input[name="mPw"]').focus();
					return false;
				}
				if($('input[name="mPw"]').val() != $('input[name="mPwChk"]').val()){
					alert('비밀번호와 비밀번호 확인을 동일하게 입력해주세요');
					$('input[name="mPw"]').val('');
					$('input[name="mPwChk"]').val('');
					$('input[name="mPw"]').focus();
					return false;
				}
				if($('input[name="mNicknameChkMsg"]').val() != "사용가능한 닉네임입니다"){
					alert('닉네임 중복체크를 해주세요');
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<c:if test="${not empty member or not empty admin }">
		<script>
			location='${conPath}/main.do';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header"><i class="user plus icon"></i>회원가입</h2>
		</div>
		<form class="ui form" action="${conPath }/join.do" method="post" id="join_form">
			<div class="field">
				<label><b>* </b>아이디</label> <input type="text" name="mId"
					placeholder="아이디" autocomplete="off" required="required">
					<span id="idMsg"></span>
					<input type="button" class="mini ui right floated button" id="idChk" value="중복체크" disabled="disabled">					
			</div>
			<div class="field">
				<label><b>* </b>비밀번호</label> <input type="password" name="mPw"
					placeholder="비밀번호" required="required">
					<div id="pwMsg"></div>
			</div>
			<div class="field">
				<label><b>* </b>비밀번호 확인</label> <input type="password" name="mPwChk"
					placeholder="비밀번호 확인" required="required">
					<div id="pwChkMsg"></div>
			</div>
			<div class="field">
				<label><b>* </b>이름</label> <input type="text" name="mName"
					placeholder="이름" required="required">
			</div>
			<div class="field">
				<label><b>* </b>닉네임</label> <input type="text" name="mNickname"
					placeholder="닉네임" required="required">
					<span id="nicknameMsg"></span>
					<input type="button" class="mini ui right floated button" id="nicknameChk" value="중복체크">
			</div>
			<div class="field">
				<label><b>* </b>생년월일</label> <input type="date" name="mBirth"
					placeholder="생년월일" required="required">
			</div>
			<div class="field">
				<label>이메일</label> <input type="email" name="mEmail"
					placeholder="이메일">
			</div>
			<div class="field">
				<label>주소</label> <input type="text" name="mAddress"
					placeholder="주소">
			</div>
			<input type="submit" class="ui button" value="회원가입">
			<input type="reset" class="ui right floated button" value="취소">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>