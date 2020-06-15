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
					
					
					travelDTO.getCitydeparture(), 
					travelDTO.getCityarrive(),
					travelDTO.getUser(),
					travelDTO.getTruck(),
					travelDTO.getPassenger()
				//	travelDTO.getDate()
					);
			
		}
		return travel;
	}

	
	
	@Override
	public TravelDTO toDTO(Travel t) {
		TravelDTO tDTO = null;
		if( t != null) {
			tDTO = new TravelDTO(
					t.getId(),
					t.getNometeam(), 
					t.getDescrizione(),
					t.getNumeroutenti(), 
					t.getNumeroteam(), 
					
				
					t.getCitydeparture(),
					t.getCityarrive(),
					t.getUser(),
					t.getTruck(),
					t.getPassenger()
				//	t.getDate()
					
					);
		}
		return tDTO;
	}
}