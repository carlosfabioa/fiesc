package exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();

	        ex.getBindingResult().getAllErrors().forEach(error -> {
	            String campo = ((FieldError) error).getField();
	            String mensagem = error.getDefaultMessage();
	            errors.put(campo, mensagem);
	        });

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }

	    @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<Map<String, String>> handleEntityNotFound(EntityNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(Map.of("erro", ex.getMessage()));
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, String>> handleOtherErrors(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Map.of("erro", "Erro inesperado: " + ex.getMessage()));
	    }
}
