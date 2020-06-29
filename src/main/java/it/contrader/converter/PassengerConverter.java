package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.PassengerDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Passenger;
import it.contrader.model.Truck;

@Component
public class PassengerConverter extends AbstractConverter<Passenger, PassengerDTO> {
	
	@Autowired
	private UserConverter userConverter;
	@Autowired 
	private TruckConverter truckConverter;
	
	
	
	@Override
	public Passenger toEntity(PassengerDTO passengerDTO) {
		Passenger passenger = null;
		if (passengerDTO != null) {
			passenger = new Passenger();
			passenger.setId(passengerDTO.getId());
			passenger.setUser(userConverter.toEntityS( passengerDTO.getUser()));
			passenger.setTruck(truckConverter.toEntityS(passengerDTO.getTruck()));
			passenger.setName(passengerDTO.getName());
			passenger.setSurname(passengerDTO.getSurname());
			passenger.setAge(passengerDTO.getAge());
			passenger.setPhone(passengerDTO.getPhone());
		}
		return passenger;
	}

	@Override
	public PassengerDTO toDTO(Passenger passenger) {
		PassengerDTO passengerDTO = null;
		if(passenger!= null) {
			passengerDTO = new PassengerDTO();
			passengerDTO.setId(passenger.getId());
			passengerDTO.setUser(userConverter.toDTOS( passenger.getUser()));
			passengerDTO.setTruck(truckConverter.toDTOS(passenger.getTruck()));
			passengerDTO.setName(passenger.getName());
			passengerDTO.setSurname(passenger.getSurname());
			passengerDTO.setAge(passenger.getAge());
			passengerDTO.setPhone(passenger.getPhone());
		}
		return passengerDTO;
	}

	@Override
	public Passenger toEntityS(PassengerDTO passengerDTO) { 
		Passenger passenger = null;
		if (passengerDTO != null) {
			passenger = new Passenger();
			passenger.setId(passengerDTO.getId());
			passenger.setName(passengerDTO.getName());
			passenger.setSurname(passengerDTO.getSurname());
			passenger.setAge(passengerDTO.getAge());
			passenger.setPhone(passengerDTO.getPhone());
		}
		return passenger;
	}

	@Override
	public PassengerDTO toDTOS(Passenger passenger) {
		PassengerDTO passengerDTO = null;
		if(passenger!= null) {
			passengerDTO = new PassengerDTO();
			passengerDTO.setId(passenger.getId()); 
			passengerDTO.setName(passenger.getName());
			passengerDTO.setSurname(passenger.getSurname());
			passengerDTO.setAge(passenger.getAge());
			passengerDTO.setPhone(passenger.getPhone());
		}
		return passengerDTO;
	}
	
}