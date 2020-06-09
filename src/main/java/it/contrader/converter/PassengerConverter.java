package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PassengerDTO;

import it.contrader.model.Passenger;

@Component
public class PassengerConverter extends AbstractConverter<Passenger, PassengerDTO> {

	@Override
	public Passenger toEntity(PassengerDTO passengerDTO) {
		Passenger passenger = null;
		if (passengerDTO != null) {
			passenger = new Passenger(passengerDTO.getId(), passengerDTO.getName(), passengerDTO.getSurname(), passengerDTO.getAge(), passengerDTO.getPhone(), passengerDTO.getUser());
		}
		return passenger;
	}

	@Override
	public PassengerDTO toDTO(Passenger passenger) {
		PassengerDTO passengerDTO = null;
		if (passenger != null) {
			passengerDTO = new PassengerDTO(passenger.getId(), passenger.getName(), passenger.getSurname(), passenger.getAge(), passenger.getPhone(), passenger.getUser());

		}
		return passengerDTO;
	}
}