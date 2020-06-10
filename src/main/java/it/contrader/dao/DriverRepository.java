package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Driver;

@Repository
@Transactional
public interface DriverRepository extends CrudRepository<Driver, Long> {

	//User findByUsernameAndPassword(String username, String password);

}
