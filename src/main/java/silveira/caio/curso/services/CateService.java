package silveira.caio.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.curso.entities.Categoria;
import silveira.caio.curso.repositories.CateRepository;


@Service
public class CateService {

	
	@Autowired
	private CateRepository repo;
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Categoria findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Categoria save(Categoria cate) {
		return repo.save(cate);
	}
}
