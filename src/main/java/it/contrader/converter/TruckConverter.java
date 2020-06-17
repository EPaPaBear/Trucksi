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
			if(truckDTO.getDriver()!=null) {
				truck.setDriver(driverConverter.toEntity(truckDTO.getDriver()));
			}
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
			if(truck.getDriver()!=null) {
				truckDTO.setDriver(driverConverter.toDTO(truck.getDriver()));
			}
			truckDTO.setLicensePlate(truck.getLicensePlate());		
			truckDTO.setModel(truck.getModel());		

		}
		return truckDTO;
	}

}
