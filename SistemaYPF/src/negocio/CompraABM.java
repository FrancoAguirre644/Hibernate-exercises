package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.CompraDao;
import datos.Cliente;
import datos.Compra;
import datos.Producto;

public class CompraABM {

	private static CompraABM instanciaCompraABM = null;

	private CompraABM() {

	}

	public static CompraABM getInstanciaCompraABM() {
		if (instanciaCompraABM == null) {
			instanciaCompraABM = new CompraABM();
		}

		return instanciaCompraABM;
	}

	public List<Compra> traer() {
		return CompraDao.getInstanciaCompraDao().traer();
	}

	public List<Compra> traer(Cliente cliente) {
		return CompraDao.getInstanciaCompraDao().traer(cliente);
	}

	public int agregar(LocalDate fecha, Producto producto, double cantidad, Cliente cliente) {
		return CompraDao.getInstanciaCompraDao()
				.agregar(new Compra(fecha, producto, cantidad, TarjetaABM.getInstanciaTarjetaABM().traer(cliente)));
	}

	public double traerCantidadVendida(Producto producto) {
		return CompraDao.getInstanciaCompraDao().traerCantidadVendida(producto);
	}

	public double traerTotalVentas(Producto producto) {
		return CompraDao.getInstanciaCompraDao().traerTotalVentas(producto);
	}

}
