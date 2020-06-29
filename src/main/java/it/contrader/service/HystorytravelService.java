package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.HystorytravelConverter;
import it.contrader.dao.HystorytravelRepository;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Driver;
import it.contrader.model.Hystorytravel;


@Service
public class HystorytravelService extends AbstractService<Hystorytravel, HystorytravelDTO> {
	
	@Autowired /* instazia repository */
	private HystorytravelRepository repository;
	
	public Hystorytravel convertHystorytravelDTO(HystorytravelDTO HtDTO) {
		return converter.toEntity(HtDTO);
	}

	
}
