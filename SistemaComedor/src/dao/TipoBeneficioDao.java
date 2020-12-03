package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.TipoBeneficio;

public class TipoBeneficioDao {

	private static Session session;
	private Transaction tx;
	private static TipoBeneficioDao instanciaTipoBeneficioDao = null;

	private TipoBeneficioDao() {

	}

	public static TipoBeneficioDao getInstanciaTipoBeneficioDao() {
		if (instanciaTipoBeneficioDao == null) {
			instanciaTipoBeneficioDao = new TipoBeneficioDao();
		}

		return instanciaTipoBeneficioDao;
	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	public int agregar(TipoBeneficio tipoBeneficio) throws HibernateException {
		int idTipoBeneficio = 0;

		try {
			iniciarOperacion();
			idTipoBeneficio = Integer.parseInt(session.save(tipoBeneficio).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idTipoBeneficio;
	}

	public TipoBeneficio traer(int idTipoBeneficio) {
		TipoBeneficio tipoBeneficio = null;

		try {
			iniciarOperacion();
			tipoBeneficio = (TipoBeneficio) session
					.createQuery("from TipoBeneficio t where t.idTipoBeneficio=" + idTipoBeneficio).uniqueResult();
		} finally {
			session.close();
		}

		return tipoBeneficio;
	}

	@SuppressWarnings("unchecked")
	public List<TipoBeneficio> traer() {
		List<TipoBeneficio> tiposBeneficios = null;

		try {
			iniciarOperacion();
			tiposBeneficios = session.createQuery("From tipoBeneficio t order by t.idTipoBeneficio").list();
		} finally {
			session.close();
		}

		return tiposBeneficios;
	}

	public void actualizar(TipoBeneficio tipoBeneficio) throws HibernateException {

		try {
			iniciarOperacion();
			session.update(tipoBeneficio);
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

	}

}
