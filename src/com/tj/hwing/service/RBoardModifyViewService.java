package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dto.RBoardDto;

public class RBoardModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		RBoardDao rDao = new RBoardDao();
		RBoardDto dto = rDao.getOneRBoard(rbNo);
		request.setAttribute("rBoard", dto);
	}
}
