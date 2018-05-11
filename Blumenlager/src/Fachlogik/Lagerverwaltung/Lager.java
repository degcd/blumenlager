package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

public class Lager {

	private int lagerId;
	private int maxAnzahlRegale;
	private ArrayList<Regal> regalListe;
	

	public Lager(int id, int maxAnzahlRegale, ArrayList<Regal> regale){
		this.lagerId = id;
		this.maxAnzahlRegale = maxAnzahlRegale;
		this.regalListe = regale;
	}
	
	public void addeRegal(Regal r)
	{
		if(r != null && regalListe.size() < maxAnzahlRegale)
			regalListe.add(r);
	}
	
	
	public int getId()
	{
		return this.lagerId;
	}
	public int getMaxAnzahlRegale(){
		return this.maxAnzahlRegale;
	}
	public ArrayList<Regal> getRegalListe(){
		return this.regalListe;
	}
	
}


