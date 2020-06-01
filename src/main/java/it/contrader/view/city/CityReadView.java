package it.contrader.view.city;

import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CityReadView extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";

	public CityReadView() {
	}

	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CityDTO city = (CityDTO) request.get("city");
			System.out.println(city);
			MainDispatcher.getInstance().callView("City", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Insert id city:");
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
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}
}
