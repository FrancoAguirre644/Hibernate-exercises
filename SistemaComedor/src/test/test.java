package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Estudiante;
import datos.TipoBeneficio;
import negocio.BeneficioABM;
import negocio.CarreraABM;
import negocio.EstudianteABM;
import negocio.TipoBeneficioABM;

public class test {

	public static void main(String[] args) {

		CarreraABM carreraABM = CarreraABM.getInstanciaCarreraABM();
		EstudianteABM estudianteABM = EstudianteABM.getInstanciaEstudianteABM();
		TipoBeneficioABM tipoBeneficioABM = TipoBeneficioABM.getInstanciaTipoBeneficioABM();
		BeneficioABM beneficioABM = BeneficioABM.getInstanciaBeneficioABM();

		System.out.println(
				"-------------------------------------------Punto-1------------------------------------------------");

		System.out.println(carreraABM.agregar("Lic. en alimentos"));
		System.out.println(carreraABM.agregar("Lic. en Sistemas"));

		System.out.println(
				"-------------------------------------------Punto-2------------------------------------------------");

		System.out.println(
				estudianteABM.agregar(403215487, "Pablo", "Perez", CarreraABM.getInstanciaCarreraABM().traer(1)));

		System.out.println(
				estudianteABM.agregar(37654812, "Laura", "Diaz", CarreraABM.getInstanciaCarreraABM().traer(1)));

		System.out.println(
				estudianteABM.agregar(34587624, "Daiana", "Guisepe", CarreraABM.getInstanciaCarreraABM().traer(2)));

		System.out
				.println(estudianteABM.agregar(42654875, "Juan", "Cuda", CarreraABM.getInstanciaCarreraABM().traer(2)));

		System.out.println(
				"-------------------------------------------Punto-3------------------------------------------------");

		Estudiante estudiante = estudianteABM.traer(34587624);

		estudiante.setEsRegular(false);

		estudianteABM.actualizar(estudiante);

		System.out.println(estudianteABM.traer(34587624));

		System.out.println(
				"-------------------------------------------Punto-4------------------------------------------------");

		System.out.println(tipoBeneficioABM.agregar("Desayuno", LocalTime.of(8, 30), LocalTime.of(11, 40), 200));

		System.out.println(tipoBeneficioABM.agregar("Almuerzo", LocalTime.of(11, 45), LocalTime.of(13, 15), 150));

		System.out.println(tipoBeneficioABM.agregar("Merienda", LocalTime.of(16, 00), LocalTime.of(18, 30), 300));

		System.out.println(
				"-------------------------------------------Punto-5------------------------------------------------");

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(3), estudianteABM.traer(42654875),
					LocalDate.of(2018, 5, 14)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(1), estudianteABM.traer(403215487),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(1), estudianteABM.traer(37654812),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(2), estudianteABM.traer(403215487),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(3), estudianteABM.traer(42654875),
					LocalDate.of(2018, 6, 1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-6------------------------------------------------");

		beneficioABM.traer(estudianteABM.traer(403215487), LocalDate.of(2018, 5, 16)).stream().forEach((b) -> {
			System.out.println(b);
		});

		System.out.println(
				"-------------------------------------------Punto-7------------------------------------------------");

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(3), estudianteABM.traer(34587624),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) { // TODO Auto-generated
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-8------------------------------------------------");

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(3), estudianteABM.traer(403215487),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-9------------------------------------------------");

		TipoBeneficio desayuno = tipoBeneficioABM.traer(1);

		desayuno.setMaxDiario(2);

		tipoBeneficioABM.actualizar(desayuno);

		try {
			System.out.println(beneficioABM.agregar(tipoBeneficioABM.traer(1), estudianteABM.traer(42654875),
					LocalDate.of(2018, 5, 16)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------Punto-10-----------------------------------------------");

		beneficioABM.traer(TipoBeneficioABM.getInstanciaTipoBeneficioABM().traer(3), LocalDate.of(2018, 6, 1)).stream()
				.forEach((b) -> {
					System.out.println(b);
				});

		System.out.println(
				"-------------------------------------------Punto-11-----------------------------------------------");

		beneficioABM.traer(LocalDate.of(2018, 5, 15), LocalDate.of(2018, 5, 30)).stream().forEach((b) -> {
			System.out.println(b);
		});

	}

}
