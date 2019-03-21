package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.MemberDao;
import com.tj.hwing.dto.MemberDto;

public class ModifyRateMemberService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		int rCode = Integer.parseInt(request.getParameter("rCode"));
		MemberDao mDao = new MemberDao();
		int result = mDao.modifyRateMember(rCode, mId);
		if(result == MemberDao.SUCCESS) {
			MemberDto dto = mDao.getOneMember(mId);
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
			request.setAttribute("msg", "회원등급 수정 성공");
		} else {
			request.setAttribute("msg", "회원등급 수정 실패");
		}
	}
}
