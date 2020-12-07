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

}
