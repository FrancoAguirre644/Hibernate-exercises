package negocio;

import java.time.LocalTime;

import dao.TipoBeneficioDao;
import datos.TipoBeneficio;

public class TipoBeneficioABM {

	private static TipoBeneficioABM instanciaTipoBeneficioABM = null;

	private TipoBeneficioABM() {
		super();
	}

	public static TipoBeneficioABM getInstanciaTipoBeneficioABM() {
		if (instanciaTipoBeneficioABM == null) {
			instanciaTipoBeneficioABM = new TipoBeneficioABM();
		}

		return instanciaTipoBeneficioABM;
	}

	public int agregar(String descripcion, LocalTime horaDesde, LocalTime horaHasta, int maxDiario) {
		return TipoBeneficioDao.getInstanciaTipoBeneficioDao()
				.agregar(new TipoBeneficio(descripcion, horaDesde, horaHasta, maxDiario));
	}

	public TipoBeneficio traer(int idTipoBeneficio) {
		return TipoBeneficioDao.getInstanciaTipoBeneficioDao().traer(idTipoBeneficio);
	}

	public void actualizar(TipoBeneficio tipoBeneficio) {
		TipoBeneficioDao.getInstanciaTipoBeneficioDao().actualizar(tipoBeneficio);
	}

}
