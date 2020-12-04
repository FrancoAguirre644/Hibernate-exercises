package negocio;

import java.util.List;

import dao.AreaDao;
import datos.Area;

public class AreaABM {

	private static AreaABM instanciaAreaABM = null;

	private AreaABM() {
		super();
	}

	public static AreaABM getInstanciaAreaABM() {
		if (instanciaAreaABM == null) {
			instanciaAreaABM = new AreaABM();
		}

		return instanciaAreaABM;
	}

	public List<Area> traer() {
		return AreaDao.getInstanciaPedidoDao().traer();
	}

	public int agregar(String nombre) {
		return AreaDao.getInstanciaPedidoDao().agregar(new Area(nombre));
	}

}
