package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Estudiante;

public class EstudianteDao {

	private static Session session;
	private Transaction tx;
	private static EstudianteDao instanciaEstudianteDao = null;

	private EstudianteDao() {

	}

	public static EstudianteDao getInstanciaEstudianteDao() {
		if (instanciaEstudianteDao == null) {
			instanciaEstudianteDao = new EstudianteDao();
		}

		return instanciaEstudianteDao;
	}

	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaException(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de datos", he);
	}

	public int agregar(Estudiante estudiante) throws HibernateException {
		int idEstudiante = 0;

		try {
			iniciarOperacion();
			idEstudiante = Integer.parseInt(session.save(estudiante).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idEstudiante;
	}

	@SuppressWarnings("unchecked")
	public List<Estudiante> traer() {
		List<Estudiante> estudiantes = null;

		try {
			iniciarOperacion();
			estudiantes = session.createQuery("from Estudiante e order by e.legajo").list();
		} finally {
			session.close();
		}

		return estudiantes;
	}

	@SuppressWarnings("unchecked")
	public List<Estudiante> traer(boolean regulares) {
		List<Estudiante> estudiantes = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Estudiante e where e.esRegular= :regulares");
			query.setParameter("regulares", regulares);
			estudiantes = query.list();
		} finally {
			session.close();
		}

		return estudiantes;
	}

}
