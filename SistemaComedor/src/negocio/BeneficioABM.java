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

}
