package br.com.hebertbrito.execicios_dev_sb.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.hebertbrito.execicios_dev_sb.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * A anotação @ControllerAdvice é uma especialização da anotação @Component d
 * Spring Framework que permite manipular exceções em todo o aplicativo em um
 * componente global. Você pode usar essa anotação para lidar com exceções
 * lançadas em qualquer lugar da sua aplicação, não só pelo controller. É como
 * se fosse uma barreira que intercepta todas as exceções que acontecem dentro
 * de um método/classe anotado com @RequestMapping e permite que você faça algum
 * tratamento antes ou depois da exceção ser lançada .
 */
@ControllerAdvice
public class ResourceExceptionsHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
