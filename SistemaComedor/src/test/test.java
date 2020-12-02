package test;

import negocio.CarreraABM;
import negocio.EstudianteABM;

public class test {

	public static void main(String[] args) {

		// System.out.println(CarreraABM.getInstanciaCarreraABM().agregar("Lic. en
		// alimentos"));

		System.out.println();

		System.out.println(CarreraABM.getInstanciaCarreraABM().traer(1));

		System.out.println();

		CarreraABM.getInstanciaCarreraABM().traer().stream().forEach((c) -> {
			System.out.println(c);
		});

		System.out.println();

//		System.out.println(EstudianteABM.getInstanciaEstudianteABM().agregar(403215487, "Pablo", "Perez",
//				CarreraABM.getInstanciaCarreraABM().traer(1)));

		EstudianteABM.getInstanciaEstudianteABM().traer().stream().forEach((e) -> {
			System.out.println(e);
		});

		EstudianteABM.getInstanciaEstudianteABM().traer(true).stream().forEach((e) -> {
			System.out.println(e);
		});

	}

}
