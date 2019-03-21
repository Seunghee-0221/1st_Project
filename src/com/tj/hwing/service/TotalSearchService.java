package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FBoardDao;
import com.tj.hwing.dao.NBoardDao;
import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dto.FBoardDto;
import com.tj.hwing.dto.NBoardDto;
import com.tj.hwing.dto.RBoardDto;

public class TotalSearchService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String search = request.getParameter("search");
		NBoardDao nBDao = new NBoardDao();
		ArrayList<NBoardDto> nBDtos = nBDao.totalSearchNBoard(search);
		RBoardDao rBDao = new RBoardDao();
		ArrayList<RBoardDto> rBDtos = rBDao.totalSearchRBoard(search);
		FBoardDao fBDao = new FBoardDao();
		ArrayList<FBoardDto> fBDtos = fBDao.totalSearchFBoard(search);
		request.setAttribute("nBoardList", nBDtos);
		request.setAttribute("rBoardList", rBDtos);
		request.setAttribute("fBoardList", fBDtos);
	}
}
