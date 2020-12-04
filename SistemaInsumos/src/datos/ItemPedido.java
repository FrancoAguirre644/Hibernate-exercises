package datos;

public class ItemPedido {

	private int idItemPedido;
	private Insumo insumo;
	private int cantidad;
	private Pedido pedido;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Pedido pedido, Insumo insumo, int cantidad) {
		super();
		this.insumo = insumo;
		this.cantidad = cantidad;
		this.pedido = pedido;
	}

	public int getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", insumo=" + insumo + ", cantidad=" + cantidad + "]";
	}

}
