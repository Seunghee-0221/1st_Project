package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.NoticeDao;
import com.tj.hwing.dto.NoticeDto;

public class NoticeModifyViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		NoticeDao nDao = new NoticeDao();
		NoticeDto dto = nDao.getOneNotice(nNo);
		request.setAttribute("notice", dto);
	}
}
