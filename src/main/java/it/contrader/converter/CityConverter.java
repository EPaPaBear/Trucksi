package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;
@Component
public class CityConverter extends AbstractConverter<City, CityDTO>{
	@Override
	public City toEntity(CityDTO cityDTO) {
		City city = null;
		if (cityDTO != null) {
			city = new City(cityDTO.getId(), cityDTO.getCityname(), cityDTO.getHt());
		}
		return city;
	}

	@Override
	public CityDTO toDTO(City city) {
		CityDTO cityDTO = null;
		if (city != null) {
			cityDTO = new CityDTO(city.getId(), city.getCityname(), city.getHt());

		}
		return cityDTO;
	}
}
