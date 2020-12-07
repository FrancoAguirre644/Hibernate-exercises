package datos;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String email;
	private long dni;
	private Tarjeta tarjeta;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, String email, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", dni=" + dni + "]";
	}

}
