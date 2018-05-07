import java.util.ArrayList;

import Datenhaltung.ArtikelDAO;
import Datenhaltung.BlumenlagerDataConnector;
import Datenhaltung.RegalDAO;
import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regal;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import UI.Controller;

public class Main {
	public static void main(String[] args) {
		
		BlumenlagerDataConnector dc = new BlumenlagerDataConnector();
		Artikelverwaltung artikelverwaltung = new Artikelverwaltung(new ArtikelDAO(dc.getConnection()));
		Regalverwaltung regalverwaltung = new Regalverwaltung(new RegalDAO(dc.getConnection()));
		Controller controller = new Controller(artikelverwaltung, regalverwaltung);
		controller.start();
		
		
		//TODO: Verbinde Views miteinander
		controller.zeigeEinlagernView();
		controller.zeigeAuslagernView();

	}

	
}
