package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {

	private static Session session;
	private Transaction tx;
	private static ClienteDao instanciaClienteDao = null;

	private ClienteDao() {

	}

	public static ClienteDao getInstanciaClienteDao() {
		if (instanciaClienteDao == null) {
			instanciaClienteDao = new ClienteDao();
		}

		return instanciaClienteDao;
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
	public List<Cliente> traer() {
		List<Cliente> clientes = null;

		try {
			iniciarOperacion();
			clientes = session.createQuery("from Cliente c order by c.idCliente").list();
		} finally {
			session.close();
		}

		return clientes;
	}

	public Cliente traer(long dni) {
		Cliente c = null;

		try {
			iniciarOperacion();
			c = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}

		return c;
	}

	public Cliente traer(int idCliente) {
		Cliente c = null;

		try {
			iniciarOperacion();
			c = (Cliente) session.createQuery("from Cliente c where c.idCliente=" + idCliente).uniqueResult();
		} finally {
			session.close();
		}

		return c;
	}

	public int agregar(Cliente c) throws HibernateException {
		int idCliente = 0;

		try {
			iniciarOperacion();
			idCliente = Integer.parseInt(session.save(c).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idCliente;
	}

}
