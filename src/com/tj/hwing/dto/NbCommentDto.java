package com.tj.hwing.dto;

import java.sql.Date;

public class NbCommentDto {
	private int nbCNo;
	private int nbNo;
	private String mId;
	private String mNickname;
	private String nbComment;
	private Date nbCDate;
	public NbCommentDto() {
		
	}
	public NbCommentDto(int nbCNo, int nbNo, String mId, String mNickname, String nbComment, Date nbCDate) {
		this.nbCNo = nbCNo;
		this.nbNo = nbNo;
		this.mId = mId;
		this.mNickname = mNickname;
		this.nbComment = nbComment;
		this.nbCDate = nbCDate;
	}
	public int getNbCNo() {
		return nbCNo;
	}
	public void setNbCNo(int nbCNo) {
		this.nbCNo = nbCNo;
	}
	public int getNbNo() {
		return nbNo;
	}
	public void setNbNo(int nbNo) {
		this.nbNo = nbNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getNbComment() {
		return nbComment;
	}
	public void setNbComment(String nbComment) {
		this.nbComment = nbComment;
	}
	public Date getNbCDate() {
		return nbCDate;
	}
	public void setNbCDate(Date nbCDate) {
		this.nbCDate = nbCDate;
	}
	@Override
	public String toString() {
		return "NbCommentDto [nbCNo=" + nbCNo + ", nbNo=" + nbNo + ", mId=" + mId + ", mNickname=" + mNickname
				+ ", nbComment=" + nbComment + ", nbCDate=" + nbCDate + "]";
	}
}
