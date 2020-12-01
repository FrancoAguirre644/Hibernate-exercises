package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Empleado;

public class EmpleadoDao {

	private static Session session;
	private Transaction tx;
	private static EmpleadoDao instanciaEmpleadoDao = null;

	private EmpleadoDao() {
		super();
	}

	public static EmpleadoDao getInstanciaEmpleadoDao() {
		if (instanciaEmpleadoDao == null) {
			instanciaEmpleadoDao = new EmpleadoDao();
		}
		return instanciaEmpleadoDao;
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
	public List<Empleado> traer() {
		List<Empleado> empleados = null;

		try {
			iniciarOperacion();
			empleados = session.createQuery("from Empleado e order by e.idPersona").list();
		} finally {
			session.close();
		}

		return empleados;
	}

	public int agregar(Empleado empleado) throws HibernateException {
		int idEmpleado = 0;

		try {
			iniciarOperacion();
			idEmpleado = Integer.parseInt(session.save(empleado).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idEmpleado;
	}
}
