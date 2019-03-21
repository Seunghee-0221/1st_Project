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

import com.tj.hwing.dto.NBoardDto;

public class NBoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public NBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int writeNBoard(String nbTitle, String nbContent, String mId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO NBOARD (NBNO, NBTITLE, NBCONTENT, MID) VALUES "
				+ "(NBOARD_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nbTitle);
			pstmt.setString(2, nbContent);
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
	public int modifyNBoard(String nbTitle, String nbContent, int nbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NBOARD SET NBTITLE=?, NBCONTENT=? WHERE NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nbTitle);
			pstmt.setString(2, nbContent);
			pstmt.setInt(3, nbNo);
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
	public int deleteNBoard(int nbNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NBOARD WHERE NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
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
	public void hitUpNBoard(int nbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NBOARD SET NBHIT=NBHIT+1 WHERE NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
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
	public void likeUpNBoard(int nbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NBOARD SET NBLIKE=NBLIKE+1 WHERE NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
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
	public void likeDownNBoard(int nbNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NBOARD SET NBLIKE=NBLIKE-1 WHERE NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
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
	public NBoardDto getOneNBoard(int nbNo) {
		NBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT N.*, M.MNICKNAME FROM NBOARD N, MEMBER M WHERE N.MID=M.MID AND NBNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nbNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String nbTitle = rs.getString("nbTitle");
				String nbContent = rs.getString("nbContent");
				int nbHit = rs.getInt("nbHit");
				int nbLike = rs.getInt("nbLike");
				Date nbDate = rs.getDate("nbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dto = new NBoardDto(nbNo, nbTitle, nbContent, nbHit, nbLike, nbDate, mId, mNickname);
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
	public int totCntNBoard() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM NBOARD";
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
	public ArrayList<NBoardDto> listNBoard(int startRow, int endRow){
		ArrayList<NBoardDto> dtos = new ArrayList<NBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, N.* FROM (SELECT N.*, M.MNICKNAME FROM NBOARD N, MEMBER M WHERE N.MID=M.MID ORDER BY NBNO DESC) N) WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int nbNo = rs.getInt("nbNo");
				String nbTitle = rs.getString("nbTitle");
				String nbContent = rs.getString("nbContent");
				int nbHit = rs.getInt("nbHit");
				int nbLike = rs.getInt("nbLike");
				Date nbDate = rs.getDate("nbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new NBoardDto(nbNo, nbTitle, nbContent, nbHit, nbLike, nbDate, mId, mNickname));
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
	public ArrayList<NBoardDto> totalSearchNBoard(String search){
		ArrayList<NBoardDto> dtos = new ArrayList<NBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, N.* FROM (SELECT NB.*, M.MNICKNAME FROM NBOARD NB, MEMBER M WHERE NB.MID=M.MID AND NBTITLE LIKE '%'||?||'%' ORDER BY NBNO DESC) N) WHERE RN BETWEEN 1 AND 5";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int nbNo = rs.getInt("nbNo");
				String nbTitle = rs.getString("nbTitle");
				String nbContent = rs.getString("nbContent");
				int nbHit = rs.getInt("nbHit");
				int nbLike = rs.getInt("nbLike");
				Date nbDate = rs.getDate("nbDate");
				String mId = rs.getString("mId");
				String mNickname = rs.getString("mNickname");
				dtos.add(new NBoardDto(nbNo, nbTitle, nbContent, nbHit, nbLike, nbDate, mId, mNickname));
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
