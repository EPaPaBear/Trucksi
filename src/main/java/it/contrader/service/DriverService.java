package it.contrader.service;

import it.contrader.converter.DriverConverter;
import it.contrader.converter.TruckConverter;
import it.contrader.dao.DriverDAO;
import it.contrader.dao.TruckDAO;
import it.contrader.dto.DriverDTO;
import it.contrader.model.Driver;

public class DriverService extends AbstractService<Driver, DriverDTO>{
	//Istanzio DAO  e Converter specifici.
		public DriverService(){
			this.dao = new DriverDAO();
			this.converter = new DriverConverter();
		}
}
