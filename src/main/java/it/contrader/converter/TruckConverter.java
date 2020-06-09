package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TruckDTO;

import it.contrader.model.Truck;

@Component
public class TruckConverter extends AbstractConverter<Truck, TruckDTO> {

	@Override
	public Truck toEntity(TruckDTO truckDTO) {
		Truck truck = null;
		if (truckDTO != null) {
			truck = new Truck(truckDTO.getId(), truckDTO.getHowManyPeople(), truckDTO.getLicensePlate(), truckDTO.getPeopleBooking());
		}
		return truck;
	}

	@Override
	public TruckDTO toDTO(Truck truck) {
		TruckDTO truckDTO = null;
		if (truck != null) {
			truckDTO = new TruckDTO(truck.getId(), truck.getHowManyPeople(), truck.getLicensePlate(), truck.getPeopleBooking());

		}
		return truckDTO;
	}
}