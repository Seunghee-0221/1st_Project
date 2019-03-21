package com.tj.hwing.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.hwing.dao.RBoardDao;
import com.tj.hwing.dao.RbCommentDao;
import com.tj.hwing.dao.RbLikeDao;
import com.tj.hwing.dto.MemberDto;
import com.tj.hwing.dto.RBoardDto;
import com.tj.hwing.dto.RbCommentDto;

public class RBoardContentViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rbNo = Integer.parseInt(request.getParameter("rbNo"));
		RBoardDao rDao = new RBoardDao();
		rDao.hitUpRBoard(rbNo);
		RBoardDto dto = rDao.getOneRBoard(rbNo);
		request.setAttribute("rBoard", dto);
		HttpSession session = request.getSession();
		MemberDto mDto = (MemberDto) session.getAttribute("member");
		if(mDto != null) {
			String mId = mDto.getmId();
			RbLikeDao rbLDao = new RbLikeDao();
			int result = rbLDao.stateRbLike(mId, rbNo);
			if(result == RbLikeDao.EXISTENT) {
				request.setAttribute("rbLike", "yes");
			}
		}
		RbCommentDao rbCDao = new RbCommentDao();
		ArrayList<RbCommentDto> dtos = rbCDao.listRbComment(rbNo);
		request.setAttribute("rbComment", dtos);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		ArrayList<RBoardDto> rDtos = rDao.listRBoard(startRow, endRow);
		request.setAttribute("list", rDtos);
		int totCnt = rDao.totCntRBoard();
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
