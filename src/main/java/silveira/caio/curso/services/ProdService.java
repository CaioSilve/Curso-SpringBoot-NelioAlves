package silveira.caio.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.curso.entities.Produto;
import silveira.caio.curso.repositories.ProdRepository;


@Service
public class ProdService {

	
	@Autowired
	private ProdRepository repo;
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	public Produto findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Produto save(Produto Prod) {
		return repo.save(Prod);
	}
}
