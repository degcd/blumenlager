package Datenhaltung;

import java.io.IOException;
import java.util.ArrayList;
import Fachlogik.Lagerverwaltung.Regal;

public interface IRegalDAO {
	ArrayList<Regal> laden() throws Exception;

	void speichern(ArrayList<Regal> liste) throws Exception;
}