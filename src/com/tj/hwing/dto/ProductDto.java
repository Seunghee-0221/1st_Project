package com.tj.hwing.dto;

public class ProductDto {
	private int pNo;
	private String pCode;
	private String pName;
	private String pContent;
	private int pPrice;
	private String pImg;
	private String pCodeName;
	public ProductDto() {
		
	}
	public ProductDto(int pNo, String pCode, String pName, String pContent, int pPrice, String pImg, String pCodeName) {
		this.pNo = pNo;
		this.pCode = pCode;
		this.pName = pName;
		this.pContent = pContent;
		this.pPrice = pPrice;
		this.pImg = pImg;
		this.pCodeName = pCodeName;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getpCodeName() {
		return pCodeName;
	}
	public void setpCodeName(String pCodeName) {
		this.pCodeName = pCodeName;
	}
	@Override
	public String toString() {
		return "ProductDto [pNo=" + pNo + ", pCode=" + pCode + ", pName=" + pName + ", pContent=" + pContent
				+ ", pPrice=" + pPrice + ", pImg=" + pImg + ", pCodeName=" + pCodeName + "]";
	}
}
