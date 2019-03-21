package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.AdminastorDao;

public class DeleteAdminastorService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		AdminastorDao aDao = new AdminastorDao();
		int result = aDao.deleteAdminastor(aId);
		if(result == AdminastorDao.SUCCESS) {
			request.setAttribute("msg", "삭제 완료");
		} else {
			request.setAttribute("msg", "삭제 실패");
		}
	}
}
