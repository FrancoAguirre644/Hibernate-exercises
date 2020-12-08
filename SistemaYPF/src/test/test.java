package test;

import java.time.LocalDate;

import negocio.ClienteABM;
import negocio.CompraABM;
import negocio.ProductoABM;
import negocio.TarjetaABM;

public class test {

	public static void main(String[] args) {

		System.out.println(
				"-------------------------------------------Punto-1------------------------------------------------");

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Micaela", "Hidalgo", "mhidalgo@gmail.com", 11111111);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Juan", "Lopez", "jlopez@gmail.com", 22222222);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Daniela", "Rojas", "drojas@gmail.com", 33333333);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Lucas", "Suarez", "lsuarez@gmail.com", 44444444);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Juan", "Lopez", "jlopez@gmail.com", 22222222);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClienteABM.getInstanciaClienteABM().traer().forEach((c) -> {
			System.out.println(c);
		});

		System.out.println(
				"-------------------------------------------Punto-2------------------------------------------------");

		try {
			ProductoABM.getInstanciaProductoABM().agregar("NAFTA SUPER", 12.0, "litros", 6.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ProductoABM.getInstanciaProductoABM().agregar("NAFTA INFINIA", 15.0, "litros", 3.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ProductoABM.getInstanciaProductoABM().agregar("INFINIA DIESEL", 15.5, "litros", 3.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ProductoABM.getInstanciaProductoABM().agregar("GNC", 10.0, "litros", 1.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ProductoABM.getInstanciaProductoABM().agregar("NAFTA INFINIA", 15.0, "litros", 3.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ProductoABM.getInstanciaProductoABM().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println(
				"-------------------------------------------Punto-3------------------------------------------------");

		try {
			TarjetaABM.getInstanciaTarjetaABM().agregar(ClienteABM.getInstanciaClienteABM().traer(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			TarjetaABM.getInstanciaTarjetaABM().agregar(ClienteABM.getInstanciaClienteABM().traer(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			TarjetaABM.getInstanciaTarjetaABM().agregar(ClienteABM.getInstanciaClienteABM().traer(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			TarjetaABM.getInstanciaTarjetaABM().agregar(ClienteABM.getInstanciaClienteABM().traer(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		TarjetaABM.getInstanciaTarjetaABM().traer().forEach((t) -> {
			System.out.println(t);
		});

		try {
			TarjetaABM.getInstanciaTarjetaABM().agregar(ClienteABM.getInstanciaClienteABM().traer(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-4------------------------------------------------");

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 17),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA SUPER"), 10.0,
				ClienteABM.getInstanciaClienteABM().traer(1));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 17),
				ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL"), 10.5,
				ClienteABM.getInstanciaClienteABM().traer(3));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 17),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA INFINIA"), 12.0,
				ClienteABM.getInstanciaClienteABM().traer(2));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 17),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA SUPER"), 10.0,
				ClienteABM.getInstanciaClienteABM().traer(1));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 18),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA SUPER"), 5.0,
				ClienteABM.getInstanciaClienteABM().traer(1));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 18),
				ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL"), 7.5,
				ClienteABM.getInstanciaClienteABM().traer(3));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 19),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA SUPER"), 8.0,
				ClienteABM.getInstanciaClienteABM().traer(1));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 19),
				ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL"), 22.0,
				ClienteABM.getInstanciaClienteABM().traer(3));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 20),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA INFINIA"), 25.0,
				ClienteABM.getInstanciaClienteABM().traer(2));

		CompraABM.getInstanciaCompraABM().agregar(LocalDate.of(2017, 10, 20),
				ProductoABM.getInstanciaProductoABM().traer("NAFTA INFINIA"), 20.5,
				ClienteABM.getInstanciaClienteABM().traer(2));

		CompraABM.getInstanciaCompraABM().traer().stream().forEach((c) -> {
			System.out.println(c);
		});

		System.out.println(
				"-------------------------------------------Punto-5------------------------------------------------");

		CompraABM.getInstanciaCompraABM().traer(ClienteABM.getInstanciaClienteABM().traer(3)).forEach((c) -> {
			System.out.println(c);
		});

		System.out.println(
				"-------------------------------------------Punto-6------------------------------------------------");

		CompraABM.getInstanciaCompraABM().traer(LocalDate.of(2017, 10, 18), LocalDate.of(2017, 10, 20)).forEach((c) -> {
			System.out.println(c);
		});

		System.out.println(
				"-------------------------------------------Punto-7------------------------------------------------");

		CompraABM.getInstanciaCompraABM().traer(LocalDate.of(2017, 10, 18), LocalDate.of(2017, 10, 20),
				ClienteABM.getInstanciaClienteABM().traer(3));

		System.out.println(
				"-------------------------------------------Punto-8------------------------------------------------");

		CompraABM.getInstanciaCompraABM().traer(ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL"))
				.forEach((c) -> {
					System.out.println(c);
				});

		System.out.println(
				"-------------------------------------------Punto-9------------------------------------------------");

		CompraABM.getInstanciaCompraABM().traer(LocalDate.of(2017, 10, 18), LocalDate.of(2017, 10, 20),
				ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL"));

		System.out.println(
				"-------------------------------------------Punto-10------------------------------------------------");

		System.out.println(CompraABM.getInstanciaCompraABM()
				.traerCantidadVendida(ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL")));

		System.out.println(
				"-------------------------------------------Punto-11------------------------------------------------");

		System.out.println(CompraABM.getInstanciaCompraABM()
				.traerTotalVentas(ProductoABM.getInstanciaProductoABM().traer("INFINIA DIESEL")));

	}

}
