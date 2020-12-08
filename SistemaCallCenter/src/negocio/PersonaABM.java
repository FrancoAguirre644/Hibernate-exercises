package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {

	private static PersonaABM instanciaPersonaABM = null;

	private PersonaABM() {
		super();
	}

	public static PersonaABM getInstanciaPersonaABM() {
		if (instanciaPersonaABM == null) {
			instanciaPersonaABM = new PersonaABM();
		}
		return instanciaPersonaABM;
	}

	public Persona traer(long dni) {
		return PersonaDao.getInstanciaPersonaDao().traer(dni);
	}
	
	public List<Persona> traer(){
		return PersonaDao.getInstanciaPersonaDao().traer();
	}

}
