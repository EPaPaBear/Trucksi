package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TruckDTO;
import it.contrader.model.Truck;

/**
 * 
 * @author Vittorio
 * 
 *         Implementando questa l'interfaccia converter la classe TruckConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class TruckConverter implements Converter<Truck, TruckDTO> {

	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user
	 * di tipo User. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public TruckDTO toDTO(Truck truck) {
		TruckDTO truckDTO = new TruckDTO();
		if (truck != null) {
			truckDTO.setId(truck.getId());
			truckDTO.setHowManyPeople(truck.getHowManyPeople());
			truckDTO.setLicensePlate(truck.getLicensePlate());
			truckDTO.setPeopleBooking(truck.getPeopleBooking());
		}
		return truckDTO;
	}

	/**
	 * Crea un oggetto di tipo truck e lo riempie con i campi del parametro truck di
	 * tipo TruckDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'a-ttributo-
	 */
	@Override
	public Truck toEntity(TruckDTO truckDTO) {
		Truck user = new Truck();
		if (truckDTO != null) {
			user.setId(truckDTO.getId());
			user.setHowManyPeople(truckDTO.getHowManyPeople());
			user.setLicensePlate(truckDTO.getLicensePlate());
			user.setPeopleBooking(truckDTO.getPeopleBooking());
		}
		return user;
	}

	/**
	 * Metodo per convertire le liste di User.
	 */
	@Override
	public List<TruckDTO> toDTOList(List<Truck> truckList) {
		// Crea una lista vuota.
		List<TruckDTO> truckDTOList = new ArrayList<TruckDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Truck truck : truckList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			truckDTOList.add(toDTO(truck));
		}
		return truckDTOList;
	}

}
