package datos;

import java.time.LocalDate;

public class Pedido {

	protected int idPedido;
	protected LocalDate fechaCreacion;
	protected Area area;
	protected boolean abierto;

	public Pedido() {
		super();
	}

	public Pedido(LocalDate fechaCreacion, Area area, boolean abierto) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.area = area;
		this.abierto = abierto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaCreacion=" + fechaCreacion + ", area=" + area + ", abierto="
				+ abierto + "]";
	}

}
