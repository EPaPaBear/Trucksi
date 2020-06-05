package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CityDTO;
import it.contrader.model.City;

public class CityConverter implements Converter<City, CityDTO>{
	@Override
	public CityDTO toDTO(City city) {
		CityDTO cityDTO = new CityDTO();
		if (city != null) {
			cityDTO.setId(city.getId());
			cityDTO.setCityname(city.getcityname());
		}
		return cityDTO;
	}
	
	/**
	 * Crea un oggetto di tipo city e lo riempie con i campi del parametro city di
	 * tipo CityDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo
	 */
	@Override
	public City toEntity(CityDTO cityDTO) {
		City city = new City();
		if (cityDTO != null) {
			city.setId(cityDTO.getId());
			city.setcityname(cityDTO.getCityname());
		}
		return city;
	}
	
	/**
	 * Metodo per convertire le liste di City.
	 */
	@Override
	public List<CityDTO> toDTOList(List<City> cityList) {
		// Crea una lista vuota
		List<CityDTO> cityDTOList = new ArrayList<CityDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (City city : cityList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			cityDTOList.add(toDTO(city));
		}
		return cityDTOList;
	}
}
