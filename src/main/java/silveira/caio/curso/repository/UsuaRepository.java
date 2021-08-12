package silveira.caio.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import silveira.caio.curso.model.Usuario;

public interface UsuaRepository extends JpaRepository<Usuario, Long> {

	
	
}
