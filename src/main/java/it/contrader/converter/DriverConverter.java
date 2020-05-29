package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DriverDTO;
import it.contrader.model.Driver;

public class DriverConverter implements Converter<Driver, DriverDTO>{
	
	@Override
	public DriverDTO toDTO(Driver driver) {
		DriverDTO driverDTO = new DriverDTO();
		if (driver != null) {
			driverDTO.setId(driver.getId());
			driverDTO.setDrivername(driver.getDrivername());
			driverDTO.setDrivermobile(driver.getDrivermobile());
			driverDTO.setIdtruck(driver.getIdtruck());
		}
		return driverDTO;
	}
	
	@Override
	public Driver toEntity(DriverDTO driverDTO) {
		Driver driver = new Driver();
		if (driverDTO != null) {
			driver.setId(driverDTO.getId());
			driver.setDrivername(driverDTO.getDrivername());
			driver.setDrivermobile(driverDTO.getDrivermobile());
			driver.setIdtruck(driverDTO.getIdtruck());
		}
		return driver;
	}
	
	@Override
	public List<DriverDTO> toDTOList(List<Driver> driverList) {
		// Crea una lista vuota.
		List<DriverDTO> driverDTOList = new ArrayList<DriverDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Driver driver : driverList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			driverDTOList.add(toDTO(driver));
		}
		return driverDTOList;
	}
}
