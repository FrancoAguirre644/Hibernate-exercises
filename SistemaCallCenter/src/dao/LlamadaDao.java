package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;
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

	@SuppressWarnings("unchecked")
	public List<Llamada> traer(LocalDate desde, LocalDate hasta) {
		List<Llamada> llamadas = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Llamada l where l.fecha between :desde and :hasta");
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			llamadas = query.list();
		} finally {
			session.close();
		}

		return llamadas;

	}

	@SuppressWarnings("unchecked")
	public List<Llamada> traer(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		List<Llamada> llamadas = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery(
					"from Llamada l where l.fecha between :desde and :hasta and l.nivelSatisfaccion= :nivelDeSatisfaccion");
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			query.setParameter("nivelDeSatisfaccion", nivelDeSatisfaccion);
			llamadas = query.list();
		} finally {
			session.close();
		}

		return llamadas;

	}

	@SuppressWarnings("unchecked")
	public List<Llamada> traer(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion, Empleado empleado) {
		List<Llamada> llamadas = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery(
					"from Llamada l where l.fecha between :desde and :hasta and l.nivelSatisfaccion= :nivelDeSatisfaccion and l.empleado.idPersona = :idPersona");
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			query.setParameter("nivelDeSatisfaccion", nivelDeSatisfaccion);
			query.setParameter("idPersona", empleado.getIdPersona());
			llamadas = query.list();
		} finally {
			session.close();
		}

		return llamadas;

	}

	public long calcularTotalNivelDeSatifaccion() {
		long total = 0;

		try {
			iniciarOperacion();
			total = (long) session.createQuery("select sum(l.nivelSatisfaccion) from Llamada l").uniqueResult();
		} finally {
			session.close();
		}

		return total;
	}

}
