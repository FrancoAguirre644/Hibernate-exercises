package datos;

import java.time.LocalDate;

public class PedidoCritico extends Pedido {

	private String motivo;
	private double porcentajeExtra;

	public PedidoCritico() {
		super();
	}

	public PedidoCritico(LocalDate fechaCreacion, Area area, boolean abierto, String motivo,
			double porcentajeExtra) {
		super(fechaCreacion, area, abierto);
		this.motivo = motivo;
		this.porcentajeExtra = porcentajeExtra;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public double getPorcentajeExtra() {
		return porcentajeExtra;
	}

	public void setPorcentajeExtra(double porcentajeExtra) {
		this.porcentajeExtra = porcentajeExtra;
	}

	@Override
	public String toString() {
		return "PedidoCritico [motivo=" + motivo + ", porcentajeExtra=" + porcentajeExtra + ", idPedido=" + idPedido
				+ ", fechaCreacion=" + fechaCreacion + ", abierto=" + abierto + "]";
	}

}
