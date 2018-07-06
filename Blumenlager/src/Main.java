import Datenhaltung.ArtikelDAO;
import Datenhaltung.BlumenlagerDataConnector;
import Datenhaltung.LagerDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.Controller;

public class Main {
	public static void main(String[] args) {
		
		/**
		 * Hier wird die Anwendung gestartet. Die erforderlichen Instanzen aller drei Schichten werden erzeugt und durch 
		 * die Methode start() des Controllers werden die Daten aus der Datenbank geladen und das Hauptmenue angezeigt.
		 */
		
		BlumenlagerDataConnector dc = new BlumenlagerDataConnector();
		Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO(dc.getConnection()));
		Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO(dc.getConnection(), artikelverwaltung), artikelverwaltung);
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung(new LagerDAO(dc.getConnection(), regalverwaltung));
		Controller controller = new Controller(artikelverwaltung, regalverwaltung, lagerverwaltung);		
		controller.start();
	}	

}
