package Datenhaltung;

import DTO.IDTO;

public interface IDAO {

	public IDTO laden() throws Exception;
	public void speichern(IDTO dto) throws Exception;
	
}
