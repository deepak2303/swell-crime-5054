package com.models;

public class Project {

	private String pname;
	private int cost;
	private int duration;
	
	
	public Project() {
		super();
	}


	public Project(String pname, int cost, int duration) {
		super();
		this.pname = pname;
		this.cost = cost;
		this.duration = duration;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Project [pname=" + pname + ", cost=" + cost + ", duration=" + duration + "]";
	}
	
}
