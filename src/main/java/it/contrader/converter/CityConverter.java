package it.contrader.converter;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;

public class CityConverter extends AbstractConverter<City, CityDTO>{
	@Override
	public City toEntity(CityDTO cityDTO) {
		City city = null;
		if (cityDTO != null) {
			city = new City(cityDTO.getId(), cityDTO.getCityname());
		}
		return city;
	}

	@Override
	public CityDTO toDTO(City city) {
		CityDTO cityDTO = null;
		if (city != null) {
			cityDTO = new CityDTO(city.getId(), city.getCityname());

		}
		return cityDTO;
	}
}
