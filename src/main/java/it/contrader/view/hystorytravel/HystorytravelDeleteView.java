package it.contrader.view.hystorytravel;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	public HystorytravelDeleteView() {
		
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Successfull deleted \n");
			MainDispatcher.getInstance().callView("Hystorytravel", null);
		}
		
	}

	@Override
	public void showOptions() {
		System.out.println("Insert id Hystory:");
		id = Integer.parseInt(getInput());
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
		
	}

}
