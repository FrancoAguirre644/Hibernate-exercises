package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Producto;

public class ProductoDao {

	private static Session session;
	private Transaction tx;
	private static ProductoDao instanciaProductoDao = null;

	private ProductoDao() {

	}

	public static ProductoDao getInstanciaProductoDao() {
		if (instanciaProductoDao == null) {
			instanciaProductoDao = new ProductoDao();
		}

		return instanciaProductoDao;
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
	public List<Producto> traer() {
		List<Producto> productos = null;

		try {
			iniciarOperacion();
			productos = session.createQuery("from Producto p order by p.idProducto").list();
		} finally {
			session.close();
		}

		return productos;
	}

	public Producto traer(String nombre) {
		Producto producto = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Producto p where p.nombre= :nombre");
			query.setParameter("nombre", nombre);
			producto = (Producto) query.uniqueResult();
		} finally {
			session.close();
		}

		return producto;
	}

	public int agregar(Producto p) throws HibernateException {
		int idProducto = 0;

		try {
			iniciarOperacion();
			idProducto = Integer.parseInt(session.save(p).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idProducto;
	}

}
