package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NBoardDao;
import com.tj.hwing.dto.NBoardDto;

public class NBoardModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		NBoardDao nDao = new NBoardDao();
		NBoardDto dto = nDao.getOneNBoard(nbNo);
		request.setAttribute("nBoard", dto);
	}
}
