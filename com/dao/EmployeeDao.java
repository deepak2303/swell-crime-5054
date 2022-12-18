package com.dao;

import java.util.List;

import com.exception.EmployeeException;
import com.exception.ProjectException;
import com.exception.WageException;
import com.models.Employee;

public interface EmployeeDao {
	
	public String loginEmployee(String email,String password) throws EmployeeException;
	
	public List<Employee> getEmployee() throws EmployeeException;
	
	public String assignWage(int empId,String ename) throws WageException;
	
	public String assignProject(int empId,String pname) throws ProjectException;
	
}
