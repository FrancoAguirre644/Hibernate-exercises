package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.Estudiante;
import datos.TipoBeneficio;

public class BeneficioABM {

	private static BeneficioABM instanciaBeneficioABM = null;

	public static BeneficioABM getInstanciaCarreraABM() {
		if (instanciaBeneficioABM == null) {
			instanciaBeneficioABM = new BeneficioABM();
		}
		return instanciaBeneficioABM;
	}

	public List<Beneficio> traer() {
		return BeneficioDao.getInstanciaBeneficioDao().traer();
	}

	public int agregar(TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha) {
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

}
