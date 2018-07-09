package Datenhaltung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

/*stellt Verbindung zur Blumenlager Datenbank her (durch  Lesen der Daten aus einer Datei)*/
public class BlumenlagerDataConnector implements IDataConnector {
	
	private Connection conn;
	
	public BlumenlagerDataConnector(){
		try{
			
			FileReader fr = new FileReader("BlumenlagerDBConnConfig.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String url = br.readLine();
			String user = br.readLine();
			String password = br.readLine();
			
			this.conn = DriverManager.getConnection(url, user, password);
			
			br.close();
			
		}catch(Exception e){}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
}
