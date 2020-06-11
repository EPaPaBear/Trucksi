package it.contrader.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.City;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<City, Long> {
	
	Optional<City> findById(Long id);

}
