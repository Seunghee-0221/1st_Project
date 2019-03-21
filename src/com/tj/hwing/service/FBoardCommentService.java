package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.FbCommentDao;
import com.tj.hwing.dto.MemberDto;

public class FBoardCommentService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fbNo = Integer.parseInt(request.getParameter("fbNo"));
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		String mId = dto.getmId();
		String fbComment = request.getParameter("fbComment");
		FbCommentDao fbCDao = new FbCommentDao();
		int result = fbCDao.writeFbComment(fbNo, mId, fbComment);
		if(result == FbCommentDao.SUCCESS) {
			request.setAttribute("msg", "댓글작성 성공");
		} else {
			request.setAttribute("msg", "댓글작성 실패");
		}
	}
}
