package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.UserDTO;
import it.contrader.model.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

	Driver findByUser(UserDTO user);    
}
