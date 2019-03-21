package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NoticeDao;

public class NoticeDeleteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		NoticeDao nDao = new NoticeDao();
		int result = nDao.deleteNotice(nNo);
		if(result == NoticeDao.SUCCESS) {
			request.setAttribute("msg", "삭제 성공");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
