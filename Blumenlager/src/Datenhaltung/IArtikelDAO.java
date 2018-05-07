package Datenhaltung;

import java.io.IOException;
import java.util.ArrayList;

import Fachlogik.Artikelverwaltung.Artikel;

public interface IArtikelDAO {
	ArrayList<Artikel> laden() throws Exception;

	void speichern(ArrayList<Artikel> liste) throws Exception;
}
