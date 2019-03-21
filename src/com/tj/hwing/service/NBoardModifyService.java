package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NBoardDao;

public class NBoardModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		String nbTitle = request.getParameter("nbTitle");
		String nbContent = request.getParameter("nbContent");
		NBoardDao nDao = new NBoardDao();
		int result = nDao.modifyNBoard(nbTitle, nbContent, nbNo);
		if(result == NBoardDao.SUCCESS) {
			request.setAttribute("msg", "수정 성공");
		} else {
			request.setAttribute("msg", "수정 실패");
		}
	}
}
