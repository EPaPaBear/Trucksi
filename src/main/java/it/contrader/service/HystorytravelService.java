package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.HystorytravelConverter;
import it.contrader.dao.HystorytravelRepository;
import it.contrader.dto.HystorytravelDTO;

import it.contrader.model.Hystorytravel;


@Service
public class HystorytravelService extends AbstractService<Hystorytravel, HystorytravelDTO> {
		/* prende il metodo del dato per esegurlo e viene chiamato nel controller " */
	@Autowired /* instanzia converter */
	private HystorytravelConverter converter;
	@Autowired /* instazia repository */
	private HystorytravelRepository repository;
	
	
	
//	public HystorytravelDTO findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(String nometeam, String descrizione, String numeroutenti, String numeroteam) {
//		return converter.toDTO(repository.findByNometeamAndDescrizioneAndNumeroutentiAndNumeroteam(nometeam, descrizione ,numeroutenti, numeroteam));
//	}
}
