package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		System.out.println("\n Benvenuto in SAMPLE PROJECT "+request.get("username").toString() + "\n");
    	
	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("NESSUNA OPZIONE DISPONIBILE!");
		System.out.println("[U]tenti [T]ruck [H]ystorytravel  [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		
		switch (choice) {
			case "u":
	        	this.request.put("mode", "USERLIST");
	        	MainDispatcher.getInstance().callAction("User", "doControl", request);
	        	break;
			
			case "t":
	        	this.request.put("mode", "TRUCKLIST");
	        	MainDispatcher.getInstance().callAction("Truck", "doControl", request);
	        	break;
	        
			case "h":
	        	this.request.put("mode", "HYSTORYTRAVELLIST");
	        	MainDispatcher.getInstance().callAction("Hystorytravel", "doControl", request);
	        	break;
	
			case "e":
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
				break;
	
			default:
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
