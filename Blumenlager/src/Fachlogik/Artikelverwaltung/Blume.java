package Fachlogik.Artikelverwaltung;

public class Blume extends Artikel{
	
	private String farbe;
	private Typ typ;
	
	
	public Blume(String bezeichnung, String farbe, Typ typ)
	{
		super(bezeichnung);
		this.farbe = farbe;
		this.typ = typ;
	}
	
	
	public void setFarbe(String farbe)
	{
		this.farbe = farbe;
	}
	
	public void setTyp(Typ typ)
	{
		this.typ = typ;
	}
	
	public String getFarbe()
	{
		return this.farbe;
	}
	
	public Typ getTyp()
	{
		return this.typ;
	}

}