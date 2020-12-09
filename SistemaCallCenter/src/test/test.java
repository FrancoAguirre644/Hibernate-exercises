package test;

import java.time.LocalDate;

import dao.PersonaDao;
import datos.Cliente;
import datos.Empleado;
import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.LlamadaABM;
import negocio.PersonaABM;

public class test {

	public static void main(String[] args) {

		EmpleadoABM empleadoABM = EmpleadoABM.getInstanciaEmpleadoABM();
		ClienteABM clienteABM = ClienteABM.getInstanciaClienteABM();
		LlamadaABM llamadaABM = LlamadaABM.getInstanciaLlamadaABM();

		System.out.println(
				"-------------------------------------------Punto-1------------------------------------------------");

		try {
			empleadoABM.agregar("Lopez", "Luis", 33333333, 10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			empleadoABM.agregar("Gomes", "Lucas", 44444444, 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clienteABM.agregar("Perez", "Pedro", 11111111);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clienteABM.agregar("Pereyra", "Pablo", 22222222);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PersonaDao.getInstanciaPersonaDao().traer().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-2------------------------------------------------");

		System.out.println(PersonaABM.getInstanciaPersonaABM().traer(11111111));

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-3------------------------------------------------");

		System.out.println(PersonaABM.getInstanciaPersonaABM().traer(33333333));

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-4------------------------------------------------");

		try {
			clienteABM.agregar("Rios", "Marcos", 22222222);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-5------------------------------------------------");

		try {
			empleadoABM.agregar("Martinez", "Miguel", 44444444, 9500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-6------------------------------------------------");

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 1), 5,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 1), 5,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(44444444));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 1), 5,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(22222222),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 2), 4,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 2), 3,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 2), 2,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 3), 5,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LlamadaABM.getInstanciaLlamadaABM().traer().stream().forEach((l) -> {
			System.out.println(l);
		});

		System.out.println(
				"-------------------------------------------Punto-7------------------------------------------------");

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 1), 6,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-8------------------------------------------------");

		clienteABM.traer().stream().forEach((c) -> {
			System.out.println(c);
		});
		
		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-9------------------------------------------------");

		empleadoABM.traer().stream().forEach((e) -> {
			System.out.println(e);
		});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-10-----------------------------------------------");

		LlamadaABM.getInstanciaLlamadaABM().traer(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3)).stream()
				.forEach((l) -> {
					System.out.println(l);
				});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-11-----------------------------------------------");

		LlamadaABM.getInstanciaLlamadaABM().traer(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3), 5).stream()
				.forEach((l) -> {
					System.out.println(l);
				});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-12-----------------------------------------------");

		LlamadaABM.getInstanciaLlamadaABM().traer(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3),
				(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333)).stream().forEach((l) -> {
					System.out.println(l);
				});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-13-----------------------------------------------");

		LlamadaABM.getInstanciaLlamadaABM().traer(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3), 5,
				(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333)).stream().forEach((l) -> {
					System.out.println(l);
				});

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-14-----------------------------------------------");

		System.out.println(LlamadaABM.getInstanciaLlamadaABM()
				.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 3), 5));

		System.out.println();

		System.out.println(
				"-------------------------------------------Punto-15-----------------------------------------------");

		System.out.println(
				LlamadaABM.getInstanciaLlamadaABM().calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2019, 12, 1),
						LocalDate.of(2019, 12, 3), 5, (Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333)));

	}

}
