package com.tj.hwing.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.service.AdminastorLoginService;
import com.tj.hwing.service.AidChkService;
import com.tj.hwing.service.DeleteAdminastorService;
import com.tj.hwing.service.DeleteMemberByAdminService;
import com.tj.hwing.service.DeleteMemberService;
import com.tj.hwing.service.FBoardCommentDeleteService;
import com.tj.hwing.service.FBoardCommentService;
import com.tj.hwing.service.FBoardContentViewService;
import com.tj.hwing.service.FBoardDeleteService;
import com.tj.hwing.service.FBoardModifyService;
import com.tj.hwing.service.FBoardModifyViewService;
import com.tj.hwing.service.FBoardReplyService;
import com.tj.hwing.service.FBoardReplyViewService;
import com.tj.hwing.service.FBoardViewService;
import com.tj.hwing.service.FBoardWriteService;
import com.tj.hwing.service.InsertAdminastorService;
import com.tj.hwing.service.JoinService;
import com.tj.hwing.service.LoginService;
import com.tj.hwing.service.LogoutService;
import com.tj.hwing.service.MainService;
import com.tj.hwing.service.ManagementAdminastorViewService;
import com.tj.hwing.service.MidChkService;
import com.tj.hwing.service.ManagementMemberViewService;
import com.tj.hwing.service.MnicknameChkService;
import com.tj.hwing.service.ModifyMemberService;
import com.tj.hwing.service.ModifyRateMemberService;
import com.tj.hwing.service.MyEstimateDeleteService;
import com.tj.hwing.service.MyEstimateViewService;
import com.tj.hwing.service.NBoardCommentDeleteService;
import com.tj.hwing.service.NBoardCommentService;
import com.tj.hwing.service.NBoardContentViewService;
import com.tj.hwing.service.NBoardDeleteService;
import com.tj.hwing.service.NBoardLikeDownService;
import com.tj.hwing.service.NBoardLikeUpService;
import com.tj.hwing.service.NBoardModifyService;
import com.tj.hwing.service.NBoardModifyViewService;
import com.tj.hwing.service.NBoardViewService;
import com.tj.hwing.service.NBoardWriteService;
import com.tj.hwing.service.NoticeContentViewService;
import com.tj.hwing.service.NoticeDeleteService;
import com.tj.hwing.service.NoticeModifyService;
import com.tj.hwing.service.NoticeModifyViewService;
import com.tj.hwing.service.NoticeViewService;
import com.tj.hwing.service.NoticeWriteService;
import com.tj.hwing.service.ProductContentViewService;
import com.tj.hwing.service.ProductDeleteService;
import com.tj.hwing.service.ProductEstimateInsertService;
import com.tj.hwing.service.ProductEstimateViewService;
import com.tj.hwing.service.ProductInsertService;
import com.tj.hwing.service.ProductManagementViewService;
import com.tj.hwing.service.ProductModifyService;
import com.tj.hwing.service.ProductModifyViewService;
import com.tj.hwing.service.RBoardCommentDeleteService;
import com.tj.hwing.service.RBoardCommentService;
import com.tj.hwing.service.RBoardContentViewService;
import com.tj.hwing.service.RBoardDeleteService;
import com.tj.hwing.service.RBoardLikeDownService;
import com.tj.hwing.service.RBoardLikeUpService;
import com.tj.hwing.service.RBoardModifyService;
import com.tj.hwing.service.RBoardModifyViewService;
import com.tj.hwing.service.RBoardViewService;
import com.tj.hwing.service.RBoardWriteService;
import com.tj.hwing.service.TotalSearchService;
import com.tj.hwing.service.Service;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		// member
		if(command.equals("/main.do")) {
			service = new MainService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/joinView.do")) {
			viewPage = "member/joinView.jsp";
		} else if(command.equals("/mIdChk.do")) {
			service = new MidChkService();
			service.execute(request, response);
			viewPage = "member/idChk.jsp";
		} else if(command.equals("/mNicknameChk.do")) {
			service = new MnicknameChkService();
			service.execute(request, response);
			viewPage = "member/nicknameChk.jsp";
		} else if(command.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "member/loginView.jsp";
		} else if(command.equals("/loginView.do")) {
			viewPage = "member/loginView.jsp";
		} else if(command.equals("/login.do")) {
			service = new LoginService();
			service.execute(request, response);
			viewPage = "member/loginView.jsp";
		} else if(command.equals("/logout.do")) {
			service = new LogoutService();
			service.execute(request, response);
			viewPage = "main.do";
		} else if(command.equals("/modifyMemberView.do")) {
			viewPage = "member/modifyMemberView.jsp";
		} else if(command.equals("/modifyMember.do")) {
			service = new ModifyMemberService();
			service.execute(request, response);
			viewPage = "main.do";
		} else if(command.equals("/deleteMember.do")) {
			service = new DeleteMemberService();
			service.execute(request, response);
			viewPage = "main.do";
		// adminastor
		} else if(command.equals("/admin.do")) {
			viewPage = "adminastor/adminLoginView.jsp";
		} else if(command.equals("/adminLogin.do")) {
			service = new AdminastorLoginService();
			service.execute(request, response);
			viewPage = "admin.do";
		} else if(command.equals("/managementMemberView.do")) {
			service = new ManagementMemberViewService();
			service.execute(request, response);
			viewPage = "adminastor/managementMemberView.jsp";
		} else if(command.equals("/modifyRateMember.do")) {
			service = new ModifyRateMemberService();
			service.execute(request, response);
			viewPage = "managementMemberView.do";
		} else if(command.equals("/deleteMemberByAdmin.do")) {
			service = new DeleteMemberByAdminService();
			service.execute(request, response);
			viewPage = "managementMemberView.do";
		} else if(command.equals("/insertAdminastorView.do")) {
			viewPage = "adminastor/insertAdminastorView.jsp";
		} else if(command.equals("/insertAdminastor.do")) {
			service = new InsertAdminastorService();
			service.execute(request, response);
			viewPage = "managementAdminastorView.do";
		} else if(command.equals("/aIdChk.do")) {
			service = new AidChkService();
			service.execute(request, response);
			viewPage = "adminastor/aIdChk.jsp";
		} else if(command.equals("/managementAdminastorView.do")) {
			service = new ManagementAdminastorViewService();
			service.execute(request, response);
			viewPage = "adminastor/managementAdminastorView.jsp";
		} else if(command.equals("/deleteAdminastor.do")) {
			service = new DeleteAdminastorService();
			service.execute(request, response);
			viewPage = "managementAdminastorView.do";
		// NBoard
		} else if(command.equals("/nBoardView.do")) {
			service = new NBoardViewService();
			service.execute(request, response);
			viewPage = "nBoard/nBoardView.jsp";
		} else if(command.equals("/nBoardWriteView.do")) {
			viewPage = "nBoard/nBoardWriteView.jsp";
		} else if(command.equals("/nBoardWrite.do")) {
			service = new NBoardWriteService();
			service.execute(request, response);
			viewPage = "nBoardView.do";
		} else if(command.equals("/nBoardContentView.do")) {
			service = new NBoardContentViewService();
			service.execute(request, response);
			viewPage = "nBoard/nBoardContentView.jsp";
		} else if(command.equals("/nBoardLikeUp.do")) {
			service = new NBoardLikeUpService();
			service.execute(request, response);
			viewPage = "nBoard/nBoardLikeUp.jsp";
		} else if(command.equals("/nBoardLikeDown.do")) {
			service = new NBoardLikeDownService();
			service.execute(request, response);
			viewPage = "nBoard/nBoardLikeDown.jsp";
		} else if(command.equals("/nBoardComment.do")) {
			service = new NBoardCommentService();
			service.execute(request, response);
			viewPage = "nBoardContentView.do";
		} else if(command.equals("/nBoardCommentDelete.do")) {
			service = new NBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "nBoardContentView.do";
		} else if(command.equals("/nBoardModifyView.do")) {
			service = new NBoardModifyViewService();
			service.execute(request, response);
			viewPage = "nBoard/nBoardModifyView.jsp";
		} else if(command.equals("/nBoardModify.do")) {
			service = new NBoardModifyService();
			service.execute(request, response);
			viewPage = "nBoardContentView.do";
		} else if(command.equals("/nBoardDelete.do")) {
			service = new NBoardDeleteService();
			service.execute(request, response);
			viewPage = "nBoardView.do";
		// RBoard
		} else if(command.equals("/rBoardView.do")) {
			service = new RBoardViewService();
			service.execute(request, response);
			viewPage = "rBoard/rBoardView.jsp";
		} else if(command.equals("/rBoardWriteView.do")) {
			viewPage = "rBoard/rBoardWriteView.jsp";
		} else if(command.equals("/rBoardWrite.do")) {
			service = new RBoardWriteService();
			service.execute(request, response);
			viewPage = "rBoardView.do";
		} else if(command.equals("/rBoardContentView.do")) {
			service = new RBoardContentViewService();
			service.execute(request, response);
			viewPage = "rBoard/rBoardContentView.jsp";
		} else if(command.equals("/rBoardLikeUp.do")) {
			service = new RBoardLikeUpService();
			service.execute(request, response);
			viewPage = "rBoard/rBoardLikeUp.jsp";
		} else if(command.equals("/rBoardLikeDown.do")) {
			service = new RBoardLikeDownService();
			service.execute(request, response);
			viewPage = "rBoard/rBoardLikeDown.jsp";
		} else if(command.equals("/rBoardComment.do")) {
			service = new RBoardCommentService();
			service.execute(request, response);
			viewPage = "rBoardContentView.do";
		} else if(command.equals("/rBoardCommentDelete.do")) {
			service = new RBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "rBoardContentView.do";
		} else if(command.equals("/rBoardModifyView.do")) {
			service = new RBoardModifyViewService();
			service.execute(request, response);
			viewPage = "rBoard/rBoardModifyView.jsp";
		} else if(command.equals("/rBoardModify.do")) {
			service = new RBoardModifyService();
			service.execute(request, response);
			viewPage = "rBoardContentView.do";
		} else if(command.equals("/rBoardDelete.do")) {
			service = new RBoardDeleteService();
			service.execute(request, response);
			viewPage = "rBoardView.do";
		// FBoard
		} else if(command.equals("/fBoardView.do")) {
			service = new FBoardViewService();
			service.execute(request, response);
			viewPage = "fBoard/fBoardView.jsp";
		} else if(command.equals("/fBoardWriteView.do")) {
			viewPage = "fBoard/fBoardWriteView.jsp";
		} else if(command.equals("/fBoardWrite.do")) {
			service = new FBoardWriteService();
			service.execute(request, response);
			viewPage = "fBoardView.do";
		} else if(command.equals("/fBoardContentView.do")) {
			service = new FBoardContentViewService();
			service.execute(request, response);
			viewPage = "fBoard/fBoardContentView.jsp";
		} else if(command.equals("/fBoardComment.do")) {
			service = new FBoardCommentService();
			service.execute(request, response);
			viewPage = "fBoardContentView.do";
		} else if(command.equals("/fBoardCommentDelete.do")) {
			service = new FBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "fBoardContentView.do";
		} else if(command.equals("/fBoardReplyView.do")) {
			service = new FBoardReplyViewService();
			service.execute(request, response);
			viewPage = "fBoard/fBoardReplyView.jsp";
		} else if(command.equals("/fBoardReply.do")) {
			service = new FBoardReplyService();
			service.execute(request, response);
			viewPage = "fBoardView.do";
		} else if(command.equals("/fBoardModifyView.do")) {
			service = new FBoardModifyViewService();
			service.execute(request, response);
			viewPage = "fBoard/fBoardModifyView.jsp";
		} else if(command.equals("/fBoardModify.do")) {
			service = new FBoardModifyService();
			service.execute(request, response);
			viewPage = "fBoardView.do";
		} else if(command.equals("/fBoardDelete.do")) {
			service = new FBoardDeleteService();
			service.execute(request, response);
			viewPage = "fBoardView.do";
		// notice
		} else if(command.equals("/noticeView.do")) {
			service = new NoticeViewService();
			service.execute(request, response);
			viewPage = "notice/noticeView.jsp";
		} else if(command.equals("/noticeContentView.do")) {
			service = new NoticeContentViewService();
			service.execute(request, response);
			viewPage = "notice/noticeContentView.jsp";
		} else if(command.equals("/noticeWriteView.do")) {
			viewPage = "notice/noticeWriteView.jsp";
		} else if(command.equals("/noticeWrite.do")) {
			service = new NoticeWriteService();
			service.execute(request, response);
			viewPage = "noticeView.do";
		} else if(command.equals("/noticeModifyView.do")) {
			service = new NoticeModifyViewService();
			service.execute(request, response);
			viewPage = "notice/noticeModifyView.jsp";
		} else if(command.equals("/noticeModify.do")) {
			service = new NoticeModifyService();
			service.execute(request, response);
			viewPage = "noticeView.do";
		} else if(command.equals("/noticeDelete.do")) {
			service = new NoticeDeleteService();
			service.execute(request, response);
			viewPage = "noticeView.do";
		// Product
		} else if(command.equals("/productManagementView.do")) {
			service = new ProductManagementViewService();
			service.execute(request, response);
			viewPage = "product/productManagementView.jsp";
		} else if(command.equals("/productInsertView.do")) {
			viewPage = "product/productInsertView.jsp";
		} else if(command.equals("/productInsert.do")) {
			service = new ProductInsertService();
			service.execute(request, response);
			viewPage = "productManagementView.do";
		} else if(command.equals("/productContentView.do")) {
			service = new ProductContentViewService();
			service.execute(request, response);
			viewPage = "product/productContentView.jsp";
		} else if(command.equals("/productModifyView.do")) {
			service = new ProductModifyViewService();
			service.execute(request, response);
			viewPage = "product/productModifyView.jsp";
		} else if(command.equals("/productModify.do")) {
			service = new ProductModifyService();
			service.execute(request, response);
			viewPage = "productManagementView.do";
		} else if(command.equals("/productDelete.do")) {
			service = new ProductDeleteService();
			service.execute(request, response);
			viewPage = "productManagementView.do";
		} else if(command.equals("/productEstimateView.do")) {
			service = new ProductEstimateViewService();
			service.execute(request, response);
			viewPage = "product/productEstimateView.jsp";
		} else if(command.equals("/productEstimateInsert.do")) {
			service = new ProductEstimateInsertService();
			service.execute(request, response);
			viewPage = "myEstimateView.do";
		} else if(command.equals("/myEstimateView.do")) {
			service = new MyEstimateViewService();
			service.execute(request, response);
			viewPage = "member/myEstimateView.jsp";
		} else if(command.equals("/myEstimateDelete.do")) {
			service = new MyEstimateDeleteService();
			service.execute(request, response);
			viewPage = "myEstimateView.do";
		// search
		} else if(command.equals("/totalSearch.do")) {
			service = new TotalSearchService();
			service.execute(request, response);
			viewPage = "main/totalSearch.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
