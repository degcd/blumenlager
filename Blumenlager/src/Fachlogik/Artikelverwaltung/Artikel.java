package Fachlogik.Artikelverwaltung;

import java.util.ArrayList;

public abstract class Artikel {

	private static int naechsteNr = 10000;
	private int artikelnummer;
	private String bezeichnung;
	private ArrayList<Artikel> artikelliste;
// enum mit verfügbaren Monaten oder Jahreszeit??? --> Erweiterung
	
    
	public Artikel(){
    	artikelnummer = naechsteNr++;
    	artikelliste.add(this);
    }

	public Artikel(String bezeichnung)
	{
		this();
		this.bezeichnung = bezeichnung;
		artikelliste.add(this);
	}
	

	//wird zur Identifikation genutzt; darf nicht geändert werden ? Methode löschen ?

//	public void setBezeichnung(String bezeichnung)
//	{
//		this.bezeichnung = bezeichnung;
//	}
	
	public int getArtikelnummer()
	{
		return this.artikelnummer;
	}
	
	public String getBezeichnung()
	{
		return this.bezeichnung;
	}
	
}
