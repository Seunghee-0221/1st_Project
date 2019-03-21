package com.tj.hwing.dto;

public class NbLikeDto {
	private int nbLNo;
	private String mId;
	private int nbNo;
	public NbLikeDto() {
		
	}
	public NbLikeDto(int nbLNo, String mId, int nbNo) {
		this.nbLNo = nbLNo;
		this.mId = mId;
		this.nbNo = nbNo;
	}
	public int getNbLNo() {
		return nbLNo;
	}
	public void setNbLNo(int nbLNo) {
		this.nbLNo = nbLNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getNbNo() {
		return nbNo;
	}
	public void setNbNo(int nbNo) {
		this.nbNo = nbNo;
	}
	@Override
	public String toString() {
		return "NbLike [nbLNo=" + nbLNo + ", mId=" + mId + ", nbNo=" + nbNo + "]";
	}
}
