package Fachlogik.Artikelverwaltung;

public abstract class Artikel {

	private int artikelnummer;
	private String bezeichnung;

	public Artikel()
	{
		
	}
	
	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
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
