package com.tj.hwing.dto;

import java.sql.Date;

public class FbComment {
	private int fbCNo;
	private int fbNo;
	private String mId;
	private String fbComment;
	private Date fbCDate;
	public FbComment() {
		
	}
	public FbComment(int fbCNo, int fbNo, String mId, String fbComment, Date fbCDate) {
		this.fbCNo = fbCNo;
		this.fbNo = fbNo;
		this.mId = mId;
		this.fbComment = fbComment;
		this.fbCDate = fbCDate;
	}
	public int getFbCNo() {
		return fbCNo;
	}
	public void setFbCNo(int fbCNo) {
		this.fbCNo = fbCNo;
	}
	public int getFbNo() {
		return fbNo;
	}
	public void setFbNo(int fbNo) {
		this.fbNo = fbNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getFbComment() {
		return fbComment;
	}
	public void setFbComment(String fbComment) {
		this.fbComment = fbComment;
	}
	public Date getFbCDate() {
		return fbCDate;
	}
	public void setFbCDate(Date fbCDate) {
		this.fbCDate = fbCDate;
	}
	@Override
	public String toString() {
		return "FbComment [fbCNo=" + fbCNo + ", fbNo=" + fbNo + ", mId=" + mId + ", fbComment=" + fbComment
				+ ", fbCDate=" + fbCDate + "]";
	}
}
