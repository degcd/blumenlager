import Datenhaltung.ArtikelDAO;

import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.Controller;
import java.sql.*;

public class Main {
	public static void main(String[] args) {	
		Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO());
		Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO());
		Controller controller = new Controller(artikelverwaltung, regalverwaltung);
		controller.start();
		//Test; Aufruf sp�ter �ber Hauptmenue
		controller.zeigeEinlagernView();
		controller.zeigeAuslagernView();
		
		
		//Test Datenbank
		try{
			//Get a connection to database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blumenlager", "blumenlager", "blumenlager");
			//Create a statement
			Statement mystat = myConn.createStatement();
			//Execute Sql query
			ResultSet myRs = mystat.executeQuery("select * from artikel");
			//Process the result set
			while(myRs.next())
			{
				System.out.println(myRs.getString("idartikel")+ " "
						+ myRs.getString("bezeichnung"));
			}
		}
		catch(Exception ex){
			
		}

	}

	
}
