<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보 수정</title>
	<link rel="stylesheet" type="text/css"
		href="${conPath }/semantic/semantic.css">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<script src="${conPath }/semantic/semantic.js"></script>
	<style>
		#modify_form{width:400px; margin:0 auto;}
		b{font-weight:bold; color:red;}
		#title{text-align:center; margin-bottom:30px;}
	</style>
	<script>
		$(document).ready(function(){
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
			$("#modify_form").submit(function() {
				if($('input[name="mPw"]').val() != "" && $('input[name="mPw"]').val().length < 6){
					alert('비밀번호 변경은 6자이상 입력해주세요');
					$('input[name="mPw"]').val('');
					$('input[name="mPwChk"]').val('');
					$('input[name="mPw"]').focus();
					return false;
				}
				if($('input[name="mPw"]').val() != $('input[name="mPwChk"]').val()){
					alert('비밀번호 변경과 비밀번호 변경 확인을 동일하게 입력해주세요');
					$('input[name="mPw"]').val('');
					$('input[name="mPwChk"]').val('');
					$('input[name="mPw"]').focus();
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<c:if test="${empty member }">
		<script>
			location="${conPath}/main.do";
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div class="ui container">
		<div id="title">
			<h2 class="ui teal image header"><i class="edit outline icon"></i>회원정보 수정</h2>
		</div>
		<form class="ui form" action="${conPath }/modifyMember.do" method="post" id="modify_form">
			<input type="hidden" name="mId" value="${member.mId }">
			<input type="hidden" name="original_mPw" value="${member.mPw }">
			<div class="field">
				<label>비밀번호 변경</label> <input type="password" name="mPw"
					placeholder="비밀번호">
					<div id="pwMsg"></div>
			</div>
			<div class="field">
				<label>비밀번호 변경 확인</label> <input type="password" name="mPwChk"
					placeholder="비밀번호 확인">
					<div id="pwChkMsg"></div>
			</div>
			<div class="field">
				<label><b>* </b>이름</label> <input type="text" name="mName"
					placeholder="이름" required="required" value="${member.mName }">
			</div>
			<div class="field">
				<label><b>* </b>닉네임</label> <input type="text" name="mNickname"
					placeholder="닉네임" required="required" value="${member.mNickname }">
					<span id="nicknameMsg"></span>
					<input type="button" class="mini ui right floated button" id="nicknameChk" value="중복체크">
			</div>
			<div class="field">
				<label><b>* </b>생년월일</label> <input type="date" name="mBirth"
					placeholder="생년월일" required="required" value="${member.mBirth }">
			</div>
			<div class="field">
				<label>이메일</label> <input type="email" name="mEmail"
					placeholder="이메일" value="${member.mEmail }">
			</div>
			<div class="field">
				<label>주소</label> <input type="text" name="mAddress"
					placeholder="주소" value="${member.mAddress }">
			</div>
			<input type="submit" class="ui button" value="정보수정">
			<input type="button" class="ui right floated button" value="회원탈퇴" onclick="location='${conPath}/deleteMember.do?mId=${member.mId }'">
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>