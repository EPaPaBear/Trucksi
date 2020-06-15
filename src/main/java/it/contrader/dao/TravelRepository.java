package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Travel;


@Repository
@Transactional
public interface TravelRepository extends CrudRepository<Travel, Long> {

	
		Travel findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(String nometeam, String descrizione, String numeroutenti, String numeroteam);
		Travel findByNometeam(String nometeam);
		
}