package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.DriverDTO;

import it.contrader.model.Driver;

@Component
public class DriverConverter extends AbstractConverter<Driver, DriverDTO> {

	@Override
	public Driver toEntity(DriverDTO driverDTO) {
		Driver driver = null;
		if (driverDTO != null) {
			driver = new Driver(driverDTO.getId(), driverDTO.getName(), driverDTO.getSurname(), driverDTO.getDriverLicense(), driverDTO.getPhone(), driverDTO.getAge(), driverDTO.getTruckList(), driverDTO.getUser());
		}
		return driver;
	}

	@Override
	public DriverDTO toDTO(Driver driver) {
		DriverDTO driverDTO = null;
		if (driver != null) {
			driverDTO = new DriverDTO(driver.getId(), driver.getName(), driver.getSurname(), driver.getDriverLicense(), driver.getPhone(), driver.getAge(), driver.getTruckList(), driver.getUser());

		}
		return driverDTO;
	}
}