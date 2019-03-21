package com.tj.hwing.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.MemberDao;
import com.tj.hwing.dto.MemberDto;

public class ModifyMemberService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		if(mPw == "") {
			mPw = request.getParameter("original_mPw");
		}
		String mName = request.getParameter("mName");
		String mNickname = request.getParameter("mNickname");
		Date mBirth = Date.valueOf(request.getParameter("mBirth"));
		String mEmail = request.getParameter("mEmail");
		String mAddress = request.getParameter("mAddress");
		MemberDao mDao = new MemberDao();
		int result = mDao.modifyMember(mPw, mName, mNickname, mBirth, mEmail, mAddress, mId);
		if(result == MemberDao.SUCCESS) {
			MemberDto dto = mDao.getOneMember(mId);
			session.setAttribute("member", dto);
			request.setAttribute("msg", "회원정보 수정 성공");
		} else {
			request.setAttribute("msg", "회원정보 수정 실패");
		}
	}
}
