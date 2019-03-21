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

import com.tj.hwing.dto.FBoardDto;

public class FBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public FBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeFBoard(String fbTitle, String fbContent, String fbFilename, String mId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES "
				+ "(FBOARD_SEQ.NEXTVAL, ?, ?, ?, FBOARD_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fbTitle);
			pstmt.setString(2, fbContent);
			pstmt.setString(3, fbFilename);
			pstmt.setString(4, mId);
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
	public int modifyFBoard(String fbTitle, String fbContent, String fbFilename, int fbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FBOARD SET FBTITLE=?, FBCONTENT=?, FBFILENAME=? WHERE FBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fbTitle);
			pstmt.setString(2, fbContent);
			pstmt.setString(3, fbFilename);
			pstmt.setInt(4, fbNo);
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
	public int deleteFBoard(int fbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FBOARD WHERE FBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbNo);
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
	public void hitUpFBoard(int fbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FBOARD SET FBHIT=FBHIT+1 WHERE FBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbNo);
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
	public FBoardDto getOneFBoard(int fbNo) {
		FBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, M.MNICKNAME FROM FBOARD F, MEMBER M WHERE F.MID=M.MID AND FBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String fbTitle = rs.getString("fbTitle");
				String fbContent = rs.getString("fbContent");
				String fbFilename = rs.getString("fbFilename");
				int fbGroup = rs.getInt("fbGroup");
				int fbStep = rs.getInt("fbStep");
				int fbIndent = rs.getInt("fbIndent");
				int fbHit = rs.getInt("fbHit");
				Date fbDate = rs.getDate("fbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dto = new FBoardDto(fbNo, fbTitle, fbContent, fbFilename, fbGroup, fbStep, fbIndent, fbHit, fbDate, mId, mNickname);
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
	public void replyStepA(int fbGroup, int fbStep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FBOARD SET FBSTEP=FBSTEP+1 WHERE FBGROUP=? AND FBSTEP>?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fbGroup);
			pstmt.setInt(2, fbStep);
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
	public int replyWrite(String fbTitle, String fbContent, String fbFilename, int fbGroup, int fbStep, int fbIndent, String mId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FBOARD (FBNO, FBTITLE, FBCONTENT, FBFILENAME, FBGROUP, FBSTEP, FBINDENT, MID) VALUES "
				+ "(FBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fbTitle);
			pstmt.setString(2, fbContent);
			pstmt.setString(3, fbFilename);
			pstmt.setInt(4, fbGroup);
			pstmt.setInt(5, fbStep);
			pstmt.setInt(6, fbIndent);
			pstmt.setString(7, mId);
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
	public int totCntFBoard() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM FBOARD";
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
	public ArrayList<FBoardDto> listFBoard(int startRow, int endRow){
		ArrayList<FBoardDto> dtos = new ArrayList<FBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, F.* FROM (SELECT F.*, M.MNICKNAME FROM FBOARD F, MEMBER M WHERE F.MID=M.MID ORDER BY FBGROUP DESC, FBSTEP) F) WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fbNo = rs.getInt("fbNo");
				String fbTitle = rs.getString("fbTitle");
				String fbContent = rs.getString("fbContent");
				String fbFilename = rs.getString("fbFilename");
				int fbGroup = rs.getInt("fbGroup");
				int fbStep = rs.getInt("fbStep");
				int fbIndent = rs.getInt("fbIndent");
				int fbHit = rs.getInt("fbHit");
				Date fbDate = rs.getDate("fbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new FBoardDto(fbNo, fbTitle, fbContent, fbFilename, fbGroup, fbStep, fbIndent, fbHit, fbDate, mId, mNickname));
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
	public ArrayList<FBoardDto> totalSearchFBoard(String search){
		ArrayList<FBoardDto> dtos = new ArrayList<FBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, F.* FROM (SELECT FB.*, M.MNICKNAME FROM FBOARD FB, MEMBER M WHERE FB.MID=M.MID AND FBTITLE LIKE '%'||?||'%' ORDER BY FBGROUP DESC, FBSTEP) F) WHERE RN BETWEEN 1 AND 5";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fbNo = rs.getInt("fbNo");
				String fbTitle = rs.getString("fbTitle");
				String fbContent = rs.getString("fbContent");
				String fbFilename = rs.getString("fbFilename");
				int fbGroup = rs.getInt("fbGroup");
				int fbStep = rs.getInt("fbStep");
				int fbIndent = rs.getInt("fbIndent");
				int fbHit = rs.getInt("fbHit");
				Date fbDate = rs.getDate("fbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new FBoardDto(fbNo, fbTitle, fbContent, fbFilename, fbGroup, fbStep, fbIndent, fbHit, fbDate, mId, mNickname));
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
