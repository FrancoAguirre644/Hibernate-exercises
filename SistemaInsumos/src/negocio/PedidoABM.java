package negocio;

import java.time.LocalDate;

import dao.PedidoDao;
import datos.Area;
import datos.PedidoCritico;
import datos.PedidoMensual;

public class PedidoABM {

	private static PedidoABM instanciaPedidoABM = null;

	private PedidoABM() {
		super();
	}

	public static PedidoABM getInstanciaPedidoABM() {
		if (instanciaPedidoABM == null) {
			instanciaPedidoABM = new PedidoABM();
		}

		return instanciaPedidoABM;
	}

	public int abrirPedido(LocalDate fechaCreacion, Area area, LocalDate fechaEntrega) {
		return PedidoDao.getInstanciaPedidoDao().agregar(new PedidoMensual(fechaCreacion, area, fechaEntrega));
	}

	public int abrirPedido(LocalDate fechaCreacion, Area area, String motivo, double porcentajeExtra) {
		return PedidoDao.getInstanciaPedidoDao()
				.agregar(new PedidoCritico(fechaCreacion, area, motivo, porcentajeExtra));
	}

}
