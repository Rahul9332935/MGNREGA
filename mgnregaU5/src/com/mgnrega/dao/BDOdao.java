package com.mgnrega.dao;

import java.sql.SQLException;

public interface BDOdao {
	
	
	abstract void bdo_login() throws SQLException;
	
	
	abstract String createGMP();
	
	
	

}
