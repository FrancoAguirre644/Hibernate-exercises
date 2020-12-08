package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Compra;
import datos.Producto;

public class CompraDao {

	private static Session session;
	private Transaction tx;
	private static CompraDao instanciaCompraDao = null;

	private CompraDao() {

	}

	public static CompraDao getInstanciaCompraDao() {
		if (instanciaCompraDao == null) {
			instanciaCompraDao = new CompraDao();
		}

		return instanciaCompraDao;
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
	public List<Compra> traer() {
		List<Compra> compras = null;

		try {
			iniciarOperacion();
			compras = session.createQuery("from Compra c order by c.idCompra").list();
		} finally {
			session.close();
		}

		return compras;
	}

	@SuppressWarnings("unchecked")
	public List<Compra> traer(Cliente cliente) {

		List<Compra> compras = null;

		try {
			iniciarOperacion();
			compras = session.createQuery("from Compra c where c.tarjeta.cliente.idCliente=" + cliente.getIdCliente())
					.list();
		} finally {
			session.close();
		}

		return compras;
	}

	@SuppressWarnings("unchecked")
	public List<Compra> traer(LocalDate desde, LocalDate hasta) {

		List<Compra> compras = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Compra c where c.fecha between :desde and :hasta");
			query.setParameter("desde", desde);
			query.setParameter("hasta", hasta);
			compras = query.list();
		} finally {
			session.close();
		}

		return compras;
	}

	@SuppressWarnings("unchecked")
	public List<Compra> traer(Producto producto) {

		List<Compra> compras = null;

		try {
			iniciarOperacion();
			compras = session.createQuery("from Compra c where c.producto.idProducto=" + producto.getIdProducto())
					.list();
		} finally {
			session.close();
		}

		return compras;
	}

	public double traerCantidadVendida(Producto producto) {

		double cantidaVendida = 0;

		try {
			iniciarOperacion();
			cantidaVendida = (double) session.createQuery(
					"select sum(cantidad) from Compra c where c.producto.idProducto=" + producto.getIdProducto())
					.uniqueResult();
		} finally {
			session.close();
		}

		return cantidaVendida;
	}
	
	public double traerTotalVentas(Producto producto) {

		double cantidaVendida = 0;

		try {
			iniciarOperacion();
			cantidaVendida = (double) session.createQuery(
					"select sum(cantidad * c.producto.precio) from Compra c where c.producto.idProducto=" + producto.getIdProducto())
					.uniqueResult();
		} finally {
			session.close();
		}

		return cantidaVendida;
	}

	public int agregar(Compra compra) {
		int idCompra = 0;

		try {
			iniciarOperacion();
			idCompra = Integer.parseInt(session.save(compra).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idCompra;
	}

}
