package com.models;

public class Admin {

	private String aname;
	private int phone;
	private String gender;
	private String address;
	private String email;
	private String password;
	private int deptId;
	
	
	public Admin() {
		super();
	}


	public Admin(String aname, int phone, String gender, String address, String email, String password, int deptId) {
		super();
		this.aname = aname;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.password = password;
		this.deptId = deptId;
	}


	public String getAname() {
		return aname;
	}


	public void setAname(String aname) {
		this.aname = aname;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "Admin [aname=" + aname + ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", email="
				+ email + ", password=" + password + ", deptId=" + deptId + "]";
	}
	
	
}
