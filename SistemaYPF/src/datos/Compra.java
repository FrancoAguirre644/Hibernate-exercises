package datos;

import java.time.LocalDate;

public class Compra {

	private int idCompra;
	private LocalDate fecha;
	private Producto producto;
	private double cantidad;

	public Compra() {
		super();
	}

	public Compra(LocalDate fecha, Producto producto, double cantidad) {
		super();
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}

}
