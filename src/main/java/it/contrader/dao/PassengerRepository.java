package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Passenger;

@Repository
@Transactional
public interface PassengerRepository extends CrudRepository<Passenger, Long> {

	//User findByUsernameAndPassword(String username, String password); 

}
