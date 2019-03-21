package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.PListDao;

public class ProductEstimateInsertService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String cpu = request.getParameter("cpu");
		String mainboard = request.getParameter("mainboard");
		String ram = request.getParameter("ram");
		String vga = request.getParameter("vga");
		String ssd = request.getParameter("ssd");
		String hdd = request.getParameter("hdd");
		String pcase = request.getParameter("pcase");
		String power = request.getParameter("power");
		PListDao pLDao = new PListDao();
		int result = pLDao.insertPList(mId, cpu, mainboard, ram, vga, ssd, hdd, pcase, power);
		if(result == PListDao.SUCCESS) {
			request.setAttribute("msg", "저장 완료");
		} else {
			request.setAttribute("msg", "저장 실패");
		}
	}
}
