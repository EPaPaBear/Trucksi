package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;

public class CityView extends AbstractView{

	private Request request;
	private String choice;

	public CityView() {
		
	}

	/**
	 * Mostra la lista delle città
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione città ----------------\n");
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
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica mostra[T]utti [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo TruckController.
	 */ 
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("City", "doControl", this.request);
	}
}
