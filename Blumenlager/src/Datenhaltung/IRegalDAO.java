package Datenhaltung;

import java.io.IOException;
import java.util.List;
import Fachlogik.Lagerverwaltung.Regal;

public interface IRegalDAO {
	List<Regal> laden() throws IOException;

	void speichern(List<Regal> liste) throws IOException;
}