package silveira.caio.curso.entities.enums;

public enum PedidoStatus {
	
	PAGO(1),
	ENTREGUE(2),
	ENVIADO(3),
	CANCELADO(4),
	AGUARDANDO_PAGAMENTO(5);
	
	private int id;
	
	private PedidoStatus(int id){
		this.id = id;
	}
	
	public int getIndice() {
		return id;
	}
	
	public static PedidoStatus valueOf(int id) {
		for(PedidoStatus valor: PedidoStatus.values()) {
			if(id == valor.getIndice()) return valor;
		}
		throw new IllegalArgumentException("Indice inválido do Status do Pedido");
	}
	
	
}
