package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.LlamadaDao;
import datos.Cliente;
import datos.Empleado;
import datos.Llamada;

public class LlamadaABM {

	private static LlamadaABM instanciaLlamadaABM = null;

	private LlamadaABM() {

	}

	public static LlamadaABM getInstanciaLlamadaABM() {
		if (instanciaLlamadaABM == null) {
			instanciaLlamadaABM = new LlamadaABM();
		}

		return instanciaLlamadaABM;
	}

	public List<Llamada> traer() {
		return LlamadaDao.getInstanciaLlamadaDao().traer();
	}

	public int agregar(LocalDate fecha, int nivelDeSatisfaccion, Cliente cliente, Empleado empleado) throws Exception {
		if (!validarNivelDeSatisfaccion(nivelDeSatisfaccion))
			throw new Exception("El nivel de Satisfaccion no es valido!");

		return LlamadaDao.getInstanciaLlamadaDao().agregar(new Llamada(cliente, empleado, fecha, nivelDeSatisfaccion));
	}

	public boolean validarNivelDeSatisfaccion(int nivelDeSatisfaccion) {
		return (nivelDeSatisfaccion >= 1 && nivelDeSatisfaccion <= 5) ? true : false;
	}

}
