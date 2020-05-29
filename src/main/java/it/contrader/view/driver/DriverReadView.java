package it.contrader.view.driver;

import it.contrader.controller.Request;
import it.contrader.dto.DriverDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DriverReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";

	public DriverReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			DriverDTO driver = (DriverDTO) request.get("driver");
			System.out.println(driver);
			MainDispatcher.getInstance().callView("Driver", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del driver:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Driver", "doControl", request);
	}
}
