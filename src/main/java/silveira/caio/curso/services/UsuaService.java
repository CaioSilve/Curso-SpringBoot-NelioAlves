package silveira.caio.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import silveira.caio.curso.entities.Usuario;
import silveira.caio.curso.repositories.UsuaRepository;
import silveira.caio.curso.services.exceptions.DatabaseException;
import silveira.caio.curso.services.exceptions.EntitieNotFound;


@Service
public class UsuaService {

	
	@Autowired
	private UsuaRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new EntitieNotFound(id));
	}
	
	public Usuario save(Usuario usua) {
		return repo.save(usua);
	}
	
	public void delete(Long id) {
		try {
			repo.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntitieNotFound(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
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
