package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public List<Llamada> traer(LocalDate desde, LocalDate hasta) {
		return LlamadaDao.getInstanciaLlamadaDao().traer(desde, hasta);
	}

	public List<Llamada> traer(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		return LlamadaDao.getInstanciaLlamadaDao().traer(desde, hasta, nivelDeSatisfaccion);
	}

	public List<Llamada> traer(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion, Empleado empleado) {
		return LlamadaDao.getInstanciaLlamadaDao().traer(desde, hasta, nivelDeSatisfaccion, empleado);
	}

	public List<Llamada> traer(LocalDate desde, LocalDate hasta, Empleado empleado) {
		List<Llamada> llamadas = new ArrayList<Llamada>();

		for (Llamada l : traer(desde, hasta)) {
			if (l.getEmpleado().getIdPersona() == empleado.getIdPersona()) {
				llamadas.add(l);
			}
		}

		return llamadas;
	}

	public boolean validarNivelDeSatisfaccion(int nivelDeSatisfaccion) {
		return (nivelDeSatisfaccion >= 1 && nivelDeSatisfaccion <= 5) ? true : false;
	}

	public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		return ((traer(desde, hasta, nivelDeSatisfaccion).size() * nivelDeSatisfaccion) * 100)
				/ LlamadaDao.getInstanciaLlamadaDao().calcularTotalNivelDeSatifaccion();
	}

	public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion,
			Empleado empleado) {
		return ((traer(desde, hasta, nivelDeSatisfaccion, empleado).size() * nivelDeSatisfaccion) * 100)
				/ LlamadaDao.getInstanciaLlamadaDao().calcularTotalNivelDeSatifaccion();
	}

}
