package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.RBoardDao;

public class RBoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		RBoardDao rDao = new RBoardDao();
		int result = rDao.deleteRBoard(rbNo);
		if(result == RBoardDao.SUCCESS) {
			request.setAttribute("msg", "삭제가 완료되었습니다");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다. 관리자에게 문의해주세요");
		}
	}
}
