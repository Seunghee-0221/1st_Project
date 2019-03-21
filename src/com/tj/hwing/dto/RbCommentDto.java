package com.tj.hwing.dto;

import java.sql.Date;

public class RbCommentDto {
	private int rbCNo;
	private int rbNo;
	private String mId;
	private String mNickname;
	private String rbComment;
	private Date rbCDate;
	public RbCommentDto() {
		
	}
	public RbCommentDto(int rbCNo, int rbNo, String mId, String mNickname, String rbComment, Date rbCDate) {
		this.rbCNo = rbCNo;
		this.rbNo = rbNo;
		this.mId = mId;
		this.mNickname = mNickname;
		this.rbComment = rbComment;
		this.rbCDate = rbCDate;
	}
	public int getRbCNo() {
		return rbCNo;
	}
	public void setRbCNo(int rbCNo) {
		this.rbCNo = rbCNo;
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
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getRbComment() {
		return rbComment;
	}
	public void setRbComment(String rbComment) {
		this.rbComment = rbComment;
	}
	public Date getRbCDate() {
		return rbCDate;
	}
	public void setRbCDate(Date rbCDate) {
		this.rbCDate = rbCDate;
	}
	@Override
	public String toString() {
		return "RbCommentDto [rbCNo=" + rbCNo + ", rbNo=" + rbNo + ", mId=" + mId + ", mNickname=" + mNickname
				+ ", rbComment=" + rbComment + ", rbCDate=" + rbCDate + "]";
	}
}
