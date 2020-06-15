package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;


@Component
public class TravelConverter extends AbstractConverter<Travel, TravelDTO> {
	
	@Override
	public Travel toEntity(TravelDTO travelDTO) {
		
		Travel travel = null;
		
		if (travelDTO != null) {
			
			travel = new Travel(
					travelDTO.getId(),
					travelDTO.getNometeam(),
					travelDTO.getDescrizione(),
					travelDTO.getNumeroutenti(),
					travelDTO.getNumeroteam(),
					travelDTO.getTruck(),
					travelDTO.getDate()
				);
		}
		return travel;
		/*
		 * 			travelDTO.getId(),
					travelDTO.getNometeam(),
					travelDTO.getDescrizione(),
					travelDTO.getNumeroutenti(),
					travelDTO.getNumeroteam(),
					travelDTO.getTruck(),
					travelDTO.getDate()
		 * 
		 * 
		 * 
		 */
	}
/*
 * 					travelDTO.getId(),
					travelDTO.getNometeam(),
					travelDTO.getDescrizione(),
					travelDTO.getNumeroutenti(),
					travelDTO.getNumeroteam(), 
//					travelDTO.getTimedeparture(), 
					//	travelDTO.getTimearrival(),
				//	travelDTO.getCitydeparture(), 
					//travelDTO.getCityarrive(),
					//travelDTO.getUser(),
					travelDTO.getTruck()
				//	travelDTO.getPassenger()
				//	travelDTO.getDate()
 * 
 * 
 * 
 * 
 */
	@Override
	public TravelDTO toDTO(Travel t) {
		TravelDTO tDTO = null;
		if( t != null) {
			tDTO = new TravelDTO(
					t.getId(),
					t.getNometeam(),
					t.getDescrizione(),
					t.getNumeroutenti(),
					t.getNometeam(),
					t.getTruck(),
					t.getDate());	
			
			/*		t.getId(),
					t.getNometeam(),
					t.getDescrizione(),
					t.getNumeroutenti(),
					t.getNumeroteam(),
					t.getTruck(),
					t.getDate()
			 * 
			 * 
			 */
			
			
			/*
			 * t.getId(),
					t.getNometeam(), 
					t.getDescrizione(),
					t.getNumeroutenti(), 
					t.getNumeroteam(), 
					//		t.getTimedeparture(),
					//		t.getTimearrival(),
					t.getCitydeparture(),
					t.getCityarrive(),
					t.getUser(),
					t.getTruck(),
					t.getPassenger()
				//	t.getDate()
			 */
		}
		return tDTO;
	}
}