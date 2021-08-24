package silveira.caio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.entities.ItemPedido;
import silveira.caio.curso.entities.pks.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

	
}
