package it.contrader.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Truck;

@Component
public class TruckConverter extends AbstractConverter<Truck, TruckDTO>{

	@Autowired
	private DriverConverter driverConverter;
	
	@Override
	public Truck toEntity(TruckDTO truckDTO) {
		Truck truck = null;
		if(truckDTO != null) {
			truck = new Truck();
			truck.setId(truckDTO.getId());
			truck.setDriver(driverConverter.toEntityS(truckDTO.getDriver()));
			truck.setLicensePlate(truckDTO.getLicensePlate());	
			truck.setModel(truckDTO.getModel());
		}
		return truck;
	}

	@Override
	public TruckDTO toDTO(Truck truck) {
		TruckDTO truckDTO = null;
		if(truck!= null) {
			truckDTO = new TruckDTO();
			truckDTO.setId(truck.getId());
			truckDTO.setDriver(driverConverter.toDTOS(truck.getDriver()));
			truckDTO.setLicensePlate(truck.getLicensePlate());		
			truckDTO.setModel(truck.getModel());		

		}
		return truckDTO;
	}

	@Override
	public Truck toEntityS(TruckDTO truckDTO) { 
		Truck truck = null;
		if(truckDTO != null) {
			truck = new Truck();
			truck.setId(truckDTO.getId());
			truck.setLicensePlate(truckDTO.getLicensePlate());	
			truck.setModel(truckDTO.getModel());
		}
		return truck;
	}

	@Override
	public TruckDTO toDTOS(Truck truck) {
		TruckDTO truckDTO = null;
		if(truck!= null) {
			truckDTO = new TruckDTO();
			truckDTO.setId(truck.getId());
			truckDTO.setLicensePlate(truck.getLicensePlate());		
			truckDTO.setModel(truck.getModel());		
 		}
		return truckDTO;
	}

}
