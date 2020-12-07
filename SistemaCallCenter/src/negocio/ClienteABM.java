package negocio;

import java.util.List;

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

	public List<Cliente> traer() {
		return ClienteDao.getInstanciaClienteDao().traer();
	}

	public Cliente traer(long id) {
		return ClienteDao.getInstanciaClienteDao().traer(id);
	}

	public int agregar(String nombre, String apellido, long dni) throws Exception {
		if (PersonaDao.getInstanciaPersonaDao().traer(dni) != null)
			throw new Exception("Cliente ya registrado!");
		return ClienteDao.getInstanciaClienteDao().agregar(new Cliente(nombre, apellido, dni));
	}

}
