package silveira.caio.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import silveira.caio.curso.entities.enums.PedidoStatus;

@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant hora;
	private Integer status;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> items = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "codi_clie")
	private Usuario clie;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(Instant hora, PedidoStatus status, Usuario clie) {
		super();
		this.hora = hora;
		this.clie = clie;
		setStatus(status);
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(ItemPedido i : items) {
			total += i.getSubTotal();
		}
		return total;
	}
	
	
	public Long getId() {
		return id;
	}

	public Instant getHora() {
		return hora;
	}

	public void setHora(Instant hora) {
		this.hora = hora;
	}

	public PedidoStatus getStatus() {
		return PedidoStatus.valueOf(status);
	}

	public void setStatus(PedidoStatus status) {
		if(status != null)
			this.status = status.getIndice();
	}

	public Usuario getClie() {
		return clie;
	}

	public void setClie(Usuario clie) {
		this.clie = clie;
	}
	
	public Set<ItemPedido> getItems(){
		return items;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
