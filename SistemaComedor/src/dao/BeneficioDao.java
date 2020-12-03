package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Beneficio;
import datos.Estudiante;
import datos.TipoBeneficio;

public class BeneficioDao {

	private static Session session;
	private Transaction tx;
	private static BeneficioDao instanciaBeneficioDao = null;

	private BeneficioDao() {

	}

	public static BeneficioDao getInstanciaBeneficioDao() {
		if (instanciaBeneficioDao == null) {
			instanciaBeneficioDao = new BeneficioDao();
		}

		return instanciaBeneficioDao;
	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	public int agregar(Beneficio beneficio) throws HibernateException {
		int idBeneficio = 0;

		try {
			iniciarOperacion();
			idBeneficio = Integer.parseInt(session.save(beneficio).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idBeneficio;
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> traer() {
		List<Beneficio> beneficios = null;

		try {
			iniciarOperacion();
			beneficios = session.createQuery("from Beneficio b order by b.idBeneficio").list();
		} finally {
			session.close();
		}

		return beneficios;
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> traer(LocalDate desde, LocalDate hasta) {
		List<Beneficio> beneficios = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Beneficio b where b.fecha between :desde and :hasta");
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			beneficios = query.list();
		} finally {
			session.close();
		}

		return beneficios;
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> traer(LocalDate fecha) {
		List<Beneficio> beneficios = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Beneficio b where b.fecha= :fecha");
			query.setParameter("fecha", fecha);
			beneficios = query.list();
		} finally {
			session.close();
		}

		return beneficios;
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> traer(TipoBeneficio tipoBeneficio, LocalDate fecha) {
		List<Beneficio> beneficios = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery(
					"from Beneficio b where b.fecha= :fecha and b.tipoBeneficio.idTipoBeneficio= :idTipoBeneficio");
			query.setParameter("fecha", fecha);
			query.setParameter("idTipoBeneficio", tipoBeneficio.getIdTipoBeneficio());
			beneficios = query.list();
		} finally {
			session.close();
		}

		return beneficios;
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> traer(Estudiante estudiante, LocalDate fecha) {
		List<Beneficio> beneficios = null;

		try {
			iniciarOperacion();
			Query query = session
					.createQuery("from Beneficio b where b.fecha= :fecha and b.estudiante.legajo= :legajo");
			query.setParameter("fecha", fecha);
			query.setParameter("legajo", estudiante.getLegajo());
			beneficios = query.list();
		} finally {
			session.close();
		}

		return beneficios;
	}

	public long cantidadOtorgada(TipoBeneficio tipoBeneficio, LocalDate fecha) {

		long cantidadOtorgada = 0;

		try {
			iniciarOperacion();
			Query query = session.createQuery(
					"SELECT COUNT(b) from Beneficio b where b.fecha= :fecha and b.tipoBeneficio.idTipoBeneficio= :idTipoBeneficio");
			query.setParameter("fecha", fecha);
			query.setParameter("idTipoBeneficio", tipoBeneficio.getIdTipoBeneficio());

			cantidadOtorgada = (long) query.uniqueResult();

		} finally {
			session.close();
		}

		return cantidadOtorgada;

	}

	public long cantidadOtorgada(Estudiante estudiante, LocalDate fecha) {

		long cantidadOtorgada = 0;

		try {
			iniciarOperacion();
			Query query = session.createQuery(
					"SELECT COUNT(b) from Beneficio b where b.fecha= :fecha and b.estudiante.legajo= :legajo");
			query.setParameter("fecha", fecha);
			query.setParameter("legajo", estudiante.getLegajo());

			cantidadOtorgada = (long) query.uniqueResult();

		} finally {
			session.close();
		}

		return cantidadOtorgada;

	}

}
