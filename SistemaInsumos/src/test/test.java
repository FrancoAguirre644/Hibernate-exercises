package test;

import java.time.LocalDate;

import negocio.AreaABM;
import negocio.InsumoABM;
import negocio.ItemPedidoABM;
import negocio.PedidoABM;

public class test {

	public static void main(String[] args) {

		System.out.println(
				"-------------------------------------------Punto-1------------------------------------------------");

		try {
			InsumoABM.getInstanciaInsumoABM().agregar("lapicera", 10.5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			InsumoABM.getInstanciaInsumoABM().agregar("cuaderno", 20.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			InsumoABM.getInstanciaInsumoABM().agregar("monitor", 200.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			InsumoABM.getInstanciaInsumoABM().agregar("mouse", 150.5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InsumoABM.getInstanciaInsumoABM().traer().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-2------------------------------------------------");

		try {
			InsumoABM.getInstanciaInsumoABM().agregar("cuaderno", 15.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InsumoABM.getInstanciaInsumoABM().traer().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-3------------------------------------------------");
		try {
			AreaABM.getInstanciaAreaABM().agregar("Sistemas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			AreaABM.getInstanciaAreaABM().agregar("Finanzas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AreaABM.getInstanciaAreaABM().traer().stream().forEach((a) -> {
			System.out.println(a);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-4------------------------------------------------");

		try {
			AreaABM.getInstanciaAreaABM().agregar("Sistemas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AreaABM.getInstanciaAreaABM().traer().stream().forEach((a) -> {
			System.out.println(a);
		});

		System.out.println(
				"-------------------------------------------Punto-5------------------------------------------------");

		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 16),
				AreaABM.getInstanciaAreaABM().traer("Sistemas"), LocalDate.of(2018, 8, 3));

		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 16),
				AreaABM.getInstanciaAreaABM().traer("Finanzas"), LocalDate.of(2018, 8, 2));

		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 16),
				AreaABM.getInstanciaAreaABM().traer("Sistemas"), "rotura de monitor", 10);

		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 17),
				AreaABM.getInstanciaAreaABM().traer("Sistemas"), "falta de lapiceras", 10);

		PedidoABM.getInstanciaPedidoABM().abrirPedido(LocalDate.of(2018, 7, 18),
				AreaABM.getInstanciaAreaABM().traer("Sistemas"), "mouse roto", 10);

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-6------------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(1),
					InsumoABM.getInstanciaInsumoABM().traer("lapicera"), 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(1),
					InsumoABM.getInstanciaInsumoABM().traer("mouse"), 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PedidoABM.getInstanciaPedidoABM().traer(1).getItemPedidos().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-7------------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(2),
					InsumoABM.getInstanciaInsumoABM().traer("lapicera"), 30);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(2),
					InsumoABM.getInstanciaInsumoABM().traer("cuaderno"), 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PedidoABM.getInstanciaPedidoABM().traer(2).getItemPedidos().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println(
				"-------------------------------------------Punto-8------------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(3),
					InsumoABM.getInstanciaInsumoABM().traer("monitor"), 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PedidoABM.getInstanciaPedidoABM().traer(3).getItemPedidos().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-9------------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(4),
					InsumoABM.getInstanciaInsumoABM().traer("lapicera"), 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PedidoABM.getInstanciaPedidoABM().traer(4).getItemPedidos().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-10-----------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(5),
					InsumoABM.getInstanciaInsumoABM().traer("mouse"), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PedidoABM.getInstanciaPedidoABM().traer(5).getItemPedidos().stream().forEach((i) -> {
			System.out.println(i);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-11-----------------------------------------------");

		PedidoABM.getInstanciaPedidoABM().traer().stream().forEach((p) -> {
			PedidoABM.getInstanciaPedidoABM().cerrar(p);
		});

		PedidoABM.getInstanciaPedidoABM().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-12-----------------------------------------------");

		try {
			ItemPedidoABM.getInstanciaItemPedidoABM().agregar(PedidoABM.getInstanciaPedidoABM().traer(1),
					InsumoABM.getInstanciaInsumoABM().traer("cuaderno"), 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-13-----------------------------------------------");

		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(1).calcularTotal());

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-14-----------------------------------------------");

		System.out.println(PedidoABM.getInstanciaPedidoABM().traer(3).calcularTotal());

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-15-----------------------------------------------");

		System.out.println(AreaABM.getInstanciaAreaABM().traer("Sistemas")
				.calcularPresupuesto(LocalDate.of(2018, 7, 15), LocalDate.of(2018, 7, 18)));

	}

}
