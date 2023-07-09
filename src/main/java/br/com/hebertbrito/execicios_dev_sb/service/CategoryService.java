package br.com.hebertbrito.execicios_dev_sb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.hebertbrito.execicios_dev_sb.entities.Category;
import br.com.hebertbrito.execicios_dev_sb.repositories.CategoryRepository;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}

//CLASSE REFATORADA (ERRO NO COMMIT)
