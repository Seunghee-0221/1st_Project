package com.tj.hwing.dto;

import java.sql.Date;

public class NoticeDto {
	private int nNo;
	private String aId;
	private String nTitle;
	private String nContent;
	private Date nDate;
	public NoticeDto() {
		
	}
	public NoticeDto(int nNo, String aId, String nTitle, String nContent, Date nDate) {
		this.nNo = nNo;
		this.aId = aId;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nDate = nDate;
	}
	public int getnNo() {
		return nNo;
	}
	public void setnNo(int nNo) {
		this.nNo = nNo;
	}
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public Date getnDate() {
		return nDate;
	}
	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	@Override
	public String toString() {
		return "NoticeDto [nNo=" + nNo + ", aId=" + aId + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nDate="
				+ nDate + "]";
	}
}
