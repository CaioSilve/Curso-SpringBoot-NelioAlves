package silveira.caio.curso.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import silveira.caio.curso.entities.Pedido;
import silveira.caio.curso.entities.Usuario;
import silveira.caio.curso.entities.enums.PedidoStatus;
import silveira.caio.curso.repositories.PedidoRepository;
import silveira.caio.curso.repositories.UsuaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuaRepository usuaRepo;

	@Autowired
	private PedidoRepository pediRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("Caio", "caio@gmail.com", "19 99632562", "123");
		Usuario u2 = new Usuario("Patrícia", "path@gmail.com", "16 2548577", "145");
		
		usuaRepo.saveAll(Arrays.asList(u1, u2));
		
		Pedido o1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
		Pedido o2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2); 
		Pedido o3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1); 
		
		pediRepo.saveAll(Arrays.asList(o1, o2, o3));

		
	}
	
	
	
}
