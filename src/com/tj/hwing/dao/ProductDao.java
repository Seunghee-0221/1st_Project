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

import com.tj.hwing.dto.ProductDto;

public class ProductDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private DataSource ds;
	public ProductDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	public int insertProduct(String pCode, String pName, String pContent, int pPrice, String pImg) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PRODUCT (PNO, PCODE, PNAME, PCONTENT, PPRICE, PIMG) VALUES "
				+ "(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			pstmt.setString(2, pName);
			pstmt.setString(3, pContent);
			pstmt.setInt(4, pPrice);
			pstmt.setString(5, pImg);
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
	public int modifyProduct(String pCode, String pName, String pContent, int pPrice, String pImg, int pNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET PCODE=?, PNAME=?, PCONTENT=?, PPRICE=?, PIMG=? WHERE PNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			pstmt.setString(2, pName);
			pstmt.setString(3, pContent);
			pstmt.setInt(4, pPrice);
			pstmt.setString(5, pImg);
			pstmt.setInt(6, pNo);
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
	public int deleteProduct(int pNo) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM PRODUCT WHERE PNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNo);
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
	public ProductDto getOneProduct(int pNo) {
		ProductDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT P.*, C.PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE=C.PCODE AND PNO=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pCode = rs.getString("pCode");
				String pName = rs.getString("pName");
				String pContent = rs.getString("pContent");
				int pPrice = rs.getInt("pPrice");
				String pImg = rs.getString("pImg");
				String pCodeName = rs.getString("pCodeName");
				dto = new ProductDto(pNo, pCode, pName, pContent, pPrice, pImg, pCodeName);
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
	public ArrayList<ProductDto> listByPname(String pCode) {
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT P.*, C.PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE = C.PCODE AND P.PCODE=? ORDER BY PNAME";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pNo = rs.getInt("pNo");
				String pName = rs.getString("pName");
				String pContent = rs.getString("pContent");
				int pPrice = rs.getInt("pPrice");
				String pImg = rs.getString("pImg");
				String pCodeName = rs.getString("pCodeName");
				dtos.add(new ProductDto(pNo, pCode, pName, pContent, pPrice, pImg, pCodeName));
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
	public ArrayList<ProductDto> newProduct(){
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, PS.* FROM (SELECT P.*, PCODENAME FROM PRODUCT P, PCODE C WHERE P.PCODE = C.PCODE ORDER BY PNO DESC) PS) WHERE RN BETWEEN 1 AND 4";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int pNo = rs.getInt("pNo");
				String pCode = rs.getString("pCode");
				String pName = rs.getString("pName");
				String pContent = rs.getString("pContent");
				int pPrice = rs.getInt("pPrice");
				String pImg = rs.getString("pImg");
				String pCodeName = rs.getString("pCodeName");
				dtos.add(new ProductDto(pNo, pCode, pName, pContent, pPrice, pImg, pCodeName));
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
}
