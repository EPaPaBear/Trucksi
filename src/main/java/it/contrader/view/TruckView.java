package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TruckDTO; 
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class TruckView extends AbstractView {

	private Request request;
	private String choice;

	public TruckView() {
		
	}

	/**
	 * Mostra la lista dei truck
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Truck Management  ----------------\n");
			System.out.println("ID\tHow Many People\tLicense Plate\tPeople Booked");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<TruckDTO> trucks = (List<TruckDTO>) request.get("trucks");
			for (TruckDTO u: trucks)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi TruckController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("Choose an operation to execute:");
		System.out.println("[R]ead [I]nsert [U]update show [A]ll [D]elete [B]ack [E]xit");

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
		MainDispatcher.getInstance().callAction("Truck", "doControl", this.request);
	}

}
