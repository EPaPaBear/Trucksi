package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;

public class HystorytravelConverter implements Converter<Hystorytravel, HystorytravelDTO> {

	@Override
	public HystorytravelDTO toDTO(Hystorytravel ht) {
		//System.out.print("hystorytravelconverter todto \n");
		HystorytravelDTO htDTO = new HystorytravelDTO();
		if(ht != null) {
			htDTO.setId(ht.getId());
			htDTO.setIdcity(ht.getIdcity());
			htDTO.setIdtravel(ht.getIdtravel());
			htDTO.setTravelindex(ht.getTravelindex());
			htDTO.setDate(ht.getDate());
		}
		return htDTO;
		
	}

	@Override
	public Hystorytravel toEntity(HystorytravelDTO htDTO) {
		//System.out.print("hystorytravelconverter to entity \n");
		Hystorytravel ht = new Hystorytravel();
		if (htDTO != null) {
			ht.setDate(htDTO.getDate());
			ht.setId(htDTO.getId());
			ht.setIdcity(htDTO.getIdcity());
			ht.setIdtravel(htDTO.getIdtravel());
			ht.setTravelindex(htDTO.getTravelindex());
			//System.out.println("HYSTORYTRAVEL converter ht to string:"+ ht.toString()+ "\n");
		}
		return ht;
		
	}

	@Override
	public List<HystorytravelDTO> toDTOList(List<Hystorytravel> htList) {
		//System.out.print("hystorytravelconverter todtolist \n");
		List<HystorytravelDTO> htDTOList = new ArrayList<HystorytravelDTO>();
		for (Hystorytravel ht : htList) {
			htDTOList.add(toDTO(ht));
		}
		return htDTOList;
	}

}
