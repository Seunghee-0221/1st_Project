package com.tj.hwing.dto;

import java.sql.Date;

public class RBoardDto {
	private int rbNo;
	private String rbTitle;
	private String rbContent;
	private int rbHit;
	private int rbLike;
	private Date rbDate;
	private String mId;
	private String mNickname;
	public RBoardDto() {
		
	}
	public RBoardDto(int rbNo, String rbTitle, String rbContent, int rbHit, int rbLike, Date rbDate, String mId,
			String mNickname) {
		this.rbNo = rbNo;
		this.rbTitle = rbTitle;
		this.rbContent = rbContent;
		this.rbHit = rbHit;
		this.rbLike = rbLike;
		this.rbDate = rbDate;
		this.mId = mId;
		this.mNickname = mNickname;
	}
	public int getRbNo() {
		return rbNo;
	}
	public void setRbNo(int rbNo) {
		this.rbNo = rbNo;
	}
	public String getRbTitle() {
		return rbTitle;
	}
	public void setRbTitle(String rbTitle) {
		this.rbTitle = rbTitle;
	}
	public String getRbContent() {
		return rbContent;
	}
	public void setRbContent(String rbContent) {
		this.rbContent = rbContent;
	}
	public int getRbHit() {
		return rbHit;
	}
	public void setRbHit(int rbHit) {
		this.rbHit = rbHit;
	}
	public int getRbLike() {
		return rbLike;
	}
	public void setRbLike(int rbLike) {
		this.rbLike = rbLike;
	}
	public Date getRbDate() {
		return rbDate;
	}
	public void setRbDate(Date rbDate) {
		this.rbDate = rbDate;
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
	@Override
	public String toString() {
		return "RBoardDto [rbNo=" + rbNo + ", rbTitle=" + rbTitle + ", rbContent=" + rbContent + ", rbHit=" + rbHit
				+ ", rbLike=" + rbLike + ", rbDate=" + rbDate + ", mId=" + mId + ", mNickname=" + mNickname + "]";
	}
}
