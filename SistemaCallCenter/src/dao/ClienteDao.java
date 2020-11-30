package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

public class ClienteDao {

	private static Session session;
	private Transaction tx;
	private static ClienteDao instanciaClienteDao = null;

	private ClienteDao() {
		super();
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

	public int agregar(Cliente cliente) throws HibernateException {
		int idCliente = 0;

		try {
			iniciarOperacion();
			idCliente = Integer.parseInt(session.save(cliente).toString());
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
