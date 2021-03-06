package datos;

import java.time.LocalDate;
import java.util.Set;

public class Area {

	private int idArea;
	private String nombre;
	private Set<Pedido> pedidos;

	public Area() {
		super();
	}

	public Area(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public double calcularPresupuesto(LocalDate desde, LocalDate hasta) {
		double presupuesto = 0;

		for (Pedido p : this.pedidos) {

			if (p.getFechaCreacion().isAfter(desde) && p.getFechaCreacion().isBefore(hasta))
				presupuesto += p.calcularTotal();

		}

		return presupuesto;
	}

	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", nombre=" + nombre + "]";
	}

}
