package silveira.caio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.entities.Produto;

public interface ProdRepository extends JpaRepository<Produto, Long> {

	
}
