package it.contrader.dao;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Travel;
@Repository
@Transactional
public interface TravelRepository extends CrudRepository<Travel, Long > {
	
	Optional<Travel> findById(Long id);

}
