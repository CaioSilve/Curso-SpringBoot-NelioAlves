package silveira.caio.curso.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name = "codi_clie")
	private Usuario clie;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(Instant hora, PedidoStatus status, Usuario clie) {
		super();
		this.hora = hora;
		this.clie = clie;
		setStatus(status);
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
