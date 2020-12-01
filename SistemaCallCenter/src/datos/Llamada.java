package datos;

import java.time.LocalDate;

public class Llamada {

	private int idLlamada;
	private Cliente cliente;
	private Empleado empleado;
	private LocalDate fecha;
	private int nivelSatisfaccion;

	public Llamada() {
		super();
	}

	public Llamada(Cliente cliente, Empleado empleado, LocalDate fecha, int nivelSatisfaccion) {
		super();
		this.cliente = cliente;
		this.empleado = empleado;
		this.fecha = fecha;
		this.nivelSatisfaccion = nivelSatisfaccion;
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNivelSatisfaccion() {
		return nivelSatisfaccion;
	}

	public void setNivelSatisfaccion(int nivelSatisfaccion) {
		this.nivelSatisfaccion = nivelSatisfaccion;
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", cliente=" + cliente.getIdPersona() + ", empleado="
				+ empleado.getIdPersona() + ", fecha=" + fecha + ", nivelSatisfaccion=" + nivelSatisfaccion + "]";
	}

}
