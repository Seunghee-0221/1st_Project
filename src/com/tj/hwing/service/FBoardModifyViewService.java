package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FBoardDao;
import com.tj.hwing.dto.FBoardDto;

public class FBoardModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fbNo = Integer.parseInt(request.getParameter("fbNo"));
		FBoardDao fDao = new FBoardDao();
		FBoardDto dto = fDao.getOneFBoard(fbNo);
		request.setAttribute("fBoard", dto);
	}
}
