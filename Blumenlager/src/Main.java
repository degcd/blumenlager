import Datenhaltung.ArtikelDAO;
import Datenhaltung.BlumenlagerDataConnector;
import Datenhaltung.LagerDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.ArtikelanzeigeView;
import UI.AuslagernView;
import UI.Controller;

public class Main {
	public static void main(String[] args) {
		
		BlumenlagerDataConnector dc = new BlumenlagerDataConnector();
		Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO(dc.getConnection()));
		Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO(dc.getConnection(), artikelverwaltung), artikelverwaltung);
		Lagerverwaltung lagerverwaltung = new Lagerverwaltung(new LagerDAO(dc.getConnection(), regalverwaltung));
		Controller controller = new Controller(artikelverwaltung, regalverwaltung, lagerverwaltung);		
		controller.start();
	

		

	}

	
}
