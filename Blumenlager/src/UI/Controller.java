package UI;

import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Lagerverwaltung lagerverwaltung;

	
	public Controller(Artikelverwaltung artikelverwaltung, Regalverwaltung regalverwaltung, Lagerverwaltung lagerverwaltung) {
		this.artikelverwaltung = artikelverwaltung;
		this.regalverwaltung = regalverwaltung;
		this.lagerverwaltung = lagerverwaltung;
	}

	public void start() {
		
		try{
			artikelverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Artikelverwaltung konnte nicht geladen werden: " + e.getMessage());
		}
		try{
			regalverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Regalverwaltung konnte nicht geladen werden: " + e.getMessage());
		}
		try{
			lagerverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Lagerverwaltung konnte nicht geladen werden: " + e.getMessage());
		}
		
    
		new Hauptmenue(this);

	}
  
	public void zeigeEinlagernView()
	{
		new EinlagernView();
	}
	public void zeigeAuslagernView()
	{
		new AuslagernView();
	}

}
