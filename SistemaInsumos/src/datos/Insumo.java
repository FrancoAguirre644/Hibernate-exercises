package datos;

import java.util.Set;

public class Insumo {

	private int idInsumo;
	private String nombre;
	private double precioUnitario;
	private Set<ItemPedido> items;

	public Insumo() {
		super();
	}

	public Insumo(String nombre, double precioUnitario) {
		super();
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
	}

	public int getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Insumo [idInsumo=" + idInsumo + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + "]";
	}

}
