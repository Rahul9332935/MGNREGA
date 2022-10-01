package com.mgnrega.login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.mgnrega.dao.BDOdao;
import com.mgnrega.dao.BDOimpl;
import com.mgnrega.utility.DBUtil;
import com.mysql.cj.log.Log;

public class Login {
	
	Scanner sc=new Scanner(System.in);
	
	
	 BDOdao bdo=new BDOimpl();
	
	public void login_choice() throws SQLException{
		
		System.out.println("Welcome to MGNREGA... \n"
				+ "1. BDO Login \n"
				+ "2. GPM Login \n"
				+ "4. Exit");
		System.out.println("Choose the appropriate option");
		
		int x=sc.nextInt();
		
		
		switch (x) {
		case 1: {
			
			bdo.bdo_login();
			break;
		}
		
		default:
			System.out.println("Wrong option..Try again \n");
			login_choice();
			break;
		}
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	Login login =new Login();
	
	DBUtil db=new DBUtil();
	Connection con= db.provideConnection();
	
	try {
		login.login_choice();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
		
		
		
	}
	

}
