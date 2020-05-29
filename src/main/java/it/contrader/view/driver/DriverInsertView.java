package it.contrader.view.driver;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class DriverInsertView extends AbstractView{
	private Request request;

	private String drivername;
	private String drivermobile;
	private int idtruck;
	private final String mode = "INSERT";

	public DriverInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			request = new Request();
			request.put("mode", "DRIVERLIST");
			MainDispatcher.getInstance().callAction("Driver", "doControl", request);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome del driver:");
			drivername = getInput();
			System.out.println("Inserisci il mobile del driver:");
			drivermobile = getInput();
			System.out.println("Inserisci l'id del truck:");
			idtruck = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("drivername", drivername);
		request.put("drivermobile", drivermobile);
		request.put("idtruck", idtruck);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Driver", "doControl", request);
	}
	
}
