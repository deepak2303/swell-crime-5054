package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.AdminException;
import com.exception.EmployeeException;
import com.models.Admin;
import com.models.Employee;
import com.utility.DBUtil;

public class AdminImpl implements AdminDao {

	@Override
	public String registerAdmin(Admin adm) throws AdminException {
		// TODO Auto-generated method stub
		String str="Admin registration failed";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into admin(aname,phone,gender,address,email,password,deptId)"+"values(?,?,?,?,?,?,?)");
			
			ps.setString(1, adm.getAname());
			ps.setInt(2, adm.getPhone());
			ps.setString(3, adm.getGender());
			ps.setString(4, adm.getAddress());
			ps.setString(5, adm.getEmail());
			ps.setString(6, adm.getPassword());
			ps.setInt(7, adm.getDeptId());
			
			int i=ps.executeUpdate();
			if(i>0)
				str="Admin added successfully";
		} catch (SQLException e) {
			// TODO: handle exception
			str=e.getMessage();
		}
		return str;
	}

	@Override
	public String loginAdmin(String email, String password) throws AdminException {
		// TODO Auto-generated method stub
		String str="Invalid credentials";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from admin where email=? and password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				str="Welcome "+rs.getString("aname");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());;
		}
		return str;
	}

	@Override
	public String addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		String str="Employee not added yet";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into employee(ename,phone,gender,address,email,password,empId)"+"values(?,?,?,?,?,?,?)");
			
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getPhone());
			ps.setString(3, emp.getGender());
			ps.setString(4, emp.getAddress());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getPassword());
			ps.setInt(7, emp.getEmpId());
			
			int i=ps.executeUpdate();
			if(i>0)
				str="Employee added successfully";
		} catch (SQLException e) {
			// TODO: handle exception
			str=e.getMessage();
		}
		return str;
	}

	@Override
	public void deleteEmployee(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from employee where empId=?");
			
			ps.setInt(1, empId);
			
			int out=ps.executeUpdate();
			if(out>0)
				System.out.println("Employee deleted successfully");
			else
				System.out.println("Employee not deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
