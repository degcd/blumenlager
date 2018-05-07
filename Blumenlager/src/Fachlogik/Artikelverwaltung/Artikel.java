package Fachlogik.Artikelverwaltung;

public abstract class Artikel {

	private static int naechsteNr = 10000;
	private int artikelnummer;
	private String bezeichnung;
	private String kategorie;
// enum mit verfügbaren Monaten oder Jahreszeit??? --> Erweiterung
	
    
	

	public Artikel(int artikelnr, String kategorie, String bezeichnung)
	{
		this.kategorie = kategorie;
		this.artikelnummer = artikelnr;
		this.bezeichnung = bezeichnung;
	}
	

	//wird zur Identifikation genutzt; darf nicht geändert werden ? Methode löschen ?

	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}
	
	public String getKategorie()
	{
		return kategorie;
	}
	public int getArtikelnummer()
	{
		return this.artikelnummer;
	}
	
	public String getBezeichnung()
	{
		return this.bezeichnung;
	}
	
}
