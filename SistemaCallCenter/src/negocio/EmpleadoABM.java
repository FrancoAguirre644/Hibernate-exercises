package negocio;

import java.util.List;

import dao.EmpleadoDao;
import dao.PersonaDao;
import datos.Empleado;

public class EmpleadoABM {

	private static EmpleadoABM instanciaEmpleadoABM = null;

	private EmpleadoABM() {
		super();
	}

	public static EmpleadoABM getInstanciaEmpleadoABM() {
		if (instanciaEmpleadoABM == null) {
			instanciaEmpleadoABM = new EmpleadoABM();
		}
		return instanciaEmpleadoABM;
	}

	public List<Empleado> traer() {
		return EmpleadoDao.getInstanciaEmpleadoDao().traer();
	}

	public int agregar(String nombre, String apellido, long dni, int sueldoBase) throws Exception {
		if (PersonaDao.getInstanciaPersonaDao().traer(dni) != null)
			throw new Exception("Empleado ya registrado!");

		return EmpleadoDao.getInstanciaEmpleadoDao().agregar(new Empleado(nombre, apellido, dni, sueldoBase));
	}

}
