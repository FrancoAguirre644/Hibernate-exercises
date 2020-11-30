package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {

	private static Session session;
	private Transaction tx;
	private static PersonaDao instanciaPersonaDao = null;

	private PersonaDao() {
		super();
	}

	public static PersonaDao getInstanciaPersonaDao() {
		if (instanciaPersonaDao == null) {
			instanciaPersonaDao = new PersonaDao();
		}
		return instanciaPersonaDao;
	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	public Persona traer(long dni) {
		Persona persona = null;

		try {
			iniciarOperacion();
			persona = (Persona) session.createQuery("from Persona p where p.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}

		return persona;
	}

}
