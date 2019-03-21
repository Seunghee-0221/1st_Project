package com.tj.hwing.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.hwing.dto.FbCommentDto;

public class FbCommentDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public FbCommentDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeFbComment(int fbNo, String mId, String fbComment) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FBCOMMENT (FBCNO, FBNO, MID, FBCOMMENT) VALUES (FBCOMMENT_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbNo);
			pstmt.setString(2, mId);
			pstmt.setString(3, fbComment);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public int deleteFbComment(int fbCNo) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FBCOMMENT WHERE FBCNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbCNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	public ArrayList<FbCommentDto> listFbComment(int fbNo){
		ArrayList<FbCommentDto> dtos = new ArrayList<FbCommentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, M.MNICKNAME FROM FBCOMMENT F, MEMBER M WHERE F.MID=M.MID AND FBNO=? ORDER BY FBCNO DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fbCNo = rs.getInt("fbCNo");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				String fbComment = rs.getString("fbComment");
				Date fbCDate = rs.getDate("fbCDate");
				dtos.add(new FbCommentDto(fbCNo, fbNo, mId, mNickname, fbComment, fbCDate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
}
