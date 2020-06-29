package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Driver;
import it.contrader.model.Truck;

@Repository
public interface TruckRepository extends CrudRepository<Truck, Long> {

	public List<Truck> findByDriver_id(long id); 
	public List<Truck> findAllByDriver(Driver driver); 

}
