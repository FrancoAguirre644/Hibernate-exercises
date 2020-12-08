package negocio;

import java.util.List;

import dao.TarjetaDao;
import datos.Cliente;
import datos.Tarjeta;

public class TarjetaABM {

	private static TarjetaABM instanciaTarjetaABM = null;

	private TarjetaABM() {

	}

	public static TarjetaABM getInstanciaTarjetaABM() {
		if (instanciaTarjetaABM == null) {
			instanciaTarjetaABM = new TarjetaABM();
		}

		return instanciaTarjetaABM;
	}

	public List<Tarjeta> traer() {
		return TarjetaDao.getInstanciaTarjetaDao().traer();
	}

	public Tarjeta traer(Cliente c) {
		return TarjetaDao.getInstanciaTarjetaDao().traer(c.getIdCliente());
	}

	public int agregar(Cliente cliente) throws Exception {

		if (traer(cliente) != null)
			throw new Exception(
					"El cliente " + cliente.getApellido() + " " + cliente.getNombre() + "ya posee una tarjeta!");

		return TarjetaDao.getInstanciaTarjetaDao().agregar(new Tarjeta(cliente));
	}

}
