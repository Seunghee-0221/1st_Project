package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NoticeDao;

public class NoticeModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		NoticeDao nDao = new NoticeDao();
		int result = nDao.modifyNotice(nNo, nTitle, nContent);
		if(result == NoticeDao.SUCCESS) {
			request.setAttribute("msg", "수정 성공");
		} else {
			request.setAttribute("msg", "수정 실패");
		}
	}
}
