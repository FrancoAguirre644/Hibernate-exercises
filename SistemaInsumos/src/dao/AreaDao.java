package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Area;

public class AreaDao {

	private static Session session;
	private Transaction tx;
	private static AreaDao instanciaAreaDao = null;

	private AreaDao() {
		super();
	}

	public static AreaDao getInstanciaPedidoDao() {
		if (instanciaAreaDao == null) {
			instanciaAreaDao = new AreaDao();
		}

		return instanciaAreaDao;
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
	public List<Area> traer() {
		List<Area> areas = null;

		try {
			iniciarOperacion();
			areas = session.createQuery("from Area a order by a.idArea").list();
		} finally {
			session.close();
		}

		return areas;
	}

	public int agregar(Area a) throws HibernateException {
		int idArea = 0;

		try {
			iniciarOperacion();
			idArea = Integer.parseInt(session.save(a).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idArea;
	}

}
