package Datenhaltung;

import java.sql.Connection;

public interface IDataConnector {
	
	public Connection getConnection() throws Exception;
	
}
