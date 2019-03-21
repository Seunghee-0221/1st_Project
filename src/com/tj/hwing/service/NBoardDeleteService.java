package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NBoardDao;

public class NBoardDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		NBoardDao nDao = new NBoardDao();
		int result = nDao.deleteNBoard(nbNo);
		if(result == NBoardDao.SUCCESS) {
			request.setAttribute("msg", "삭제가 완료되었습니다");
		} else {
			request.setAttribute("msg", "삭제에 실패했습니다. 관리자에게 문의해주세요");
		}
	}
}
