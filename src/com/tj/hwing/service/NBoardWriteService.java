package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NBoardDao;

public class NBoardWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String nbTitle = request.getParameter("nbTitle");
		String nbContent = request.getParameter("nbContent");
		NBoardDao nDao = new NBoardDao();
		int result = nDao.writeNBoard(nbTitle, nbContent, mId);
		if(result == NBoardDao.SUCCESS) {
			request.setAttribute("msg", "글쓰기 성공");
		} else {
			request.setAttribute("msg", "글쓰기 실패");
		}
	}
}
