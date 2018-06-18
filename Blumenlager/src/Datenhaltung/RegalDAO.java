package Datenhaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.IDTO;
import DTO.RegalDTO;
import Fachlogik.Artikelverwaltung.Artikel;
import Fachlogik.Artikelverwaltung.Artikelverwaltung;
import Fachlogik.Lagerverwaltung.Regal;

public class RegalDAO implements IDAO{

	private Connection conn;
	private Artikelverwaltung artikelverwaltung;
	
	public RegalDAO(Connection c, Artikelverwaltung a)
	{
		this.conn = c;
		this.artikelverwaltung = a;
	}

	@Override
	public RegalDTO laden() throws Exception {
		
		ArrayList<Regal> regalliste = new ArrayList<Regal>();
		Statement statement = conn.createStatement();
		ResultSet rsRegal = statement.executeQuery("select * from Regal");
		//Gehe alle Regale durch 
		while(rsRegal.next())
		{
			//Für jedes Regal: finde alle Artikel; erstelle Liste 
			//füge fertiges Regal zu der Regalliste hinzu
			ArrayList<Artikel> artikel = new ArrayList<Artikel>();
			Statement stat2 = conn.createStatement();
			ResultSet rsRegalArtikel = stat2.executeQuery("select * from artikel where idRegal =" + rsRegal.getString("idRegal"));

			
			while(rsRegalArtikel.next())
			{
				artikel.add(artikelverwaltung.getArtikel(rsRegalArtikel.getInt("idArtikel")));
			}
			regalliste.add(new Regal(rsRegal.getInt("idRegal"),rsRegal.getInt("maxAnzahlArtikel"), rsRegal.getString("platzbezeichnung"), artikel));
			
		}
		
		return new RegalDTO(this, regalliste, artikelverwaltung);
	}

	
	public void speichern(IDTO dto) throws Exception {
		
		Statement statement = conn.createStatement();
		statement.executeUpdate("Delete from regal;");
		
		RegalDTO regaldto = (RegalDTO) dto;
		ArrayList<Regal> liste = regaldto.getListe();
		for(Regal r: liste){
			
			statement.executeUpdate("insert into regal values("
					+ Integer.toString(r.getId()) + ","
					+ "'"+ r.getPlatzbezeichnung()+"',"
					+ Integer.toString(r.getMaxAnzahlArtikel())+ ", null );");
			
			for(Artikel a : r.getArtikelListe()){
				Statement stat2 = conn.createStatement();
				stat2.executeUpdate("update artikel set idregal= "
						+ Integer.toString(r.getId()) + " where idartikel="
						+ Integer.toString(a.getId()));	
			}
		}

		
	}

}
