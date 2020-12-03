package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.Estudiante;
import datos.TipoBeneficio;

public class BeneficioABM {

	private static BeneficioABM instanciaBeneficioABM = null;

	public static BeneficioABM getInstanciaBeneficioABM() {
		if (instanciaBeneficioABM == null) {
			instanciaBeneficioABM = new BeneficioABM();
		}
		return instanciaBeneficioABM;
	}

	public List<Beneficio> traer() {
		return BeneficioDao.getInstanciaBeneficioDao().traer();
	}

	public int agregar(TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha) throws Exception {

		if (!estudiante.getEsRegular())
			throw new Exception(
					estudiante.getApellido() + " " + estudiante.getNombre() + " no es un estudiante regular");

		if (tipoBeneficio.getMaxDiario() == cantidadOtorgada(tipoBeneficio, fecha))
			throw new Exception("Se han agotado la cant. de beneficios de " + tipoBeneficio.getDescripcion());

		if (cantidadOtorgada(estudiante, fecha) == 2)
			throw new Exception("cantidad de beneficios diarios alcanzado para " + estudiante.getApellido() + " "
					+ estudiante.getNombre());

		return BeneficioDao.getInstanciaBeneficioDao().agregar(new Beneficio(tipoBeneficio, estudiante, fecha));
	}

	public int agregar(TipoBeneficio tipoBeneficio, Estudiante estudiante) {
		return BeneficioDao.getInstanciaBeneficioDao()
				.agregar(new Beneficio(tipoBeneficio, estudiante, LocalDate.now()));
	}

	public List<Beneficio> traer(LocalDate desde, LocalDate hasta) {
		return BeneficioDao.getInstanciaBeneficioDao().traer(desde, hasta);
	}

	public List<Beneficio> traer(LocalDate fecha) {
		return BeneficioDao.getInstanciaBeneficioDao().traer(fecha);
	}

	public List<Beneficio> traer(TipoBeneficio tipoBeneficio, LocalDate fecha) {
		return BeneficioDao.getInstanciaBeneficioDao().traer(tipoBeneficio, fecha);
	}

	public List<Beneficio> traer(Estudiante estudiante, LocalDate fecha) {
		return BeneficioDao.getInstanciaBeneficioDao().traer(estudiante, fecha);
	}

	public long cantidadOtorgada(TipoBeneficio tipoBeneficio, LocalDate fecha) {
		return BeneficioDao.getInstanciaBeneficioDao().cantidadOtorgada(tipoBeneficio, fecha);
	}

	public long cantidadOtorgada(Estudiante estudiante, LocalDate fecha) {
		return BeneficioDao.getInstanciaBeneficioDao().cantidadOtorgada(estudiante, fecha);
	}

}
