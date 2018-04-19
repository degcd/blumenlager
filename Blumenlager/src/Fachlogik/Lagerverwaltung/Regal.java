package Fachlogik.Lagerverwaltung;

public class Regal {

	private int regalnummer;
	private int maxAnzahlArtikel;
	
	public Regal()
	{
		
	}
	public void setMaxAnzahlArtikel(int maxAnzahlArtikel)
	{
		this.maxAnzahlArtikel = maxAnzahlArtikel;
	}
	public int getRegalnummer()
	{
		return this.regalnummer;
	}
	public int getMaxAnzahlArtikel()
	{
		return this.maxAnzahlArtikel;
	}
	
}
