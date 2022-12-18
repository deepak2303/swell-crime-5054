package com.dao;

import java.util.List;

import com.exception.WageException;
import com.models.Wage;

public interface WageDao {

	public String addWage(Wage wage) throws WageException;
	
	public List<Wage> getWage() throws WageException;
	
	public void deleteWage(String ename) throws WageException;
}
