package com.mgnrega.dao;

import java.security.interfaces.RSAPublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mgnrega.login.Login;
import com.mgnrega.utility.DBUtil;

public class BDOimpl implements BDOdao{
	
	DBUtil db=new DBUtil();
	Connection con= db.provideConnection();
	
	  Scanner sc=new Scanner(System.in);

	@Override
	public  String createGMP() {
		
		
		return "message";
	}

	@Override
	public void bdo_login() throws SQLException {
		
		try {
		
		Statement statement =con.createStatement();
		
		System.out.println("Enter Email id : ");
		String email=sc.next();
		
		System.out.println("Enter password : ");
		String password=sc.next();
		
		ResultSet rs= statement.executeQuery("select * from BDO where email='"+email+"' AND password ='"+password+"' ");
		if ( rs.next()) {
			System.out.println("welcome.....");
			System.out.println("Block Development Officer");
			
			bdofun();
			
		}else {
			System.out.println("Email/Password is incorrect");
			Login l=new Login();
			l.login_choice();
		}
		}catch (Exception e) {	
			System.out.println(e);
		}
	}
	
	
	public void bdofun() {
		
		System.out.print("1.Create Gpm \n"
				+ "2.Create Project \n"
				+ "3.View Project \n"
				+ "4.View all the GPM.\n"
				+ "5. Exit");
		System.out.println();
		System.out.println("Choose an appropriate option");
		int x=sc.nextInt();
		
		switch (x) {
		case 1: {
			
			try {
				createGmp();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			break;
		}
		case 2:{
			try {
			createProject();
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}
		case 3:{
			try {
				viewProject();
			} catch (SQLException e) {
				System.out.println(e.getMessage()); 
			}
			break;
		}
		case 4:{
			    try {
					viewAllGMP();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		case 5:{
			System.out.println("Thank You");
			Login l=new Login();
			try {
				l.login_choice();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + x);
		}
		
	}
	
	public void createGmp() throws SQLException {
		
		try {
			
			Statement statement =con.createStatement();
			sc.nextLine();
			
			System.out.println("Enter name:");
			String name=sc.nextLine();
			System.out.println("Enter email id:");
			String email=sc.nextLine();
			System.out.println("Enter Password:");
			String password=sc.nextLine();
			System.out.println("Enter Area:");
			String area=sc.nextLine();
			System.out.println("Enter PinCode:");
			int pincode=sc.nextInt();
			System.out.println("Enter BDO id:");
			int bdo_id=sc.nextInt();
			
			statement.execute("insert into gmp (name,email, password, area, pincode, bdo_Id) " +
					"values('" + name + "','" + email+ "','" + password + "','" + area + "','" + pincode + "','" + bdo_id + "')");
			System.out.println("Done");
			statement.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			bdofun();
		}
	
	}
	
	public void createProject() {
		try {
			Statement statement = con.createStatement();
			sc.nextLine();

			System.out.println("Enter project name:");
			String name = sc.nextLine();
			System.out.println("Enter area:");
			String area = sc.nextLine();
			System.out.println("Enter pincode:");
			int pincode = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter total members:");
			int totalmembers = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter estimated cost:");
			int cost = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter start date in the form YYYY-MM-DD :");
			String startdate = sc.nextLine();
            
			System.out.println("Enter end date in the form YYYY-MM-DD :");
			String enddate = sc.nextLine();
			statement.executeUpdate("insert into Project(Project_Name,Area,Pincode,Total_members,Cost_estimated,Start_date,End_date)" +
					"values('" + name + "','" + area + "','" + pincode + "','" + totalmembers + "','" + cost + "','" + startdate + "','" + enddate + "')");

			System.out.println("Done");
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error is:" + e.getMessage());
		} finally {
			bdofun();
		}
	}
	
	
public void viewProject() throws SQLException {
		
		try {
		
		Statement statement =con.createStatement();
		
		ResultSet rs= statement.executeQuery("select * from project");
		
		
		
		while ( rs.next()) {
			System.out.println("---------------------------------");
			System.out.println("Project id :- "+rs.getInt("Project_id"));
			System.out.println("Project name :- "+rs.getString("Project_name"));
			System.out.println("Area :- "+rs.getString("Area"));
			System.out.println("PinCode :- "+rs.getString("Pincode"));
			System.out.println("Total member :- "+rs.getInt("Total_members"));
			System.out.println("Estimated cost :- "+rs.getInt("Cost_estimated"));
			System.out.println("Project Start date :- "+rs.getString("Start_date"));
			System.out.println("Project End_date :- "+rs.getString("End_date"));
			
			
			System.out.println("----------------------------------");
			
		}
		
		bdofun();
		
		}catch (Exception e) {	
			System.out.println(e);
		}
	}
	
public void viewAllGMP() throws SQLException {
	
	try {
	
	Statement statement =con.createStatement();
	
	ResultSet rs= statement.executeQuery("select * from GMP");
	
	while ( rs.next()) {
		System.out.println("---------------------------------");
		System.out.println("GMP name :- "+rs.getString("name"));
		System.out.println("GMP Emaail id :- "+rs.getString("email"));
		System.out.println("GMP Password :- "+rs.getString("password"));
		System.out.println("Area :- "+rs.getString("area"));
		System.out.println("Pincode :- "+rs.getString("pincode"));
		System.out.println("BDO ID :- "+rs.getInt("bdo_Id"));
		
		
		System.out.println("----------------------------------");
		
		
	}
	bdofun();
	}catch (Exception e) {	
		System.out.println(e);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
