package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.AdminastorDao;
import com.tj.hwing.dto.AdminastorDto;

public class AdminastorLoginService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		String aPw = request.getParameter("aPw");
		AdminastorDao aDao = new AdminastorDao();
		AdminastorDto dto = aDao.loginAdminastor(aId, aPw);
		if(dto == null) {
			request.setAttribute("msg", "로그인 실패! 아이디와 비밀번호를 확인하세요");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("admin", dto);
		}
	}
}
