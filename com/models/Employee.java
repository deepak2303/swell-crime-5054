package com.models;

public class Employee {

	private String ename;
	private int phone;
	private String gender;
	private String address;
	private String email;
	private String password;
	private int empId;
	
	
	public Employee() {
		super();
	}


	public Employee(String ename, int phone, String gender, String address, String email, String password, int empId) {
		super();
		this.ename = ename;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.password = password;
		this.empId = empId;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
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


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	@Override
	public String toString() {
		return "Employee [ename=" + ename + ", phone=" + phone + ", gender=" + gender + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", empId=" + empId + "]";
	}

	
}
