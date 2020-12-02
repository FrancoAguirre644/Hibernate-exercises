package test;

import java.time.LocalDate;

import negocio.BeneficioABM;
import negocio.CarreraABM;
import negocio.EstudianteABM;
import negocio.TipoBeneficioABM;

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

		/*
		 * System.out.println(TipoBeneficioABM.getInstanciaTipoBeneficioABM().agregar(
		 * "Desayuno", LocalTime.of(8, 30), LocalTime.of(11, 40), 200));
		 * 
		 * System.out.println(TipoBeneficioABM.getInstanciaTipoBeneficioABM().agregar(
		 * "Almuerzo", LocalTime.of(11, 45), LocalTime.of(13, 15), 150));
		 */

		System.out.println();

		System.out.println(TipoBeneficioABM.getInstanciaTipoBeneficioABM().traer(1));
		System.out.println(TipoBeneficioABM.getInstanciaTipoBeneficioABM().traer(2));

		System.out.println();

		System.out.println(
				BeneficioABM.getInstanciaCarreraABM().agregar(TipoBeneficioABM.getInstanciaTipoBeneficioABM().traer(1),
						EstudianteABM.getInstanciaEstudianteABM().traer(403215487), LocalDate.of(2018, 5, 16)));
		
		System.out.println();
		
		BeneficioABM.getInstanciaCarreraABM().traer().stream().forEach((b) -> {
			System.out.println(b);
		});

	}

}
