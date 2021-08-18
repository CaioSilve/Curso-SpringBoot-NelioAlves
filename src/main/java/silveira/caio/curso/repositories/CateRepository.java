package silveira.caio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.entities.Categoria;

public interface CateRepository extends JpaRepository<Categoria, Long> {

	
}
