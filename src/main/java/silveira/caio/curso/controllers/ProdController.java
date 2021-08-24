package silveira.caio.curso.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import silveira.caio.curso.entities.Produto;
import silveira.caio.curso.services.ProdService;

@RestController
@RequestMapping("/produtos")
public class ProdController {

	@Autowired
	private ProdService serv;
	
	@GetMapping()
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(serv.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return ResponseEntity.ok(serv.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto prod){
		prod = serv.save(prod);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(uri).body(prod);
	}
	
}








