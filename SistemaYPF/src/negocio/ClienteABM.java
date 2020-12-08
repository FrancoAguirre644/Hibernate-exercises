package negocio;

import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	private static ClienteABM instanciaClienteABM = null;

	private ClienteABM() {

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

	public Cliente traer(long dni) {
		return ClienteDao.getInstanciaClienteDao().traer(dni);
	}

	public Cliente traer(int idCliente) {
		return ClienteDao.getInstanciaClienteDao().traer(idCliente);
	}

	public int agregar(String nombre, String apellido, String email, long dni) throws Exception {

		if (traer(dni) != null)
			throw new Exception("Cliente ya existente!");

		return ClienteDao.getInstanciaClienteDao().agregar(new Cliente(nombre, apellido, email, dni));
	}

}
