package silveira.caio.curso.services.exceptions;

public class EntitieNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public EntitieNotFound(Object id) {
		super("Entidade não encontrada. ID: " + id);
	}

}
