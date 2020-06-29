package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CityDTO;

import it.contrader.model.City;

@Component
public class CityConverter extends AbstractConverter<City, CityDTO> {

	@Override
	public City toEntity(CityDTO cityDTO) {
		City city = null;
		if(cityDTO != null) {
			city = new City();
			city.setId(cityDTO.getId());
			city.setCityname(cityDTO.getCityname());
		}
	
		return city;
	}

	@Override
	public CityDTO toDTO(City city) {
		CityDTO cityDTO = null;
		if (city != null) {
			cityDTO = new CityDTO();
			cityDTO.setId(city.getId()); 
			cityDTO.setCityname(city.getCityname());
			
		}
		return cityDTO;
	}

	@Override
	public City toEntityS(CityDTO cityDTO) {
		return null;
	}

	@Override
	public CityDTO toDTOS(City city) {
		
		return null;
	}
}