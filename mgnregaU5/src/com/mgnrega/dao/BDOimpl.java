package com.mgnrega.dao;

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
	
	static  Scanner sc=new Scanner(System.in);

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
		}else {
			System.out.println("Email/Password is incorrect");
			Login l=new Login();
			l.login_choice();
		}
		}catch (Exception e) {	
			System.out.println(e);
		}
	}

}
