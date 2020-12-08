package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Tarjeta;

public class TarjetaDao {

	private static Session session;
	private Transaction tx;
	private static TarjetaDao instanciaTarjetaDao = null;

	private TarjetaDao() {

	}

	public static TarjetaDao getInstanciaTarjetaDao() {
		if (instanciaTarjetaDao == null) {
			instanciaTarjetaDao = new TarjetaDao();
		}

		return instanciaTarjetaDao;
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
	public List<Tarjeta> traer() {
		List<Tarjeta> tarjetas = null;

		try {
			iniciarOperacion();
			tarjetas = session.createQuery("from Tarjeta t order by t.idTarjeta").list();
		} finally {
			session.close();
		}

		return tarjetas;
	}

	public Tarjeta traer(long idCliente) {
		Tarjeta t = null;

		try {
			iniciarOperacion();
			t = (Tarjeta) session.createQuery("from Tarjeta t where t.cliente.idCliente=" + idCliente).uniqueResult();
		} finally {
			session.close();
		}

		return t;
	}

	public int agregar(Tarjeta t) throws HibernateException {
		int idTarjeta = 0;

		try {
			iniciarOperacion();
			idTarjeta = Integer.parseInt(session.save(t).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idTarjeta;
	}
}
