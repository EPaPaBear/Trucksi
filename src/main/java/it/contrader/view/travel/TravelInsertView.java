package it.contrader.view.travel;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TravelInsertView extends AbstractView{
	private Request request;

	private int idusername;
	private int idtruck;
	private int idcity;
	private int idhistory;
	private final String mode = "INSERT";

	public TravelInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Change successfull.\n");
			request = new Request();
			request.put("mode", "TRAVELLIST");
			MainDispatcher.getInstance().callAction("Travel", "doControl", request);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("Insert Username ID:");
			idusername = Integer.parseInt(getInput());
			System.out.println("insert truck ID:");
			idtruck = Integer.parseInt(getInput());
			System.out.println("Insert city ID:");
			idcity = Integer.parseInt(getInput());
			System.out.println("Insert History ID:");
			idhistory = Integer.parseInt(getInput());
	}


	@Override
	public void submit() {
		request = new Request();
		request.put("idusername", idusername);
		request.put("idtruck", idtruck);
		request.put("idcity", idcity);
		request.put("idhistory", idhistory);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Travel", "doControl", request);
	}


}
