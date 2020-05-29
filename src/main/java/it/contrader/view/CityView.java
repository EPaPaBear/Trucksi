package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;

public class CityView extends AbstractView{

	private Request request;
	private String choice;
	private String userType = MainDispatcher.getInstance().getUserType();
	public CityView() {
		
	}

	/**
	 * Mostra la lista delle città
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- City management ----------------\n");
			System.out.println("ID\tCITY NAMES");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CityDTO> cities = (List<CityDTO>) request.get("cities");
			for (CityDTO u: cities)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi CityController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Choose an operation:");
		if(userType.equals("ADMIN")) {
			System.out.println("[R]ead [I]nsert [M]odify list[A]ll [D]elete [B]ack [E]sci");
		}
		else if (userType.equals("USER")){
			System.out.println("[R]ead [I]nsert list[A]ll [B]ack [E]sci");
		}
		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo TruckController.
	 */ 
	@Override
	public void submit() {
//	TODO: pezzo da cancellare
//		if(userType.equals("ADMIN")) {
//			request = new Request();
//			request.put("choice", choice);
//			request.put("mode", "GETCHOICE");
//			MainDispatcher.getInstance().callAction("City", "doControl", this.request);	
//		}
//		else if (userType.equals("USER")){
//			request = new Request();
//			request.put("choice", choice);
//			request.put("mode", "GETCHOICEUSER");
//			MainDispatcher.getInstance().callAction("City", "doControl", this.request);	
//			
//		}
		if(userType.equals("ADMIN")) {

		}
		else if (userType.equals("USER")){
			if(this.choice.equals("r") || this.choice.equals("i") || this.choice.equals("a") || this.choice.equals("b") || this.choice.equals("e")) {
				
			}
			else {
				this.choice = "ERROR";
			}
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("City", "doControl", this.request);	
	}
}
