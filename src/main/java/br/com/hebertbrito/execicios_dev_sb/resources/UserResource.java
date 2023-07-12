package br.com.hebertbrito.execicios_dev_sb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hebertbrito.execicios_dev_sb.entities.User;
import br.com.hebertbrito.execicios_dev_sb.service.UserService;

/**
 * A anotação @RequestBody é usada para vincular o corpo da solicitação HTTP a
 * um objeto em seu controlador. Isso significa que o Spring irá desserializar
 * automaticamente o corpo da solicitação HTTP em um objeto Java. O objeto é
 * passado como um parâmetro do método do controlador.
 * 
 * A anotação @PathVariable é usada para vincular uma variável de modelo de URI
 * a um parâmetro de método em seu controlador . Isso significa que o Spring irá
 * extrair o valor da variável de modelo de URI e passá-lo como um parâmetro do
 * método do controlador.
 *
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> upDate(@PathVariable Long id, @RequestBody User obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
