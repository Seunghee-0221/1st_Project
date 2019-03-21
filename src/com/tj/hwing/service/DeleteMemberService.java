package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.MemberDao;

public class DeleteMemberService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = new MemberDao();
		int result = mDao.deleteMember(mId);
		if(result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg", "회원탈퇴 성공");
		} else {
			request.setAttribute("msg", "회원탈퇴 실패! 관리자에게 문의하세요");
		}
	}
}
