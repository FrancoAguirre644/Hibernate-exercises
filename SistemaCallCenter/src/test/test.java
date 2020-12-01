package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Empleado;
import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.LlamadaABM;
import negocio.PersonaABM;

public class test {

	public static void main(String[] args) {/*

		PersonaABM personaABM = PersonaABM.getInstanciaPersonaDao();
		ClienteABM clienteABM = ClienteABM.getInstanciaClienteABM();
		EmpleadoABM empleadoABM = EmpleadoABM.getInstanciaEmpleadoABM();
		LlamadaABM llamadaABM = LlamadaABM.getInstanciaLlamadaABM();

		personaABM.traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(personaABM.traer(11111111));

		try {
			clienteABM.agregar("Franco", "Aguirre", 11111112);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

		try {
			empleadoABM.agregar("Martin", "Garcia", 33333332, 4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

		llamadaABM.traer().stream().forEach((l) -> {
			System.out.println(l);
		});

		System.out.println();

		try {
			System.out.println(LlamadaABM.getInstanciaLlamadaABM().agregar((Cliente) personaABM.traer(11111112),
					(Empleado) personaABM.traer(33333332), LocalDate.now(), 8));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

		clienteABM.traer().stream().forEach((c) -> {
			System.out.println(c);
		});

		System.out.println();

		empleadoABM.traer().stream().forEach((e) -> {
			System.out.println(e);
		});
		*/		
		

	}

}
