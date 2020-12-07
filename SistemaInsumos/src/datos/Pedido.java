package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	protected int idPedido;
	protected LocalDate fechaCreacion;
	protected Area area;
	protected boolean abierto;
	protected Set<ItemPedido> itemPedidos;

	public Pedido() {
		super();
	}

	public Pedido(LocalDate fechaCreacion, Area area) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.area = area;
		this.abierto = true;
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

	public Set<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(Set<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public double calcularTotal() {

		double total = 0;

		for (ItemPedido i : itemPedidos) {
			total += i.calcularSubTotal();
		}

		return total;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaCreacion=" + fechaCreacion + ", area=" + area.getIdArea()
				+ ", abierto=" + abierto + ", itemPedidos=" + itemPedidos + "]";
	}

}
