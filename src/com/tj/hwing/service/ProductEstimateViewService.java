package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.ProductDao;
import com.tj.hwing.dto.ProductDto;

public class ProductEstimateViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ProductDao pDao = new ProductDao();
		ArrayList<ProductDto> cpuList = pDao.listByPname("CPU");
		ArrayList<ProductDto> mainboardList = pDao.listByPname("MAINBOARD");
		ArrayList<ProductDto> ramList = pDao.listByPname("RAM");
		ArrayList<ProductDto> vgaList = pDao.listByPname("VGA");
		ArrayList<ProductDto> ssdList = pDao.listByPname("SSD");
		ArrayList<ProductDto> hddList = pDao.listByPname("HDD");
		ArrayList<ProductDto> pcaseList = pDao.listByPname("PCASE");
		ArrayList<ProductDto> powerList = pDao.listByPname("POWER");
		request.setAttribute("cpuList", cpuList);
		request.setAttribute("mainboardList", mainboardList);
		request.setAttribute("ramList", ramList);
		request.setAttribute("vgaList", vgaList);
		request.setAttribute("ssdList", ssdList);
		request.setAttribute("hddList", hddList);
		request.setAttribute("pcaseList", pcaseList);
		request.setAttribute("powerList", powerList);
	}
}
