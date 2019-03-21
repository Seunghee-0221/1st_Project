package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.PListDao;

public class MyEstimateDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pLNo = Integer.parseInt(request.getParameter("pLNo"));
		PListDao pLDao = new PListDao();
		int result = pLDao.deletePList(pLNo);
		if(result == PListDao.SUCCESS) {
			request.setAttribute("msg", "삭제 완료");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
