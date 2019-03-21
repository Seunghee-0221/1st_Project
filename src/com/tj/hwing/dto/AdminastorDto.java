package com.tj.hwing.dto;

public class AdminastorDto {
	private String aId;
	private String aPw;
	private int aMaster;
	public AdminastorDto() {
		
	}
	public AdminastorDto(String aId, String aPw, int aMaster) {
		this.aId = aId;
		this.aPw = aPw;
		this.aMaster = aMaster;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaPw() {
		return aPw;
	}
	public void setaPw(String aPw) {
		this.aPw = aPw;
	}
	public int getaMaster() {
		return aMaster;
	}
	public void setaMaster(int aMaster) {
		this.aMaster = aMaster;
	}
	@Override
	public String toString() {
		return "AdminastorDto [aId=" + aId + ", aPw=" + aPw + ", aMaster=" + aMaster + "]";
	}
}
