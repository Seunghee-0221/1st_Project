package com.tj.hwing.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.hwing.dto.PListDto;

public class PListDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public PListDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int insertPList(String mId, String cpu, String mainboard, String ram, String vga, String ssd, String hdd, String pcase, String power) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PLIST (PLNO, MID, CPU, MAINBOARD, RAM, VGA, SSD, HDD, PCASE, POWER) VALUES "
				+ "(PLIST_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, cpu);
			pstmt.setString(3, mainboard);
			pstmt.setString(4, ram);
			pstmt.setString(5, vga);
			pstmt.setString(6, ssd);
			pstmt.setString(7, hdd);
			pstmt.setString(8, pcase);
			pstmt.setString(9, power);
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
	public int deletePList(int pLNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PLIST WHERE PLNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pLNo);
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
	public ArrayList<PListDto> listBymId(String mId) {
		ArrayList<PListDto> dtos = new ArrayList<PListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLIST WHERE MID=? ORDER BY PLNO DESC";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pLNo = rs.getInt("pLNo");
				int cpu = rs.getInt("cpu");
				int mainboard = rs.getInt("mainboard");
				int ram = rs.getInt("ram");
				int vga = rs.getInt("vga");
				int ssd = rs.getInt("ssd");
				int hdd = rs.getInt("hdd");
				int pcase = rs.getInt("pcase");
				int power = rs.getInt("power");
				dtos.add(new PListDto(pLNo, mId, cpu, mainboard, ram, vga, ssd, hdd, pcase, power));
			}
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
		return dtos;
	}
	public PListDto getOnePList(int pLNo) {
		PListDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PLIST WHERE PLNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pLNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String mId = rs.getString("mId");
				int cpu = rs.getInt("cpu");
				int mainboard = rs.getInt("mainboard");
				int ram = rs.getInt("ram");
				int vga = rs.getInt("vga");
				int ssd = rs.getInt("ssd");
				int hdd = rs.getInt("hdd");
				int pcase = rs.getInt("pcase");
				int power = rs.getInt("power");
				dto = new PListDto(pLNo, mId, cpu, mainboard, ram, vga, ssd, hdd, pcase, power);
			}
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
		return dto;
	}
}
