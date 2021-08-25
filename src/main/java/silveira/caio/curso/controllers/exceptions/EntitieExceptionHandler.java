package silveira.caio.curso.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import silveira.caio.curso.services.exceptions.DatabaseException;
import silveira.caio.curso.services.exceptions.EntitieNotFound;

@ControllerAdvice
public class EntitieExceptionHandler {

	@ExceptionHandler(EntitieNotFound.class)
	public ResponseEntity<StandartError> entitieNotFound(EntitieNotFound e, HttpServletRequest request){
		String error = "Entidade não encontrada";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandartError> database(DatabaseException e, HttpServletRequest request){
		String error = "Erro banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
