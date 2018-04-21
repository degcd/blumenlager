package Fachlogik.Artikelverwaltung;

public abstract class Artikel {

	private static int naechsteNr = 10000;
	private int artikelnummer;
	private String bezeichnung;
// enum mit verfügbaren Monaten oder Jahreszeit??? --> Erweiterung
	
    
	public Artikel(){
    	artikelnummer = naechsteNr++;
    }

	public Artikel(String bezeichnung)
	{
		this();
		this.bezeichnung = bezeichnung;
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
