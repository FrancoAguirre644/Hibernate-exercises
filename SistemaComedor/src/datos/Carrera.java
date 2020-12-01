package datos;

import java.util.Set;

public class Carrera {

	private int idCarrera;
	private String descripcion;
	private Set<Estudiante> estudiantes;

	public Carrera() {
		super();
	}

	public Carrera(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", descripcion=" + descripcion + "]";
	}

}
