import Datenhaltung.ArtikelDAO;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.Controller;

public class Main {
	public static void main(String[] args) {	
		Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO());
		Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO());
		Controller controller = new Controller(artikelverwaltung, regalverwaltung);
		controller.start();
		//Test; Aufruf sp�ter �ber Hauptmenue
		controller.zeigeEinlagernView();
		controller.zeigeAuslagernView();

	}

	
}
