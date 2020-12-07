package datos;

public class Producto {

	private int idProducto;
	private String nombre;
	private double precio;
	private String unidadMedida;
	private double pesosPorKms;

	public Producto() {
		super();
	}

	public Producto(int idProducto, String nombre, double precio, String unidadMedida, double pesosPorKms) {
		super();
		this.idProducto = idProducto;
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

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", unidadMedida="
				+ unidadMedida + ", pesosPorKms=" + pesosPorKms + "]";
	}

}
