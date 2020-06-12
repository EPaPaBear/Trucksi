package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.UserDTO;
import it.contrader.model.Driver;
import it.contrader.model.Hystorytravel;

@Repository
@Transactional
public interface DriverRepository extends CrudRepository<Driver, Long> {

	Driver findByUser(UserDTO user);    
}
