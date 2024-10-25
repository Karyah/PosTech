package br.com.fiap.reserva_salas.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	private StandardError err = new StandardError();
	
	@ExceptionHandler(ControllerNotFoundException.class)
	public ResponseEntity<StandardError> EntityNotFoundException(ControllerNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Entity not Found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(this.err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> ValidationError(MethodArgumentNotValidException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError validationError = new ValidationError();
		validationError.setMessage(e.getMessage());
		validationError.setError("Erro de validação");
		validationError.setStatus(status.value());
		validationError.setPath(request.getRequestURI());
		validationError.setTimestamp(Instant.now());
		
		for(FieldError f: e.getBindingResult().getFieldErrors()) {
			validationError.addMensagens(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(validationError);
		
	}
}
