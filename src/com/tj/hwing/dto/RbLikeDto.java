package com.tj.hwing.dto;

public class RbLikeDto {
	private int rbLNo;
	private int rbNo;
	private String mId;
	public RbLikeDto() {
		
	}
	public RbLikeDto(int rbLNo, int rbNo, String mId) {
		this.rbLNo = rbLNo;
		this.rbNo = rbNo;
		this.mId = mId;
	}
	public int getRbLNo() {
		return rbLNo;
	}
	public void setRbLNo(int rbLNo) {
		this.rbLNo = rbLNo;
	}
	public int getRbNo() {
		return rbNo;
	}
	public void setRbNo(int rbNo) {
		this.rbNo = rbNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	@Override
	public String toString() {
		return "RbLikeDto [rbLNo=" + rbLNo + ", rbNo=" + rbNo + ", mId=" + mId + "]";
	}
}
