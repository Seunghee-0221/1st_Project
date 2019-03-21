package com.tj.hwing.dto;

public class PCode {
	private String pCode;
	private String pCodeName;
	public PCode() {
		
	}
	public PCode(String pCode, String pCodeName) {
		this.pCode = pCode;
		this.pCodeName = pCodeName;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpCodeName() {
		return pCodeName;
	}
	public void setpCodeName(String pCodeName) {
		this.pCodeName = pCodeName;
	}
	@Override
	public String toString() {
		return "PCode [pCode=" + pCode + ", pCodeName=" + pCodeName + "]";
	}
}
