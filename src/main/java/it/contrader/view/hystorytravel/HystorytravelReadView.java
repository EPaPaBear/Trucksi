package it.contrader.view.hystorytravel;

import it.contrader.controller.Request;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class HystorytravelReadView  extends AbstractView {
	private int id;
	private Request request;
	private final String mode = "READ";
	public HystorytravelReadView() {
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			HystorytravelDTO htDTO = (HystorytravelDTO) request.get("hystorytravel");
			System.out.println(htDTO);
			MainDispatcher.getInstance().callView("Hystorytravel", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("Insert id of Hystorytravel:");
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
