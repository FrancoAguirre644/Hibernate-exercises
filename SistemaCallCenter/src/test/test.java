package test;

import java.time.LocalDate;

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

		for (Cliente c : clienteABM.traer()) {
			System.out.println(c);
		}

		System.out.println();

		for (Empleado e : empleadoABM.traer()) {
			System.out.println(e);
		}

		System.out.println();

		System.out.println(PersonaABM.getInstanciaPersonaABM().traer(11111111));

		System.out.println();

		System.out.println(PersonaABM.getInstanciaPersonaABM().traer(33333333));

		try {
			clienteABM.agregar("Rios", "Marcos", 22222222);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			empleadoABM.agregar("Martinez", "Miguel", 44444444, 9500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		try {
			llamadaABM.agregar(LocalDate.of(2019, 12, 1), 6,
					(Cliente) PersonaABM.getInstanciaPersonaABM().traer(11111111),
					(Empleado) PersonaABM.getInstanciaPersonaABM().traer(33333333));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
