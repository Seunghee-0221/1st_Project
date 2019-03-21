package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.AdminastorDao;

public class AidChkService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		AdminastorDao aDao = new AdminastorDao();
		int result = aDao.aIdChk(aId);
		if(result == AdminastorDao.EXISTENT) {
			request.setAttribute("aIdChkMsg", "<b>중복된 아이디입니다</b>");
		} else {
			request.setAttribute("aIdChkMsg", "사용가능한 아이디입니다");
		}
	}
}
