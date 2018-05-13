package UI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Lagerverwaltung lagerverwaltung;

	private Hauptmenue hauptmenue;
	
	public Controller(Artikelverwaltung artikelverwaltung, Regalverwaltung regalverwaltung, Lagerverwaltung lagerverwaltung) {
		this.artikelverwaltung = artikelverwaltung;
		this.regalverwaltung = regalverwaltung;
		this.lagerverwaltung = lagerverwaltung;
	}

	public void start() {
		
		laden();
		
		this.hauptmenue = new Hauptmenue(this);
		hauptmenue.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				speichern();
			}
		});

	}
  
	//Anzeige Views
	public void zeigeEinlagernView()
	{
		new EinlagernView(this);
	}
	public void zeigeAuslagernView()
	{
		new AuslagernView(this);
	}
	
	public void zeigeArtikelanzeigeView()
	{
		new ArtikelanzeigeView(this, regalverwaltung, artikelverwaltung);
	}
	
	
	//Einlagern und Auslagern
	public void einlagern(String regalbezeichnung, int anzahlArtikel) throws Exception{
		regalverwaltung.einlagern(regalbezeichnung, anzahlArtikel);
	}
	public void auslagern(String regalbezeichnung, int anzahlArtikel) throws Exception{
		regalverwaltung.auslagern(regalbezeichnung, anzahlArtikel);
	}
	
	
	//Speichern und laden
	public void laden()
	{
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
	}
	
	public void speichern()
	{
		try{
			artikelverwaltung.speichern();
		} catch(Exception e)
		{
			System.out.println("Fehler beim Speichern der Artikelverwaltung: " + e.getMessage());
		}
		try{
			regalverwaltung.speichern();
		} catch(Exception e)
		{
			System.out.println("Fehler beim Speichern der Regalverwaltung: " + e.getMessage());
		}
		try{
			lagerverwaltung.speichern();
		} catch(Exception e)
		{
			System.out.println("Fehler beim Speichern der Lagerverwaltung: " + e.getMessage());
		}
	}
	
}



