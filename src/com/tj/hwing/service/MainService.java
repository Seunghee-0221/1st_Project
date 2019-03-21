package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FBoardDao;
import com.tj.hwing.dao.NBoardDao;
import com.tj.hwing.dao.NoticeDao;
import com.tj.hwing.dao.ProductDao;
import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dto.FBoardDto;
import com.tj.hwing.dto.NBoardDto;
import com.tj.hwing.dto.NoticeDto;
import com.tj.hwing.dto.ProductDto;
import com.tj.hwing.dto.RBoardDto;

public class MainService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int startRow = 1;
		int endRow = 5;
		NoticeDao nDao = new NoticeDao();
		ArrayList<NoticeDto> nDtos = nDao.listNotice(startRow, endRow);
		NBoardDao nbDao = new NBoardDao();
		ArrayList<NBoardDto> nbDtos = nbDao.listNBoard(startRow, endRow);
		RBoardDao rbDao = new RBoardDao();
		ArrayList<RBoardDto> rbDtos = rbDao.listRBoard(startRow, endRow);
		FBoardDao fbDao = new FBoardDao();
		ArrayList<FBoardDto> fbDtos = fbDao.listFBoard(startRow, endRow);
		ProductDao pDao = new ProductDao();
		ArrayList<ProductDto> pDtos = pDao.newProduct();
		request.setAttribute("nList", nDtos);
		request.setAttribute("nbList", nbDtos);
		request.setAttribute("rbList", rbDtos);
		request.setAttribute("fbList", fbDtos);
		request.setAttribute("newProduct", pDtos);
	}
}
