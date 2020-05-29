package it.contrader.view.travel;

import it.contrader.controller.Request;
import it.contrader.dto.TravelDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TravelReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public TravelReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			TravelDTO travel = (TravelDTO) request.get("travel");
			System.out.println(travel);
			MainDispatcher.getInstance().callView("Travel", null);
		}
	}

	
	
	@Override
	public void showOptions() {
		System.out.println("Insert Travel ID");
		id = Integer.parseInt(getInput());
	}

	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Travel", "doControl", request);
	}

}
