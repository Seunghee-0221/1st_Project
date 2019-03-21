package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.FBoardDao;
import com.tj.hwing.dao.FbCommentDao;
import com.tj.hwing.dto.FBoardDto;
import com.tj.hwing.dto.FbCommentDto;

public class FBoardContentViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fbNo = Integer.parseInt(request.getParameter("fbNo"));
		FBoardDao fDao = new FBoardDao();
		fDao.hitUpFBoard(fbNo);
		FBoardDto dto = fDao.getOneFBoard(fbNo);
		request.setAttribute("fBoard", dto);
		FbCommentDao fbCDao = new FbCommentDao();
		ArrayList<FbCommentDto> dtos = fbCDao.listFbComment(fbNo);
		request.setAttribute("fbComment", dtos);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		ArrayList<FBoardDto> fDtos = fDao.listFBoard(startRow, endRow);
		request.setAttribute("list", fDtos);
		int totCnt = fDao.totCntFBoard();
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("totCnt", totCnt);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("pageNum", currentPage);
	}
}
