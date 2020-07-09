package com.proj.pro.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import com.proj.pro.util.PageUtil;

public class BoardVO {
	private int bdno, memno, borino, vcnt, imgno, rno, ccnt;
	private String bdct, bdtt, bdbd, bdshow, today, name, memid, type, input;
	private PageUtil page;
	private Date bDate;
	private Time bTime;
	public int getBdno() {
		return bdno;
	}
	public void setBdno(int bdno) {
		this.bdno = bdno;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getBorino() {
		return borino;
	}
	public void setBorino(int borino) {
		this.borino = borino;
	}
	public int getVcnt() {
		return vcnt;
	}
	public void setVcnt(int vcnt) {
		this.vcnt = vcnt;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getBdct() {
		return bdct;
	}
	public void setBdct(String bdct) {
		this.bdct = bdct;
	}
	public String getBdtt() {
		return bdtt;
	}
	public void setBdtt(String bdtt) {
		this.bdtt = bdtt;
	}
	public String getBdbd() {
		return bdbd;
	}
	public void setBdbd(String bdbd) {
		this.bdbd = bdbd;
	}
	public String getBdshow() {
		return bdshow;
	}
	public void setBdshow(String bdshow) {
		this.bdshow = bdshow;
	}
	public String getToday() {
		return today;
	}
	public void setToday() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.today = form1.format(bDate) + " " + form2.format(bTime);
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Time getbTime() {
		return bTime;
	}
	public void setbTime(Time bTime) {
		this.bTime = bTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	
	public int getCcnt() {
		return ccnt;
	}
	public void setCcnt(int ccnt) {
		this.ccnt = ccnt;
	}
	@Override
	public String toString() {
		return "BoardVO [bdno=" + bdno + ", memno=" + memno + ", borino=" + borino + ", vcnt=" + vcnt + ", imgno="
				+ imgno + ", rno=" + rno + ", bdct=" + bdct + ", bdtt=" + bdtt + ", bdbd=" + bdbd + ", bdshow=" + bdshow
				+ ", today=" + today + ", name=" + name + ", memid=" + memid + ", type=" + type + ", input=" + input
				+ ", page=" + page + ", bDate=" + bDate + ", bTime=" + bTime + "]";
	}
}
