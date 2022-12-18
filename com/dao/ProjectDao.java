package com.dao;

import java.util.List;

import com.exception.ProjectException;
import com.models.Project;

public interface ProjectDao {

	public String addProject(Project proj) throws ProjectException;
	
	public List<Project> getProject() throws ProjectException;
	
	public void deleteProject(String pname) throws ProjectException;
}
