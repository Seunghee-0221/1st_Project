package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.PListDao;
import com.tj.hwing.dao.ProductDao;
import com.tj.hwing.dto.PListDto;
import com.tj.hwing.dto.ProductDto;

public class MyEstimateViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		String mId = request.getParameter("mId");
		PListDao pLDao = new PListDao();
		ArrayList<PListDto> pLDtos = pLDao.listBymId(mId);
		if(!pLDtos.isEmpty()) {
			int totCnt = pLDtos.size();
			int pLNo = pLDtos.get(currentPage-1).getpLNo();
			int cpu = pLDtos.get(currentPage-1).getCpu();
			int mainboard = pLDtos.get(currentPage-1).getMainboard();
			int ram = pLDtos.get(currentPage-1).getRam();
			int vga = pLDtos.get(currentPage-1).getVga();
			int ssd = pLDtos.get(currentPage-1).getSsd();
			int hdd = pLDtos.get(currentPage-1).getHdd();
			int pcase = pLDtos.get(currentPage-1).getPcase();
			int power = pLDtos.get(currentPage-1).getPower();
			ProductDao pDao = new ProductDao();
			ProductDto cpuDto = pDao.getOneProduct(cpu);
			ProductDto mainboardDto = pDao.getOneProduct(mainboard);
			ProductDto ramDto = pDao.getOneProduct(ram);
			ProductDto vgaDto = pDao.getOneProduct(vga);
			ProductDto ssdDto = pDao.getOneProduct(ssd);
			ProductDto hddDto = pDao.getOneProduct(hdd);
			ProductDto pcaseDto = pDao.getOneProduct(pcase);
			ProductDto powerDto = pDao.getOneProduct(power);
			request.setAttribute("pLNo", pLNo);
			request.setAttribute("cpu", cpuDto);
			request.setAttribute("mainboard", mainboardDto);
			request.setAttribute("ram", ramDto);
			request.setAttribute("vga", vgaDto);
			request.setAttribute("ssd", ssdDto);
			request.setAttribute("hdd", hddDto);
			request.setAttribute("pcase", pcaseDto);
			request.setAttribute("power", powerDto);
			request.setAttribute("pageNum", currentPage);
			request.setAttribute("totCnt", totCnt);
		}
	}
}
