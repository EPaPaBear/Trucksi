package it.contrader.controller;

import java.util.List;

import it.contrader.dto.DriverDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.DriverService;

public class DriverController implements Controller{

	private static String sub_package = "driver.";
	
	private DriverService driverService; 
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public DriverController() {
		this.driverService = new DriverService(); 
	}
	
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode"); 
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String drivername;
		String drivermobile;
		int idtruck;

		switch (mode) {
		
		// Arriva qui dalla TruckReadView. Invoca il Service con il parametro id e invia alla TruckReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			DriverDTO driverDTO = driverService.read(id);
			if(driverDTO.getId()==0) {
				System.out.println("ID non trovato");
				request.put("mode", "DRIVERLIST"); 
	        	MainDispatcher.getInstance().callAction("Driver", "doControl", request);
			}else {
				request.put("driver", driverDTO);
				MainDispatcher.getInstance().callView(sub_package + "DriverRead", request);
				
			}
			break;
		
		case "INSERT":
			drivername = request.get("drivername").toString();
			drivermobile = request.get("drivermobile").toString();
			idtruck = Integer.parseInt(request.get("idtruck").toString());
			
			//costruisce l'oggetto driver da inserire
			DriverDTO drivertoinsert = new DriverDTO(drivername, drivermobile, idtruck);
			//invoca il service
			driverService.insert(drivertoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "DriverInsert", request);
			break;
		
		// Arriva qui dalla TruckDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			driverService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DriverDelete", request);
			break;
		
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			drivername = request.get("drivername").toString();
			drivermobile = request.get("drivermobile").toString();
			idtruck = Integer.parseInt(request.get("idtruck").toString());
			DriverDTO drivertoupdate = new DriverDTO(drivername, drivermobile, idtruck);
			drivertoupdate.setId(id);
			driverService.update(drivertoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "DriverUpdate", request);
			break;
			
		case "DRIVERLIST":
			List<DriverDTO> driversDTO = driverService.getAll();
			//Impacchetta la request con la lista dei driver
			request.put("drivers", driversDTO);
			MainDispatcher.getInstance().callView("Driver", request);
			break;
			
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "DriverRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "DriverInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "DriverUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "DriverDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
