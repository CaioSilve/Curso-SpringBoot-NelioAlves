package silveira.caio.curso.services.exceptions;

public class EntityNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public EntityNotFound(Object id) {
		super("Entidade não encontrada. ID: " + id);
	}

}
