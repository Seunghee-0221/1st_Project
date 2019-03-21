package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NbCommentDao;

public class NBoardCommentDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbCNo = Integer.parseInt(request.getParameter("nbCNo"));
		NbCommentDao nbCDao = new NbCommentDao();
		int result = nbCDao.deleteNbComment(nbCNo);
		if(result == NbCommentDao.SUCCESS) {
			request.setAttribute("msg", "삭제 완료");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
