package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.RBoardDao;

public class RBoardModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		String rbTitle = request.getParameter("rbTitle");
		String rbContent = request.getParameter("rbContent");
		RBoardDao rDao = new RBoardDao();
		int result = rDao.modifyRBoard(rbTitle, rbContent, rbNo);
		if(result == RBoardDao.SUCCESS) {
			request.setAttribute("msg", "수정 성공");
		} else {
			request.setAttribute("msg", "수정 실패");
		}
	}
}
