package negocio;

import dao.ClienteDao;
import dao.PersonaDao;
import datos.Cliente;

public class ClienteABM {

	private static ClienteABM instanciaClienteABM = null;

	private ClienteABM() {
		super();
	}

	public static ClienteABM getInstanciaClienteABM() {
		if (instanciaClienteABM == null) {
			instanciaClienteABM = new ClienteABM();
		}
		return instanciaClienteABM;
	}

	public int agregar(String nombre, String apellido, long dni) throws Exception {
		if (PersonaDao.getInstanciaPersonaDao().traer(dni) != null)
			throw new Exception("Cliente ya registrado!");
		return ClienteDao.getInstanciaClienteDao().agregar(new Cliente(nombre, apellido, dni));
	}

}