package com.mgnrega.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import com.mgnrega.login.Login;
import com.mgnrega.utility.DBUtil;

public class GMP {
	
	
	
	DBUtil db=new DBUtil();
	Connection con= db.provideConnection();
	
	  Scanner sc=new Scanner(System.in);
	  
	  
	  public void gmp_login() throws SQLException {
			
			try {
			
			Statement statement =con.createStatement();
			
			System.out.println("Enter Email id : ");
			String email=sc.next();
			
			System.out.println("Enter password : ");
			String password=sc.next();
			
			ResultSet rs= statement.executeQuery("select * from GMP where email='"+email+"' AND password ='"+password+"' ");
			if ( rs.next()) {
				System.out.println("welcome.....");
				System.out.println("Gram Panchayet member");
				
				gmpfun();
				
			}else {
				System.out.println("Email/Password is incorrect");
				Login l=new Login();
				l.login_choice();
			}
			}catch (Exception e) {	
				System.out.println(e);
			}
		}
	
	  public void gmpfun() {
			
			System.out.print("1.Create Employee \n"
					+ "2.View the Details of Employee \n"
					+ "3.Assign Employee to a Project \n"
					+ "4.total number of days Employee \n"
					+ "5. Exit");
			System.out.println();
			System.out.println("Choose an appropriate option");
			int x=sc.nextInt();
			
			switch (x) {
			case 1: {
				
				try {
					try {
						create_Employee();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			case 2:{
				try {
					viewAllGMP();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
//			case 3:{
//				try {
//					
//				} catch (SQLException e) {
//					System.out.println(e.getMessage()); 
//				}
//			}
//			case 4:{
//				    try {
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			}
//			case 5:{
//				System.out.println("Thank You");
//				Login l=new Login();
//				try {
//					l.login_choice();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			//}
			default:
				throw new IllegalArgumentException("Unexpected value: " + x);
			}
			
		}
	  
	  public void create_Employee() throws SQLException, ParseException, IOException {
			try {
				Statement statement = con.createStatement();
				sc.nextLine();

				System.out.println("Enter name:");
				String name = sc.nextLine();
				System.out.println("Enter email:");
				String email = sc.nextLine();
				System.out.println("Enter password:");
				String password = sc.nextLine();
				System.out.println("Enter area:");
				String area = sc.nextLine();
				System.out.println("Enter pincode:");
				int pincode = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter age:");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter GPM id");
				int id = sc.nextInt();

				statement.execute("insert into Employee (name,email,password,area,pincode,age,Gmp_id)" +
						"values('" + name + "','" + email + "','" + password + "','" + area + "','" + pincode + "','" + age + "','" + id + "')");
				System.out.println("Done");
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error is:" + e.getMessage());
			} finally {
				gmpfun();
			}
		}
	  
	  public void viewAllGMP() throws SQLException {
			
			try {
			
			Statement statement =con.createStatement();
			
			ResultSet rs= statement.executeQuery("select * from Employee");
			
			while ( rs.next()) {
				System.out.println("---------------------------------");
				System.out.println("Employee ID :- "+rs.getInt("e_id"));
				System.out.println("Employee name :- "+rs.getString("name"));
				System.out.println("Employee Emaail id :- "+rs.getString("email"));
				System.out.println("Employee Password :- "+rs.getString("password"));
				System.out.println("Area :- "+rs.getString("area"));
				System.out.println("Pincode :- "+rs.getString("pincode"));
				System.out.println("age :- "+rs.getInt("age"));
				System.out.println("GMP ID :- "+rs.getInt("GMP_Id"));
				
				
				System.out.println("----------------------------------");
				
				
			}
			gmpfun();
			}catch (Exception e) {	
				System.out.println(e);
			}
		}
	
	
	

}
