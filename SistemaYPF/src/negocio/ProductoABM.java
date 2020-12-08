package negocio;

import java.util.List;

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

	public List<Producto> traer() {
		return ProductoDao.getInstanciaProductoDao().traer();
	}

	public Producto traer(String nombre) {
		return ProductoDao.getInstanciaProductoDao().traer(nombre);
	}

	public int agregar(String nombre, double precio, String unidadMedida, double pesosPorKms) throws Exception{
		
		if(traer(nombre) != null) throw new Exception("Producto ya existente!");
		
		return ProductoDao.getInstanciaProductoDao().agregar(new Producto(nombre, precio, unidadMedida, pesosPorKms));
	}
}
