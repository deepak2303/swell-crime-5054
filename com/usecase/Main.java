package com.usecase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminImpl;
import com.dao.EmployeeDao;
import com.dao.EmployeeImpl;
import com.dao.ProjectDao;
import com.dao.ProjectImpl;
import com.dao.WageDao;
import com.dao.WageImpl;
import com.exception.AdminException;
import com.exception.EmployeeException;
import com.exception.ProjectException;
import com.exception.WageException;
import com.models.Admin;
import com.models.Employee;
import com.models.Project;
import com.models.Wage;

public class Main {

	public static void main(String[] args) throws EmployeeException, AdminException, WageException, ProjectException {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select 1 for Admin");
		System.out.println("Select 2 for Employee");
		int a=sc.nextInt();
		
		if(a==1) {
			System.out.println("Select 1 for Registration");
			System.out.println("Select 2 for Login");
			System.out.println("Select 3 to Exit");
			
			int b=sc.nextInt();
			
			Scanner input=new Scanner(System.in);
			
			if(b==1) {
				System.out.println("Admin Registration");
				System.out.println("Enter Admin Name");
				String aname=input.next();
				System.out.println("Enter Phone No.");
				int phone=input.nextInt();
				System.out.println("Enter Gender");
				String gender=input.next();
				System.out.println("Enter Address");
				String address=input.next();
				System.out.println("Enter Email");
				String email=input.next();
				System.out.println("Enter Password");
				String password=input.next();
				System.out.println("Enter Department Id");
				int deptId=input.nextInt();
				
				Admin adm=new Admin(aname, phone, gender, address, email, password, deptId);
				AdminDao ad=new AdminImpl();
				String result=ad.registerAdmin(adm);
				System.out.println(result);
			}else if(b==2) {
				System.out.println("Admin Login");
				System.out.println("Enter Email");
				String email=input.next();
				System.out.println("Enter Password");
				String password=input.next();
				
				AdminDao ad=new AdminImpl();
				String result=ad.loginAdmin(email, password);
				System.out.println(result);
				
				System.out.println("Type 1 for Add Employee");
				System.out.println("Type 2 for Delete Employee");
				System.out.println("Type 3 for Add Wage");
				System.out.println("Type 4 for Assign Wage");
				System.out.println("Type 5 for Delete Wage");
				System.out.println("Type 6 for Add Project");
				System.out.println("Type 7 for Assign Project");
				System.out.println("Type 8 for Delete Project");
				
				int c=input.nextInt();
				
				if(c==1) {
					System.out.println("Enter Employee Name");
					String ename=input.next();
					System.out.println("Enter Phone No.");
					int phone=input.nextInt();
					System.out.println("Enter Gender");
					String gender=input.next();
					System.out.println("Enter Address");
					String address=input.next();
					System.out.println("Enter Email");
					String empEmail=input.next();
					System.out.println("Enter Password");
					String empPassword=input.next();
					System.out.println("Enter Employee Id");
					int empId=input.nextInt();
					
					Employee emp=new Employee(ename, phone, gender, address, empEmail, empPassword, empId);
					AdminDao ad1=new AdminImpl();
					String result1=ad1.addEmployee(emp);
					System.out.println(result1);
				}else if(c==2) {
					System.out.println("Enter Employee ID");
					int empId=input.nextInt();
					
					AdminDao ad2=new AdminImpl();
					ad2.deleteEmployee(empId);
				}else if(c==3) {
					System.out.println("Enter Employee Name");
					String ename=input.next();
					System.out.println("Enter the Amount");
					int amount=input.nextInt();
					System.out.println("Enter the Month");
					String month=input.next();
					
					Wage wage=new Wage(ename, amount, month);
					WageDao wd=new WageImpl();
					String result2=wd.addWage(wage);
					System.out.println(result2);
				}else if(c==4) {
					System.out.println("Enter Employee Id");
					int empId=sc.nextInt();
					System.out.println("Enter Employee Name");
					String empName=sc.next();
					
					EmployeeDao ed=new EmployeeImpl();
					String message=ed.assignWage(empId, empName);
					System.out.println(message);
				}else if(c==5) {
					System.out.println("Enter Employee Name");
					String ename=input.next();
					
					WageDao wd1=new WageImpl();
					wd1.deleteWage(ename);
				}else if(c==6) {
					System.out.println("Enter Project Name");
					String pname=input.next();
					System.out.println("Enter Project Cost");
					int cost=input.nextInt();
					System.out.println("Enter Project Duration(In no. of Days)");
					int duration=input.nextInt();
					
					Project proj=new Project(pname, cost, duration);
					ProjectDao pd=new ProjectImpl();
					String result3=pd.addProject(proj);
					System.out.println(result3);
				}else if(c==7) {
					System.out.println("Enter Employee Id");
					int empId=sc.nextInt();
					System.out.println("Enter Emp Id");
					String pname=sc.next();
					
					EmployeeDao ed=new EmployeeImpl();
					String message=ed.assignProject(empId, pname);
					System.out.println(message);
				}else if(c==8) {
					System.out.println("Enter Product Name");
					String pname=input.next();
					
					ProjectDao pd1=new ProjectImpl();
					pd1.deleteProject(pname);
				}
			}else {
				System.out.println("Visit Again");
			}
		}else {
			System.out.println("Type 1 for Employee Login");
			System.out.println("Type 2 for Exit");
			
			int b=sc.nextInt();
			Scanner input=new Scanner(System.in);
			if(b==1) {
				System.out.println("Employee Login");
				System.out.println("Enter Email");
				String email=input.next();
				System.out.println("Enter Password");
				String password=input.next();
				
				EmployeeDao ed=new EmployeeImpl();
				String result=ed.loginEmployee(email, password);
				System.out.println(result);
				
				System.out.println("Type 1 To Get All Employee Data");
				System.out.println("Type 2 To Get All Wage Data");
				System.out.println("Type 3 To Get All Project Data");
				
				int c=input.nextInt();
				
				if(c==1) {
					EmployeeDao ed1=new EmployeeImpl();
					System.out.println(ed1.getEmployee());
				}else if(c==2) {
					WageDao wd=new WageImpl();
					System.out.println(wd.getWage());
				}else if(c==3) {
					ProjectDao pd=new ProjectImpl();
					System.out.println(pd.getProject());
				}
			}
		}
		
		sc.close();
	}

}
