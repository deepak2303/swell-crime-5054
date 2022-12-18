package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EmployeeException;
import com.exception.ProjectException;
import com.exception.WageException;
import com.models.Employee;
import com.utility.DBUtil;

public class EmployeeImpl implements EmployeeDao {
	
	@Override
	public String loginEmployee(String email, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		String str="Invalid credentials";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from employee where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				str="Welcome "+rs.getString("ename");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());;
		}
		return str;
	}
	
	public List<Employee> getEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> employees=new ArrayList<>();
		try (Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from employee");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Employee emp=new Employee(rs.getString("ename"),rs.getInt("phone"),rs.getString("gender"),rs.getString("address"),rs.getString("email"),rs.getString("password"),rs.getInt("empId"));
				employees.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return employees;
	}
	
	@Override
	public String assignWage(int empId, String ename) throws WageException {
		// TODO Auto-generated method stub
		String str="Wage not assigned";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update employee set ename=? where empId=?");
			
			ps.setString(1, ename);
			ps.setInt(2, empId);
			
			int out=ps.executeUpdate();
			if(out>0)
				str="Wage assigned successfully";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());;
		}
		return str;
	}

	@Override
	public String assignProject(int empId, String pname) throws ProjectException {
		// TODO Auto-generated method stub
		String str="Project not assigned";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update employee set pname=? where empId=?");
			
			ps.setString(1, pname);
			ps.setInt(2, empId);
			
			int out=ps.executeUpdate();
			if(out>0)
				str="Project assigned successfully";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());;
		}
		return str;
	}


}
