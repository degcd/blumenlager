package UI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Artikelverwaltung.IArtikelverwaltung;
import Fachlogik.Lagerverwaltung.ILagerverwaltung;
import Fachlogik.Lagerverwaltung.IRegalverwaltung;
import Fachlogik.Lagerverwaltung.Lagerverwaltung;
import Fachlogik.Lagerverwaltung.Regalverwaltung;
import Logging.Log;

public class Controller{

	private Artikelverwaltung artikelverwaltung;
	private Regalverwaltung regalverwaltung;
	private Lagerverwaltung lagerverwaltung;

	private ArtikelanzeigeView aav;
	private LagerDetailsView ldv;
	private EinlagernView einlagernView;

	ResourceBundle bundle;
	
	public Controller(IArtikelverwaltung artikelverwaltung, IRegalverwaltung regalverwaltung, ILagerverwaltung lagerverwaltung) {
		this.artikelverwaltung = (Artikelverwaltung) artikelverwaltung;
		this.regalverwaltung = (Regalverwaltung) regalverwaltung;
		this.lagerverwaltung = (Lagerverwaltung) lagerverwaltung;
	}

	public void start() {
		
		laden();
		Hauptmenue hauptmenue = Hauptmenue.getInstance();
		hauptmenue.createHauptmenue(this);
		hauptmenue.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				speichern();
				try{
					Log blumenlagerLog = Log.getInstance("BlumenlagerLogging.txt");
					blumenlagerLog.logger.info("Anwendung wurde geschlossen.");
					blumenlagerLog.logger.info("---------------------------------------");
				}
				catch(Exception ex){}
			}
		});
	}
  
	//Anzeige Views
	public void zeigeEinlagernView() {
		einlagernView = new EinlagernView(this);
	}
	public void zeigeAuslagernView() {
		new AuslagernView(this);
	}
	
	public void zeigeArtikelanzeigeView() {
		aav = new ArtikelanzeigeView(this, regalverwaltung);
	}
	
	public void zeigeLagerDetailsView() {
		ldv = new LagerDetailsView(this, regalverwaltung);
	}
	
	public void zeigeEinlagernHinweis() {
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		new HinweisView(null, bundle.getString("erfolgEin"));
	}
	
	public void zeigeAuslagernHinweis() {
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		new HinweisView(null, bundle.getString("erfolgAus"));
	}
	
	public void zeigeFehlerEinlagern() {
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		new HinweisView(null, bundle.getString("fehlerEin"));
	}
	
	public void zeigeFehlerAuslagern() {
		if (LanguageController.getLanguageController().getFlag() == 0)
		bundle = ResourceBundle.getBundle("Bundle_de_DE");
		if (LanguageController.getLanguageController().getFlag() == 1)
		bundle = ResourceBundle.getBundle("Bundle_en_GB");
		new HinweisView(null, bundle.getString("fehlerAus"));
	}

	public ArtikelanzeigeView getAktuelleArtikelanzeigeView() {
		return aav;
	}
	
	public LagerDetailsView getAktuelleLagerDetailsView() {
		return ldv;
	}
	
	public EinlagernView getAktuelleEinlagernView() {
		return einlagernView;
	}

	public Hauptmenue getAktuellesHauptmenue(){
		return Hauptmenue.getInstance();
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



