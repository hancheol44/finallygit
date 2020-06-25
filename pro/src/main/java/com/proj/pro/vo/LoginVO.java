package com.proj.pro.vo;

import java.sql.*;
import java.text.*;

public class LoginVO {
	
	private int memno, carno;
	private double rd;
	private String id, pw, bno, name, phone, sDate, membir, bname, bloc;
	private Date joinDate;
	private Time joinTime;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
		return "LoginVO [memno=" + memno + ", carno=" + carno + ", rd=" + rd + ", id=" + id + ", pw=" + pw
				+ ", bno=" + bno + ", name=" + name + ", phone=" + phone + ", sDate=" + sDate + ", membir=" + membir
				+ ", bname=" + bname + ", bloc=" + bloc + ", joinDate=" + joinDate + ", joinTime=" + joinTime + "]";
	}
	
	
}
