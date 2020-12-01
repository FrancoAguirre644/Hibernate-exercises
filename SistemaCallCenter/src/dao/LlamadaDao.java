package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Llamada;

public class LlamadaDao {

	private static Session session;
	private Transaction tx;
	private static LlamadaDao instanciaLlamadaDao = null;

	private LlamadaDao() {

	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	public static LlamadaDao getInstanciaLlamadaDao() {
		if (instanciaLlamadaDao == null) {
			instanciaLlamadaDao = new LlamadaDao();
		}

		return instanciaLlamadaDao;
	}

	@SuppressWarnings("unchecked")
	public List<Llamada> traer() {
		List<Llamada> llamadas = null;

		try {
			iniciarOperacion();
			llamadas = session.createQuery("from Llamada l order by l.idLlamada").list();
		} finally {
			session.close();
		}

		return llamadas;
	}

	public int agregar(Llamada l) {
		int idLlamada = 0;

		try {
			iniciarOperacion();
			idLlamada = Integer.parseInt(session.save(l).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idLlamada;
	}

}
