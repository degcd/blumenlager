package Fachlogik.Artikelverwaltung;

public abstract class Artikel {

	private static int naechsteNr = 10000;
	private int idArtikel;
	private String bezeichnung;
	private String kategorie;

    
	

	public Artikel(int artikelnr, String kategorie, String bezeichnung)
	{
		this.kategorie = kategorie;
		this.idArtikel = artikelnr;
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

	public int getId()
	{
		return this.idArtikel;
	}
	
	public String getBezeichnung()
	{
		return this.bezeichnung;
	}
	
}
