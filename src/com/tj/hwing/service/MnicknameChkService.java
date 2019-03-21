package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.MemberDao;

public class MnicknameChkService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mNickname = request.getParameter("mNickname");
		MemberDao mDao = new MemberDao();
		int result = mDao.mNicknameChk(mNickname);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("mNicknameChkMsg", "<b>중복된 닉네임입니다</b>");
		} else {
			request.setAttribute("mNicknameChkMsg", "사용가능한 닉네임입니다");
		}
	}
}
