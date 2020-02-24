package com.nt.dto;

import java.io.Serializable;


public class StudentBean implements Serializable {

	
	private int eno;
	private String ename;
	private String desg;
	private float basicSalary;
	private float grosSalary;
	
	public float getGrosSalary() {
		return grosSalary;
	}
	public void setGrosSalary(float grosSalary) {
		this.grosSalary = grosSalary;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	private float netSalary;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
	
	
}

