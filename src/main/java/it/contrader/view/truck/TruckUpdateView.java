package it.contrader.view.truck;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class TruckUpdateView extends AbstractView {
	private Request request;

	private int idusername;
	private int idtruck;
	private int idcity;
	private int idhistory;
	private final String mode = "UPDATE";
	private String userType = MainDispatcher.getInstance().getUserType();
	public TruckUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Change successfull.\n");
			MainDispatcher.getInstance().callView("Travel", null);
		}
	}
	@Override
	public void showOptions() {
		
		if (userType.equals("ADMIN")) {
			try {
				
				System.out.println("Insert Username ID:");
				id = Integer.parseInt(getInput());
				System.out.println("Insert Truck  ID:");
				idtruck = Integer.parseInt(getInput());
				System.out.println("Insert city ID");
				idcity = Integer.parseInt(getInput());
				System.out.println("Insert history id :");
				idhistory = Integer.parseInt(getInput());
			} catch (Exception e) {

			}
		}else {
	    	System.out.println("You cannot edit as a USER");
		}
	
	}

	@Override
	public void submit() {
		request = new Request();
		if (userType.equals("ADMIN")) {
			request.put("idusername", idusername);
			request.put("idtruck", idtruck);
			request.put("idcity", idcity);
			request.put("idhistory", idhistory);
			request.put("mode", mode);
		}else {
			request.put("mode", "TRAVELHISTORY");
		}
		
		MainDispatcher.getInstance().callAction("Travel", "doControl", request);
	}

}
