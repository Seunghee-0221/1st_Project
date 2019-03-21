package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.MemberDao;

public class MidChkService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = new MemberDao();
		int result = mDao.mIdChk(mId);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("mIdChkMsg", "<b>중복된 아이디입니다</b>");
		} else {
			request.setAttribute("mIdChkMsg", "사용가능한 아이디입니다");
		}
	}
}
