package it.contrader.view.driver;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DriverUpdateView extends AbstractView{
	private Request request;

	private int id;
	private String drivername;
	private String drivermobile;
	private int idtruck;
	private final String mode = "UPDATE";

	public DriverUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Driver", null);
		}
	}
	
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del driver:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome del driver:");
			drivername = getInput();
			System.out.println("Inserisci il mobile del driver:");
			drivermobile = getInput();
			System.out.println("Inserisci l'ID del truck:");
			idtruck = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("drivername", drivername);
		request.put("drivemobile", drivermobile);
		request.put("idtruck", idtruck);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Driver", "doControl", request);
	}
}
