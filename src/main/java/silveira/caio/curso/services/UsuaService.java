package silveira.caio.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import silveira.caio.curso.entities.Usuario;
import silveira.caio.curso.repositories.UsuaRepository;


@Service
public class UsuaService {

	
	@Autowired
	private UsuaRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findById(Long id) {
		return repo.findById(id).get();
	}
}
