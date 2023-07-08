package br.com.hebertbrito.execicios_dev_sb.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.hebertbrito.execicios_dev_sb.entities.User;
import br.com.hebertbrito.execicios_dev_sb.repositories.UserRepository;

@Configuration // -> ANOTAÇAO PARA CLASSE ESPECIFICA DE CONFIGURAÇÃO;
@Profile("test") // -> ANOTAÇÃO DE CONFIGURAÇÃO ESPECIFICA PARA O PERFIL DE TESTE;
public class TestConfig implements CommandLineRunner {
	/*
	 * CLASSE DE CONFIGURAÇÃO ESPECIFICA PARA O PERFIL DE TESTE ESSA CLASSE É UMA
	 * CLASSE AUXILIAR (NAO É CONTROLLER, SERVICE NEM REPOSITORY) QUE VAI FAZER
	 * ALGUMAS CONFIGURAÇÕES NA APLICAÇÃO,
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));//-> RECEBE QUALQUE OBJ QUE SEJA ITERAVEL (AQUI NO CADO UM ARRAY)
		
		
	}

}
