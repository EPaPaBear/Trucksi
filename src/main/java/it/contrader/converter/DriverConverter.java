package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.DriverDTO;

import it.contrader.model.Driver;

@Component
public class DriverConverter extends AbstractConverter<Driver, DriverDTO> {
	@Autowired
	private UserConverter userConverter;
	@Autowired 
	private TruckConverter truckConverter;
	
	@Override
	public Driver toEntity(DriverDTO driverDTO) {
		Driver driver = null;
		if(driverDTO != null) {
			driver = new Driver();
			driver.setId(driverDTO.getId());
			if(driverDTO.getUser() != null) {
				driver.setUser(userConverter.toEntity(driverDTO.getUser()));
			}
			
			/*if(driverDTO.getTruckList() != null) {
				driver.setTruckList(truckConverter.toEntityList(driver.getTruckList()));
			}
			*/
			driver.setName(driverDTO.getName());
			driver.setSurname(driverDTO.getSurname());
			driver.setDriverLicense(driverDTO.getDriverLicense());
			driver.setPhone(driverDTO.getPhone());
			driver.setAge(driverDTO.getAge());
		}
	
		return driver;
	}

	@Override
	public DriverDTO toDTO(Driver driver) {
		DriverDTO driverDTO = null;
		if (driver != null) {
			driverDTO = new DriverDTO();
			driverDTO.setId(driver.getId());
			if(driver.getUser() != null) {
				driverDTO.setUser(userConverter.toDTO(driver.getUser()));
			}
			/*
			if(driver.getTruckList()!= null) {
				driverDto.setTruckList(truckConverter.toDTO(driver.getTruck()));
			}
			*/
			driverDTO.setName(driver.getName());
			driverDTO.setSurname(driver.getSurname());
			driverDTO.setDriverLicense(driver.getDriverLicense());
			driverDTO.setPhone(driver.getPhone());
			driverDTO.setAge(driver.getAge());
		}
		return driverDTO;
	}
}