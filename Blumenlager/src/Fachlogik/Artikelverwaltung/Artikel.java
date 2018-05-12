package Fachlogik.Artikelverwaltung;

public abstract class Artikel {


  private String kategorie;
	private int idArtikel;
	private String bezeichnung;

    	
	public Artikel(int artikelnr, String kategorie, String bezeichnung)
	{
		this.idArtikel = artikelnr;
		this.kategorie = kategorie;
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
