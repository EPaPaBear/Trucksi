package it.contrader.view.hystorytravel;

import it.contrader.controller.Request;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelRead  extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";
	public HystorytravelRead() {
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			UserDTO user = (UserDTO) request.get("user");
			System.out.println(user);
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'hystorytravel:");
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
