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
			travel = new Travel(travelDTO.getId(), travelDTO.getTraveldate(), travelDTO.getPassenger(), travelDTO.getTruck());
		}
		return travel;
	}

	@Override
	public TravelDTO toDTO(Travel travel) {
		TravelDTO travelDTO = null;
		if (travel != null) {
			travelDTO = new TravelDTO(travel.getId(), travel.getTraveldate(),travel.getPassenger(),travel.getTruck());

		}
		return travelDTO;
	}
}