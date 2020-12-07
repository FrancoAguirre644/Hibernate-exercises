package test;

import dao.ClienteDao;

public class test {

	public static void main(String[] args) {

		ClienteDao.getInstanciaClienteDao().traer().stream().forEach((c) -> {
			System.out.println(c);
		});

	}

}
