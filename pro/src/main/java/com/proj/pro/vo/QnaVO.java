package com.proj.pro.vo;

import java.sql.*;
import java.text.*;

public class QnaVO {
	private int qno, qorno, qmemno, qhits, cnt;
	private String qtt, qip, name, today, anstt, ansip, ansDate, memid, ok;
	private Date qqDate, asDate;
	private Time qqTime, asTime;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getQhits() {
		return qhits;
	}
	public void setQhits(int qhits) {
		this.qhits = qhits;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getQorno() {
		return qorno;
	}
	public void setQorno(int qorno) {
		this.qorno = qorno;
	}
	public int getQmemno() {
		return qmemno;
	}
	public void setQmemno(int qmemno) {
		this.qmemno = qmemno;
	}
	public String getQtt() {
		return qtt;
	}
	public void setQtt(String qtt) {
		this.qtt = qtt;
	}
	public String getQip() {
		return qip;
	}
	public void setQip(String qip) {
		this.qip = qip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String gettoday() {
		return today;
	}
	public void setqDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.today = form1.format(qqDate) + " " + form2.format(qqTime);
	}
	public void setqDate(String qDate) {
		this.today = today;
	}
	public String getAnstt() {
		return anstt;
	}
	public void setAnstt(String anstt) {
		this.anstt = anstt;
	}
	public String getAnsip() {
		return ansip;
	}
	public void setAnsip(String ansip) {
		this.ansip = ansip;
	}
	public String getAnsDate() {
		return ansDate;
	}
	public void setAnsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");	
		this.ansDate = form1.format(asDate) + " " + form2.format(asTime);
	}
	public void setAnsDate(String ansDate) {
		this.ansDate = ansDate;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}
	public Date getQqDate() {
		return qqDate;
	}
	public void setQqDate(Date qqDate) {
		this.qqDate = qqDate;
	}
	public Date getAsDate() {
		return asDate;
	}
	public void setAsDate(Date asDate) {
		this.asDate = asDate;
	}
	public Time getQqTime() {
		return qqTime;
	}
	public void setQqTime(Time qqTime) {
		this.qqTime = qqTime;
	}
	public Time getAsTime() {
		return asTime;
	}
	public void setAsTime(Time asTime) {
		this.asTime = asTime;
	}
	@Override
	public String toString() {
		return "QnaVO [qno=" + qno + ", qorno=" + qorno + ", qmemno=" + qmemno + ", qhits=" + qhits + ", cnt=" + cnt
				+ ", qtt=" + qtt + ", qip=" + qip + ", name=" + name + ", today=" + today + ", anstt=" + anstt
				+ ", ansip=" + ansip + ", ansDate=" + ansDate + ", memid=" + memid + ", ok=" + ok + ", qqDate=" + qqDate
				+ ", asDate=" + asDate + ", qqTime=" + qqTime + ", asTime=" + asTime + "]";
	}
	
	
	
	
	
}
