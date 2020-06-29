package it.contrader.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {


}
