
package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Hystorytravel;
import it.contrader.model.Truck;


@Component
public class HystorytravelConverter extends AbstractConverter<Hystorytravel, HystorytravelDTO> {
	
	@Autowired
	private TruckConverter truckConverter;
	
	@Autowired
	private TravelConverter travelConverter;
	
	@Override
	public Hystorytravel toEntity(HystorytravelDTO HystorytravelDTO) {
		
		Hystorytravel Hystorytravel = null;
		
		if (HystorytravelDTO != null) {
			
			//				HystorytravelDTO.getCitydeparture(), 
			//				HystorytravelDTO.getCityarrive(),
//			HystorytravelDTO.getUser(),
//			HystorytravelDTO.getTruck(),
//			HystorytravelDTO.getTravel()
			Hystorytravel = new Hystorytravel(
					HystorytravelDTO.getIdt(),
					HystorytravelDTO.getNometeam(),
					HystorytravelDTO.getDescrizione(),
					HystorytravelDTO.getNumeroutenti(),
					HystorytravelDTO.getNumeroteam(), 
					HystorytravelDTO.getTimedeparture(), 
					HystorytravelDTO.getTimearrival(),
					travelConverter.toEntityS(HystorytravelDTO.getTravel()),
					truckConverter.toEntityS(HystorytravelDTO.getTruck())
					);
		//	Hystorytravel = new Hystorytravel(HystorytravelDTO.getIdt(), HystorytravelDTO.getNometeam(), HystorytravelDTO.getDescrizione(), HystorytravelDTO.getNumeroutenti(), HystorytravelDTO.getNumeroteam());
			
		}
		return Hystorytravel;
	}
	
	
//	ht.getCitydeparture(),
//	ht.getCityarrive(),
//	ht.getUser(),
//	ht.getTruck(),
//	ht.getTravel());
	
	@Override
	public HystorytravelDTO toDTO(Hystorytravel ht) {
		HystorytravelDTO htDTO = null;
		if( ht != null) {
			htDTO = new HystorytravelDTO(
					ht.getIdt(),
					ht.getNometeam(), 
					ht.getDescrizione(),
					ht.getNumeroutenti(), 
					ht.getNumeroteam(), 
					ht.getTimedeparture(),
					ht.getTimearrival(),
					travelConverter.toDTOS(ht.getTravel()),
					truckConverter.toDTOS(ht.getTruck())
					);
		}
		return htDTO;
		
	}


	@Override
	public Hystorytravel toEntityS(HystorytravelDTO dto) {
		Hystorytravel ht = null;
		if (dto != null) {
			ht = new Hystorytravel();
			ht.setIdt(dto.getIdt());
			ht.setTimearrival(dto.getTimearrival());
			ht.setTimedeparture(dto.getTimedeparture());
		}
		return ht;
	}


	@Override
	public HystorytravelDTO toDTOS(Hystorytravel entity) { 
		HystorytravelDTO htdto = null;
		if(entity!= null) {
			htdto = new HystorytravelDTO();
			htdto.setIdt(entity.getIdt());
			htdto.setNometeam(entity.getNometeam());
			htdto.setDescrizione(entity.getDescrizione());
			htdto.setNumeroutenti(entity.getNumeroutenti());
			htdto.setTimearrival(entity.getTimearrival());
			htdto.setTimedeparture(entity.getTimedeparture());
			
		}
		return htdto;
	}
	/*
	Truck truck = null;
	if(truckDTO != null) {
		truck = new Truck();
		truck.setId(truckDTO.getId());
		truck.setLicensePlate(truckDTO.getLicensePlate());	
		truck.setModel(truckDTO.getModel());
	}
	return truck;
	
		TruckDTO truckDTO = null;
		if(truck!= null) {
			truckDTO = new TruckDTO();
			truckDTO.setId(truck.getId());
			truckDTO.setLicensePlate(truck.getLicensePlate());		
			truckDTO.setModel(truck.getModel());		
 		}
		return truckDTO;
	
	*/


}

