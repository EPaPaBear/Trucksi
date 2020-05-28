package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CityService;

public class CityController implements Controller {

	/**
	 * definisce il pacchetto di vista city.
	 */
	private static String sub_package = "city.";
	
	private CityService cityService; 
	/**
	 * Costruisce un oggetto di tipo CityService per poterne usare i metodi
	 */
	public CityController() {
		this.cityService = new CityService(); 
	}
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode"); 
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String cityname;

		switch (mode) {
		
		// Arriva qui dalla CityReadView. Invoca il Service con il parametro id e invia alla CityReadView una città da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			CityDTO cityDTO = cityService.read(id);
			request.put("city", cityDTO);
			MainDispatcher.getInstance().callView(sub_package + "CityRead", request);
			break;
		
		// Arriva qui dalla CityInsertView. Estrae i parametri da inserire e chiama il service per inserire una città con questi parametri
		case "INSERT":
			cityname = request.get("cityname").toString();
			
			//costruisce l'oggetto city da inserire
			CityDTO citytoinsert = new CityDTO(cityname);
			//invoca il service
			cityService.insert(citytoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CityInsert", request);
			break;
		
		// Arriva qui dalla CityDeleteView. Estrae l'id della città da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			cityService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CityDelete", request);
			break;
		
		// Arriva qui dalla CityUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			cityname = request.get("cityname").toString();
			CityDTO citytoupdate = new CityDTO(cityname);
			citytoupdate.setId(id);
			cityService.update(citytoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CityUpdate", request);
			break;
			
		//Arriva qui dalla CityView Invoca il Service e invia alla CityView il risultato da mostrare 
		case "CITYLIST":
			List<CityDTO> citiesDTO = cityService.getAll();
			//Impacchetta la request con la lista delle cities
			request.put("cities", citiesDTO);
			MainDispatcher.getInstance().callView("City", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CityRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CityInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CityUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CityDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			case "T":
				request.put("mode", "CITYLIST");
				MainDispatcher.getInstance().callAction("City", "doControl", request);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
