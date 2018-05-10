package UI;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Hauptmenue menue;

	
	public Controller(Artikelverwaltung artikelverwaltung, Regalverwaltung regalverwaltung) {
		this.artikelverwaltung = artikelverwaltung;
		this.regalverwaltung = regalverwaltung;
	}

	public void start() {
		
		try{
			artikelverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Artikelverwaltung konnte nicht geladen werden.");
		}
		try{
			regalverwaltung.laden();
		}
		catch(Exception e)
		{
			System.out.println("Regalverwaltung konnte nicht geladen werden.");
		}
		
    
		menue = new Hauptmenue(this);

	}
  
	public void zeigeEinlagernView()
	{
		EinlagernView einlagernView = new EinlagernView();
	}
	public void zeigeAuslagernView()
	{
		AuslagernView auslagernView = new AuslagernView();
	}

}
