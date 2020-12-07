package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Pedido;
import datos.PedidoCritico;
import datos.PedidoMensual;

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

	public Pedido traer(int idPedido) {
		Pedido pedido = null;

		try {
			iniciarOperacion();
			pedido = (Pedido) session.createQuery("from Pedido p where p.idPedido=" + idPedido).uniqueResult();
			Hibernate.initialize(pedido.getItemPedidos());
		} finally {
			session.close();
		}

		return pedido;
	}

	public int agregar(PedidoMensual p) throws HibernateException {
		int idPedido = 0;

		try {
			iniciarOperacion();
			idPedido = Integer.parseInt(session.save(p).toString());
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idPedido;
	}

	public int agregar(PedidoCritico p) throws HibernateException {
		int idPedido = 0;

		try {
			iniciarOperacion();
			idPedido = Integer.parseInt(session.save(p).toString());
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idPedido;
	}

	public void actualizar(Pedido p) throws HibernateException {

		try {
			iniciarOperacion();
			session.update(p);
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}
	}

}
