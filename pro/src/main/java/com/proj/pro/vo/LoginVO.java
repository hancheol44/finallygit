package com.proj.pro.vo;

import java.sql.*;
import java.text.*;

public class LoginVO {
	
	private int kmemno, carno, kcarno, kid;
	private double rd;
	private String kmail, bno, kname, kphone, sDate, kmembir, bname, bloc;
	private Date joinDate;
	private Time joinTime;
	
	
	
	
	
	public int getKmemno() {
		return kmemno;
	}
	public void setKmemno(int kmemno) {
		this.kmemno = kmemno;
	}
	public int getCarno() {
		return carno;
	}
	public void setCarno(int carno) {
		this.carno = carno;
	}
	public int getKcarno() {
		return kcarno;
	}
	public void setKcarno(int kcarno) {
		this.kcarno = kcarno;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public double getRd() {
		return rd;
	}
	public void setRd(double rd) {
		this.rd = rd;
	}
	public String getKmail() {
		return kmail;
	}
	public void setKmail(String kmail) {
		this.kmail = kmail;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public String getKphone() {
		return kphone;
	}
	public void setKphone(String kphone) {
		this.kphone = kphone;
	}
	public String getKmembir() {
		return kmembir;
	}
	public void setKmembir(String kmembir) {
		this.kmembir = kmembir;
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
		return "LoginVO [kmemno=" + kmemno + ", carno=" + carno + ", kcarno=" + kcarno + ", kid=" + kid + ", rd=" + rd
				+ ", kmail=" + kmail + ", bno=" + bno + ", kname=" + kname + ", kphone=" + kphone + ", sDate=" + sDate
				+ ", kmembir=" + kmembir + ", bname=" + bname + ", bloc=" + bloc + ", joinDate=" + joinDate
				+ ", joinTime=" + joinTime + "]";
	}
	
	
}
