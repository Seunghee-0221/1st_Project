package com.tj.hwing.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.MemberDao;

public class JoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		String mName = request.getParameter("mName");
		String mNickname = request.getParameter("mNickname");
		Date mBirth = Date.valueOf(request.getParameter("mBirth"));
		String mEmail = request.getParameter("mEmail");
		String mAddress = request.getParameter("mAddress");
		MemberDao mDao = new MemberDao();
		int result = mDao.joinMember(mId, mPw, mName, mNickname, mBirth, mEmail, mAddress);
		if(result == MemberDao.SUCCESS) {
			request.setAttribute("mId", mId);
			request.setAttribute("msg", "가입성공! 로그인 후 이용하세요");
		} else {
			request.setAttribute("msg", "가입실패.. 양식을 다시 확인하세요");
		}
	}
}
