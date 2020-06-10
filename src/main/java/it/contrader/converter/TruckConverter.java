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
			truck = new Truck(truckDTO.getId(), truckDTO.getLicensePlate(), truckDTO.getDriver());
		}
		return truck;
	}

	@Override
	public TruckDTO toDTO(Truck truck) {
		TruckDTO truckDTO = null;
		if (truck != null) {
			truckDTO = new TruckDTO(truck.getId(), truck.getLicensePlate(), truck.getDriver());

		}
		return truckDTO;
	}
}