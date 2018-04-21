package Datenhaltung;

import java.io.IOException;
import java.util.List;

import Fachlogik.Artikelverwaltung.Artikel;

public interface IArtikelDAO {
	List<Artikel> laden() throws IOException;

	void speichern(List<Artikel> liste) throws IOException;
}
