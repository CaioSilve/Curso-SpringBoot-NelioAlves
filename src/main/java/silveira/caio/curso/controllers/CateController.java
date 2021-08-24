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

import silveira.caio.curso.entities.Categoria;
import silveira.caio.curso.services.CateService;

@RestController
@RequestMapping("/categorias")
public class CateController {

	@Autowired
	private CateService serv;
	
	@GetMapping()
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok(serv.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.ok(serv.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria cate){
		cate = serv.save(cate);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cate.getId()).toUri();
		return ResponseEntity.created(uri).body(cate);
	}
	
}








