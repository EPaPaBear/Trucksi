package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;

public class HystorytravelConverter implements Converter<Hystorytravel, HystorytravelDTO> {

	@Override
	public HystorytravelDTO toDTO(Hystorytravel ht) {
		HystorytravelDTO htDTO = new HystorytravelDTO();
		if(ht != null) {
			htDTO.setId(ht.getId());
			htDTO.setIdcity(ht.getIdcity());
			htDTO.setIdtravel(ht.getIdtravel());
			htDTO.setTravelindex(ht.getTravelindex());
			htDTO.setHour(ht.getHour());
		}
		return htDTO;
		
	}

	@Override
	public Hystorytravel toEntity(HystorytravelDTO htDTO) {
		Hystorytravel ht = new Hystorytravel();
		if (htDTO != null) {
			ht.setHour(htDTO.getHour());
			ht.setId(htDTO.getId());
			ht.setIdcity(htDTO.getIdcity());
			ht.setIdtravel(htDTO.getIdtravel());
			ht.setTravelindex(htDTO.getTravelindex());
		}
		return ht;
		
	}

	@Override
	public List<HystorytravelDTO> toDTOList(List<Hystorytravel> htList) {
		List<HystorytravelDTO> htDTOList = new ArrayList<HystorytravelDTO>();
		for (Hystorytravel ht : htList) {
			htDTOList.add(toDTO(ht));
		}
		return htDTOList;
	}

}
