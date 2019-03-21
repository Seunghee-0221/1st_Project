package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.AdminastorDao;

public class InsertAdminastorService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		AdminastorDao aDao = new AdminastorDao();
		int result = aDao.insertAdminastor(aId, aPw);
		if(result == AdminastorDao.SUCCESS) {
			request.setAttribute("msg", "관리자 등록 성공");
		} else {
			request.setAttribute("msg", "관리자 등록 실패");
		}
	}
}
