package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Pedido;

public class PedidoDao {

	private static Session session;
	private Transaction tx;
	private static PedidoDao instanciaPedidoDao = null;

	private PedidoDao() {
		super();
	}

	public static PedidoDao getInstanciaPedidoDao() {
		if (instanciaPedidoDao == null) {
			instanciaPedidoDao = new PedidoDao();
		}

		return instanciaPedidoDao;
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
	public List<Pedido> traer() {
		List<Pedido> pedidos = null;

		try {
			iniciarOperacion();
			pedidos = session.createQuery("from Pedido p order by p.idPedido").list();
		} finally {
			session.close();
		}

		return pedidos;
	}
	
	

}
