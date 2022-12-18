package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.ProjectException;
import com.models.Project;
import com.utility.DBUtil;

public class ProjectImpl implements ProjectDao {

	@Override
	public String addProject(Project proj) throws ProjectException {
		// TODO Auto-generated method stub
		String str="Project not added yet";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into project values(?,?,?)");
			
			
			ps.setString(1, proj.getPname());
			ps.setInt(2, proj.getCost());
			ps.setInt(3, proj.getDuration());
			
			int i=ps.executeUpdate();
			if(i>0)
				str="Project added successfully";
		} catch (SQLException e) {
			// TODO: handle exception
			str=e.getMessage();
		}
		return str;
	}

	@Override
	public List<Project> getProject() throws ProjectException {
		// TODO Auto-generated method stub
		List<Project> projects=new ArrayList<>();
		try (Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from project");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Project proj=new Project(rs.getString("pname"),rs.getInt("cost"),rs.getInt("duration"));
				projects.add(proj);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return projects;
	}

	@Override
	public void deleteProject(String pname) throws ProjectException {
		// TODO Auto-generated method stub
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from project where pname=?");
			
			ps.setString(1, pname);
			
			int out=ps.executeUpdate();
			if(out>0)
				System.out.println("Project deleted successfully");
			else
				System.out.println("Project not deleted");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
