package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Truck;

@Repository
@Transactional
public interface TravelRepository extends CrudRepository<Truck, Long> {

	//Truck findByUsernameAndPassword(String username, String password);

}
