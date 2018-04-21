package Fachlogik.Artikelverwaltung;

public class Typ {

	private String gattung;
	private String familie;
	
	
	public Typ(String gattung, String familie)
	{
		this.gattung = gattung;
		this.familie = familie;
	}
	
	public void setGattung(String gattung)
	{
		this.gattung = gattung;
	}
	public void setFamilie(String familie)
	{
		this.familie = familie;
	}
	
	public String getGattung()
	{
		return this.gattung;
	}
	
	public String getFamilie()
	{
		return this.familie;
	}
	
}
