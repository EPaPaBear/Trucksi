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
			if(passengerDTO.getUser() != null) {
				passenger.setUser(userConverter.toEntity(passengerDTO.getUser()));
			}
			if(passengerDTO.getTruck() != null) {
				passenger.setTruck(truckConverter.toEntity(passengerDTO.getTruck()));
			}
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
			if(passenger.getUser()!=null) {
				passengerDTO.setUser(userConverter.toDTO(passenger.getUser()));
			}
			if(passenger.getTruck()!=null) {
				passengerDTO.setTruck(truckConverter.toDTO(passenger.getTruck()));
			}
			passengerDTO.setName(passenger.getName());
			passengerDTO.setSurname(passenger.getSurname());
			passengerDTO.setAge(passenger.getAge());
			passengerDTO.setPhone(passenger.getPhone());
		}
		return passengerDTO;

		
	}
	
}