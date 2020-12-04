package datos;

import java.time.LocalDate;

public class PedidoMensual extends Pedido {

	private LocalDate fechaEntrega;

	public PedidoMensual() {
		super();
	}

	public PedidoMensual(LocalDate fechaCreacion, Area area, boolean abierto, LocalDate fechaEntrega) {
		super(fechaCreacion, area, abierto);
		this.fechaEntrega = fechaEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "PedidoMensual [fechaEntrega=" + fechaEntrega + ", idPedido=" + idPedido + ", fechaCreacion="
				+ fechaCreacion + ", abierto=" + abierto + "]";
	}

}
