package silveira.caio.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Usuario save(Usuario usua) {
		return repo.save(usua);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario usua) {
		Usuario ent = repo.getById(id);
		updateData(ent, usua);
		return repo.save(ent);
	}

	private void updateData(Usuario ent, Usuario usua) {
		ent.setEmail(usua.getEmail());
		ent.setFone(usua.getFone());
		ent.setNome(usua.getNome());
	}
	
	
	
	
	
	
}
