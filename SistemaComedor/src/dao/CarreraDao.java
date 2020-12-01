package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Carrera;

public class CarreraDao {

	private static Session session;
	private Transaction tx;
	private static CarreraDao instanciaCarreraDao = null;

	private CarreraDao() {

	}

	public static CarreraDao getInstanciaCarreraDao() {
		if (instanciaCarreraDao == null) {
			instanciaCarreraDao = new CarreraDao();
		}

		return instanciaCarreraDao;
	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	@SuppressWarnings("unchecked")
	public List<Carrera> traer() {
		List<Carrera> carreras = null;

		try {
			iniciarOperacion();
			carreras = session.createQuery("from Carrera c order by c.idCarrera").list();
		} finally {
			session.close();
		}

		return carreras;
	}

	public Carrera traer(int idCarrera) {

		Carrera carrera = null;

		try {
			iniciarOperacion();
			carrera = (Carrera) session.createQuery("from Carrera c where c.idCarrera=" + idCarrera).uniqueResult();
		} finally {
			session.close();
		}

		return carrera;
	}

	public int agregar(Carrera carrera) throws HibernateException {
		int idCarrera = 0;

		try {
			iniciarOperacion();
			idCarrera = Integer.parseInt(session.save(carrera).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idCarrera;
	}

}
