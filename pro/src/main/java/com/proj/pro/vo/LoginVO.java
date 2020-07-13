package com.proj.pro.vo;

import java.sql.*;
import java.text.*;

public class LoginVO {
	
	private int memno, carno, pno;
	private double rd;
	private String memid, bno, name, phone, sDate, membir, bname, bloc, mno, mname, mname2, mname3, mprice, mprice2, mprice3;
	private Date joinDate;
	private Time joinTime;
	
	
	
	
	
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
	public String getMprice2() {
		return mprice2;
	}
	public void setMprice2(String mprice2) {
		this.mprice2 = mprice2;
	}
	public String getMprice3() {
		return mprice3;
	}
	public void setMprice3(String mprice3) {
		this.mprice3 = mprice3;
	}
	public String getMname2() {
		return mname2;
	}
	public void setMname2(String mname2) {
		this.mname2 = mname2;
	}
	public String getMname3() {
		return mname3;
	}
	public void setMname3(String mname3) {
		this.mname3 = mname3;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public int getCarno() {
		return carno;
	}
	public void setCarno(int carno) {
		this.carno = carno;
	}
	public double getRd() {
		return rd;
	}
	public void setRd(double rd) {
		this.rd = rd;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMembir() {
		return membir;
	}
	public void setMembir(String membir) {
		this.membir = membir;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public void setsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		String str = form1.format(joinDate) + " " + form2.format(joinTime);
				
		this.sDate = str;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Time getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Time joinTime) {
		this.joinTime = joinTime;
	}
	@Override
	public String toString() {
		return "LoginVO [memno=" + memno + ", carno=" + carno + ", mno=" + mno + ", pno=" + pno + ", mprice=" + mprice
				+ ", rd=" + rd + ", memid=" + memid + ", bno=" + bno + ", name=" + name + ", phone=" + phone
				+ ", sDate=" + sDate + ", membir=" + membir + ", bname=" + bname + ", bloc=" + bloc + ", mname=" + mname
				+ "]";
	}

	
}
