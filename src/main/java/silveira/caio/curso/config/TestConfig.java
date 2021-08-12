package silveira.caio.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import silveira.caio.curso.model.Usuario;
import silveira.caio.curso.repository.UsuaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuaRepository repo;

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("Caio", "caio@gmail.com", "19 99632562", "123");
		Usuario u2 = new Usuario("Patrícia", "path@gmail.com", "16 2548577", "145");
		
		repo.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	
}
