package datos;

public class Tarjeta {

	private int idTarjeta;
	private int kilometros;
	private Cliente cliente;

	public Tarjeta() {
		super();
	}

	public Tarjeta(Cliente cliente) {
		super();
		this.kilometros = 0;
		this.cliente = cliente;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", kilometros=" + kilometros + ", cliente=" + cliente + "]";
	}

}
