package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.MemberDao;

public class DeleteMemberByAdminService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = new MemberDao();
		int result = mDao.deleteMember(mId);
		if(result == MemberDao.SUCCESS) {
			request.setAttribute("msg", "회원탈퇴 처리 성공");
		} else {
			request.setAttribute("msg", "회원탈퇴 처리 실패");
		}
	}
}
