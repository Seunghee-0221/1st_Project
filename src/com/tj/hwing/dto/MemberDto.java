package com.tj.hwing.dto;

import java.sql.Date;

public class MemberDto {
	private String mId;
	private String mPw;
	private String mName;
	private String mNickname;
	private Date mBirth;
	private String mEmail;
	private String mAddress;
	private Date mJoindate;
	private int rCode;
	public MemberDto() {
		
	}
	public MemberDto(String mId, String mPw, String mName, String mNickname, Date mBirth, String mEmail,
			String mAddress, Date mJoindate, int rCode) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mNickname = mNickname;
		this.mBirth = mBirth;
		this.mEmail = mEmail;
		this.mAddress = mAddress;
		this.mJoindate = mJoindate;
		this.rCode = rCode;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public Date getmBirth() {
		return mBirth;
	}
	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public Date getmJoindate() {
		return mJoindate;
	}
	public void setmJoindate(Date mJoindate) {
		this.mJoindate = mJoindate;
	}
	public int getrCode() {
		return rCode;
	}
	public void setrCode(int rCode) {
		this.rCode = rCode;
	}
	@Override
	public String toString() {
		return "MemberDto [mId=" + mId + ", mPw=" + mPw + ", mName=" + mName + ", mNickname=" + mNickname + ", mBirth="
				+ mBirth + ", mEmail=" + mEmail + ", mAddress=" + mAddress + ", mJoindate=" + mJoindate + ", rCode="
				+ rCode + "]";
	}
}
