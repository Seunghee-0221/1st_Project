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

import com.tj.hwing.dto.NbCommentDto;

public class NbCommentDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public NbCommentDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeNbComment(int nbNo, String mId, String nbComment) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO NBCOMMENT (NBCNO, NBNO, MID, NBCOMMENT) VALUES (NBCOMMENT_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
			pstmt.setString(2, mId);
			pstmt.setString(3, nbComment);
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
	public int deleteNbComment(int nbCNo) {
		int result = FAIL;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NBCOMMENT WHERE NBCNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbCNo);
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
	public ArrayList<NbCommentDto> listNbComment(int nbNo){
		ArrayList<NbCommentDto> dtos = new ArrayList<NbCommentDto>();
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT N.*, M.MNICKNAME FROM NBCOMMENT N, MEMBER M WHERE N.MID=M.MID AND NBNO=? ORDER BY NBCNO";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int nbCNo = rs.getInt("nbCNo");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				String nbComment = rs.getString("nbComment");
				Date nbCDate = rs.getDate("nbCDate");
				dtos.add(new NbCommentDto(nbCNo, nbNo, mId, mNickname, nbComment, nbCDate));
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
