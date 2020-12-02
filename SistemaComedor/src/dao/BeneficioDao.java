package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Beneficio;

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

}
