package UI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import DTO.RegalDTO;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Artikelverwaltung.IArtikelverwaltung;
import Fachlogik.Lagerverwaltung.ILagerverwaltung;
import Fachlogik.Lagerverwaltung.IRegalverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;

public class Controller {

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Lagerverwaltung lagerverwaltung;

	private ArtikelanzeigeView aav;
	private LagerDetailsView ldv;
	
	public Controller(IArtikelverwaltung artikelverwaltung, IRegalverwaltung regalverwaltung, ILagerverwaltung lagerverwaltung) {
		this.artikelverwaltung = (Artikelverwaltung) artikelverwaltung;
		this.regalverwaltung = (Regalverwaltung) regalverwaltung;
		this.lagerverwaltung = (Lagerverwaltung) lagerverwaltung;
	}

	public void start() {
		
		laden();	
		Hauptmenue.getInstance();
		Hauptmenue.getInstance().createHauptmenue(this);
		Hauptmenue.getInstance().addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				speichern();
			}
		});

	}
  
	//Anzeige Views
	public void zeigeEinlagernView() {
		new EinlagernView(this);
	}
	public void zeigeAuslagernView() {
		new AuslagernView(this);
	}
	
	public void zeigeArtikelanzeigeView() {
		aav = new ArtikelanzeigeView(this, new RegalDTO(regalverwaltung.getDAO(), regalverwaltung.getRegalListe(), regalverwaltung.getArtikelverwaltung()));
	}
	
	public void zeigeLagerDetailsView() {
		ldv = new LagerDetailsView(this, new RegalDTO(regalverwaltung.getDAO(), regalverwaltung.getRegalListe(), regalverwaltung.getArtikelverwaltung()));
	}
	
	public void zeigeEinlagernHinweis() {
		new HinweisView(null, "Erfolgreich eingelagert!");
	}
	
	public void zeigeAuslagernHinweis() {
		new HinweisView(null, "Erfolgreich ausgelagert!");
	}
	
	public void zeigeFehlerEinlagern() {
		new HinweisView(null, "Fehler beim Einlagern!");
	}
	
	public void zeigeFehlerAuslagern() {
		new HinweisView(null, "Fehler beim Auslagern!");
	}

	public ArtikelanzeigeView getAktuelleArtikelanzeigeView() {
		return aav;
	}
	
	public LagerDetailsView getAktuelleLagerDetailsView() {
		return ldv;
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
	
	
	public Controller getController() {
		return this;
	}
	
}



