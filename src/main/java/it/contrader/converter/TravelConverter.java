package it.contrader.converter;

import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;
import java.util.ArrayList;
import java.util.List;

public class TravelConverter implements Converter<Travel, TravelDTO> {

	@Override
	public TravelDTO toDTO(Travel travel) {
		// TODO Auto-generated method stub
		TravelDTO travelDTO = new TravelDTO();
		if (travel != null) {
			travelDTO.setId(travel.getId());
			travelDTO.setIdusername(travel.getIdusername());
			travelDTO.setIdtruck(travel.getIdtruck());
			travelDTO.setIdcity(travel.getIdcity());
			travelDTO.setIdhistory(travel.getIdhistory());
		}
		return travelDTO;
	}

	@Override
	public Travel toEntity(TravelDTO tvDTO) {
		// TODO Auto-generated method stub
		Travel tv = new Travel();
		if (tvDTO != null) {
			tv.setId(tvDTO.getId());
			tv.setIdusername(tvDTO.getIdusername());
			tv.setIdcity(tvDTO.getIdcity());
			tv.setIdtruck(tvDTO.getIdtruck());
			tv.setIdhistory(tvDTO.getIdhistory());
		}
		return tv;
	}
	
	@Override
	public List<TravelDTO> toDTOList(List<Travel> tvList) {
		List<TravelDTO> tvDTOList = new ArrayList<TravelDTO>();
		for (Travel tv : tvList) {
			tvDTOList.add(toDTO(tv));
		}
		return tvDTOList;
	}
	
	

}
