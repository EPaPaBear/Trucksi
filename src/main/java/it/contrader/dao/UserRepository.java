package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findById(Long id);

	User findByUsernameAndPassword(String username, String password);

}
