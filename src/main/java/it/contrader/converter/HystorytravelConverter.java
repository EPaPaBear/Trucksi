
package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;


@Component
public class HystorytravelConverter extends AbstractConverter<Hystorytravel, HystorytravelDTO> {
	
	@Override
	public Hystorytravel toEntity(HystorytravelDTO HystorytravelDTO) {
		
		Hystorytravel Hystorytravel = null;
		
		if (HystorytravelDTO != null) {
			
			Hystorytravel = new Hystorytravel(
					HystorytravelDTO.getIdt(),
					HystorytravelDTO.getNometeam(),
					HystorytravelDTO.getDescrizione(),
					HystorytravelDTO.getNumeroutenti(),
					HystorytravelDTO.getNumeroteam(), 
					HystorytravelDTO.getTimedeparture(), 
					HystorytravelDTO.getCitydeparture(), 
					HystorytravelDTO.getCityarrive()
					);
		//	Hystorytravel = new Hystorytravel(HystorytravelDTO.getIdt(), HystorytravelDTO.getNometeam(), HystorytravelDTO.getDescrizione(), HystorytravelDTO.getNumeroutenti(), HystorytravelDTO.getNumeroteam());
			
		}
		return Hystorytravel;
	}
	
	
	
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
					ht.getCitydeparture(),
					ht.getCityarrive());
		}
		return htDTO;
		
	}
}

