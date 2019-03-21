package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.MemberDao;
import com.tj.hwing.dto.MemberDto;

public class LoginService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		MemberDao mDao = new MemberDao();
		MemberDto dto = mDao.loginMember(mId, mPw);
		if(dto == null) {
			request.setAttribute("mId", mId);
			request.setAttribute("msg", "로그인 실패! 아이디와 비밀번호 확인를 확인하세요");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
		}
	}
}
