package datos;

import java.util.Set;

public class Empleado extends Persona {

	private int sueldoBase;
	private Set<Llamada> llamadas;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellido, long dni, int sueldoBase) {
		super(nombre, apellido, dni);
		this.sueldoBase = sueldoBase;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Set<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(Set<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	@Override
	public String toString() {
		return "Empleado [sueldoBase=" + sueldoBase + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}

}
