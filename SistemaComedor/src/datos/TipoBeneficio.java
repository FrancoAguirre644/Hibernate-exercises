package datos;

import java.time.LocalTime;
import java.util.Set;

public class TipoBeneficio {

	private int idTipoBeneficio;
	private String descripcion;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int maxDiario;
	private Set<Beneficio> beneficios;

	public TipoBeneficio() {
		super();
	}

	public TipoBeneficio(String descripcion, LocalTime horaDesde, LocalTime horaHasta, int maxDiario) {
		super();
		this.descripcion = descripcion;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.maxDiario = maxDiario;
	}

	public int getIdTipoBeneficio() {
		return idTipoBeneficio;
	}

	public void setIdTipoBeneficio(int idTipoBeneficio) {
		this.idTipoBeneficio = idTipoBeneficio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public int getMaxDiario() {
		return maxDiario;
	}

	public void setMaxDiario(int maxDiario) {
		this.maxDiario = maxDiario;
	}

	public Set<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Set<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	@Override
	public String toString() {
		return "TipoBeneficio [idTipoBeneficio=" + idTipoBeneficio + ", descripcion=" + descripcion + ", horaDesde="
				+ horaDesde + ", horaHasta=" + horaHasta + ", maxDiario=" + maxDiario + "]";
	}

}
