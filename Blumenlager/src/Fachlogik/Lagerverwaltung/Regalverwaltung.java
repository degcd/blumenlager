package Fachlogik.Lagerverwaltung;

import java.util.ArrayList;

import Datenhaltung.IArtikelDAO;
import Datenhaltung.IRegalDAO;
import Fachlogik.Artikelverwaltung.Artikel;

public class Regalverwaltung {

	private ArrayList<Regal> regalListe;
	private IRegalDAO regaldao;
	
	
	public Regalverwaltung(IRegalDAO regaldao)
	{
		regalListe = new ArrayList<Regal>();
		this.regaldao = regaldao;
	}
	
	public ArrayList<Regal> getRegalListe()
	{
		return this.regalListe;
	}

}
