package com.tj.hwing.dto;

import java.sql.Date;

public class FBoardDto {
	private int fbNo;
	private String fbTitle;
	private String fbContent;
	private String fbFilename;
	private int fbGroup;
	private int fbStep;
	private int fbIndent;
	private int fbHit;
	private Date fbDate;
	private String mId;
	private String mNickname;
	public FBoardDto() {
		
	}
	public FBoardDto(int fbNo, String fbTitle, String fbContent, String fbFilename, int fbGroup, int fbStep,
			int fbIndent, int fbHit, Date fbDate, String mId, String mNickname) {
		this.fbNo = fbNo;
		this.fbTitle = fbTitle;
		this.fbContent = fbContent;
		this.fbFilename = fbFilename;
		this.fbGroup = fbGroup;
		this.fbStep = fbStep;
		this.fbIndent = fbIndent;
		this.fbHit = fbHit;
		this.fbDate = fbDate;
		this.mId = mId;
		this.mNickname = mNickname;
	}
	public int getFbNo() {
		return fbNo;
	}
	public void setFbNo(int fbNo) {
		this.fbNo = fbNo;
	}
	public String getFbTitle() {
		return fbTitle;
	}
	public void setFbTitle(String fbTitle) {
		this.fbTitle = fbTitle;
	}
	public String getFbContent() {
		return fbContent;
	}
	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}
	public String getFbFilename() {
		return fbFilename;
	}
	public void setFbFilename(String fbFilename) {
		this.fbFilename = fbFilename;
	}
	public int getFbGroup() {
		return fbGroup;
	}
	public void setFbGroup(int fbGroup) {
		this.fbGroup = fbGroup;
	}
	public int getFbStep() {
		return fbStep;
	}
	public void setFbStep(int fbStep) {
		this.fbStep = fbStep;
	}
	public int getFbIndent() {
		return fbIndent;
	}
	public void setFbIndent(int fbIndent) {
		this.fbIndent = fbIndent;
	}
	public int getFbHit() {
		return fbHit;
	}
	public void setFbHit(int fbHit) {
		this.fbHit = fbHit;
	}
	public Date getFbDate() {
		return fbDate;
	}
	public void setFbDate(Date fbDate) {
		this.fbDate = fbDate;
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
		return "FBoardDto [fbNo=" + fbNo + ", fbTitle=" + fbTitle + ", fbContent=" + fbContent + ", fbFilename="
				+ fbFilename + ", fbGroup=" + fbGroup + ", fbStep=" + fbStep + ", fbIndent=" + fbIndent + ", fbHit="
				+ fbHit + ", fbDate=" + fbDate + ", mId=" + mId + ", mNickname=" + mNickname + "]";
	}
}
