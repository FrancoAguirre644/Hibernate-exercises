package test;

import dao.PedidoDao;
import negocio.AreaABM;
import negocio.InsumoABM;

public class test {

	public static void main(String[] args) {

		// System.out.println(AreaABM.getInstanciaAreaABM().agregar("Sistemas"));
		
		System.out.println(AreaABM.getInstanciaAreaABM().traer("Sistemas"));
		
		try {
			System.out.println(InsumoABM.getInstanciaInsumoABM().agregar("cuaderno", 20));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			AreaABM.getInstanciaAreaABM().agregar("Sistemas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AreaABM.getInstanciaAreaABM().traer().stream().forEach((a) -> {
			System.out.println(a);
		});

		InsumoABM.getInstanciaInsumoABM().traer().stream().forEach((i) -> {
			System.out.println(i);
		});

		PedidoDao.getInstanciaPedidoDao().traer().stream().forEach((p) -> {
			System.out.println(p);
		});

	}

}
