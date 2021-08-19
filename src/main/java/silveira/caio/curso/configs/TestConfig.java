package silveira.caio.curso.configs;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import silveira.caio.curso.entities.Categoria;
import silveira.caio.curso.entities.ItemPedido;
import silveira.caio.curso.entities.Pedido;
import silveira.caio.curso.entities.Produto;
import silveira.caio.curso.entities.Usuario;
import silveira.caio.curso.entities.enums.PedidoStatus;
import silveira.caio.curso.repositories.CateRepository;
import silveira.caio.curso.repositories.ItemPedidoRepository;
import silveira.caio.curso.repositories.PedidoRepository;
import silveira.caio.curso.repositories.ProdRepository;
import silveira.caio.curso.repositories.UsuaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuaRepository usuaRepo;

	@Autowired
	private PedidoRepository pediRepo;
	
	@Autowired
	private CateRepository cateRepo;
	
	@Autowired
	private ProdRepository prodRepo;
	
	@Autowired
	private ItemPedidoRepository itemPediRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario("Caio", "caio@gmail.com", "19 99632562", "123");
		Usuario u2 = new Usuario("Patrícia", "path@gmail.com", "16 2548577", "145");
		
		usuaRepo.saveAll(Arrays.asList(u1, u2));
		
		Pedido o1 = new Pedido(Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1); 
		Pedido o2 = new Pedido(Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2); 
		Pedido o3 = new Pedido(Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1); 
		
		pediRepo.saveAll(Arrays.asList(o1, o2, o3));
		
		Categoria cat1 = new Categoria("Eletrônicos"); 
		Categoria cat2 = new Categoria("Livros"); 
		Categoria cat3 = new Categoria("Computadores"); 
		
		cateRepo.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Produto p1 = new Produto("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Produto p2 = new Produto("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Produto p3 = new Produto("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Produto p4 = new Produto("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Produto p5 = new Produto("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		prodRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		prodRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		ItemPedido ip1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(o1, p3, 1, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(o2, p3, 2, p3.getPreco());
		ItemPedido ip4 = new ItemPedido(o3, p5, 2, p5.getPreco());
		
		itemPediRepo.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));
		

		
	}
	
	
	
}
