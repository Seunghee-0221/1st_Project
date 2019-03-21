package com.tj.hwing.dto;

public class PList {
	private int pLNo;
	private String mId;
	private int cpu;
	private int mainboard;
	private int ram;
	private int vga;
	private int ssd;
	private int hdd;
	private int pcase;
	private int power;
	public PList() {
		
	}
	public PList(int pLNo, String mId, int cpu, int mainboard, int ram, int vga, int ssd, int hdd, int pcase,
			int power) {
		this.pLNo = pLNo;
		this.mId = mId;
		this.cpu = cpu;
		this.mainboard = mainboard;
		this.ram = ram;
		this.vga = vga;
		this.ssd = ssd;
		this.hdd = hdd;
		this.pcase = pcase;
		this.power = power;
	}
	public int getpLNo() {
		return pLNo;
	}
	public void setpLNo(int pLNo) {
		this.pLNo = pLNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMainboard() {
		return mainboard;
	}
	public void setMainboard(int mainboard) {
		this.mainboard = mainboard;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getVga() {
		return vga;
	}
	public void setVga(int vga) {
		this.vga = vga;
	}
	public int getSsd() {
		return ssd;
	}
	public void setSsd(int ssd) {
		this.ssd = ssd;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public int getPcase() {
		return pcase;
	}
	public void setPcase(int pcase) {
		this.pcase = pcase;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "PList [pLNo=" + pLNo + ", mId=" + mId + ", cpu=" + cpu + ", mainboard=" + mainboard + ", ram=" + ram
				+ ", vga=" + vga + ", ssd=" + ssd + ", hdd=" + hdd + ", pcase=" + pcase + ", power=" + power + "]";
	}
}
