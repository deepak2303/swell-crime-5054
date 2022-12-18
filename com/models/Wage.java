package com.models;

public class Wage {

	private String ename;
	private int amount;
	private String month;
	
	
	public Wage() {
		super();
	}


	public Wage(String ename, int amount, String month) {
		super();
		this.ename = ename;
		this.amount = amount;
		this.month = month;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	@Override
	public String toString() {
		return "Wage [ename=" + ename + ", amount=" + amount + ", month=" + month + "]";
	}
	
	
}
