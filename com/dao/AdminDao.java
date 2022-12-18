package com.dao;

import com.exception.AdminException;
import com.exception.EmployeeException;
import com.models.Admin;
import com.models.Employee;

public interface AdminDao {

	public String registerAdmin(Admin adm) throws AdminException;
	
	public String loginAdmin(String email,String password) throws AdminException;
	
	public String addEmployee(Employee emp) throws EmployeeException;
	
	public void deleteEmployee(int empId) throws EmployeeException;
	
}
