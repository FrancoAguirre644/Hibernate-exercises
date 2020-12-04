package negocio;

import java.util.List;

import dao.InsumoDao;
import datos.Insumo;

public class InsumoABM {

	private static InsumoABM instanciaInsumoABM = null;

	public static InsumoABM getInstanciaInsumoABM() {
		if (instanciaInsumoABM == null) {
			instanciaInsumoABM = new InsumoABM();
		}

		return instanciaInsumoABM;
	}

	public List<Insumo> traer() {
		return InsumoDao.getInstanciaInsumoDao().traer();
	}

	public Insumo traer(String nombre) {
		return InsumoDao.getInstanciaInsumoDao().traer(nombre);
	}

	public int agregar(String nombre, double precioUnitario) throws Exception {
		if (traer(nombre) != null)
			throw new Exception("Insumo ya existente!");

		return InsumoDao.getInstanciaInsumoDao().agregar(new Insumo(nombre, precioUnitario));
	}

}
