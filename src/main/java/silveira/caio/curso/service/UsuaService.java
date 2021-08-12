package silveira.caio.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import silveira.caio.curso.model.Usuario;
import silveira.caio.curso.repository.UsuaRepository;


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
