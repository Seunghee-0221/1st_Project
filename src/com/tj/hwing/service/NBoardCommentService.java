package com.tj.hwing.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.NbCommentDao;
import com.tj.hwing.dto.MemberDto;

public class NBoardCommentService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		String mId = dto.getmId();
		String nbComment = request.getParameter("nbComment");
		NbCommentDao nbCDao = new NbCommentDao();
		int result = nbCDao.writeNbComment(nbNo, mId, nbComment);
		if(result == NbCommentDao.SUCCESS) {
			request.setAttribute("msg", "댓글작성 성공");
		} else {
			request.setAttribute("msg", "댓글작성 실패");
		}
	}
}
