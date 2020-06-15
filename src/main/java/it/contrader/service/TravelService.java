package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.TravelConverter;
import it.contrader.dao.TravelRepository;
import it.contrader.dto.TravelDTO;

import it.contrader.model.Travel;


@Service
public class TravelService extends AbstractService<Travel, TravelDTO> {
	
	@Autowired 
	private TravelConverter converter;
	@Autowired /* instazia repository */
	private TravelRepository repository;
	
	public TravelDTO findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(String nometeam, String descrizione, String numeroutenti, String numeroteam) {
		return converter.toDTO(repository.findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(nometeam, descrizione ,numeroutenti, numeroteam));
	}
}
