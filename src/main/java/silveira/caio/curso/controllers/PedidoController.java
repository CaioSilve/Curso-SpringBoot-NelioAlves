package silveira.caio.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.curso.entities.Pedido;
import silveira.caio.curso.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService serv;
	
	@GetMapping()
	public ResponseEntity<List<Pedido>> findAll(){
		return ResponseEntity.ok(serv.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		return ResponseEntity.ok(serv.findById(id));
	}
	
}
