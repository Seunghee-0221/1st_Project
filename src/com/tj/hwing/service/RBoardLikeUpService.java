package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dao.RbLikeDao;
import com.tj.hwing.dto.RBoardDto;

public class RBoardLikeUpService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		String mId = request.getParameter("mId");
		RBoardDao rDao = new RBoardDao();
		rDao.likeUpRBoard(rbNo);
		RbLikeDao rbDao = new RbLikeDao();
		rbDao.insertRbLike(mId, rbNo);
		RBoardDto dto = rDao.getOneRBoard(rbNo);
		request.setAttribute("rBoard", dto);
	}
}
