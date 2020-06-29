package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;


@Repository
@Transactional
public interface HystorytravelRepository extends CrudRepository<Hystorytravel, Long> {

	
		//Hystorytravel findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(String nometeam, String descrizione, String numeroutenti, String numeroteam);
		//Hystorytravel findByNometeam(String nometeam);
	//	public HystorytravelDTO saveandreturn(HystorytravelDTO ht);
}