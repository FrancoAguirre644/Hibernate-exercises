package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoABM {

	private static ProductoABM instanciaProductoABM = null;

	private ProductoABM() {

	}

	public static ProductoABM getInstanciaProductoABM() {
		if (instanciaProductoABM == null) {
			instanciaProductoABM = new ProductoABM();
		}

		return instanciaProductoABM;
	}

	public Producto traer(String nombre) {
		return ProductoDao.getInstanciaProductoDao().traer(nombre);
	}

	public int agregar(String nombre, double precio, String unidadMedida, double pesosPorKms) {
		return ProductoDao.getInstanciaProductoDao().agregar(new Producto(nombre, precio, unidadMedida, pesosPorKms));
	}
}
