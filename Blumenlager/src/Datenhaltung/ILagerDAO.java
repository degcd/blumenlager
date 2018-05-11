package Datenhaltung;

import java.util.ArrayList;

import Fachlogik.Lagerverwaltung.Lager;


public interface ILagerDAO {

	ArrayList<Lager> laden() throws Exception;

	void speichern(ArrayList<Lager> liste) throws Exception;
	
}
