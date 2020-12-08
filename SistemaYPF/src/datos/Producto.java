package datos;

import java.util.Set;

public class Producto {

	private int idProducto;
	private String nombre;
	private double precio;
	private String unidadMedida;
	private double pesosPorKms;
	private Set<Compra> compras;

	public Producto() {
		super();
	}

	public Producto(String nombre, double precio, String unidadMedida, double pesosPorKms) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.unidadMedida = unidadMedida;
		this.pesosPorKms = pesosPorKms;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public double getPesosPorKms() {
		return pesosPorKms;
	}

	public void setPesosPorKms(double pesosPorKms) {
		this.pesosPorKms = pesosPorKms;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", unidadMedida="
				+ unidadMedida + ", pesosPorKms=" + pesosPorKms + "]";
	}

}
