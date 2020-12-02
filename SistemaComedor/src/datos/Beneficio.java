package datos;

import java.time.LocalDate;

public class Beneficio {

	private int idBeneficio;
	private TipoBeneficio tipoBeneficio;
	private Estudiante estudiante;
	private LocalDate fecha;

	public Beneficio() {
		super();
	}

	public Beneficio(TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha) {
		super();
		this.tipoBeneficio = tipoBeneficio;
		this.estudiante = estudiante;
		this.fecha = fecha;
	}

	public int getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public TipoBeneficio getTipoBeneficio() {
		return tipoBeneficio;
	}

	public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Beneficio [idBeneficio=" + idBeneficio + ", tipoBeneficio=" + tipoBeneficio.getIdTipoBeneficio()
				+ ", estudiante=" + estudiante.getLegajo() + ", fecha=" + fecha + "]";
	}

}
