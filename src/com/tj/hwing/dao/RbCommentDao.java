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

import com.tj.hwing.dto.RbCommentDto;

public class RbCommentDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public RbCommentDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeRbComment(int rbNo, String mId, String rbComment) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RBCOMMENT (RBCNO, RBNO, MID, RBCOMMENT) VALUES (RBCOMMENT_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
			pstmt.setString(2, mId);
			pstmt.setString(3, rbComment);
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
	public int deleteRbComment(int rbCNo) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RBCOMMENT WHERE RBCNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbCNo);
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
	public ArrayList<RbCommentDto> listRbComment(int rbNo){
		ArrayList<RbCommentDto> dtos = new ArrayList<RbCommentDto>();
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT R.*, M.MNICKNAME FROM RBCOMMENT R, MEMBER M WHERE R.MID=M.MID AND RBNO=? ORDER BY RBCNO";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rbCNo = rs.getInt("rbCNo");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				String rbComment = rs.getString("rbComment");
				Date rbCDate = rs.getDate("rbCDate");
				dtos.add(new RbCommentDto(rbCNo, rbNo, mId, mNickname, rbComment, rbCDate));
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
