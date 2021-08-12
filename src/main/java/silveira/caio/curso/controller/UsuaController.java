package silveira.caio.curso.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import silveira.caio.curso.model.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuaController {

	@GetMapping("/lista")
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario("Caio", "caio@gmail.com", "16992941653", "123");
		return ResponseEntity.ok(u);
	}
	
}
