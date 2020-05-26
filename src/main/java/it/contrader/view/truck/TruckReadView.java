package it.contrader.view.truck;

import it.contrader.controller.Request;

import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Vittorio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class TruckReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public TruckReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla TruckView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			TruckDTO truck = (TruckDTO) request.get("truck");
			System.out.println(truck);
			MainDispatcher.getInstance().callView("Truck", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del truck:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Truck", "doControl", request);
	}

}
