package it.contrader.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;

@Component
public class TravelConverter extends AbstractConverter<Travel, TravelDTO>{

	@Autowired
	private TruckConverter truckConverter;

	
	
	@Override
	public Travel toEntity(TravelDTO travelDTO) {
		Travel travel = null;
		if(travelDTO != null) {
			travel = new Travel();
			travel.setId(travelDTO.getId());
			if(travelDTO.getTruckDTO()!=null) {
				travel.setTruck(truckConverter.toEntity(travelDTO.getTruckDTO()));
			}
			travel.setDate(travelDTO.getDate());	
		}
		return travel;
	}

	@Override
	public TravelDTO toDTO(Travel travel) {
		TravelDTO travelDTO = null;
		if(travel!= null) {
			travelDTO = new TravelDTO();
			travelDTO.setId(travel.getId());
			if(travel.getTruck()!=null) {
				travelDTO.setTruckDTO(truckConverter.toDTO(travel.getTruck()));
			}
			travelDTO.setDate(travel.getDate());		
		}
		return travelDTO;
	}

}
