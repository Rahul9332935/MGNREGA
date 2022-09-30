package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mgnrega.utility.DBUtil;

public class BDOimpl implements BDOdao{

	@Override
	public String createGMP() {
		
		String message="Not Created";
		
		
		try(Connection conn=DBUtil.provideConnection()){
			
			conn.prepareStatement("insert into GMP ")
			
			
			
		}catch (SQLException e) {
			
			
			
			
		}
		
		
		
		
		
		
		return message;
	}

}
