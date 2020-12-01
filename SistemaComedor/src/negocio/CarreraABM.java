package negocio;

import java.util.List;

import dao.CarreraDao;
import datos.Carrera;

public class CarreraABM {

	private static CarreraABM instanciaCarreraABM = null;

	public static CarreraABM getInstanciaCarreraABM() {
		if (instanciaCarreraABM == null) {
			instanciaCarreraABM = new CarreraABM();
		}
		return instanciaCarreraABM;
	}

	public List<Carrera> traer() {
		return CarreraDao.getInstanciaCarreraDao().traer();
	}

	public Carrera traer(int idCarrera) {
		return CarreraDao.getInstanciaCarreraDao().traer(idCarrera);
	}

	public int agregar(String descripcion) {
		return CarreraDao.getInstanciaCarreraDao().agregar(new Carrera(descripcion));
	}

}
