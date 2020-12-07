package test;

import java.time.LocalDate;

import dao.ItemPedidoDao;
import dao.PedidoDao;
import negocio.AreaABM;
import negocio.InsumoABM;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;

public class test {

	public static void main(String[] args) {

		// System.out.println(AreaABM.getInstanciaAreaABM().agregar("Sistemas"));

		System.out.println(AreaABM.getInstanciaAreaABM().traer("Sistemas"));

		try {
			System.out.println(InsumoABM.getInstanciaInsumoABM().agregar("cuaderno", 20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			AreaABM.getInstanciaAreaABM().agregar("Sistemas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AreaABM.getInstanciaAreaABM().traer().stream().forEach((a) -> {
			System.out.println(a);
		});

		InsumoABM.getInstanciaInsumoABM().traer().stream().forEach((i) -> {
			System.out.println(i);
		});

		PedidoDao.getInstanciaPedidoDao().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

//		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 16),
//				AreaABM.getInstanciaAreaABM().traer("Sistemas"), LocalDate.of(2018, 8, 3));

		System.out.println();

//		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 17),
//				AreaABM.getInstanciaAreaABM().traer("Sistemas"), "Falta de lapiceras", 10);

		System.out.println();

		PedidoABM.getInstanciaPedidoABM().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(1));
		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(2));

		try {
			System.out.println(InsumoABM.getInstanciaInsumoABM().agregar("lapicera", 20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(1),
//				InsumoABM.getInstanciaInsumoABM().traer("cuaderno"), 10);
//
//		ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(1),
//				InsumoABM.getInstanciaInsumoABM().traer("lapicera"), 15);
//
//		ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(2),
//				InsumoABM.getInstanciaInsumoABM().traer("lapicera"), 40);
//
//		ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(2),
//				InsumoABM.getInstanciaInsumoABM().traer("cuaderno"), 45);

		ItemPedidoABM.getInstanciaItemPedidoABM().traer().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		PedidoABM.getInstanciaPedidoABM().traer(1).getItemPedidos().stream().forEach((p) -> {
			System.out.println(p);
		});

		PedidoABM.getInstanciaPedidoABM().traer(2).getItemPedidos().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(2).getItemPedidos());

		System.out.println();

		System.out.println(AreaABM.getInstanciaAreaABM().traer("Sistemas").getPedidos());

		System.out.println();

		PedidoABM.getInstanciaPedidoABM().traer(1).getItemPedidos().stream().forEach((p) -> {
			System.out.println(p.calcularSubTotal());
		});
		
		System.out.println();
		
		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(1).calcularTotal());
		

	}

}
