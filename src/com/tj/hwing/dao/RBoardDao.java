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

import com.tj.hwing.dto.RBoardDto;

public class RBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public RBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeRBoard(String rbTitle, String rbContent, String mId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RBOARD (RBNO, RBTITLE, RBCONTENT, MID) VALUES "
				+ "(RBOARD_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rbTitle);
			pstmt.setString(2, rbContent);
			pstmt.setString(3, mId);
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
	public int modifyRBoard(String rbTitle, String rbContent, int rbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RBOARD SET RBTITLE=?, RBCONTENT=? WHERE RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rbTitle);
			pstmt.setString(2, rbContent);
			pstmt.setInt(3, rbNo);
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
	public int deleteRBoard(int rbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RBOARD WHERE RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
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
	public void hitUpRBoard(int rbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RBOARD SET RBHIT=RBHIT+1 WHERE RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
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
	public void likeUpRBoard(int rbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RBOARD SET RBLIKE=RBLIKE+1 WHERE RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
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
	public void likeDownRBoard(int rbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RBOARD SET RBLIKE=RBLIKE-1 WHERE RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
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
	public RBoardDto getOneRBoard(int rbNo) {
		RBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT R.*, M.MNICKNAME FROM RBOARD R, MEMBER M WHERE R.MID=M.MID AND RBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rbNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String rbTitle = rs.getString("rbTitle");
				String rbContent = rs.getString("rbContent");
				int rbHit = rs.getInt("rbHit");
				int rbLike = rs.getInt("rbLike");
				Date rbDate = rs.getDate("rbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dto = new RBoardDto(rbNo, rbTitle, rbContent, rbHit, rbLike, rbDate, mId, mNickname);
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
		return dto;
	}
	public int totCntRBoard() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM RBOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
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
	public ArrayList<RBoardDto> listRBoard(int startRow, int endRow){
		ArrayList<RBoardDto> dtos = new ArrayList<RBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, R.* FROM (SELECT R.*, M.MNICKNAME FROM RBOARD R, MEMBER M WHERE R.MID=M.MID ORDER BY RBNO DESC) R) WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rbNo = rs.getInt("rbNo");
				String rbTitle = rs.getString("rbTitle");
				String rbContent = rs.getString("rbContent");
				int rbHit = rs.getInt("rbHit");
				int rbLike = rs.getInt("rbLike");
				Date rbDate = rs.getDate("rbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new RBoardDto(rbNo, rbTitle, rbContent, rbHit, rbLike, rbDate, mId, mNickname));
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
	public ArrayList<RBoardDto> totalSearchRBoard(String search){
		ArrayList<RBoardDto> dtos = new ArrayList<RBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, R.* FROM (SELECT RB.*, M.MNICKNAME FROM RBOARD RB, MEMBER M WHERE RB.MID=M.MID AND RBTITLE LIKE '%'||?||'%' ORDER BY RBNO DESC) R) WHERE RN BETWEEN 1 AND 5";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rbNo = rs.getInt("rbNo");
				String rbTitle = rs.getString("rbTitle");
				String rbContent = rs.getString("rbContent");
				int rbHit = rs.getInt("rbHit");
				int rbLike = rs.getInt("rbLike");
				Date rbDate = rs.getDate("rbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new RBoardDto(rbNo, rbTitle, rbContent, rbHit, rbLike, rbDate, mId, mNickname));
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
