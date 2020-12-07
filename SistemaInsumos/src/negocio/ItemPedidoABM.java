package negocio;

import java.util.List;

import org.hibernate.HibernateException;

import dao.ItemPedidoDao;
import datos.Insumo;
import datos.ItemPedido;
import datos.Pedido;

public class ItemPedidoABM {

	private static ItemPedidoABM instanciaItemPedidoABM = null;

	public static ItemPedidoABM getInstanciaItemPedidoABM() {
		if (instanciaItemPedidoABM == null) {
			instanciaItemPedidoABM = new ItemPedidoABM();
		}

		return instanciaItemPedidoABM;
	}

	public List<ItemPedido> traer() {
		return ItemPedidoDao.getInstanciaItemPedidoDao().traer();
	}

	public int agregar(Pedido pedido, Insumo insumo, int cantidad) throws Exception {

		if (!pedido.isAbierto())
			throw new Exception("El pedido ya fue cerrado");

		return ItemPedidoDao.getInstanciaItemPedidoDao().agregar(new ItemPedido(pedido, insumo, cantidad));
	}

}
