package datos;

import java.util.Set;

public class Cliente extends Persona {

	private boolean activo;
	private Set<Llamada> llamadas;

	public Cliente() {
		super();
	}

	public Cliente(String nombre, String apellido, long dni) {
		super(nombre, apellido, dni);
		this.activo = true;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(Set<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

	@Override
	public String toString() {
		return "Cliente [activo=" + activo + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}

}
