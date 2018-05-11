package Datenhaltung;

import java.sql.Connection;
import java.sql.DriverManager;

public class BlumenlagerDataConnector implements IDataConnector {
	
	private Connection conn;
	
	public BlumenlagerDataConnector(){
		try{
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blumenlager", "blumenlager", "blumenlager");
		}catch(Exception e){}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
}
