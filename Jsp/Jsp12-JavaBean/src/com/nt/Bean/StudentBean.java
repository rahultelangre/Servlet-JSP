package com.nt.Bean;

import java.io.Serializable;

public class StudentBean implements Serializable {

	
	private int sno;
	private String sname;
	private String result;
	private float avg;
	public StudentBean() {
		System.out.println("StudentBean.StudentBean()");
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	
	
}

