package com.tj.hwing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NbLikeDao {
	public static final int EXISTENT = 1;
	public static final int NONEXISTENT = 0;
	private DataSource ds;
	public NbLikeDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int stateNbLike(String mId, int nbNo) {
		int result = EXISTENT;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NBLIKE WHERE MID=? AND NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, nbNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT;
			} else {
				result = NONEXISTENT;
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
		return result;
	}
	public void insertNbLike(String mId, int nbNo) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO NBLIKE (NBLNO, MID, NBNO) VALUES (NBLIKE_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, nbNo);
			pstmt.executeUpdate();
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
	}
	public void deleteNbLike(String mId, int nbNo) {
		Connection conn = null; 
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NBLIKE WHERE MID=? AND NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setInt(2, nbNo);
			pstmt.executeUpdate();
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
	}
}
