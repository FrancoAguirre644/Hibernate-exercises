package negocio;

import java.util.List;

import dao.EstudianteDao;
import datos.Carrera;
import datos.Estudiante;

public class EstudianteABM {

	private static EstudianteABM instanciaEstudianteABM = null;

	private EstudianteABM() {
		super();
	}

	public static EstudianteABM getInstanciaEstudianteABM() {
		if (instanciaEstudianteABM == null) {
			instanciaEstudianteABM = new EstudianteABM();
		}

		return instanciaEstudianteABM;
	}

	public int agregar(int dni, String nombre, String apellido, Carrera carrera) {
		return EstudianteDao.getInstanciaEstudianteDao().agregar(new Estudiante(dni, nombre, apellido, carrera));
	}

	public List<Estudiante> traer() {
		return EstudianteDao.getInstanciaEstudianteDao().traer();
	}

	public List<Estudiante> traer(boolean regulares) {
		return EstudianteDao.getInstanciaEstudianteDao().traer(regulares);
	}

	public Estudiante traer(int dni) {
		return EstudianteDao.getInstanciaEstudianteDao().traer(dni);
	}

	public void actualizar(Estudiante estudiante) {
		EstudianteDao.getInstanciaEstudianteDao().actualizar(estudiante);
	}

}
