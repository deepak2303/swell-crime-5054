package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.WageException;
import com.models.Wage;
import com.utility.DBUtil;

public class WageImpl implements WageDao {

	@Override
	public String addWage(Wage wage) throws WageException {
		// TODO Auto-generated method stub
		String str="Wage not added yet";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into wage values(?,?,?)");
			
			
			ps.setString(1, wage.getEname());
			ps.setInt(2, wage.getAmount());
			ps.setString(3, wage.getMonth());
			
			int i=ps.executeUpdate();
			if(i>0)
				str="Wage added successfully";
		} catch (SQLException e) {
			// TODO: handle exception
			str=e.getMessage();
		}
		return str;
	}

	@Override
	public List<Wage> getWage() throws WageException {
		// TODO Auto-generated method stub
		List<Wage> wages=new ArrayList<>();
		try (Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from wage");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Wage wag=new Wage(rs.getString("ename"),rs.getInt("amount"),rs.getString("month"));
				wages.add(wag);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return wages;
	}

	@Override
	public void deleteWage(String ename) throws WageException {
		// TODO Auto-generated method stub
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from wage where ename=?");
			
			ps.setString(1, ename);
			
			int out=ps.executeUpdate();
			if(out>0)
				System.out.println("Wage deleted successfully");
			else
				System.out.println("Wage not deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
