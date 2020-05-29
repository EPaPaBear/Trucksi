package it.contrader.view.travel;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TravelDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public TravelDeleteView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Travel Successfully eliminated! \n");
			MainDispatcher.getInstance().callView("Travel", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Insert the travel ID");
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
