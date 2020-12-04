package test;

import negocio.AreaABM;

public class test {

	public static void main(String[] args) {

		System.out.println(AreaABM.getInstanciaAreaABM().agregar("Sistemas"));

		AreaABM.getInstanciaAreaABM().traer().stream().forEach((a) -> {
			System.out.println(a);
		});

	}

}
