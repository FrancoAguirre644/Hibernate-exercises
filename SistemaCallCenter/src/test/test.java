package test;

import negocio.ClienteABM;
import negocio.EmpleadoABM;
import negocio.PersonaABM;

public class test {

	public static void main(String[] args) {

		PersonaABM.getInstanciaPersonaDao().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

		System.out.println();

		System.out.println(PersonaABM.getInstanciaPersonaDao().traer(11111111));

		try {
			ClienteABM.getInstanciaClienteABM().agregar("Franco", "Aguirre", 11111112);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

		try {
			EmpleadoABM.getInstanciaEmpleadoABM().agregar("Martin", "Garcia", 33333332, 4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
