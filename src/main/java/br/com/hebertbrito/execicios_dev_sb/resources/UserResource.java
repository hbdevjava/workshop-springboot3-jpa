package br.com.hebertbrito.execicios_dev_sb.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hebertbrito.execicios_dev_sb.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "HB", "hb@gmail.com", "8599997878", "123456" );
		return ResponseEntity.ok().body(u);
	}
	
	
	
}
