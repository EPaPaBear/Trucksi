package it.contrader.controller;

import java.util.List;

import it.contrader.dao.LoginDAO;
import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.TruckService;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class TruckController implements Controller {

	/**
	 * definisce il pacchetto di vista truck.
	 */
	private static String sub_package = "truck.";
	
	private TruckService truckService; 
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public TruckController() {
		this.truckService = new TruckService(); 
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
		int howManyPeople;
		String licensePlate;
		int peopleBooking;

		switch (mode) {
		
		// Arriva qui dalla TruckReadView. Invoca il Service con il parametro id e invia alla TruckReadView uno user da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TruckDTO truckDTO = truckService.read(id);
			if(truckDTO.getId()==0) {
				System.out.println("ID not found");
				request.put("mode", "TRUCKLIST"); 
	        	MainDispatcher.getInstance().callAction("Truck", "doControl", request);
			}else {
				request.put("truck", truckDTO);
				MainDispatcher.getInstance().callView(sub_package + "TruckRead", request);
		
			}
			break;
		
		// Arriva qui dalla TruckInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			howManyPeople = Integer.parseInt(request.get("howmanypeople").toString());
			licensePlate = request.get("licenseplate").toString();
			peopleBooking = Integer.parseInt(request.get("peoplebooking").toString());
			
			//costruisce l'oggetto user da inserire
			TruckDTO trucktoinsert = new TruckDTO(howManyPeople, licensePlate, peopleBooking);
			//invoca il service
			truckService.insert(trucktoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "TruckInsert", request);
			break;
		
		// Arriva qui dalla TruckDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			truckService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TruckDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			howManyPeople = Integer.parseInt(request.get("howmanypeople").toString());
			licensePlate = request.get("licenseplate").toString();
			peopleBooking = Integer.parseInt(request.get("peoplebooking").toString());
			TruckDTO trucktoupdate = new TruckDTO(howManyPeople, licensePlate, peopleBooking);
			trucktoupdate.setId(id);
			truckService.update(trucktoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TruckUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla TruckView il risultato da mostrare 
		case "TRUCKLIST":
			List<TruckDTO> trucksDTO = truckService.getAll();
			//Impacchetta la request con la lista dei truck
			request.put("trucks", trucksDTO);
			MainDispatcher.getInstance().callView("Truck", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "R":
				MainDispatcher.getInstance().callView(sub_package + "TruckRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TruckInsert", null);
				break;
				
			case "U":
			
				MainDispatcher.getInstance().callView(sub_package + "TruckUpdate", null);	
				
				break;
				
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "TruckDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			case "A":
				
				request.put("mode", "TRUCKLIST");
				MainDispatcher.getInstance().callAction("Truck", "doControl", request);
				break;
			
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
