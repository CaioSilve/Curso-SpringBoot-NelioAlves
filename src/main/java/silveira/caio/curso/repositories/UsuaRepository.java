package silveira.caio.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.entities.Usuario;

public interface UsuaRepository extends JpaRepository<Usuario, Long> {

	
	
}
