package silveira.caio.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
