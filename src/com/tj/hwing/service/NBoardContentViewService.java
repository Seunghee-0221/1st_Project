package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.NBoardDao;
import com.tj.hwing.dao.NbCommentDao;
import com.tj.hwing.dao.NbLikeDao;
import com.tj.hwing.dto.MemberDto;
import com.tj.hwing.dto.NBoardDto;
import com.tj.hwing.dto.NbCommentDto;

public class NBoardContentViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nbNo = Integer.parseInt(request.getParameter("nbNo"));
		NBoardDao nDao = new NBoardDao();
		nDao.hitUpNBoard(nbNo);
		NBoardDto dto = nDao.getOneNBoard(nbNo);
		request.setAttribute("nBoard", dto);
		HttpSession session = request.getSession();
		MemberDto mDto = (MemberDto) session.getAttribute("member");
		if(mDto != null) {
			String mId = mDto.getmId();
			NbLikeDao nbLDao = new NbLikeDao();
			int result = nbLDao.stateNbLike(mId, nbNo);
			if(result == NbLikeDao.EXISTENT) {
				request.setAttribute("nbLike", "yes");
			}
		}
		NbCommentDao nbCDao = new NbCommentDao();
		ArrayList<NbCommentDto> dtos = nbCDao.listNbComment(nbNo);
		request.setAttribute("nbComment", dtos);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		ArrayList<NBoardDto> nDtos = nDao.listNBoard(startRow, endRow);
		request.setAttribute("list", nDtos);
		int totCnt = nDao.totCntNBoard();
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
