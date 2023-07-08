package br.com.hebertbrito.execicios_dev_sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hebertbrito.execicios_dev_sb.entities.User;
import br.com.hebertbrito.execicios_dev_sb.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
