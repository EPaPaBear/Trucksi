package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;


/**
 * Estende CrudRepository ed eredita tutti i metodi di CRUD. 
 * Definisce il metodo di login.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 *
 * @see CrudRepository
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
	User findByUsernameAndPassword(String username, String password);
	
}
