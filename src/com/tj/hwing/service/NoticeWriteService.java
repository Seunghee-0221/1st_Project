package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NoticeDao;

public class NoticeWriteService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		NoticeDao nDao = new NoticeDao();
		int result = nDao.writeNotice(aId, nTitle, nContent);
		if(result == NoticeDao.SUCCESS) {
			request.setAttribute("msg", "공지사항 작성 완료");
		} else {
			request.setAttribute("msg", "공지사항 작성 실패");
		}
	}
}
