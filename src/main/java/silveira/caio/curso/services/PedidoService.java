package silveira.caio.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silveira.caio.curso.entities.Pedido;
import silveira.caio.curso.repositories.PedidoRepository;


@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository repo;
	
	public List<Pedido> findAll(){
		return repo.findAll();
	}
	
	public Pedido findById(Long id) {
		return repo.findById(id).get();
	}
}
