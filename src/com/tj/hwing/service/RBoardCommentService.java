package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.RbCommentDao;
import com.tj.hwing.dto.MemberDto;

public class RBoardCommentService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		String mId = dto.getmId();
		String rbComment = request.getParameter("rbComment");
		RbCommentDao rbCDao = new RbCommentDao();
		int result = rbCDao.writeRbComment(rbNo, mId, rbComment);
		if(result == RbCommentDao.SUCCESS) {
			request.setAttribute("msg", "댓글작성 성공");
		} else {
			request.setAttribute("msg", "댓글작성 실패");
		}
	}
}
