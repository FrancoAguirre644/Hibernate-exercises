package datos;

public class Estudiante {

	private int legajo;
	private int dni;
	private String nombre;
	private String apellido;
	private Carrera carrera;
	private boolean esRegular;

	public Estudiante() {
		super();
	}

	public Estudiante(int dni, String nombre, String apellido, Carrera carrera) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carrera = carrera;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public boolean getEsRegular() {
		return esRegular;
	}

	public void setEsRegular(boolean esRegular) {
		this.esRegular = esRegular;
	}

	@Override
	public String toString() {
		return "Estudiante [legajo=" + legajo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", carrera=" + carrera.getIdCarrera() + ", esRegular=" + esRegular + "]";
	}

}
