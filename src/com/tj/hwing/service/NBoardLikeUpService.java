package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NBoardDao;
import com.tj.hwing.dao.NbLikeDao;
import com.tj.hwing.dto.NBoardDto;

public class NBoardLikeUpService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		String mId = request.getParameter("mId");
		NBoardDao nDao = new NBoardDao();
		nDao.likeUpNBoard(nbNo);
		NbLikeDao nbDao = new NbLikeDao();
		nbDao.insertNbLike(mId, nbNo);
		NBoardDto dto = nDao.getOneNBoard(nbNo);
		request.setAttribute("nBoard", dto);
	}
}
