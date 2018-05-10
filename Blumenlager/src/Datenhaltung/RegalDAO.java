package Datenhaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Bindegruen;
import Fachlogik.Artikelverwaltung.Blume;
import Fachlogik.Artikelverwaltung.Typ;
import Fachlogik.Lagerverwaltung.Regal;

public class RegalDAO implements IRegalDAO{

	private Connection conn;
	
	public RegalDAO(Connection c)
	{
		this.conn = c;
	}
	
	@Override
	public ArrayList<Regal> laden() throws Exception {
		
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		Statement statement = conn.createStatement();
		ResultSet rsRegal = statement.executeQuery("select * from Regal");
		//Gehe alle Regale durch 
		while(rsRegal.next())
		{
			//F�r jedes Regal: finde alle Artikel; erstelle Liste 
			//f�ge fertiges Regal zu der Regalliste hinzu
			ArrayList<Artikel> artikel = new ArrayList<Artikel>();
			Statement stat2 = conn.createStatement();
			ResultSet rsRegalArtikel = stat2.executeQuery("select * from artikel where idRegal =" + rsRegal.getString("idRegal"));
			
			while(rsRegalArtikel.next())
			{
				//F�r jeden Artikel im Regal Details herausfinden, um Artikel zu erzeugen;
				//schlussendlich zur Artikelliste, die dem Regal beigef�gt wird, hinzuf�gen
				Statement stat3 = conn.createStatement();
				ResultSet rsArtikel = stat3.executeQuery("select * from Artikel where idArtikel = " + rsRegalArtikel.getString("idArtikel"));
				rsArtikel.next();
				String kategorie = rsArtikel.getString("kategorie");
				if(kategorie.equals("Blume"))
				{
					artikel.add(new Blume(rsArtikel.getInt("idArtikel"),
							rsArtikel.getString("bezeichnung"),
							rsArtikel.getString("farbe"),
							new Typ(rsArtikel.getString("gattung"),rsArtikel.getString("familie"))));
				}
				else if(kategorie.equals("Bindegruen"))
				{
					artikel.add(new Bindegruen(rsArtikel.getInt("idArtikel"),
							rsArtikel.getString("bezeichnung")));
				}
			}
			regalliste.add(new Regal(rsRegal.getInt("idRegal"),rsRegal.getInt("maxAnzahlArtikel"), rsRegal.getString("platzbezeichnung"), artikel));
			
		}
		
		
		return regalliste;
	}

	@Override
	public void speichern(ArrayList<Regal> liste) throws Exception {
		
		Statement statement = conn.createStatement();
		statement.executeUpdate("Delete from regal;");
		for(Regal r: liste){
			
			statement.executeUpdate("insert into regal values("
					+ Integer.toString(r.getId()) + ","
					+ "'"+ r.getPlatzbezeichnung()+"',"
					+ Integer.toString(r.getMaxAnzahlArtikel())+ ");");
			
			for(Artikel a : r.getArtikelListe()){
				Statement stat2 = conn.createStatement();
				stat2.executeUpdate("update artikel set idregal= "
						+ Integer.toString(r.getId()) + " where idartikel="
						+ Integer.toString(a.getId()));	
			}
		}
		
	}

}
