package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.MemberDao;
import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dto.MemberDto;

public class RBoardWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String rbTitle = request.getParameter("rbTitle");
		String rbContent = request.getParameter("rbContent");
		MemberDao mDao = new MemberDao();
		int result = mDao.rateUpMember(mId);
		if(result == 1) {
			MemberDto dto = mDao.getOneMember(mId);
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
		}
		RBoardDao rDao = new RBoardDao();
		result = rDao.writeRBoard(rbTitle, rbContent, mId);
		if(result == RBoardDao.SUCCESS) {
			request.setAttribute("msg", "글쓰기 성공");
		} else {
			request.setAttribute("msg", "글쓰기 실패");
		}
	}
}
