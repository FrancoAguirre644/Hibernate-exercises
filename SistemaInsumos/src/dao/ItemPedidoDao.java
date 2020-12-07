package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemPedido;

public class ItemPedidoDao {

	private static Session session;
	private Transaction tx;
	private static ItemPedidoDao instanciaItemPedidoDao = null;

	private ItemPedidoDao() {
		super();
	}

	public static ItemPedidoDao getInstanciaItemPedidoDao() {
		if (instanciaItemPedidoDao == null) {
			instanciaItemPedidoDao = new ItemPedidoDao();
		}

		return instanciaItemPedidoDao;
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
	public List<ItemPedido> traer() {
		List<ItemPedido> items = null;

		try {
			iniciarOperacion();
			items = session.createQuery("from ItemPedido i inner join fetch i.insumo").list();
		} finally {
			session.close();
		}

		return items;
	}

	public int agregar(ItemPedido i) throws HibernateException {
		int idItemPedido = 0;

		try {
			iniciarOperacion();
			idItemPedido = Integer.parseInt(session.save(i).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idItemPedido;

	}
}
