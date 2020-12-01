package test;

import negocio.CarreraABM;

public class test {

	public static void main(String[] args) {
		
		System.out.println(CarreraABM.getInstanciaCarreraABM().agregar("Lic. en alimentos"));
		
		System.out.println();
		
		System.out.println(CarreraABM.getInstanciaCarreraABM().traer(1));
		
		System.out.println();

		CarreraABM.getInstanciaCarreraABM().traer().stream().forEach((c)->{
			System.out.println(c);
		});
		
	}

}
