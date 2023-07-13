package br.com.hebertbrito.execicios_dev_sb.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { //CONSTRUTOR COM ARGUMENTO
		super("Resource NotFound. Id " + id );
	}
	
	

}
