package silveira.caio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
