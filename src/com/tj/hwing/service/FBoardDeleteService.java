package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FBoardDao;

public class FBoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fbNo = Integer.parseInt(request.getParameter("fbNo"));
		FBoardDao fDao = new FBoardDao();
		int result = fDao.deleteFBoard(fbNo);
		if(result == FBoardDao.SUCCESS) {
			request.setAttribute("msg", "삭제가 완료되었습니다");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다. 관리자에게 문의해주세요");
		}
	}
}
