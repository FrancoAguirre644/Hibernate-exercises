package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Insumo;

public class InsumoDao {

	private static Session session;
	private Transaction tx;
	private static InsumoDao instanciaInsumoDao = null;

	private InsumoDao() {
		super();
	}

	public static InsumoDao getInstanciaInsumoDao() {
		if (instanciaInsumoDao == null) {
			instanciaInsumoDao = new InsumoDao();
		}

		return instanciaInsumoDao;
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
	public List<Insumo> traer() {
		List<Insumo> insumos = null;

		try {
			iniciarOperacion();
			insumos = session.createQuery("from Insumo").list();
		} finally {
			session.close();
		}

		return insumos;
	}

	public Insumo traer(String nombre) {
		Insumo insumo = null;

		try {
			iniciarOperacion();
			Query query = session.createQuery("from Insumo i where i.nombre= :nombre");
			query.setParameter("nombre", nombre);
			insumo = (Insumo) query.uniqueResult();
		} finally {
			session.close();
		}

		return insumo;
	}

	public int agregar(Insumo insumo) throws HibernateException {
		int idInsumo = 0;

		try {
			iniciarOperacion();
			idInsumo = Integer.parseInt(session.save(insumo).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaException(he);
			throw he;
		} finally {
			session.close();
		}

		return idInsumo;
	}

}
