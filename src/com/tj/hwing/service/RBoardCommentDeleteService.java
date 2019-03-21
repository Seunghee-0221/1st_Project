package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.RbCommentDao;

public class RBoardCommentDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbCNo = Integer.parseInt(request.getParameter("rbCNo"));
		RbCommentDao rbCDao = new RbCommentDao();
		int result = rbCDao.deleteRbComment(rbCNo);
		if(result == RbCommentDao.SUCCESS) {
			request.setAttribute("msg", "삭제 완료");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
