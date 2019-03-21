package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FbCommentDao;

public class FBoardCommentDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fbCNo = Integer.parseInt(request.getParameter("fbCNo"));
		FbCommentDao fbCDao = new FbCommentDao();
		int result = fbCDao.deleteFbComment(fbCNo);
		if(result == FbCommentDao.SUCCESS) {
			request.setAttribute("msg", "삭제 완료");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
