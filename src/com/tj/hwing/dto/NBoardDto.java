package com.tj.hwing.dto;

import java.sql.Date;

public class NBoardDto {
	private int nbNo;
	private String nbTitle;
	private String nbContent;
	private int nbHit;
	private int nbLike;
	private Date nbDate;
	private String mId;
	private String mNickname;
	public NBoardDto() {
		
	}
	public NBoardDto(int nbNo, String nbTitle, String nbContent, int nbHit, int nbLike, Date nbDate, String mId,
			String mNickname) {
		this.nbNo = nbNo;
		this.nbTitle = nbTitle;
		this.nbContent = nbContent;
		this.nbHit = nbHit;
		this.nbLike = nbLike;
		this.nbDate = nbDate;
		this.mId = mId;
		this.mNickname = mNickname;
	}

	public int getNbNo() {
		return nbNo;
	}

	public void setNbNo(int nbNo) {
		this.nbNo = nbNo;
	}

	public String getNbTitle() {
		return nbTitle;
	}

	public void setNbTitle(String nbTitle) {
		this.nbTitle = nbTitle;
	}

	public String getNbContent() {
		return nbContent;
	}

	public void setNbContent(String nbContent) {
		this.nbContent = nbContent;
	}

	public int getNbHit() {
		return nbHit;
	}

	public void setNbHit(int nbHit) {
		this.nbHit = nbHit;
	}

	public int getNbLike() {
		return nbLike;
	}

	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}

	public Date getNbDate() {
		return nbDate;
	}

	public void setNbDate(Date nbDate) {
		this.nbDate = nbDate;
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
		return "NBoardDto [nbNo=" + nbNo + ", nbTitle=" + nbTitle + ", nbContent=" + nbContent + ", nbHit=" + nbHit
				+ ", nbLike=" + nbLike + ", nbDate=" + nbDate + ", mId=" + mId + ", mNickname=" + mNickname + "]";
	}
}
