package silveira.caio.curso.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import silveira.caio.curso.entities.Usuario;
import silveira.caio.curso.services.UsuaService;

@RestController
@RequestMapping("/usuarios")
public class UsuaController {

	@Autowired
	private UsuaService serv;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(serv.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		return ResponseEntity.ok(serv.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usua){
		usua = serv.save(usua);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usua.getId()).toUri();
		return ResponseEntity.created(uri).body(usua);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usua){
		return ResponseEntity.ok(usua = serv.update(id, usua));
	}
	
	
	
	
}
