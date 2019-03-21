package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.AdminastorDao;
import com.tj.hwing.dto.AdminastorDto;

public class ManagementAdminastorViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		AdminastorDao aDao = new AdminastorDao();
		ArrayList<AdminastorDto> dtos = aDao.listAllAdminastor();
		request.setAttribute("listAdmin", dtos);
	}
}
